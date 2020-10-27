package algorithm.symmetric.aes;

/**
 * @author Sadman
 */
public class AESMain {
    public static void main(String[] args) {
        final String secretKey = "ssshhhhhhhhhhh!!!!";

        String originalString = "howtodoinjava.com";
        String encryptedString = AESLibrary.encrypt(originalString, secretKey) ;
        String decryptedString = AESLibrary.decrypt(encryptedString, secretKey) ;

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }
}
