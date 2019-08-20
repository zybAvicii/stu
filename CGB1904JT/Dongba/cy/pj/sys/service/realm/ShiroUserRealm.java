package com.cy.pj.sys.service.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.entity.SysUser;
@Service
public class ShiroUserRealm extends AuthorizingRealm{
	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher hcm=new HashedCredentialsMatcher();
		hcm.setHashAlgorithmName("MD5");
		hcm.setHashIterations(1);
		super.setCredentialsMatcher(hcm);
	}

	
	/**
	 * 负责认证信息的获取及封装
	 * */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) 
					throws AuthenticationException {
		//获取用户名
		UsernamePasswordToken upToken=
				(UsernamePasswordToken)token;
		String username = 
				upToken.getUsername();
		//基于用户名查询数据库
		SysUser user = 
				sysUserDao.findUserByUserName(username);
		//判断用户是否存在
		if(user==null)
			throw new UnknownAccountException();
		//判断用户是否被禁用
		if(user.getValid()==0)
			throw new LockedAccountException();
		//封装用户信息并返回 
		ByteSource credentialsSalt=
				ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo info=
				new SimpleAuthenticationInfo(
				user,//principal (身份)
				user.getPassword(),//hashedCredentials
				credentialsSalt, //credentialsSalt
				getName()//"ShiRouserRealm" //返回给SecurityManager(本身认证和授权)
				
				);//realName 
				
		return info;
	}


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	
		return null;
	}

}









