package com.example.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MemberDao;
import com.example.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;

	@Override
	public void insertMember(MemberVO member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectAllMembers(Map map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectMember(Map map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember(MemberVO member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMember(String userid) {
		// TODO Auto-generated method stub

	}

}
