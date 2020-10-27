package algorithm.symmetric.des;

import algorithm.symmetric.aes.AESLibrary;

/**
 * @author Sadman
 */
public class DESMain {
    public static void main(String[] args) {
        final String secretKey = "ssshhhhhhhhhhh!!!!";

        String originalString = "howtodoinjava.com";
        String encryptedString = DESLibrary.encrypt(originalString, secretKey) ;
        String decryptedString = DESLibrary.decrypt(encryptedString, secretKey) ;

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }
}
