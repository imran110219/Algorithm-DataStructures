package algorithm.keygen;

import javax.crypto.KeyGenerator;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sadman
 */
public class KeyGeneration {
    public static void main(String args[]) throws Exception{

        List<String> algorithms = Arrays.asList("AES", "DES", "DESede", "HmacSHA1", "HmacSHA256");
        //AES (128)
        //DES (56)
        //DESede (168)
        //HmacSHA1
        //HmacSHA256

        SecureRandom secRandom = new SecureRandom();
        for (String algorithm : algorithms) {
            KeyGenerator keyGen = KeyGenerator.getInstance(algorithm);
            Key key = keyGen.generateKey();
            System.out.println(key);
        }
    }
}
