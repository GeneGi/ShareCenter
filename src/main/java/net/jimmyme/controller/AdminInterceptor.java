package net.jimmyme.controller;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.jimmyme.model.User;
import net.jimmyme.param.StaticParam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		
		User user = (User) request.getSession().getAttribute("user");
		//System.out.println(request.getSession().getAttribute("user")+"---AccessInterceptor");
		if(user.getUserType() != StaticParam.USER_TYPE_ADMIN){
			 try {
				request.getRequestDispatcher("/login").forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return false;
		}
		
		return true;
	}
	
}
