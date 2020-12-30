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
	
	public CityVO read(String cityname) {
		return this.cityDao.select(cityname);
	}
	
	public List<CityVO> readAll(String countryCode){
		return this.cityDao.selectAll(countryCode);
	}
	
	public List<String> readAllCountryCode(){
		return this.cityDao.selectCountryCode();
	}
}
