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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.service.BoardService;
import com.example.vo.BoardVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	private BoardService boardService;

	@GetMapping("/list")
	public String list(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		this.boardService.readAll(map);
		List<BoardVO> list = (List<BoardVO>)map.get("results");
		//log.warn("size = " + list.size());
		list.forEach(board -> {
			String filename = board.getFilename();
			if(filename != null) {
				int lastindex = filename.lastIndexOf(".");
				String ext = filename.substring(lastindex + 1);
				board.setFilename(ext);
			}
		});
		model.addAttribute("boardlist", list);
		return "list";     //  /templates/list.html
	}
	
	@GetMapping("/write")
	public String write() {
		return "write";     // /templates/write.html
	}
	
	@PostMapping("/write")
	public String write(BoardVO boardVo, 
			@RequestParam("company") String company, 
			@RequestParam("file") MultipartFile file) throws Exception {
		String email = boardVo.getEmail();
		if(!email.equals("")) email += "@" + company;
		boardVo.setEmail(email);
		//log.warn("file = " + file.getOriginalFilename());
		//log.warn("email = " + boardVo.getEmail());
		this.boardService.create(boardVo, file);
		return "redirect:/list";
	}
	
	@GetMapping("/view/{idx}")
	public String view(@PathVariable int idx, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idx", idx);
		this.boardService.read(map);
		List<BoardVO> list = (List<BoardVO>)map.get("result");
		BoardVO boardVo = list.get(0);
		
		String name = boardVo.getName();
		name = rechange(name);
		boardVo.setName(name);
		
		String title = boardVo.getTitle();
		title = rechange(title);
		boardVo.setTitle(title);
		
		String contents = boardVo.getContents();
		contents = rechange(contents);
		boardVo.setContents(contents);
		
		String filename = boardVo.getFilename();
		if(filename != null) {
			int lastIndex = filename.lastIndexOf(".");
			String ext = filename.substring(lastIndex + 1);
			model.addAttribute("ext", ext);
		}
		
		model.addAttribute("board", boardVo);
		return "view";     //  /templates/view.html
	}
	
	private String rechange(String oldStr) {
		String newStr = oldStr.replace("''", "'");   //홑홑따옴표를 홑따옴표로
		newStr = newStr.replace("&lt;", "<");
		newStr = newStr.replace("&gt;", ">");
		return newStr;
	}
}
