package algorithm.symmetric.aes;

import java.util.Base64;

/**
 * @author Sadman
 */
public class AESMain {
    public static void main(String[] args) throws Exception {
        final String secretKey = "ABCDEF";
        String originalString = "howtodoinjava.com";

//        AESLibrary.generateKey();
        AESLibrary.generateKey(secretKey);

        String encryptedString = AESLibrary.encrypt(originalString) ;
        String decryptedString = AESLibrary.decrypt(encryptedString) ;


        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }
}
