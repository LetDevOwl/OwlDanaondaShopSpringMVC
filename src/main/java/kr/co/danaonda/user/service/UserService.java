package kr.co.danaonda.user.service;

import kr.co.danaonda.user.domain.User;

public interface UserService {
	public int insertUser(User user);

	public int updateUser(User user);

	public int deleteUser(String userId);

	public User selectCheckLogin(User user);

	public User selectOneById(String userId);
}
