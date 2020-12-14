package algorithm.keygen;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * @author Sadman
 */
public class KeyGeneration {
    public static void main(String args[]) throws Exception{

        List<String> algorithms = Arrays.asList("DES", "AES", "DESede", "HmacSHA256", "HmacSHA1");
        //AES (128)
        //DES (56)
        //DESede (168)
        //HmacSHA1
        //HmacSHA256

        List<Key> keys = new ArrayList<>();

        SecureRandom secRandom = new SecureRandom();
        for (String algorithm : algorithms) {
            KeyGenerator keyGen = KeyGenerator.getInstance(algorithm);
            Key key = keyGen.generateKey();
            keys.add(key);
            System.out.println(key.getEncoded().length + "  " + key.getAlgorithm() + "  " + convertKeyToString(key));
            System.out.println(convertStringToKey(convertKeyToString(key),key.getAlgorithm()));

        }
    }

    public static String convertKeyToString(Key key){
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    public static Key convertStringToKey(String keyString, String algorithm){
        byte[] decodedKey = Base64.getDecoder().decode(keyString);
        Key key = new SecretKeySpec(decodedKey, 0, decodedKey.length, algorithm);
        return key;
    }
}
