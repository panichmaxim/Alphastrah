package com.panichmaxim.alphastrah.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyProperties;
import android.util.Base64;
import android.util.Log;
import com.panichmaxim.alphastrah.App;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

public class Security {

    private static String sAllias = "MyKey";

    // http://stackoverflow.com/questions/1101380/determine-if-running-on-a-rooted-device

    public static boolean isDeviceRooted() {
        return checkRootMethod1() || checkRootMethod2() || checkRootMethod3();
    }

    private static boolean checkRootMethod1() {
        String buildTags = android.os.Build.TAGS;
        return buildTags != null && buildTags.contains("test-keys");
    }

    private static boolean checkRootMethod2() {
        String[] paths = { "/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su",
                "/system/bin/failsafe/su", "/data/local/su" };
        for (String path : paths) {
            if (new File(path).exists()) return true;
        }
        return false;
    }

    private static boolean checkRootMethod3() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[] { "/system/xbin/which", "su" });
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            if (in.readLine() != null) return true;
            return false;
        } catch (Throwable t) {
            return false;
        } finally {
            if (process != null) process.destroy();
        }
    }
    /*
    http://stackoverflow.com/questions/19957052/android-encryption-pad-block-corrupted-exception
    +
    RSA:
    http://developer.android.com/intl/ru/reference/android/security/keystore/KeyGenParameterSpec.html
    http://stackoverflow.com/questions/9658921/encrypting-aes-key-with-rsa-public-key
    */
    private static SecretKeySpec getKey() throws Exception {
        if (SimpleStorage.getInstance().getCryptoKey() == null) {
            // Generate AES key for data encryption
            byte[] seed = new byte[128];
            SecureRandom sRnd = SecureRandom.getInstance("SHA1PRNG");
            sRnd.nextBytes(seed);
            sRnd.setSeed(seed);
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES);
            keyGenerator.init(128, sRnd);
            byte[] key = keyGenerator.generateKey().getEncoded();
            // Generate RSA key for AES encryption and encrypt
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KeyProperties.KEY_ALGORITHM_RSA, "AndroidKeyStore");
                Calendar start = Calendar.getInstance();
                Calendar end = Calendar.getInstance();
                end.add(Calendar.YEAR, 1);
                KeyPairGeneratorSpec spec = new KeyPairGeneratorSpec.Builder(App.getContext()).setAlias(sAllias)
                        .setSubject(new X500Principal("CN=myKey")).setStartDate(start.getTime()).setEndDate(end.getTime()).setSerialNumber(BigInteger.valueOf(1337)).build();
                keyPairGenerator.initialize(spec);
                keyPairGenerator.generateKeyPair();
                key = encryptAESKey(key);
            }
            // Save key
            SimpleStorage.getInstance().saveCryptoKey(key);
            return new SecretKeySpec(key, "AES");
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
                return decryptAESKey(SimpleStorage.getInstance().getCryptoKey());
            } else {
                return new SecretKeySpec(SimpleStorage.getInstance().getCryptoKey(), "AES");
            }
        }
    }

    private static byte[] encryptAESKey (byte[] key)
    {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keyStore.getCertificate(sAllias).getPublicKey());
            return cipher.doFinal(key);
        } catch(Exception e) {
            System.out.println("Exception encoding the aes key: " + e.getMessage());
        }
        return null;
    }

    private static SecretKeySpec decryptAESKey(byte[] data)
    {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, keyStore.getKey(sAllias, null) );
            return new SecretKeySpec (cipher.doFinal(data), "AES");
        } catch(Exception e) {
            System.out.println("Exception decrypting the aes key: " + e.getMessage());
        }
        return null;
    }

    public static String encrypt(String clearText) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, getKey());
            return Base64.encodeToString(cipher.doFinal(clearText.getBytes("UTF-8")), Base64.DEFAULT);
        } catch (Exception e) {
            Log.e("Security", "Encryption error");
            return clearText;
        }
    }

    public static String decrypt(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, getKey());
            return new String(cipher.doFinal(Base64.decode(encryptedText, Base64.DEFAULT)), "UTF-8");
        } catch (Exception e) {
            Log.e("Security", "Decryption error");
            return encryptedText;
        }
    }

    // http://stackoverflow.com/questions/26881925/how-can-i-to-determine-whether-the-device-is-open-wifi-hotspot-on-android
    // http://stackoverflow.com/questions/28905604/android-detecting-if-wifi-is-wep-wpa-wpa2-etc-programmatically
    public static boolean checkWifiSecurity() {
        WifiManager wifi = (WifiManager) App.getContext().getSystemService(Context.WIFI_SERVICE);
        List<ScanResult> networkList = wifi.getScanResults();
        WifiInfo wi = wifi.getConnectionInfo();
        String currentSSID = wi.getSSID();

        if (networkList != null) {
            for (ScanResult network : networkList) {
                if (currentSSID.equals("\"" + network.SSID + "\"")) {
                    String Capabilities =  network.capabilities;
                    return (Capabilities.contains("WPA2") || Capabilities.contains("WPA"));
                }
            }
        }
        return false;
    }

}
