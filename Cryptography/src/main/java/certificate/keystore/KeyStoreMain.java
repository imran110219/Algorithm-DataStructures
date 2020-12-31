package certificate.keystore;

import certificate.DigitalCertificate;
import sun.security.tools.keytool.CertAndKeyGen;
import sun.security.x509.X500Name;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.List;

/**
 * @author Sadman
 */
public class KeyStoreMain {
    public static void main(String[] args) throws Exception {
//        JKS, JCEKS, PKCS12, PKCS11 and DKS
        String[] keyStoreTypes = {"JKS", "JCEKS", "PKCS12", "PKCS11", "DKS", "BKS"};

        JavaKeyStore javaKeyStore = new JavaKeyStore(keyStoreTypes[1],"123456", "DemoJCEKS.jks");
        javaKeyStore.createEmptyKeyStore();
//        System.out.println(javaKeyStore.getKeyStore());

//        CertAndKeyGen keypair = DigitalCertificate.generateCertAndKeyGen();
//        X500Name x500Name = new X500Name("Sadman Sobhan", "Engineering", "Cipher Text", "Dhaka", "Dhaka", "BD");
//        keypair.generate(512);
//        X509Certificate certificate =  keypair.getSelfCertificate(x500Name, new Date(), 365 * 24 * 60 * 60);
//        PrivateKey privateKey = keypair.getPrivateKey();
//
//        javaKeyStore.setCertificateEntry("certificate",certificate);
//        javaKeyStore.setKeyEntry("privateKey",privateKey,"123456", new Certificate[]{certificate});
//
//        System.out.println(javaKeyStore.getEntry("privateKey"));
//        System.out.println(javaKeyStore.getCertificate("certificate"));

        CertAndKeyGen keypair1 = DigitalCertificate.generateCertAndKeyGen();
        X500Name x500Name1 = new X500Name("Md Amin", "Developer", "Dohatec", "Juraine", "Juraine", "US");
        keypair1.generate(512);
        X509Certificate certificate1 =  keypair1.getSelfCertificate(x500Name1, new Date(), 365 * 24 * 60 * 60);
        PrivateKey privateKey1 = keypair1.getPrivateKey();

//        javaKeyStore.setCertificateEntry("certificate1",certificate1);
        javaKeyStore.setKeyEntry("privateKey1",privateKey1,"123456", new Certificate[]{certificate1});

        System.out.println(javaKeyStore.getCertificate("privateKey1"));
        X509Certificate cer = (X509Certificate)javaKeyStore.getCertificate("privateKey1");
        PrivateKey key = (PrivateKey)javaKeyStore.getKey("privateKey1","123456");

        String enc = DigitalCertificate.encrypt(cer,"Test");
        System.out.println(enc);
        String plain = DigitalCertificate.decrypt(key,enc);
        System.out.println(plain);


        List<Certificate> list = javaKeyStore.getCertificateList();
        System.out.println(list.size());
    }
}
