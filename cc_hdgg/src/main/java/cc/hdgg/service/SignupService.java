package cc.hdgg.service;

import cc.common.PracResult;
import cc.hdgg.entity.ActivitySignup;

public interface SignupService {

	/**
	 * 查询所有的报名信息(分页查询)
	 * @return 信息类
	 * @param page 页码
	 * @param size 每页条数
	 * */
	public PracResult selectAll(int page,int size,String orderField,String orderSeq);
	
	/**
	 * 根据id 查询报名信息列表的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult selectById(int id);
	
	
	/**
	 * 根据id 删除报名信息的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult deleteById(int id);
	
	/**
	 * 修改报名信息的方法
	 * @param signup 更新后的报名信息类
	 * @return 信息类
	 */
	public PracResult update(ActivitySignup signup);
	
	
	/**
	 * 新增报名信息
	 * @param signup 新增的报名信息类
	 * @return 信息类
	 */
	public PracResult insert(ActivitySignup signup);
	
	/**
	 * 根据activity_id 查询报名信息列表的方法
	 * @param activity_id 活动公告id
	 * @return 信息类
	 */
	public PracResult selectByActivityId(int activity_id,int page, int size,String orderField,String orderSeq);

	/**
	 * 根据手机号 查询报名信息列表的方法
	 * @param phone手机号
	 * @return 信息类
	 */
	public PracResult selectByPhone(String phone, int page, int size, String orderField, String orderSeq);
	

	/**
	 * 根据用户id 查询报名信息列表的方法
	 * @param id用户ID
	 * @return 信息类
	 */
	public PracResult selectByUserId(int user_id, int page, int size, String orderField, String orderSeq);
	
	
	

}
