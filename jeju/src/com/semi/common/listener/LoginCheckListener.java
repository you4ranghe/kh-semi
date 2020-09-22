package com.semi.common.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginCheckListener
 *
 */
@WebListener
public class LoginCheckListener implements HttpSessionListener, HttpSessionAttributeListener {

	private static int connectCount;
	//static 하면 어디서도 사용이 가능
	
	
    /**
     * Default constructor. 
     */
    public LoginCheckListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
        System.out.println("세션생성 create "); 
    	//여기서 접속자수 count 하게 되면 index페이지에 접속만해도 세션이 생성됨
        //그래서 attribute add 와 remove에서 로직을 짜야한다

    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         System.out.println("세션삭제 destroy");
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         System.out.println("세션객체 속성값(데이터) 추가");
         connectCount++;
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	System.out.println("세션객체 속성값(데이터) 삭제");
    	connectCount--;
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	System.out.println("세션객체 속성값(데이터) 대체/변경");
    }
    
    public static int getConnectCount() {
    	return connectCount;
    }
	
}
