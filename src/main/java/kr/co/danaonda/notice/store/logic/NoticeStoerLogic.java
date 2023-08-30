package kr.co.danaonda.notice.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.danaonda.notice.domain.Notice;
import kr.co.danaonda.notice.domain.PageInfo;
import kr.co.danaonda.notice.store.NoticeStore;

@Repository
public class NoticeStoerLogic implements NoticeStore{
	
	@Override
	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	@Override
	public int updateNotice(SqlSession session, Notice notice) {
		int result = session.update("NoticeMapper.updateNotice", notice);
		return result;
	}

	@Override
	public int deleteNotice(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

	@Override
	public List<Notice> selectNoticeList(SqlSession session, PageInfo pInfo) {
		int limit = 10; // 가져오는 행의 갯수
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList", null, rowBounds);
		return nList;
	}
	
	@Override
	public Notice selectOneById(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneById", noticeNo);
		return notice;
	}

	@Override
	public List<Notice> searchNoticesByKeyword(SqlSession session, PageInfo pInfo, Map<String, String> paramMap) {
		int limit = pInfo.getRecordCountPage(); // 가져오는 행의 갯수
		int offset = (pInfo.getCurrentPage()-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> searchList = session.selectList("NoticeMapper.searchNoticesByKeyword", paramMap, rowBounds);
		return searchList;
	}

	@Override
	public int selectListCount(SqlSession session) {
		int result = session.selectOne("NoticeMapper.selectListCount");
		return result;
	}

	@Override
	public int selectListCount(SqlSession session, Map<String, String> paramMap) {
		int result = session.selectOne("NoticeMapper.selectListByKeywordCount", paramMap);
		return result;
	}

	@Override
	public Notice selectNoticeByNo(SqlSession session, Integer noticeNo) {
		Notice noticeOne = session.selectOne("NoticeMapper.selectNoticeByNo", noticeNo);
		return noticeOne;
	}
}
