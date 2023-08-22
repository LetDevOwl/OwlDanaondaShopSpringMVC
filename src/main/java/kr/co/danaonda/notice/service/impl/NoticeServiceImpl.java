package kr.co.danaonda.notice.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kr.co.danaonda.notice.domain.Notice;
import kr.co.danaonda.notice.domain.PageInfo;
import kr.co.danaonda.notice.service.NoticeService;
import kr.co.danaonda.notice.store.NoticeStore;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private SqlSession session;
	@Autowired
	private NoticeStore nStore;

	@Override
	public int insertNotice(Notice notice) {
		int result = nStore.insertNotice(session, notice);
		return result;
	}

	@Override
	public int deleteNotice(int noticeNo) {
		int result = nStore.deleteNotice(session, noticeNo);
		return result;
	}

	@Override
	public List<Notice> selectNoticeList(PageInfo pInfo) {
		List<Notice> nList = nStore.selectNoticeList(session, pInfo);
		return nList;
	}

	@Override
	public Notice selectOneById(int noticeNo) {
		Notice notice = nStore.selectOneById(session, noticeNo);
		return notice;
	}

	@Override
	public int getListCount() {
		int result = nStore.selectListCount(session);
		return result;
	}
	
	@Override
	public List<Notice> searchNoticesByKeyword(PageInfo pInfo, Map<String, String> paramMap) {
		List<Notice> searchList = nStore.searchNoticesByKeyword(session, pInfo, paramMap);
		return searchList;
	}

	@Override
	public int getListCount(Map<String, String> paramMap) {
		int result = nStore.selectListCount(session, paramMap);
		return result;
	}
}
