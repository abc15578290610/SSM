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

public class SampleRealm extends AuthorizingRealm {
	
	Map<String, String> user = new HashMap<String, String>(16);
	public SampleRealm() {
		super();
		super.setName("SampleRealm");
		user.put("admin", "admin");
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		//授权
		System.out.println("处理授权");
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		//获取认证信息
		String username = (String) arg0.getPrincipal();
		System.out.println("主体输出"+username);
		/* 1、获取用户输入的用户名
		 * 2、通过用户名从数据库中获取真实的密码
		 * 3、返回正式的用户名、用户密码
		 * */
		SimpleAuthenticationInfo AuthenticationInfo = new SimpleAuthenticationInfo("admin","admin","SampleRealm");
		
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
