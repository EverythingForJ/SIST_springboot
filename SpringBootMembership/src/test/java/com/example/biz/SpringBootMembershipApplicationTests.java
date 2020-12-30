package com.example.biz;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class SpringBootMembershipApplicationTests {

	@Autowired
	private SqlSession sqlSession;
	
	@Disabled @Test
	void contextLoads() {
		assertNotNull(this.sqlSession);
	}

	@Test
	void test2() {
		java.util.Date today = 
				(java.util.Date)this.sqlSession.selectOne("Member.currentDate");
		log.warn(today.toLocaleString());
	}
}
