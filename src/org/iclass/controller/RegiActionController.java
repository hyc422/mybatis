package org.iclass.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.dao.NewMemberMybatisDao;
import org.iclass.vo.NewMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegiActionController implements Controller
{
	private static final Logger logger = LoggerFactory.getLogger(RegiActionController.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	// getParameter("parameter명") 만약에 parameter가 jsp 파일에 없으면 null, 있지만 값을 입력안하면 ""

		request.setCharacterEncoding("UTF-8");
		
		NewMemberMybatisDao dao = NewMemberMybatisDao.getInstance();
		
		int result = 0;
		try 
		{
			result = dao.insert(NewMember.builder()
										 .id(request.getParameter("id"))
										 .name(request.getParameter("name"))
										 .password(request.getParameter("password"))
										 .email(request.getParameter("email"))
										 .age(Integer.parseInt(request.getParameter("age")))
										 .gender((request.getParameter("gender")).equals("male")?"0":request.getParameter("gender").equals("female")?"2":"3")
										 .hobbies(request.getParameter("hobbies"))
										 .build());
		} 
		catch (NumberFormatException e) {logger.error("[MyInfo] - {}",e.getMessage());}	
		
		response.setCharacterEncoding("UTF-8");		// 응답헤더 설정 : 인코딩, 응답의 내용물 타입
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		
		if(result==1)
		{
			out.print("<script>");
			out.print("alert('회원 등록이 완료되었습니다.');");
			out.print("location.href='index.jsp'");
			out.print("</script>");
		}
		else
		{
			out.print("<script>");
			out.print("alert('오류가 발생하였습니다.');");
			out.print("location.href='regi.jsp'");
			out.print("</script>");
		}
	}	// method end
}	// Class end
