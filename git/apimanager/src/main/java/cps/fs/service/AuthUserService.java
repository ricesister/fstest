package cps.fs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cps.fs.bean.AuthUser;
import cps.fs.dao.AuthUserDao;

@Service
public class AuthUserService {
	
	@Autowired
	private AuthUserDao authUserDao;
	
	public AuthUser getLoginUser(AuthUser loginuser) {
		return authUserDao.getUser(loginuser);
	}
	

}
