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
		this.sqlSession.insert("Membership.insert", member);
	}

	@Override
	public void readAll(Map map) {
		this.sqlSession.selectList("Membership.selectAll", map);
	}

	@Override
	public void read(Map map) {
		this.sqlSession.selectOne("Membership.select", map);
	}

	@Override
	public void update(MemberVO member) {
	this.sqlSession.update("Membership.update", member);
	}

	@Override
	public void delete(String userid) {
		// TODO Auto-generated method stub

	}

}
