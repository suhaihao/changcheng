package cc.sjzd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cc.common.PracConstant;
import cc.common.PracResult;
import cc.sjzd.dao.PracticeInstituteMapper;
import cc.sjzd.entity.PracticeInstitute;
import cc.sjzd.service.InstituteService;

@Service(value="townService")
public class InstituteServiceImpl implements InstituteService {
	
	@Autowired
	private PracticeInstituteMapper townDao;
	
	/**
	 * 查询所有的文明实践所
	 * @return 信息类
	 * */
	@Override
	public PracResult selectAll(int page, int size,String orderField,String orderSeq) {
		PracResult result = new PracResult();
		String orderBy = orderField + " "+orderSeq;
		PageHelper.startPage(page, size, orderBy);
		List<PracticeInstitute> townLists = townDao.selectAll();
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(townLists);
		return result;
	}
	
	/**
	 * 根据id 查询文明实践所的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	@Override
	public PracResult selectById(int id) {
		PracResult result = new PracResult();
		PracticeInstitute town = townDao.selectByPrimaryKey(id);
		if(town == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setData(town);
		return result;
	}
	
	/**
	 * 根据id 删除文明实践所的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	@Override
	public PracResult deleteById(int id) {
		PracResult result = new PracResult();
		PracticeInstitute town = townDao.selectByPrimaryKey(id);
		if(town == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		int row = townDao.deleteByPrimaryKey(id);
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
	 * 修改文明实践所的方法
	 * @param center 更新后的文明实践所类
	 * @return 信息类
	 */
	@Override
	public PracResult update(PracticeInstitute town) {
		PracResult result = new PracResult();
		int row = townDao.updateByPrimaryKeySelective(town);
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
	 * 新增文明实践所
	 * @param center 新增的文明实践所类
	 * @return 信息类
	 */
	@Override
	public PracResult insert(PracticeInstitute town) {
		PracResult result = new PracResult();
		int row = townDao.insert(town);
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
	 * 根据center_id查询下属的实践站
	 * @param center_id 文明实践中心的id
	 * @return 信息类
	 */
	@Override
	public PracResult selectByCenterId(int center_id) {
		PracResult result = new PracResult();
		List<PracticeInstitute> townLists = townDao.selectByCenterId(center_id);
		if(townLists == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setData(townLists);
		return result;
	}

	/**
	 * 根据名称模糊查询实践站
	 * @param name 文明实践站
	 * @return 信息类
	 */
	@Override
	public PracResult selectByInstituteName(String name,int page, int size,String orderField,String orderSeq) {
		PracResult result = new PracResult();
		String orderBy = orderField + " "+orderSeq;
		PageHelper.startPage(page, size, orderBy);
		List<PracticeInstitute> townList = townDao.selectByInstituteName(name);
		if(townList == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(townList);
		return result;
	}
	


}
