package com.jscd.app.member.dao;

import com.jscd.app.lecture.lstRegist.dto.LectureApplyDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jscd.app.member.dto.MemberDto;

import java.util.List;

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
	public int countGeneral() throws Exception {
		return session.selectOne(namespace + "countGeneral");
	}

	@Override
	public int countStudent() throws Exception {
		return session.selectOne(namespace + "countStudent");
	}

	@Override
	public int deleteAll() throws Exception {
		return session.delete(namespace + "deleteAll");
	}

	@Override
	public int insertTermsYN(MemberDto memberDto) throws Exception {
		System.out.println("insertTerms" + memberDto);
		return session.insert(namespace + "insertTerms", memberDto);
	}

	@Override
	public List<LectureApplyDto> selectLecture(LectureApplyDto lectureApplyDto) throws Exception {
		return session.selectList(namespace+"selectLecture", lectureApplyDto);
	}

	//<payhty.status> == 'paid'일 때, <stod.status> && <lectureApply.status> == 'paid' update
//	@Override
//	public void updateStatusToPaid(LectureApplyDto lectureApplyDto) {
//		session.update("com.example.mapper.MemberMapper.updateStatusToPaid", lectureApplyDto);
//	}

	@Override
	public String selectEmail(MemberDto memberDto)throws Exception{
		return session.selectOne(namespace+"selectEmail",memberDto);
	}

	@Override
	public int updatePwd(MemberDto memberDto)throws Exception{
		return session.update(namespace+"updatePwd",memberDto);
	}

	@Override
	public int selectByID(String ID){
		return session.selectOne(namespace + "selectByID", ID);
	}

}