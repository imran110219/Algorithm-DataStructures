package certificate;

import sun.security.tools.keytool.CertAndKeyGen;
import sun.security.x509.X500Name;

import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;

/**
 * @author Sadman
 */
public class CertificateMain {
    public static void main(String[] args) throws Exception {

//        String loc = "E:/Office/Digital Certificate/local.keystore";
//        X509Certificate certificate = DigitalCertificate.generateSunCertificate();
//        PrivateKey privateKey = DigitalCertificate.generateSunPrivateKey();
//        System.out.println(certificate.getSubjectDN().getName());
//        System.out.println(certificate.getIssuerDN().getName());
//        System.out.println(privateKey.getEncoded().toString());
        String loc = "new.keystore";
        String password = "123456";
        for(Certificate cer : DigitalCertificate.getCertificateFromKeystore(loc, password)) {
            System.out.println(cer.toString());
        }
        for(PrivateKey privateKey : DigitalCertificate.getPrivateKeyFromKeystore(loc, password)) {
            System.out.println(privateKey.toString());
        }
        System.out.println(DigitalCertificate.getCertificateFromKeystore(loc, password).size());

//        Certificate certificate = DigitalCertificate.getCertificateFromKeystore(loc, password).get(0);
//        PrivateKey privateKey = DigitalCertificate.getPrivateKeyFromKeystore(loc, password).get(0);
//        CertAndKeyGen keypair = DigitalCertificate.generateCertAndKeyGen();
//        X500Name x500Name = new X500Name("Sadman Sobhan", "Engineering", "Cipher Text", "Dhaka", "Dhaka", "BD");
//        keypair.generate(512);
//        X509Certificate certificate =  keypair.getSelfCertificate(x500Name, new Date(), 365 * 24 * 60 * 60);
//        PrivateKey privateKey = keypair.getPrivateKey();
//
//        String encrypted = DigitalCertificate.encrypt(certificate, "Test");
//        System.out.println(encrypted);
//        System.out.println(DigitalCertificate.decrypt(privateKey, encrypted));
//
//        byte[] signedMessage = DigitalCertificate.sign("SHA256withRSA",privateKey,"Test");
//        System.out.println(signedMessage);
//        System.out.println(DigitalCertificate.verify("SHA256withRSA", certificate, "Test", signedMessage));
    }
}
