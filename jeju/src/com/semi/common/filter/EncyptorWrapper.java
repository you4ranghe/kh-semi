
package com.semi.common.filter;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class EncyptorWrapper extends HttpServletRequestWrapper {
	
	//매개변수로 받는 생성자를 만들어줘야한다
	public EncyptorWrapper(HttpServletRequest request) {
		super(request);
	}
	
	//재정의 하고 싶은 메소드 작성 =>@Override
	@Override
	public String getParameter(String name) {
		
		//클라이언트가 전달한 값중 비밀번호(password를 가진 name값만) 암호화처리
		//나머지 name은 정상적으로 처리
		
		String returnValue="";
		
		
		if(name.equals("password")) {
			//암호화처리후 반환
			String pw=super.getParameter(name);
																				System.out.println(pw);
			//원본값을 암호화처리한다
			String encPw=getSha512(pw);
																				System.out.println(encPw);
			returnValue=encPw;
		
		
		}else {
			//정상적으로 반환
			returnValue=super.getParameter(name);
			//원래 부모로가게 반환
		}
		

		return returnValue;
	}
	
	//암호화 처리하는 함수만들자
	private String getSha512(String value) {
		
		String encPwd=null; //암호환 값 보관
		
		//암호화처리 객체 생성
		MessageDigest md=null;
		//1.암호화 알고리즘을 불러온다
		try {
			md=MessageDigest.getInstance("SHA-512");
		
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		//2.알고르짐을 이용해서 Byte단위로 암호화 처리를 한다.
		byte[] bytes = value.getBytes(Charset.forName("UTF-8")); //우리가 가진 value값(password)을 먼저 byte단위로 변경
		//byte값을 MessageDigest를 이용해서 암호화한다
		//md.update() 메소드를 이용한다
		md.update(bytes); //md에 지정된 update()암호화 알고리즘에 의해 매개변수의 값을 암호화 한다.
		
		//3.Byte로 쪼개서 암호화한 내용을 String값으로 변환
		encPwd=Base64.getEncoder().encodeToString(md.digest());
		
		//4.변환값 리턴!
		return encPwd;

	}
	

}
