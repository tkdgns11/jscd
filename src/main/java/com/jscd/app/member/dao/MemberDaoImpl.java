package com.jscd.app.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jscd.app.member.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private SqlSession session;
	private static String namespace = "com.jscd.app.member.memberMapper.";
	
	@Override
	public MemberDto selectUser(String id) throws Exception {
		return session.selectOne(namespace + "select", id);
	}
	@Override
	public int deleteUser(String id) throws Exception {
		return session.delete(namespace + "delete", id);
	}
	@Override
	public int insertUser(MemberDto memberDto) throws Exception {
		return session.insert(namespace+ "insert", memberDto);
	}
	@Override
	public int updateUser(MemberDto memberDto) throws Exception {
		return session.update(namespace + "update", memberDto);
	}
	@Override
	public int count() throws Exception {
		return session.selectOne(namespace + "count");
	}
	@Override
	public int deleteAll() throws Exception {
		return session.delete(namespace + "deleteAll");
	}

}
