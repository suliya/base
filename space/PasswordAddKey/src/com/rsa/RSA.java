package com.rsa;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;

public class RSA {

	public static void main(String[] args) {
		
		String clearText="123";
		String pubKey="3dadsfxfasdf";
		
		System.out.println("δ�������ģ�"+clearText);
		byte[] cipherText=rsaEncrypt(clearText.getBytes(),Base64.decode(pubKey));
		System.out.println("���ܺ�"+Base64.encode(cipherText));
        String priKey="3sdafagdf";
        byte[] dectyptText=rsaDecrypt(cipherText, Base64.decode(priKey));
        System.out.println("���ܺ�"+new String(dectyptText));
	}
	
	//��Կ����
	public static byte[] rsaEncrypt(byte[] data,byte[] pubKey) {
		try {
			
			//��ȡ��Կ
			X509EncodedKeySpec x=new X509EncodedKeySpec(pubKey);
			
			//��Կ������ʼ��
			KeyFactory keyFactory=KeyFactory.getInstance("RSA");
			
			//���ɹ�Կ
			PublicKey publicKey=keyFactory.generatePublic(x);
			
			//���ݼ���
			Cipher cipher=Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] result=cipher.doFinal(data);
			return result;
			
		} catch (NoSuchAlgorithmException  e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//˽Կ����
	public static byte[] rsaDecrypt(byte[] data,byte[] priKey) {
		try {
			
			//��ȡ˽Կ
			PKCS8EncodedKeySpec x=new PKCS8EncodedKeySpec(priKey);
			
			//��Կ������ʼ��
			KeyFactory keyFactory=KeyFactory.getInstance("RSA");
			
			//���ɹ�Կ
			PublicKey privateKey=keyFactory.generatePublic(x);
			
			//���ݽ���
			Cipher cipher=Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			byte[] clearText=cipher.doFinal(data);
			return clearText;
			
		} catch (NoSuchAlgorithmException  e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}

}