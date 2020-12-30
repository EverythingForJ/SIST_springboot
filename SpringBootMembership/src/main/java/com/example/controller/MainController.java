package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.service.MemberService;
import com.example.vo.MemberVO;

@Controller
public class MainController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index"; // /templates/index.html
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register"; // /templates/register.html
	}

	@PostMapping("/register")
	public String register(MemberVO member) {
		this.memberService.insertMember(member);
		return "redirect:/list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.memberService.selectAllMembers(map);
		List<MemberVO> list = (List<MemberVO>) map.get("results");
		// list.forEach(member -> log.info("" + member));
		model.addAttribute("members", list);
		return "list"; // templates/list.html
	}

	@GetMapping("/member/{userid}")
	public String display(@PathVariable String userid, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		this.memberService.selectMember(map);
		List<MemberVO> list = (List<MemberVO>) map.get("result");
		MemberVO member = list.get(0);
		model.addAttribute("member", member);
		// log.info("user = {}", member);
		return "display"; // templates/display.html
	}

	@GetMapping("/member/update/{userid}")
	public String update(@PathVariable String userid, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		this.memberService.selectMember(map);
		List<MemberVO> list = (List<MemberVO>) map.get("result");
		MemberVO member = list.get(0);
		model.addAttribute("member", member);
		// log.info("수정할 UserID = " + userid);
		return "update"; // templates/update.html
	}

	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String update(MemberVO member) {
		// log.info("수정할 멤버 = " + member);
		this.memberService.updateMember(member);
		return "redirect:/member/" + member.getUserid();
	}

}
