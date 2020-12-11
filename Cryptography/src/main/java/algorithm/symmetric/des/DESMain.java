package algorithm.symmetric.des;

import algorithm.symmetric.aes.AESLibrary;

/**
 * @author Sadman
 */
public class DESMain {
    public static void main(String[] args) throws Exception {
        final String secretKey = "Bar12345Bar12345";


        String originalString = "howtodoinjava.com";
        DESLibrary.generateKey();
        DESLibrary.generateKey("tan");
        String encryptedString = DESLibrary.encrypt(originalString) ;
        String decryptedString = DESLibrary.decrypt(encryptedString) ;

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }
}
