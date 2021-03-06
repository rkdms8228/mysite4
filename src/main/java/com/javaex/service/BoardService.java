package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	//필드
	@Autowired
	BoardDao boardDao;
	
	//생성자
	
	
	//메소드-gs
	
	
	//메소드-일반
	//리스트 불러오기 + 검색(페이징)
	public Map<String, Object> getList2(int crtPage) {
		
		System.out.println("BoardService > getList2");
		
		//////////////////////////////////////////////
		//                 리스트 가져오기               //
		//////////////////////////////////////////////
		
		//페이지당 글 갯수
		int listCnt = 10;
		
		//현재 페이지
		//             조건문       true일 때 : false일 때
		crtPage = (crtPage > 0) ? crtPage : (crtPage = 1);
		
		/*
		if(crtPage>0) {
			
		}else {
			crtPage = 1;
		}
		*/
		
		//시작글 번호
		int startRnum = (crtPage-1)*listCnt + 1;
		
		//끝글 번호
		int endRnum = (startRnum + listCnt) - 1;
		
		//System.out.println("글갯수" + listCnt + ",페이지" + crtPage + ",시작글" + startRnum + ",끝글" + endRnum);
		
		List<BoardVo> boardList = boardDao.getList2(startRnum, endRnum);
		
		//System.out.println(boardList);
		
		//////////////////////////////////////////////
		//                  페이징 계산                 //
		//////////////////////////////////////////////
		
		//전체 글갯수
		int totalCnt = boardDao.selectTotalCnt();
		System.out.println("service" + totalCnt);
		
		//페이지당 버튼 갯수
		int pageBtnCount = 5;
		
		//마지막 버튼 번호
		int endPageBtnNo = (int)Math.ceil(crtPage/(double)pageBtnCount)*pageBtnCount;
		
		//시작 버튼 번호
		int startPageBtnNo = (endPageBtnNo-pageBtnCount)+1;
		
		//다음 페이지 화살표 유무
		boolean next = false;
		
		if((listCnt*endPageBtnNo) < totalCnt) {
			next = true;
		}else {
			endPageBtnNo = (int)Math.ceil(totalCnt/(double)listCnt);
		}
		
		//이전 페이지 화살표 유무
		boolean prev = false;
		
		if(startPageBtnNo != 1) {
			prev = true;
		}
		
		System.out.println("페이지" + crtPage + ",시작 버튼 번호" + startPageBtnNo + ",마지막 버튼 번호" + endPageBtnNo + ",이전" + prev + ", 다음" + next);
		
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("boardList", boardList);
		pMap.put("prev", prev);
		pMap.put("next", next);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("startPageBtnNo", startPageBtnNo);
		
		return pMap;
		
	}
	
	//리스트 불러오기 + 검색
	public List<Map<String, Object>> getList(String keyword) {
		
		System.out.println("BoardService > getList");
		
		List<Map<String, Object>> boardList = boardDao.getList(keyword);
		
		//System.out.println(boardList);
		
		return boardList;
		
	}
	
	//게시판 내용 읽기 + 조회수
	public Map<String, Object> read(int no) {
		
		System.out.println("BoardService > read");
		
		//조회수 올리기
		boardDao.boardHit(no);
		
		//게시판 내용 읽기
		Map<String, Object> bMap = boardDao.read(no);
		
		return bMap;
		
	}
	
	//게시판 글쓰기
	public int write(BoardVo boardVo) {
		
		System.out.println("BoardService > write");
		
		/*
		for(int i=1; i<127; i++) { //글쓰기 조작
			boardVo.setTitle(i+" 번째 게시물 제목입니다.");
			boardVo.setContent(i+" 번째 게시물 내용입니다.");
			boardDao.write(boardVo);
		}
		*/
		
		int count = boardDao.write(boardVo);

		return 1;
	}
	
	//게시판 수정
	public int modify(BoardVo boardVo) {
		
		System.out.println("BoardService > modify");
		
		int count = boardDao.modify(boardVo);
		
		return count;
		
	}
	
	//게시판 삭제
	public int delete(int no) {
		
		System.out.println("BoardService > delete");
		
		int count = boardDao.delete(no);
		
		return count;
		
	}

}
