package com.example.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.MemberVO;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void create(MemberVO member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void readAll(Map map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void read(Map map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(MemberVO member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String userid) {
		// TODO Auto-generated method stub

	}

}
