package cc.grzx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cc.common.PracResult;
import cc.grzx.service.UserService;
import cc.grzx.entity.User;

@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class userController {
	
	@Autowired
	private UserService userService;
	
	//查找所有的方法(分页)
	@GetMapping("/activity/user/all")
	public PracResult selectAll(
			@RequestParam(name="page",required=false,defaultValue="1")int page, 
			@RequestParam(name="size",required=false,defaultValue="10")int size,
			@RequestParam(name="orderField",required=false,defaultValue="id")String orderField,
			@RequestParam(name="orderSeq",required=false,defaultValue="desc")String orderSeq) {
		PracResult result = userService.selectAll(page,size,orderField,orderSeq);		
		return result;
	} 
	
	//根据id查找用户的方法
	@GetMapping("/activity/user/get")
	public PracResult selectOne(int id) {
		PracResult result = userService.selectById(id);
		return result;
	} 
	
	
	//根据id 删除用户的方法
	@GetMapping("/activity/user/delete")
	public PracResult deleteuser(int id) {
		PracResult result = userService.deleteById(id);
		return result;
	} 
	
	//修改用户的方法
	@PostMapping("/activity/user/update")
	public PracResult updateuser(User user) {
		PracResult result = userService.update(user);
		return result;
	} 
	
	//添加用户列表
    @PostMapping("/activity/user/add")
    public PracResult insert(User user) {
    	PracResult result = userService.insert(user);
		return result;
    }
}
