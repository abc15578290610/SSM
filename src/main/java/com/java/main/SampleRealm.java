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
		//��Ȩ
		System.out.println("������Ȩ");
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		//��ȡ��֤��Ϣ
		String username = (String) arg0.getPrincipal();
		System.out.println("�������"+username);
		/* 1����ȡ�û�������û���
		 * 2��ͨ���û��������ݿ��л�ȡ��ʵ������
		 * 3��������ʽ���û������û�����
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
	 * ������֤����
	 */
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
}
