package kr.co.danaonda.user.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.danaonda.user.domain.User;
import kr.co.danaonda.user.service.UserService;
import kr.co.danaonda.user.store.UserStore;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private UserStore uStore;

	@Override
	public int insertUser(User user) {
		int result = uStore.insertUser(sqlSession, user);
		return result;
	}

	@Override
	public int updateUser(User user) {
		int result = uStore.updateUser(sqlSession, user);
		return result;
	}

	@Override
	public int deleteUser(String userId) {
		int result = uStore.deleteUser(sqlSession, userId);
		return result;
	}

	@Override
	public User selectCheckLogin(User user) {
		User uOne = uStore.selectCheckLogin(sqlSession, user);
		return uOne;
	}

	@Override
	public User selectOneById(String userId) {
		User user = uStore.selectOneById(sqlSession, userId);
		return user;
	}

}
