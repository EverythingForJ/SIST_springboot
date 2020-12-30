package com.example.biz;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.vo.CityVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BootJdbcDemoApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	void test() {
		//assertNotNull(this.jdbcTemplate);
		String query = "SELECT id, name, countrycode, district, population FROM City" + 
								"WHERE countrycode = ?";
//		List<CityVO> list = this.jdbcTemplate.query(query, new BeanPropertyRowMapper<CityVO>(CityCO.class), "KOR");
//		
//		list.forEach(city -> log.warn(city.toString()));
	}

}
