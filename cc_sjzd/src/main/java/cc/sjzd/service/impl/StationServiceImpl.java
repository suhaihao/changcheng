package cc.sjzd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cc.common.PracConstant;
import cc.common.PracResult;
import cc.sjzd.dao.PracticeStationMapper;
import cc.sjzd.entity.PracticeStation;
import cc.sjzd.service.StationService;
@Service(value="villageService")
public class StationServiceImpl implements StationService {
	
	@Autowired
	private PracticeStationMapper villageDao;
	
	/**
	 * 查询所有的文明实践站
	 * @return 信息类
	 * */
	@Override
	public PracResult selectAll(int page, int size,String orderField,String orderSeq) {
		PracResult result = new PracResult();
		String orderBy = orderField + " "+orderSeq;
		PageHelper.startPage(page, size, orderBy);
		List<PracticeStation> villageLists = villageDao.selectAll();
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(villageLists);
		return result;
	}
	
	/**
	 * 根据id 查询文明实践站的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	@Override
	public PracResult selectById(int id) {
		PracResult result = new PracResult();
		PracticeStation village = villageDao.selectByPrimaryKey(id);
		if(village == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setData(village);
		return result;
	}
	
	/**
	 * 根据id 删除文明实践站的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	@Override
	public PracResult deleteById(int id) {
		PracResult result = new PracResult();
		PracticeStation village = villageDao.selectByPrimaryKey(id);
		if(village == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		int row = villageDao.deleteByPrimaryKey(id);
		if(row<0) {
			result.setCode(PracConstant.ERROR2);
			result.setMsg(PracConstant.DELETE_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.DELETE_SUCCESS);
		return result;
	}

	/**
	 * 修改文明实践站的方法
	 * @param center 更新后的文明实践站类
	 * @return 信息类
	 */
	@Override
	public PracResult update(PracticeStation village) {
		PracResult result = new PracResult();
		int row = villageDao.updateByPrimaryKeySelective(village);
		if(row<0) {
			result.setCode(PracConstant.ERROR3);
			result.setMsg(PracConstant.UPDATE_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.UPDATE_SUCCESS);
		return result;
	}


	/**
	 * 新增文明实践站
	 * @param center 新增的文明实践站类
	 * @return 信息类
	 */
	@Override
	public PracResult insert(PracticeStation village) {
		PracResult result = new PracResult();
		int row = villageDao.insert(village);
		if(row<0) {
			result.setCode(PracConstant.ERROR4);
			result.setMsg(PracConstant.INSERT_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.INSERT_SUCCESS);
		return result;
	}

	
	/**
	 *  通过名称模糊查询实践站
	 * @param name 实践站名称
	 * @return 信息类
	 */
	@Override
	public PracResult selectByName(String name,int page, int size,String orderField,String orderSeq) {
		PracResult result = new PracResult();
		String orderBy = orderField + " "+orderSeq;
		PageHelper.startPage(page, size, orderBy);
		List<PracticeStation> villageLists = villageDao.selectByStationName(name);
		if(villageLists == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(villageLists);
		return result;
	}

	/**
	 *  通过town_id查询实践站
	 * @param town_id 
	 * @return 信息类
	 */
	@Override
	public PracResult selectByInstituteId(int institute_id) {
		PracResult result = new PracResult();
		List<PracticeStation> villageLists = villageDao.selectByInstituteId(institute_id);
		if(villageLists == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setData(villageLists);
		return result;
	}
	
	


}
