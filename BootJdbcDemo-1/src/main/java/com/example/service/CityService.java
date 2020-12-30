package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CityDao;
import com.example.vo.CityVO;

@Service
public class CityService {
	@Autowired
	private CityDao cityDao;
	
	public CityVO readCity(int id) {
		return this.cityDao.selectCity(id);
	}
	
	public List<CityVO> readAllCities(String code){
		return this.cityDao.selectAllCities(code);
	}
	
	public List<String> readAllCountryCode(){
		return this.cityDao.selectAllCountryCode();
	}
}
