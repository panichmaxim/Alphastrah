package com.panichmaxim.alphastrah.utils;

import android.security.keystore.KeyProperties;
import android.util.Base64;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class Security {

    private static SecretKeySpec getKey() throws Exception {
//        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
//        keyStore.load(null);
//        return (SecretKey) keyStore.getKey(alias, null);
        if (SimpleStorage.getInstance().getCryptoKey().equals("")) {
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

}
