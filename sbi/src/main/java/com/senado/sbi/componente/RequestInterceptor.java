package com.senado.sbi.componente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

	/**
	 * This is not a good practice to use sysout. Always integrate any logger with
	 * your application. We will discuss about integrating logger with spring boot
	 * application in some later article
	 */
	private static final Log LOG = LogFactory.getLog(RequestInterceptor.class);
	private static final String DEFAULT_LAYOUT = "plantilla/base";
	private static final String DEFAULT_VIEW_ATTRIBUTE_NAME = "view";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

		String cURL = request.getRequestURI();
		request.setAttribute("iniTiempo", System.currentTimeMillis());

		if (cURL.equals("/") || cURL.equals("/login")) {
			return true;
		}

		// SessionUsu user = (SessionUsu) request.getSession().getAttribute("Usuario");

		/*
		 * if (user == null) {
		 * 
		 * response.sendRedirect("/"); return true; } else { return true; }
		 */

		//response.sendRedirect("/");

		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView == null || !modelAndView.hasView()) {
			return;
		}
		String originalViewName = modelAndView.getViewName();
		if (isRedirectOrForward(originalViewName)) {
			return;
		}
		modelAndView.setViewName(DEFAULT_LAYOUT);
		modelAndView.addObject(DEFAULT_VIEW_ATTRIBUTE_NAME, originalViewName);
	}

	private boolean isRedirectOrForward(String viewName) {
		return viewName.startsWith("redirect:") || viewName.startsWith("forward:");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3)
			throws Exception {

		long startTime = (long) request.getAttribute("iniTiempo");
		LOG.info("URL:" + request.getRequestURL().toString() + " TIEMPO: "
				+ (System.currentTimeMillis() - startTime + " ms"));

	}

}