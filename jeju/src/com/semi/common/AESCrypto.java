package com.semi.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;



public class AESCrypto {
	
	private static SecretKey key; 
	private String path; 
	
	public AESCrypto() {

		this.path=AESCrypto.class.getResource("/").getPath();
	
		File f = new File(this.path+"/bslove.bs");
		
		if(f.exists()) {

			try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f))) {
				key=(SecretKey)(ois.readObject());
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println(key);
			System.out.println(f);
			
		}else {

			if(key==null) {
				getGenerator();
			}
			
		}

	}
	
	private void getGenerator() {
	
		SecureRandom ser = new SecureRandom();

		
		KeyGenerator keygen=null;
		try { 
			keygen=KeyGenerator.getInstance("AES");
			keygen.init(128,ser); 
			key=keygen.generateKey(); 
				
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		

		File f = new File(this.path+"/bslove.bs"); 
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){
			
			oos.writeObject(this.key);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static String encrypt(String str) throws 
	NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
	BadPaddingException ,IllegalBlockSizeException{
	

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		

		byte[] encrypt= str.getBytes(Charset.forName("UTF-8"));
		byte[] result=cipher.doFinal(encrypt);
		String strResult = Base64.getEncoder().encodeToString(result);
		
		return strResult;
	}
	

	public static String decrypt(String str) throws NoSuchAlgorithmException, 
	NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException  {
		
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);

		byte[] decodeStr= Base64.getDecoder().decode(str.getBytes(Charset.forName("UTF-8")));
		byte[] decypt = cipher.doFinal(decodeStr);


		return new String(decypt);
		
	}

}//클래스
