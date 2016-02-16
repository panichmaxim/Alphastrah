package com.panichmaxim.alphastrah.utils;

import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import java.security.KeyStore;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Security {

    private static String alias = "MyKey";

    private static SecretKey getKey() throws Exception {
        if (true) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
            keyGenerator.init(
                    new KeyGenParameterSpec.Builder(alias,
                            KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                            .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                            .build());
            return keyGenerator.generateKey();
        } else {
            KeyStore keyStore = KeyStore.getInstance    ("AndroidKeyStore");
            keyStore.load(null);
            return (SecretKey) keyStore.getKey(alias, null);
        }
    }

    public static String encrypt(String value) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, getKey());
        return new String(cipher.doFinal(value.getBytes()));
    }

    public static String decrypt(String value) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, getKey());
        return new String(cipher.doFinal(value.getBytes()));
    }

}
