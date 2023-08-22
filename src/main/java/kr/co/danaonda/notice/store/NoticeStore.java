package kr.co.danaonda.notice.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.danaonda.notice.domain.Notice;
import kr.co.danaonda.notice.domain.PageInfo;

public interface NoticeStore {
	/**
	 * 공지사항 등록 Store
	 * @param session
	 * @param notice
	 * @return
	 */
	int insertNotice(SqlSession session, Notice notice);

	/**
	 * 공지사항 삭제 Store
	 * @param session
	 * @param noticeNo
	 * @return
	 */
	int deleteNotice(SqlSession session, int noticeNo);

	/**
	 * 공지사항 목록 조회 Store
	 * @param session
	 * @return
	 */
	List<Notice> selectNoticeList(SqlSession session, PageInfo pInfo);

	/**
	 * 공지사항 상세 페이지 Store
	 * @param session
	 * @param noticeNo
	 * @return
	 */
	Notice selectOneById(SqlSession session, int noticeNo);

	/**
	 * 공지사항 갯수 조회 Store
	 * @return
	 */
	int selectListCount(SqlSession session);
	
	/**
	 * 공지사항 동적 조회 Store
	 * @param session
	 * @param searchCondition
	 * @param searchKeyword
	 * @return
	 */
	List<Notice> searchNoticesByKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap);

	/**
	 * 공지사항 검색 게시물 전체 갯수 Store
	 * @param paramMap
	 * @return
	 */
	int selectListCount(SqlSession session, Map<String, String> paramMap);
}
