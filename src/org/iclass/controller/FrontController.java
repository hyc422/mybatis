package org.iclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//css와 js도 요청에 대한 응답으로 처리해야 하므로 구별을 위해 확장자 설정
@WebServlet(urlPatterns = {"*.hrd"})		
public class FrontController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
			
	@Override
	public void init() throws ServletException 
	{RequestControllerMapping.init();}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {   //Get,Post 방식 둘다 처리
		String url = request.getServletPath();
		String method = request.getMethod();
		
		RequestKeyValue key = new RequestKeyValue(url, method);
		Controller controller = RequestControllerMapping.getController(key);
		if(controller != null) 
		{controller.handle(request, response);}	
		//else 는 error 페이지로 구현 예정.	
	}
}
