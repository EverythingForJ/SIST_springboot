package com.example.biz;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootBbsDemoApplicationTests {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	void test1() {
		assertNotNull(this.sqlSession);
	}
	
	@Test
	void test2() {
	}

}
