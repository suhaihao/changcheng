package cc.hdgg.service;

import cc.common.PracResult;
import cc.hdgg.entity.ActivityMessage;

public interface MessageService {

	/**
	 * 查询所有的留言信息(分页查询)
	 * @return 信息类
	 * @param page 页码
	 * @param size 每页条数
	 * */
	public PracResult selectAll(int page,int size,String orderField,String orderSeq);
	
	/**
	 * 根据id 查询留言信息列表的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult selectById(int id);
	
	
	/**
	 * 根据id 删除留言信息的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult deleteById(int id);
	
	/**
	 * 修改留言信息的方法
	 * @param message 更新后的留言信息类
	 * @return 信息类
	 */
	public PracResult update(ActivityMessage message);
	
	
	/**
	 * 新增留言信息
	 * @param message 新增的留言信息类
	 * @return 信息类
	 */
	public PracResult insert(ActivityMessage message);
	
	/**
	 * 根据活动id 查询留言信息列表的方法
	 * @param activity_id 活动公告id
	 * @return 信息类
	 */
	public PracResult selectByActivityId(int activity_id,int page, int size,String orderField,String orderSeq);
	
	
	
	
	

}
