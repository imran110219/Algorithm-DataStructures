package certificate;

import sun.security.tools.keytool.CertAndKeyGen;
import sun.security.x509.X500Name;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * @author Sadman
 */
public class DigitalCertificate {

    private static final int keysize = 1024;
    private static final String commonName = "www.test.de";
    private static final String organizationalUnit = "IT";
    private static final String organization = "test";
    private static final String city = "test";
    private static final String state = "test";
    private static final String country = "DE";
    private static final long validity = 1096; // 3 years
    private static final String alias = "tomcat";
    private static final char[] keyPass = "123456".toCharArray();

    public static X509Certificate generateSunCertificate() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, null);
        CertAndKeyGen keypair = new CertAndKeyGen("RSA", "SHA1WithRSA", null);
        X500Name x500Name = new X500Name(commonName, organizationalUnit, organization, city, state, country);
        keypair.generate(keysize);
        return keypair.getSelfCertificate(x500Name, new Date(), (long) validity * 24 * 60 * 60);
    }

    public static PrivateKey generateSunPrivateKey() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, null);
        CertAndKeyGen keypair = new CertAndKeyGen("RSA", "SHA1WithRSA", null);
        X500Name x500Name = new X500Name(commonName, organizationalUnit, organization, city, state, country);
        keypair.generate(keysize);
        return keypair.getPrivateKey();
    }

    public static List<Certificate> getCertificateFromKeystore(String keyLocation, String password) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {

        File file = new File(keyLocation);
        InputStream is = new FileInputStream(file);
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(is, password.toCharArray());

        List<Certificate> certificates = new ArrayList<>();

        Enumeration<String> enumeration = keystore.aliases();
        while (enumeration.hasMoreElements()) {
            String alias = enumeration.nextElement();
//            System.out.println("alias name: " + alias);
            Certificate certificate = keystore.getCertificate(alias);
            certificates.add(certificate);
//            System.out.println(certificate.toString());
        }
        return certificates;
    }

    public static List<PrivateKey> getPrivateKeyFromKeystore(String keyLocation, String password) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {

        File file = new File(keyLocation);
        InputStream is = new FileInputStream(file);
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(is, password.toCharArray());

        List<PrivateKey> privateKeys = new ArrayList<>();

        Enumeration<String> enumeration = keystore.aliases();
        while (enumeration.hasMoreElements()) {
            String alias = enumeration.nextElement();
//            System.out.println("alias name: " + alias);
            PrivateKey privateKey = (PrivateKey) keystore.getKey(alias, "123456".toCharArray());
            privateKeys.add(privateKey);
//            System.out.println(certificate.toString());
        }
        return privateKeys;
    }

    public static String encrypt(X509Certificate cert, String message) throws CertificateEncodingException, IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, cert);
        return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
    }

    public static String decrypt(PrivateKey key, String message) throws CertificateEncodingException, IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(message)));
    }

    public static String sign(String signatureAlgorithm, PrivateKey privateKey, String message) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        Signature signature = Signature.getInstance(signatureAlgorithm);
        signature.initSign(privateKey);
        signature.update(Base64.getDecoder().decode(message));
        return new String(signature.sign(),"UTF8");
    }

    public static boolean verify(String signatureAlgorithm, X509Certificate cert, String message, String signedMessage) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        Signature signature = Signature.getInstance(signatureAlgorithm);
        signature.initVerify(cert);
        signature.update(message.getBytes("UTF-8"));

        return signature.verify(signedMessage.getBytes("UTF-8"));
    }
}
