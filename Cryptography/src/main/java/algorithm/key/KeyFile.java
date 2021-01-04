package algorithm.key;

import org.bouncycastle.openssl.PKCS8Generator;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemObjectGenerator;
import org.bouncycastle.util.io.pem.PemWriter;
import sun.misc.BASE64Decoder;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author Sadman
 */
public class KeyFile {

    public static PublicKey getPemPublicKey(String filename, String algorithm) throws Exception {
        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int) f.length()];
        dis.readFully(keyBytes);
        dis.close();

        String temp = new String(keyBytes);
        String publicKeyPEM = temp.replace("-----BEGIN PUBLIC KEY-----", "");
        publicKeyPEM = publicKeyPEM.replace("-----END PUBLIC KEY-----", "");


        BASE64Decoder b64 = new BASE64Decoder();
        byte[] decoded = b64.decodeBuffer(publicKeyPEM);

        X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
        KeyFactory kf = KeyFactory.getInstance(algorithm);
        return kf.generatePublic(spec);
    }

    public static PublicKey get(String filename)
            throws Exception {

        byte[] keyBytes = Files.readAllBytes(Paths.get(filename));

        X509EncodedKeySpec spec =
                new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("AES");
        keyGen.initialize(512);
        KeyPair keyPair = keyGen.genKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
//        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

        try(JcaPEMWriter pemWriter = new JcaPEMWriter(new FileWriter("public.pem"))) {
            pemWriter.writeObject(privateKey);
        }

        PublicKey newpublicKey = KeyFile.get("public.pem");
//        PublicKey newpublicKey = KeyFile.getPemPublicKey("public.pem","RSA");
        System.out.println(newpublicKey);


//        File f = new File("public.pem");
//        FileInputStream fis = new FileInputStream(f);
//        DataInputStream dis = new DataInputStream(fis);
//        byte[] keyBytes = new byte[(int) f.length()];
//        dis.readFully(keyBytes);
//        dis.close();
//
//        String temp = new String(keyBytes);
//        String publicKeyPEM = temp.replace("-----BEGIN PUBLIC KEY-----", "");
//        publicKeyPEM = publicKeyPEM.replace("-----END PUBLIC KEY-----", "");
//        publicKeyPEM = publicKeyPEM.replace("\n", "");
//        System.out.println(publicKeyPEM);
    }
}
