package com.imooc.controller;

import com.imooc.vo.LoginStatus;
import com.imooc.vo.User;
import com.imooc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserMapper userMapper;


	
	@RequestMapping("/getAll")
	public List<User> getAll() {
		List<User> user=userMapper.getAll();
		return user;
	}

	@RequestMapping("/getUser/{id}")
	public User getUser(@PathVariable("id") int id) {
		User user = userMapper.getOne(id);
		return user;
	}




	@RequestMapping(value = "/insertUser")
	public void insertUser(User user) {

		userMapper.insert(user);
	}

	@RequestMapping(value = "/deleteUser/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userMapper.delete(id);
	}


	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String index(//@RequestBody @Validated Front front,
			HttpServletRequest request,HttpServletResponse response ) {
		response.setHeader("Access-Control-Allow-Origin", "*");
//		System.out.print(front.toString());
		String c=request.getParameter("username");
		System.out.print(c);
		return c;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public LoginStatus login(HttpServletRequest request, HttpServletResponse response){
		//01234  1学生登录成功已经存在  2管理员登录成功
		//      3密码错误    4权限不匹配   0初始装态
		response.setHeader("Access-Control-Allow-Origin", "*");
		int status=0;
		User user=new User();
		LoginStatus loginStatus=new LoginStatus();
		String p=request.getParameter("power");  //获取用户权限
		String u=request.getParameter("userName");  //获取用户名字
		String pw=request.getParameter("password");   //获取用户密码
		user.setUserName(u);
		user.setPassword(pw);
		user.setPower(p);
		User user1=userMapper.getUserbyName(u);           //通过用户名称在数据库中进行查询获取但用户信息方便下面的比较
		if(user.getPower().equals("student")&&user.getPower().equals(user1.getPower())&&user.getPassword().equals(user1.getPassword())){
			status=1;
		}if(user.getPower().equals("administrator")&&user.getPower().equals(user1.getPower())&&user.getPassword().equals(user1.getPassword())){
			status=2;
		}if(!user.getPassword().equals(user1.getPassword())){
			status=3;
		}if(!user.getPower().equals(user1.getPower())&&user.getPassword().equals(user1.getPassword())){
			status=4;
		}
		loginStatus.setId(user1.getUserID());
		loginStatus.setStatus(status);
	
		
		return loginStatus;     //返回登录状态
	}

}