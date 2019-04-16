package com.java.main;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private int count = 0;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("欢迎加入.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@RequestMapping(value = "/subLogin", method = RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String login(@ModelAttribute ( "name" ) String name,@ModelAttribute ( "password" ) String password) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(name,password);
		try {
			logger.info("尝试登录1"+(count++));
			subject.login(token);
		} catch  ( UnknownAccountException uae ) {
			return "用户不存在";
		} catch  ( IncorrectCredentialsException ice ) {
			return "凭证不正确";
		} catch  ( LockedAccountException lae ) {
			return "账户被冻结";
		} catch  ( ExcessiveAttemptsException eae ) {
			return "尝试次数过多";
		}
		catch ( AuthenticationException ae ) {
			return "身份验证失败";
		}
		return "登录成功";
	}
}
