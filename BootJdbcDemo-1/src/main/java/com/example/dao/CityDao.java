package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.vo.CityVO;

@Repository
public class CityDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public CityVO selectCity(int id) {
		String sql = "SELECT * FROM City WHERE id = ?";
		return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<CityVO>(CityVO.class), id);
	}
	
	public List<CityVO> selectAllCities(String code){
		String sql = "SELECT * FROM City WHERE countrycode = ?";
		return this.jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<CityVO>(CityVO.class), code);
	}
	
	public List<String> selectAllCountryCode(){
		String sql = "SELECT DISTINCT countrycode FROM CountryLanguage";
		return this.jdbcTemplate.query(sql, 
				new RowMapper<String>() {

					@Override
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getString("countrycode");
					}
					
				});
	}
}
