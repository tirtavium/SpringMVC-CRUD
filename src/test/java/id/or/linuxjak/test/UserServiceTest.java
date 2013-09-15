package id.or.linuxjak.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import id.or.linuxjak.dao.GenericDao;
import id.or.linuxjak.domain.User;
import id.or.linuxjak.domain.UserInfo;
import id.or.linuxjak.service.UserInfoService;
import id.or.linuxjak.service.UserService;

@Ignore
public class UserServiceTest extends BaseTest {

	@Autowired
	UserService userService;

	@Autowired
	UserInfoService userInfoService;

	@Test
//	@Rollback(value=false)
	public void testAddUser() {
		// TODO Auto-generated method stub
		User user = new User();
		UserInfo ui = new UserInfo();

		ui.setAddress("tangerang");
		ui.setJob("programmer");
		ui.setLastName("gepeng");
		ui.setListedDate(new Date());
		ui.setName("tirta");
		ui.setUser(user);

		user.setUsername("tirta1");
		user.setPassword("gepeng");
		user.setUserInfo(ui);

		// userInfoService.create(ui);
		userService.create(user);

		List<UserInfo> list = userInfoService.getAll();
		System.out.println(list.get(0).getUserInfoId());
		assertNotNull(list);
		
		
		
		
		

	}

}
