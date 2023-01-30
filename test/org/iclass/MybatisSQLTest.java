package org.iclass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.dao.NewMemberMybatisDao;
import org.iclass.vo.NewMember;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import mybatis.SqlSessionBean;

@TestMethodOrder(value=MethodOrderer.OrderAnnotation.class)
class MybatisSQLTest 
{
	private NewMemberMybatisDao dao = NewMemberMybatisDao.getInstance();
	
	@Order(1)
	@DisplayName("SqlSession 연결 테스트")
	@Test
	void session()
	{
		SqlSession mapper = SqlSessionBean.getSession();
		assertNotEquals(mapper, null);
		mapper.close();
	}	// Test end
	
	@Order(2)
	@DisplayName("select 전체 조회 테스트 - 현재 예상값 3")
	@Test
	void selectList()
	{
		assertEquals(dao.selectAll().size(), 3);
	}	// Test end
	
	@Order(3)
	@DisplayName("insert 테스트 - id : momo 추가")
	@Test
	void insert()
	{
		int result = dao.insert(NewMember.builder()
				.id("momo")
				.name("이모모")
				.password("1212")
				.email("momo@naver.com")
				.age(21)
				.gender("2")
				.hobbies("달리기")
				.build());
		
		assertEquals(result, 1);
	}	// Test end
	
	@Order(4)
	@DisplayName("select id 조회 테스트 - 현재 예상값 email = momo@naver.com")
	@Test
	void selectOne()
	{
		assertEquals(dao.selectOne("momo").getEmail(),"momo@naver.com");
	}	// Test end
	
	@Order(5)
	@DisplayName("update 테스트 - id : momo 수정")
	@Test
	void update()
	{
		int result = dao.update(NewMember.builder()
								.id("momo")
								.email("momo@google.com")
								.hobbies("야구")
								.build());
		
		assertEquals(result, 1);
	}	// Test end
	
	@Order(6)
	@DisplayName("login 테스트 - id : momo, pasword : 1212")
	@Test
	void login()
	{
		String id = "momo";
		String password = "1212";
		
		Map<String,String> map = new HashMap<>();
		
		map.put("id",id);
		map.put("password", password);
		
		NewMember vo = dao.login(map);
		
		assertNotNull(vo.getId());
	}	// Test end
	
	@Order(7)
	@DisplayName("delete 테스트 - id : momo 삭제")
	@Test
	void delete()
	{
		int result = dao.delete("momo");
		
		assertEquals(result, 1);
	}	// Test end
}	// Class end
