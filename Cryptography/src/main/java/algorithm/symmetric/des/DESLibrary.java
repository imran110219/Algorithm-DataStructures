package algorithm.symmetric.des;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author Sadman
 */
public class DESLibrary {
    private static SecretKey key;
    private static String str;

    public static void generateKey() throws NoSuchAlgorithmException {
        key = KeyGenerator.getInstance("DES").generateKey();
        str = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println(Base64.getEncoder().encodeToString(key.getEncoded()));
    }

    public static void generateKey(String key) throws NoSuchAlgorithmException {
        byte[] decodedKey = Base64.getDecoder().decode(str);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
        System.out.println(Base64.getEncoder().encodeToString(originalKey.getEncoded()));
    }

    public static String encrypt(String strToEncrypt)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
