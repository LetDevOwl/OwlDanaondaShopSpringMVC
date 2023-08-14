package kr.co.danaonda.user.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.danaonda.user.domain.User;
import kr.co.danaonda.user.store.UserStore;

@Repository
public class UserStoreLogic implements UserStore{

	@Override
	public int insertUser(SqlSession sqlSession, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(SqlSession sqlSession, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(SqlSession sqlSession, String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectCheckLogin(SqlSession sqlSession, User user) {
		User uOne = sqlSession.selectOne("UserMapper.selectCheckLogin", user);
		return uOne;
	}

	@Override
	public User selectOneById(SqlSession sqlSession, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
