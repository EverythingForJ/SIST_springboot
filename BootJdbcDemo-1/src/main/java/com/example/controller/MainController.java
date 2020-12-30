package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.CityService;
import com.example.vo.CityVO;

@Controller
public class MainController {
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		List<String> list = this.cityService.readAllCountryCode();
		model.addAttribute("codelist", list);
		return "index"; // 확장자가 없으니 template이다.
	}
	
	@RequestMapping(value = "/view/{code}", method = RequestMethod.GET)
	public String view(@PathVariable String code, Model model) {
		List<CityVO> list = this.cityService.readAllCities(code);
		model.addAttribute("code", code);
		model.addAttribute("citylist", list);
		return "view"; // /templates/view.html
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("id") int id, Model model) {
		CityVO city = this.cityService.readCity(id);
		model.addAttribute("city", city);
		return "detail"; // /templates/detail.html
	}
}
