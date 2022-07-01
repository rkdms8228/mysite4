package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.FileVo;

@Repository
public class FileDao {
	
	//필드
	@Autowired
	SqlSession sqlSession;

	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	public int fileInsert(FileVo fileVo) {
		
		System.out.println("FileDao > fileInsert");
		
		int count = sqlSession.insert("file.insert", fileVo);
		
		return count;
		
	}

}
