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
		
		System.out.println("未加密明文："+clearText);
		byte[] cipherText=rsaEncrypt(clearText.getBytes(),Base64.decode(pubKey));
		System.out.println("加密后："+Base64.encode(cipherText));
        String priKey="3sdafagdf";
        byte[] dectyptText=rsaDecrypt(cipherText, Base64.decode(priKey));
        System.out.println("解密后："+new String(dectyptText));
	}
	
	//公钥加密
	public static byte[] rsaEncrypt(byte[] data,byte[] pubKey) {
		try {
			
			//获取公钥
			X509EncodedKeySpec x=new X509EncodedKeySpec(pubKey);
			
			//密钥工厂初始化
			KeyFactory keyFactory=KeyFactory.getInstance("RSA");
			
			//生成公钥
			PublicKey publicKey=keyFactory.generatePublic(x);
			
			//数据加密
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
	
	//私钥解密
	public static byte[] rsaDecrypt(byte[] data,byte[] priKey) {
		try {
			
			//获取私钥
			PKCS8EncodedKeySpec x=new PKCS8EncodedKeySpec(priKey);
			
			//密钥工厂初始化
			KeyFactory keyFactory=KeyFactory.getInstance("RSA");
			
			//生成公钥
			PublicKey privateKey=keyFactory.generatePublic(x);
			
			//数据解密
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
