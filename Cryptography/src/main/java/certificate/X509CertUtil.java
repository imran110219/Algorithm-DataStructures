package certificate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Random;

import sun.security.x509.AlgorithmId;
import sun.security.tools.keytool.CertAndKeyGen;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateIssuerName;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateSubjectName;
import sun.security.x509.CertificateValidity;
import sun.security.x509.CertificateVersion;
import sun.security.x509.CertificateX509Key;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

/**
 * @author Sadman
 */

public class X509CertUtil {
    private static final String ALGORITHM = "SHA1PRNG";
    private static final String PROVIDER = "SUN";
    /* 指定加密算法为RS A */
    private static final String PUBLIC_KEY_ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
    /* 密钥长度，用来初始化 */
    private static final int KEYSIZE = 1024;

    private static final String CERTIFICATE_TYPE = "X.509";

    private static final String KEY_STORE_TYPE = "pkcs12";

    // 1 years
    private static final long VALIDITY = 365 * 24 * 60 * 60;

    public static void main(String args[]) throws IOException {
        // CN commonName 一般名字
        // L localityName 地方名
        // ST stateOrProvinceName 州省名
        // O organizationName 组织名
        // OU organizationalUnitName 组织单位名
        // C countryName 国家
        // STREET streetAddress 街道地址
        // DC domainComponent 领域
        // UID user id 用户ID
        String issueName = "CN=RootCA,ST=RootCAState,L=RootCALocality,OU=RootCAOrganizationUnit,O=RootCAOrganization";
        X500Name issue = new X500Name(issueName);
        String issuePfxPath = "ROOTCA.pfx";
        String issueCrtPath = "ROOTCA.crt";
        String issueAlias = "RootCA";
        String issuePassword = "root";

        String subjectName = "CN=HPE,ST=subjectState,L=subjectLocality,OU=HPE,O=HPE";
        X500Name subject = new X500Name(subjectName);
        String subjectPfxPath = "ISSUE.pfx";
        String subjectCrtPath = "ISSUE.crt";
        String subjectAlias = "HPE";
        String subjectPassword = "hpe";

        try {
            X509CertUtil.createRootCert(issuePfxPath, issueCrtPath, issue);

            X509CertUtil.createIssueCert(issue, subject, issueAlias, issuePfxPath, issuePassword, issueCrtPath, subjectAlias, subjectPfxPath, subjectPassword, subjectCrtPath);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建根证书（证书有效期10年，私钥保存密码“root”，公钥算法“RSA”，签名算法“MD5WithRSA”）
     *
     * @param issuePfxPath
     * @param issueCrtPath
     * @param issue
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws CertificateException
     * @throws IOException
     * @throws InvalidKeyException
     * @throws SignatureException
     * @throws NoSuchProviderException
     */
    public static void createRootCert(String issuePfxPath, String issueCrtPath, X500Name issue) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException, InvalidKeyException, SignatureException, NoSuchProviderException {
        CertAndKeyGen rootCertAndKeyGen = new CertAndKeyGen(PUBLIC_KEY_ALGORITHM, SIGNATURE_ALGORITHM);
        rootCertAndKeyGen.setRandom(getSecureRandom());
        rootCertAndKeyGen.generate(KEYSIZE);

        // 10 years
        long validity = 3650 * 24 * 60 * 60;
        X509Certificate rootCertificate = rootCertAndKeyGen.getSelfCertificate(issue, validity);
        X509Certificate[] chain = new X509Certificate[] { rootCertificate };

        String password = "root";
        createKeyStore("RootCA", rootCertAndKeyGen.getPrivateKey(), password.toCharArray(), chain, issuePfxPath);

        FileOutputStream fos = new FileOutputStream(new File(issueCrtPath));
        fos.write(rootCertificate.getEncoded());
        fos.close();
    }

    /**
     * 颁布证书
     *
     * @param issue
     * @param subject
     * @param issueAlias
     * @param issuePfxPath
     * @param issuePassword
     * @param issueCrtPath
     * @param subjectAlias
     * @param subjectPfxPath
     * @param subjectPassword
     * @param subjectCrtPath
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws IOException
     * @throws CertificateException
     * @throws KeyStoreException
     * @throws UnrecoverableKeyException
     * @throws SignatureException
     * @throws NoSuchProviderException
     */
    public static void createIssueCert(X500Name issue, X500Name subject, String issueAlias, String issuePfxPath, String issuePassword, String issueCrtPath, String subjectAlias, String subjectPfxPath, String subjectPassword, String subjectCrtPath)
            throws NoSuchAlgorithmException, InvalidKeyException, CertificateException, IOException, UnrecoverableKeyException, KeyStoreException, NoSuchProviderException, SignatureException {
        CertAndKeyGen certAndKeyGen = new CertAndKeyGen(PUBLIC_KEY_ALGORITHM, SIGNATURE_ALGORITHM);
        certAndKeyGen.setRandom(getSecureRandom());
        certAndKeyGen.generate(KEYSIZE);

        Date firstDate = new Date();
        Date lastDate = new Date();
        lastDate.setTime(firstDate.getTime() + VALIDITY * 1000);
        CertificateValidity interval = new CertificateValidity(firstDate, lastDate);

        X509CertInfo info = new X509CertInfo();
        // Add all mandatory attributes
        // 证书版本号
        info.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));
        // 序列号
        info.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber(new Random().nextInt() & 0x7fffffff));
        // 签名算法
        AlgorithmId algID = AlgorithmId.get(SIGNATURE_ALGORITHM);
        info.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(algID));
        // subject：主体名
        info.set(X509CertInfo.SUBJECT, subject);
        // key：公钥
        info.set(X509CertInfo.KEY, new CertificateX509Key(certAndKeyGen.getPublicKey()));
        // 证书有效期
        info.set(X509CertInfo.VALIDITY, interval);
        // issuer：签发者
        info.set(X509CertInfo.ISSUER, issue);

        PrivateKey privateKey = readPrivateKey(issueAlias, issuePfxPath, issuePassword);
        X509CertImpl cert = new X509CertImpl(info);
        cert.sign(privateKey, SIGNATURE_ALGORITHM);
        X509Certificate certificate = cert;
        X509Certificate issueCertificate = readX509Certificate(issueCrtPath);
        X509Certificate[] chain = new X509Certificate[] { certificate, issueCertificate };

        createKeyStore(subjectAlias, certAndKeyGen.getPrivateKey(), subjectPassword.toCharArray(), chain, subjectPfxPath);

        FileOutputStream fos = new FileOutputStream(new File(subjectCrtPath));
        fos.write(certificate.getEncoded());
        fos.close();
    }

    /**
     * 读取PFX文件中的私钥
     *
     * @param alias
     *            别名
     * @param pfxPath
     *            PFX文件路径
     * @param password
     *            密码
     * @return
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     * @throws IOException
     * @throws UnrecoverableKeyException
     */
    public static PrivateKey readPrivateKey(String alias, String pfxPath, String password) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException {
        KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE);
        FileInputStream fis = new FileInputStream(pfxPath);
        keyStore.load(fis, password.toCharArray());
        fis.close();
        return (PrivateKey) keyStore.getKey(alias, password.toCharArray());
    }

    /**
     * 读取X.509证书
     *
     * @param crtPath
     *            证书路径
     * @return
     * @throws CertificateException
     * @throws IOException
     */
    public static X509Certificate readX509Certificate(String crtPath) throws CertificateException, IOException {
        FileInputStream inStream = new FileInputStream(crtPath);
        CertificateFactory cf = CertificateFactory.getInstance(CERTIFICATE_TYPE);
        X509Certificate certificate = (X509Certificate) cf.generateCertificate(inStream);
        inStream.close();
        return certificate;
    }

    /**
     * Get SecureRandom number.
     *
     * @return
     */
    private static SecureRandom getSecureRandom() {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance(ALGORITHM, PROVIDER);
            return secureRandom;
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 证书私钥存储设施
     *
     * @param alias
     *            KeyStore别名
     * @param key
     *            密钥（这里是私钥）
     * @param password
     *            保存密码
     * @param chain
     *            证书链
     * @param filePath
     *            PFX文件路径
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     * @throws IOException
     */
    private static void createKeyStore(String alias, Key key, char[] password, Certificate[] chain, String filePath) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        KeyStore keyStore = KeyStore.getInstance(KEY_STORE_TYPE);
        keyStore.load(null, password);
        keyStore.setKeyEntry(alias, key, password, chain);
        FileOutputStream fos = new FileOutputStream(filePath);
        keyStore.store(fos, password);
        fos.close();
    }
}
