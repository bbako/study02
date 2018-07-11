package com.nuritelecom.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nuritelecom.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;




public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Inject
	MemberService mservice;

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object memberVO = modelMap.get("MemberVO");

		if (memberVO != null) {

			session.setAttribute(LOGIN, memberVO);

			if(request.getParameter("useCookie")!=null){
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60*60*24*7);
				response.addCookie(loginCookie);
			}
			Object dest = session.getAttribute("dest");
			response.sendRedirect(dest != null ? (String)dest:"/index");

		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();

		if (session.getAttribute(LOGIN) != null) {
			session.removeAttribute(LOGIN);
		}

		return true;
	}

}
