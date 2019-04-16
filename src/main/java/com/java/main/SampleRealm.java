package com.java.main;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.main.service.userService;

public class SampleRealm extends AuthorizingRealm {
	private static final Logger logger = LoggerFactory.getLogger(SampleRealm.class);

	Map<String, String> user = new HashMap<String, String>(16);
	@Autowired
	userService userService;
	public SampleRealm() {
		super();
		super.setName("SampleRealm");
		user.put("admin", "admin");
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		//授权
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		//获取认证信息
		String username = (String) arg0.getPrincipal();
		/* 1、获取用户输入的用户名
		 * 2、通过用户名从数据库中获取真实的密码
		 * 3、返回真实的用户密码
		 * */
		User userInfo = userService.getUserInfo(username);
		if (userInfo.getPassword().length()<=0) {
			
		}
		logger.info(username+"------"+userInfo.getPassword());
		SimpleAuthenticationInfo AuthenticationInfo = new SimpleAuthenticationInfo(username,userInfo.getPassword(),"SampleRealm");
		
		return AuthenticationInfo;
	}
	public  void clearCachedAuthorizationInfo() {
		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
	/**
	 * 清理认证缓存
	 */
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
}
