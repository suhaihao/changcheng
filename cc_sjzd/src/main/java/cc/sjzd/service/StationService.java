package cc.sjzd.service;

import cc.common.PracResult;
import cc.sjzd.entity.PracticeStation;

public interface StationService {
	
	/**
	 * 查询所有的文明实践站
	 * @return 信息类
	 * */
	public PracResult selectAll(int page,int size,String orderField,String orderSeq);
	
	/**
	 * 根据id 查询文明实践站列表的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult selectById(int id);
	
	
	/**
	 * 根据id 删除文明实践站的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult deleteById(int id);
	
	/**
	 * 修改文明实践站的方法
	 * @param center 更新后的文明实践站类
	 * @return 信息类
	 */
	public PracResult update(PracticeStation village);
	
	
	/**
	 *  新增文明实践站
	 * @param center 新增的文明实践站类
	 * @return 信息类
	 */
	public PracResult insert(PracticeStation village);
	
	/**
	 *  通过名称模糊查询实践站
	 * @param name 实践站名称
	 * @return 信息类
	 */
	public PracResult selectByName(String name,int page,int size,String orderField,String orderSeq);
	
	/**
	 *  通过town_id查询实践站
	 * @param town_id 
	 * @return 信息类
	 */
	public PracResult selectByInstituteId(int institute_id) ;

}
