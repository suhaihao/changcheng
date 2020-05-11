package cc.hdgg.service;

import cc.common.PracResult;
import cc.hdgg.entity.ActivityNotice;

public interface NoticeService {

	/**
	 * 查询所有的活动公告(分页查询)
	 * @return 信息类
	 * @param page 页码
	 * @param size 每页条数
	 * */
	public PracResult selectAll(int page,int size,String orderField,String orderSeq);
	
	/**
	 * 根据id 查询活动公告列表的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult selectById(int id);
	
	
	/**
	 * 根据id 删除活动公告的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult deleteById(int id);
	
	/**
	 * 修改活动公告的方法
	 * @param notice 更新后的活动公告类
	 * @return 信息类
	 */
	public PracResult update(ActivityNotice notice);
	
	
	/**
	 * 新增活动公告
	 * @param notice 新增的活动公告类
	 * @return 信息类
	 */
	public PracResult insert(ActivityNotice notice);
	
	
	/**
	 * 根据名称模糊查询
	 * @param name 名称
	 * @return 信息类
	 */
	public PracResult selectByTitle(String title,int page,int size,String orderField,String orderSeq);

	
	

}
