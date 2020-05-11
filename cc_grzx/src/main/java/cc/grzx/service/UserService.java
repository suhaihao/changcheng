package cc.grzx.service;

import cc.common.PracResult;
import cc.grzx.entity.User;

public interface UserService {

	/**
	 * 查询所有的用户(分页查询)
	 * @return 信息类
	 * @param page 页码
	 * @param size 每页条数
	 * */
	public PracResult selectAll(int page,int size,String orderField,String orderSeq);
	
	/**
	 * 根据id 查询用户列表的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult selectById(int id);
	
	
	/**
	 * 根据id 删除用户的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult deleteById(int id);
	
	/**
	 * 修改用户的方法
	 * @param user 更新后的用户类
	 * @return 信息类
	 */
	public PracResult update(User user);
	
	
	/**
	 * 新增用户
	 * @param user 新增的用户类
	 * @return 信息类
	 */
	public PracResult insert(User user);
	

	
	
	

}
