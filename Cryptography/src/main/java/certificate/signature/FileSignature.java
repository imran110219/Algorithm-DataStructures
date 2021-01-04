package certificate.signature;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;

public class FileSignature {
    public static void main(String[] args) throws Exception {

        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);

        byte[] messageBytes = Files.readAllBytes(Paths.get("C:\\Users\\Sadman\\Desktop\\Order.txt"));

        signature.update(messageBytes);
        byte[] digitalSignature = signature.sign();

        Files.write(Paths.get("C:\\Users\\Sadman\\Desktop\\SignedOrder.txt"), digitalSignature);
    }
}
