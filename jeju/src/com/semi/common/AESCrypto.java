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

//양방향 암호화처리 객체
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
			
		}else {
		
			if(key==null) {
				getGenerator();
			}
			
		}

	}
	
	private void getGenerator() {
		//랜덤값을 가져오는 객체 => key값을 만들때 salt(기준이되는값)
		SecureRandom ser = new SecureRandom();
		
		
		KeyGenerator keygen=null;
		try { 
			keygen=KeyGenerator.getInstance("AES");
			keygen.init(128,ser); 
			key=keygen.generateKey(); 
			
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		//생성한 key를 파일로 저장해서 현재 생성된 key만 이용할수 있게 처리해야 한다.
		File f = new File(this.path+"/bslove.bs"); 
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){
			
			oos.writeObject(this.key); 
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//암호화 메소드 작성
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
	
	//복호화 메스도 작성
	public static String decrypt(String str) throws NoSuchAlgorithmException, 
	NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException  {
		
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
	
		byte[] decodeStr= Base64.getDecoder().decode(str.getBytes(Charset.forName("UTF-8")));
		byte[] decypt = cipher.doFinal(decodeStr);
		
		return new String(decypt);
		
	}

}//클래스
