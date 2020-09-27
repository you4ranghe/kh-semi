package com.semi.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.semi.member.model.vo.Member;
import com.semi.partner.model.vo.Partner;
/**
 * Servlet Filter implementation class PartnerFilter
 */
@WebFilter("/partner/*")
public class PartnerFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PartnerFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpSession session = ((HttpServletRequest)request).getSession(false);
		Member loginm=(Member)(session.getAttribute("logginedMember"));
		Partner loginp = (Partner)(session.getAttribute("logginedPartner"));
		if(loginm==null) {
			
			request.setAttribute("msg", "로그인을 해주세요 !");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			
			return;
		}else if(loginp==null) {
			request.setAttribute("msg", "파트너만 접근이 가능합니다 !");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			
			return;
			
		}
		

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
