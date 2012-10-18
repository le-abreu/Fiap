package br.com.fiap.util;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class AssinaturaDigital {

	public static String assinarDigitalmente(String string, PrivateKey chavePrivate) {
		Signature signature;
		try {
			signature = Signature.getInstance("DSA");
			signature.initSign(chavePrivate);
			signature.update(string.getBytes());
			byte[] signArray = signature.sign();
			String sign = new String(signArray);
			
			return sign;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean isAssinadoDigitalmente(String string, String sign, PublicKey chavePublica){
		Signature signature;
		try {
			signature = Signature.getInstance("DSA");
			signature.initVerify(chavePublica);
			signature.update(string.getBytes());
			return signature.verify(sign.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
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
