package id.or.linuxjak.service;

import java.util.List;

import id.or.linuxjak.domain.UserInfo;
import id.or.linuxjak.service.common.ServiceHelper;


public interface UserInfoService extends ServiceHelper<UserInfo> {

	List<UserInfo> getAll() ;
	
	
}
