package cc.sjzd.service;

import cc.common.PracResult;
import cc.sjzd.entity.PracticeCenter;

public interface CenterService {

	/**
	 * 查询所有的文明实践中心及其包含的文明实践所(分页查询)
	 * @return 信息类
	 * @param page 页码
	 * @param size 每页条数
	 * */
	public PracResult selectAll(int page,int size,String orderField,String orderSeq);
	/**
	 * 查询所有的文明实践中心及其包含的文明实践中心 
	 * @return 信息类
	 * */
	public PracResult selectAllCenter();
	
	/**
	 * 根据id 查询文明实践中心列表的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult selectById(int id);
	
	
	/**
	 * 根据id 删除文明实践中心的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult deleteById(int id);
	
	/**
	 * 修改文明实践中心的方法
	 * @param center 更新后的文明实践中心类
	 * @return 信息类
	 */
	public PracResult update(PracticeCenter center);
	
	
	/**
	 * 新增文明实践中心
	 * @param center 新增的文明实践中心类
	 * @return 信息类
	 */
	public PracResult insert(PracticeCenter center);
	
	
	/**
	 * 根据名称模糊查询
	 * @param name 名称
	 * @return 信息类
	 */
	public PracResult selectByCenterName(String name,int page,int size,String orderField,String orderSeq);

	
	/**
	 * 查询所有的实践中心名称
	 * @return 信息类
	 */
	public PracResult selectAllCenterName();
	
	

}
