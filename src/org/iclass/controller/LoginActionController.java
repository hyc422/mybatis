package org.iclass.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.dao.NewMemberMybatisDao;
import org.iclass.vo.NewMember;

//new RequestKeyValue("/login.hrd", "POST")
public class LoginActionController implements Controller 
{
	@Override
	public void handle(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException 
	{
		
		NewMemberMybatisDao dao = NewMemberMybatisDao.getInstance();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		Map<String,String> map = new HashMap<>();
		
		map.put("id",id);
		map.put("password", password);
		
		NewMember vo = dao.login(map);
		
		if(vo != null)
		{
			// login 성공
			session.setAttribute("user", vo);
		}
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.hrd");
		dispatcher.forward(request, response);
	}	// method end
}	// Class end
