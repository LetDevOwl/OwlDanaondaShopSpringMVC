package kr.co.danaonda.user.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.danaonda.user.domain.User;

public interface UserStore {
	public int insertUser(SqlSession sqlSession, User user);

	public int updateUser(SqlSession sqlSession, User user);

	public int deleteUser(SqlSession sqlSession, String userId);

	public User selectCheckLogin(SqlSession sqlSession, User user);

	public User selectOneById(SqlSession sqlSession, String userId);
}
