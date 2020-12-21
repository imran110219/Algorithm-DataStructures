package certificate;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

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

        Certificate certificate = DigitalCertificate.getCertificateFromKeystore(loc, password).get(0);
        PrivateKey privateKey = DigitalCertificate.getPrivateKeyFromKeystore(loc, password).get(0);
        System.out.println(DigitalCertificate.encrypt((X509Certificate) certificate, "Test"));
        String encrypted = DigitalCertificate.encrypt((X509Certificate) certificate, "Test");
        System.out.println(DigitalCertificate.decrypt(privateKey, encrypted));
        System.out.println(DigitalCertificate.sign("SHA1WithRSA",privateKey,"Test"));
        String signedMessage = DigitalCertificate.sign("SHA1WithRSA",privateKey,"Test");
        System.out.println(DigitalCertificate.verify("SHA1WithRSA", (X509Certificate)certificate, "Test", signedMessage));
    }
}
