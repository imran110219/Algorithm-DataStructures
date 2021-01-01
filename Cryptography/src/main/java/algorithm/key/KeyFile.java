package algorithm.key;

import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.util.io.pem.PemObjectGenerator;
import org.bouncycastle.util.io.pem.PemWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.security.*;

/**
 * @author Sadman
 */
public class KeyFile {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair keyPair = keyGen.genKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        try(JcaPEMWriter pemWriter = new JcaPEMWriter(new FileWriter("public.pem"))) {
            pemWriter.writeObject(publicKey);
        }
    }
}
