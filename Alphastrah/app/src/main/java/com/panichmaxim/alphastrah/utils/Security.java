package com.panichmaxim.alphastrah.utils;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.security.keystore.KeyProperties;
import android.util.Base64;
import android.util.Log;

import com.panichmaxim.alphastrah.App;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.BitSet;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class Security {

    public static boolean checkRoot() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            final BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            return in.readLine() != null;
        } catch (Throwable e) {
            return false;
        } finally {
            if (process !=null) process.destroy();
        }
    }

    // http://stackoverflow.com/questions/19957052/android-encryption-pad-block-corrupted-exception

    private static SecretKeySpec getKey() throws Exception {
//        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
//        keyStore.load(null);
//        return (SecretKey) keyStore.getKey(alias, null);
        if (SimpleStorage.getInstance().getCryptoKey() == null) {
            byte[] seed = new byte[128];
            SecureRandom sRnd = SecureRandom.getInstance("SHA1PRNG");
            sRnd.nextBytes(seed);
            sRnd.setSeed(seed);
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES);
            keyGenerator.init(128, sRnd);
            SecretKeySpec keySpec = new SecretKeySpec(keyGenerator.generateKey().getEncoded(), "AES");
            SimpleStorage.getInstance().saveCryptoKey(keySpec);
            return keySpec;
        } else {
            return SimpleStorage.getInstance().getCryptoKey();
        }
    }

    public static String encrypt(String clearText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, getKey());
        return Base64.encodeToString(cipher.doFinal(clearText.getBytes("UTF-8")), Base64.DEFAULT);
    }

    public static String decrypt(String encryptedText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, getKey());
        return new String( cipher.doFinal(Base64.decode(encryptedText, Base64.DEFAULT)), "UTF-8");
    }

    // http://stackoverflow.com/questions/26881925/how-can-i-to-determine-whether-the-device-is-open-wifi-hotspot-on-android
    public static boolean checkWifiSecurity() {
        WifiManager wifiManager = (WifiManager) App.getContext().getSystemService(Context.WIFI_SERVICE);
        Method[] methods = wifiManager.getClass().getDeclaredMethods();

        for (Method m: methods) {
            if(m.getName().equals("getWifiApConfiguration")) {
                try {
                    WifiConfiguration wifiConfiguration = (WifiConfiguration) m.invoke(wifiManager);
                    BitSet allowedAuthAlgorimths = wifiConfiguration.allowedAuthAlgorithms;
                    // GOSH
                } catch (Exception e) {
                    Log.e("Error", e.getMessage());
                    return false;
                }
            }
        }
        return true;
    }

}
