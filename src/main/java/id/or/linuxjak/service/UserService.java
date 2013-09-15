package id.or.linuxjak.service;

import java.util.List;

import id.or.linuxjak.domain.User;
import id.or.linuxjak.service.common.ServiceHelper;


public interface UserService extends ServiceHelper<User>{
	List<User> getAll();
	 User findUserbyId(Long id);
	 void update(User user);
}
