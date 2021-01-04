package certificate.signature;

import java.lang.reflect.Array;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;

import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
/**
 * @author Sadman
 */
public class SignatureVerification {
    public static void main(String args[]) throws Exception{
        //Creating KeyPair generator object
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");

        //Initializing the key pair generator
        keyPairGen.initialize(2048);

        //Generate the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //Getting the privatekey from the key pair
        PrivateKey privKey = pair.getPrivate();

        //Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withDSA");

        //Initializing the signature
        sign.initSign(privKey);
        byte[] bytes = "Hello how are you".getBytes();
        byte[] bytes1 = "Hello how are you?".getBytes();

        //Adding data to the signature
        sign.update(bytes);

        //Calculating the signature
        byte[] signature = sign.sign();

        String signString = Base64.getEncoder().encodeToString(signature);

        byte[] signature1 = Base64.getDecoder().decode(signString);

        System.out.println(signature);
        System.out.println(signature1);
        System.out.println(Arrays.equals(signature,signature1));

        //Initializing the signature
        sign.initVerify(pair.getPublic());
        sign.update(bytes1);

        //Verifying the signature
        boolean bool = sign.verify(signature);

        if(bool) {
            System.out.println("Signature verified");
        } else {
            System.out.println("Signature failed");
        }
    }
}
