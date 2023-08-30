package kr.co.danaonda.notice.service;

import java.util.List;
import java.util.Map;

import kr.co.danaonda.notice.domain.Notice;
import kr.co.danaonda.notice.domain.PageInfo;

public interface NoticeService {
	/**
	 * 공지사항 등록 Serivce
	 * @param notice
	 * @return
	 */
	int insertNotice(Notice notice);
	
	/**
	 * 공지사항 수정 Service
	 * @param notice
	 * @return
	 */
	int updateNotice(Notice notice);

	/**
	 * 공지사항 삭제 Service
	 * @param noticeNo
	 * @return
	 */
	int deleteNotice(int noticeNo);

	/**
	 * 공지사항 목록 조회 Service
	 * @return
	 */
	List<Notice> selectNoticeList(PageInfo pInfo);

	/**
	 * 공지사항 상세페이지 Service
	 * @param noticeNo
	 * @return
	 */
	Notice selectOneById(int noticeNo);

	/**
	 * 공지사항 전체 갯수 조회 Service
	 * @return
	 */
	int getListCount();
	
	/**
	 * 공자사항 조건에 따라 키워드로 검색 Service
	 * @param pInfo 
	 * @param searchCondition
	 * @param searchKeyword
	 * @return
	 */
	List<Notice> searchNoticesByKeyword(PageInfo pInfo, Map<String, String> paramMap);

	/**
	 * 공지사항 검색 게시물 전체 갯수 Service
	 * @param paramMap
	 * @return
	 */
	int getListCount(Map<String, String> paramMap);

	/**
	 * 공지사항 번호로 선택 Service
	 * @param noticeNo
	 * @return
	 */
	Notice selectNoticeByNo(Integer noticeNo);
	
}
