package org.iclass.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.NewMember;

import mybatis.SqlSessionBean;

public class NewMemberMybatisDao 
{
	// singleton pattern
	private static final NewMemberMybatisDao dao = new NewMemberMybatisDao();
	private NewMemberMybatisDao() {};
	public static NewMemberMybatisDao getInstance()
	{return dao;}
	
	public List<NewMember> selectAll()
	{	// Exception 처리 필요 없음. 객체와 db column 매핑, list add 필요없음
		SqlSession mapper = SqlSessionBean.getSession();
		List<NewMember> list = mapper.selectList("selectAll");
		
		mapper.close();		// 필수
		return list;
	}	// method end
	
	public NewMember selectOne(String id)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		NewMember member = mapper.selectOne("selectOne",id);
		
		mapper.close();
		
		return member;
	}	// method end
	
	public int insert(NewMember vo)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.insert("insert",vo);	// 두번째 인자 vo는 insert에 필요한 parameter
		// Mybatis는 autocommit 아님
		
		mapper.commit();
		mapper.close();
		
		return result;
	}	// method end
	
	public int update(NewMember vo)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("update",vo);
		
		mapper.commit();
		mapper.close();
		
		return result;
	}	// method end
	
	public int delete(String id)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.delete("delete",id);
		
		mapper.commit();
		mapper.close();
		
		return result;
	}	// method end
	
	public NewMember login(Map<String,String> map)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		NewMember member = mapper.selectOne("login", map);
				
		mapper.commit();
		mapper.close();
		
		return member;
	}	// method end
}	// Class end
