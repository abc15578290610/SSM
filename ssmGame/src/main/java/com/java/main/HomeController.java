package com.java.main;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.main.service.userService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private int count = 0;
	
	@Resource
	private regist regist;
	
	@Autowired
	private userService userService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String home(Locale locale, Model model) {
		regist.save();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	@RequestMapping(value = "/subLogin", method = RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	private Map<String, String> login(@ModelAttribute("name") String name, @ModelAttribute("password") String password) {
		Map<String, String> map = new HashMap<>() ;
		Subject subject = SecurityUtils.getSubject();
		logger.info("用户名"+name+"---密码"+password);
		UsernamePasswordToken token = new UsernamePasswordToken(name,password);
		try {
			logger.info("登录尝试"+(count++));
			subject.login(token);
		} catch  ( UnknownAccountException uae ) {
			map.put("msg","用户不存在");
			logger.info(map.get("msg"));
			return map;
		} catch  ( IncorrectCredentialsException ice ) {
			map.put("msg","密码不正确");
			return map;
		} catch  ( LockedAccountException lae ) {
			map.put("msg","账户已冻结");
			return map;
		} catch  ( ExcessiveAttemptsException eae ) {
			map.put("msg","尝试次数过多");
			return map;
		}
		catch ( AuthenticationException ae ) {
			map.put("msg", "身份验证失败");
			return map;
		}
		map.put("msg", "登录成功");
		logger.info(map.get("msg"));
		return map;
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	private String rigist(@ModelAttribute ( "name" ) String name,@ModelAttribute ( "password" ) String password) {
		userService.AddUser(name, password);
		return "注册成功";
	}
}
