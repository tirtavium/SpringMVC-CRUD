package id.or.linuxjak.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.or.linuxjak.domain.User;
import id.or.linuxjak.domain.UserInfo;
import id.or.linuxjak.service.UserService;
import id.or.linuxjak.service.common.ServiceHelperImpl;

@Service("userService")
@Transactional
public class UserServiceImpl extends ServiceHelperImpl<User> implements
		UserService {

	public List<User> getAll() {
		// TODO Auto-generated method stub
		return super.getAll(User.class);
	}

	public User findUserbyId(Long id) {
		return super.find(User.class, id);
	}

	public void update(User user) {

		genericDao.update(user);
	}

}
