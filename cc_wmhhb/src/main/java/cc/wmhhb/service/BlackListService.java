package cc.wmhhb.service;

import cc.common.PracResult;
import cc.wmhhb.entity.BlackList;

public interface BlackListService {

	/**
	 * 查询所有的黑榜信息(分页查询)
	 * @return 信息类
	 * @param page 页码
	 * @param size 每页条数
	 * */
	public PracResult selectAll(int page,int size,String orderField,String orderSeq);
	
	/**
	 * 根据id 查询黑榜信息列表的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult selectById(int id);
	
	
	/**
	 * 根据id 删除黑榜信息的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult deleteById(int id);
	
	/**
	 * 修改黑榜信息的方法
	 * @param message 更新后的黑榜信息类
	 * @return 信息类
	 */
	public PracResult update(BlackList black);
	
	
	/**
	 * 新增黑榜信息
	 * @param message 新增的黑榜信息类
	 * @return 信息类
	 */
	public PracResult insert(BlackList black);
	
	
	
	

}
