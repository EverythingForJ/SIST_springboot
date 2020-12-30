package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.CityService;
import com.example.vo.CityVO;

@Controller
public class HomeController {
	@Autowired
	private CityService cityService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<String> list = this.cityService.readAllCountryCode();
		model.addAttribute("countryCodeList", list);
		
		return "index"; // /WEB-INF/views/index.jsp
	}
	
	@GetMapping("/view/{code}")
	public String view(@PathVariable String code, Model model) {
		List<CityVO> list = this.cityService.readAll(code);
		model.addAttribute("code", code);
		model.addAttribute("citylist", list);
		return "view"; //  /WEB-INF/views/view.jsp
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("name") String cityname, Model model) {
		CityVO city = this.cityService.read(cityname);
		model.addAttribute("cityname", city);
		return "detail"; // /WEB-INF/views/detail.jsp
	}
}
