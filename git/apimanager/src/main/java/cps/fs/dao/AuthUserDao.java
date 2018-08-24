package cps.fs.dao;

import cps.fs.bean.AuthUser;

/**
 * 
 * @description 对用户表操作
 * @author fs
 * @2018年8月23日
 *
 */
public interface AuthUserDao {
	
	/**
	 * 返回用户封装信息类
	 * @param loginuser
	 * @return
	 */
	AuthUser getUser(AuthUser loginuser);

}
