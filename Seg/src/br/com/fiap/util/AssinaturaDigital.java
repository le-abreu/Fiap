package br.com.fiap.util;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class AssinaturaDigital {

	private static Signature signature;
	private static MessageDigest messageDigest;
	
	static{
		try {
			messageDigest  =  MessageDigest.getInstance("MD5");
			signature = Signature.getInstance("DSA", messageDigest.getProvider());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static String assinarDigitalmente(String string, PrivateKey chavePrivate) {
		try {
			signature.initSign(chavePrivate);
			signature.update(string.getBytes());
			byte[] signArray = signature.sign();
			String sign = new String(signArray);
			return sign;
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean isAssinadoDigitalmente(String string, String sign, PublicKey chavePublica){
		try {
			signature.initVerify(chavePublica);
			signature.update(string.getBytes());
			return signature.verify(sign.getBytes());
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		return false;
	}
	
    public static KeyPair gerarChaves() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("DAS");
            kpg.initialize(1024);
            KeyPair kp = kpg.generateKeyPair();
            return kp;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
