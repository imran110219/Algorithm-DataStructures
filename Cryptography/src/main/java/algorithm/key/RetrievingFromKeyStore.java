package algorithm.key;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import java.security.KeyStore.SecretKeyEntry;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author Sadman
 */
public class RetrievingFromKeyStore {
    public static void main(String args[]) throws Exception{
        //Creating the KeyStore object
        KeyStore keyStore = KeyStore.getInstance("JCEKS");

        //Loading the the KeyStore object
        char[] password = "changeit".toCharArray();
        java.io.FileInputStream fis = new FileInputStream("C:/Program Files/Java/jre1.8.0_71/lib/security/cacerts");

        keyStore.load(fis, password);

        //Creating the KeyStore.ProtectionParameter object
        ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);

        //Creating SecretKey object
        SecretKey mySecretKey = new SecretKeySpec("myPassword".getBytes(), "DSA");

        //Creating SecretKeyEntry object
        SecretKeyEntry secretKeyEntry = new SecretKeyEntry(mySecretKey);
        keyStore.setEntry("secretKeyAlias", secretKeyEntry, protectionParam);

        //Storing the KeyStore object
        java.io.FileOutputStream fos = null;
        fos = new java.io.FileOutputStream("newKeyStoreName");
        keyStore.store(fos, password);

        //Creating the KeyStore.SecretKeyEntry object
        SecretKeyEntry secretKeyEnt = (SecretKeyEntry)keyStore.getEntry("secretKeyAlias", protectionParam);

        //Creating SecretKey object
        SecretKey mysecretKey = secretKeyEnt.getSecretKey();
        System.out.println("Algorithm used to generate key : "+mysecretKey.getAlgorithm());
        System.out.println("Format used for the key: "+mysecretKey.getFormat());
    }
}
