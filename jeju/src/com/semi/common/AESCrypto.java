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
//양방향 암호화처리시에서 key관리가 중요하다.

public class AESCrypto {
	
	private static SecretKey key; //암호화키 객체 SecretKey객체이용
	private String path; //key를 저장한 위치(경로)
	
	public AESCrypto() {
		//생성과 동시에 key값을 가져와야한다.
		//key가 없으면 암호화 key(SecretKey)를 생성하고
		//있으면 원래있는 key(SecretKey)를 가져온다
		
		//WEB-INF경로 가져오기(외부에서 접근이 불가능) 가져와서 내가 선언한 변수(경로로 설정된) 넣기
		this.path=AESCrypto.class.getResource("/").getPath();
	
		//key가 있는지 확인
		File f = new File(this.path+"/bslove.bs");
		
		if(f.exists()) {
			//있으면 bslove.bs파일을 불러오기
			try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f))) {
				key=(SecretKey)(ois.readObject());
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			//key 객체를 만들고 파일에 저장 //없으면 만들기
			if(key==null) {
				getGenerator();
			}
			
		}

	}
	
	private void getGenerator() {
		//랜덤값을 가져오는 객체 => key값을 만들때 salt(기준이되는값)
		SecureRandom ser = new SecureRandom();
		//key를 생성하는 객체
		
		KeyGenerator keygen=null;
		try { //알고리즘 설정및 예외처리
			keygen=KeyGenerator.getInstance("AES");
			keygen.init(128,ser); //초기화 128 비트 난수객체 넣어서
			key=keygen.generateKey(); //생성한 키를 key를 넣기
			
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		//생성한 key를 파일로 저장해서 현재 생성된 key만 이용할수 있게 처리해야 한다.
		File f = new File(this.path+"/bslove.bs"); // 위에 경로랑 똑같이 호출해서 담기
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){
			
			oos.writeObject(this.key); //파일을 불러와서 아웃풋으로 암호화해 생성된 key를  다시 돌려보낸다
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//암호화 메소드 작성(공용사용 static)        //호출하는 쪽에서 예외처리하기 위해 throws 던져준다
	public static String encrypt(String str) throws 
	NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
	BadPaddingException ,IllegalBlockSizeException{
		//Cipher객체를 이용해서 key값을 가지고 암호화 작업을 한다

		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		//매개변수로 넘어온 값을 암호화 해주기
		//byte로 변환해서 암호화 처리를 해준다
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
		//암호화의 반대로 하면된다
		byte[] decodeStr= Base64.getDecoder().decode(str.getBytes(Charset.forName("UTF-8")));
		byte[] decypt = cipher.doFinal(decodeStr);
		//형변환 해준다
		return new String(decypt);
		
	}

}//클래스
