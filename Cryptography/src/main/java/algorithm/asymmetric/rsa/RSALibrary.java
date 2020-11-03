package algorithm.asymmetric.rsa;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;

/**
 * @author Sadman
 */
public class RSALibrary {

    private static PrivateKey privateKey;
    private static PublicKey publicKey;

    public static void generateKeys() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom();
        kpg.initialize(2048,secureRandom);
        KeyPair kp = kpg.generateKeyPair();
        publicKey = kp.getPublic();
        privateKey = kp.getPrivate();

        String path1 = "KeyPair/publicKey";
        File f1 = new File(path1);
        f1.getParentFile().mkdirs();
        FileOutputStream fos1 = new FileOutputStream(f1);
        fos1.write(publicKey.getEncoded());
        fos1.flush();
        fos1.close();

        String path2 = "KeyPair/privateKey";
        File f2 = new File(path2);
        f2.getParentFile().mkdirs();
        FileOutputStream fos2 = new FileOutputStream(f2);
        fos2.write(privateKey.getEncoded());
        fos2.flush();
        fos2.close();
    }

    public static String encrypt(String plainText, PrivateKey privatekey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privatekey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes("UTF-8")));
    }

    public static String decrypt(String cipherText, PublicKey publickey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publickey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(cipherText.getBytes("UTF-8")));
    }

    public static void main(String[] args) throws Exception {
        RSALibrary.generateKeys();
        System.out.println(RSALibrary.encrypt("Secret",privateKey));
        String cipher = RSALibrary.encrypt("Secret",privateKey);
        System.out.println(RSALibrary.decrypt(cipher,publicKey));
    }
}
