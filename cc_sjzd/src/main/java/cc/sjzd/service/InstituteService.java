package cc.sjzd.service;

import cc.common.PracResult;
import cc.sjzd.entity.PracticeInstitute;

public interface InstituteService {
	
	/**
	 * 查询所有的文明实践所
	 * @return 信息类
	 * */
	public PracResult selectAll(int page, int size,String orderField,String orderSeq);
	
	/**
	 * 根据id 查询文明实践所列表的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult selectById(int id);
	
	
	/**
	 * 根据id 删除文明实践所的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	public PracResult deleteById(int id);
	
	/**
	 * 修改文明实践所的方法
	 * @param center 更新后的文明实践所类
	 * @return 信息类
	 */
	public PracResult update(PracticeInstitute town);
	
	
	/**
	 * 新增文明实践所
	 * @param center 新增的文明实践所类
	 * @return 信息类
	 */
	public PracResult insert(PracticeInstitute town);
	
	
	/**
	 * 根据center_id查询下属的实践站
	 * @param center_id 文明实践中心的id
	 * @return 信息类
	 */
	public PracResult selectByCenterId(int center_id);
	
	/**
	 * 根据名名称查询实践站
	 * @param name 文明实践站
	 * @return 信息类
	 */
	public PracResult selectByInstituteName(String name,int page, int size,String orderField,String orderSeq);

}
