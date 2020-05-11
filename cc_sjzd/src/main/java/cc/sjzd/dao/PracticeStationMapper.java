package cc.sjzd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import cc.sjzd.entity.PracticeStation;

public interface PracticeStationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table practice_station
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    @Delete({
        "delete from practice_station",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table practice_station
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    @Insert({
        "insert into practice_station (station_name, ",
        "create_time, address, ",
        "manager, phone, ",
        "intro, type_id, center_id, ",
        "institute_id, imgs)",
        "values (#{stationName,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=DATE}, #{address,jdbcType=VARCHAR}, ",
        "#{manager,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{intro,jdbcType=VARCHAR}, #{typeId,jdbcType=INTEGER}, #{centerId,jdbcType=INTEGER}, ",
        "#{instituteId,jdbcType=INTEGER}, #{imgs,jdbcType=LONGVARCHAR})"
    })
    int insert(PracticeStation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table practice_station
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    @InsertProvider(type=PracticeStationSqlProvider.class, method="insertSelective")
    int insertSelective(PracticeStation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table practice_station
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    @Select({
        "select",
        "id, station_name, create_time, address, manager, phone, intro, type_id, center_id, ",
        "institute_id, imgs",
        "from practice_station",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id="stationMap",value={
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="station_name", property="stationName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="manager", property="manager", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.INTEGER),
        @Result(column="center_id", property="centerId", jdbcType=JdbcType.INTEGER),
        @Result(column="institute_id", property="instituteId", jdbcType=JdbcType.INTEGER),
        @Result(column="imgs", property="imgs", jdbcType=JdbcType.LONGVARCHAR)
    })
    PracticeStation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table practice_station
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    @UpdateProvider(type=PracticeStationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PracticeStation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table practice_station
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    @Update({
        "update practice_station",
        "set station_name = #{stationName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=DATE},",
          "address = #{address,jdbcType=VARCHAR},",
          "manager = #{manager,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "type_id = #{typeId,jdbcType=INTEGER},",
          "center_id = #{centerId,jdbcType=INTEGER},",
          "institute_id = #{instituteId,jdbcType=INTEGER},",
          "imgs = #{imgs,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(PracticeStation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table practice_station
     *
     * @mbg.generated Wed Apr 01 10:14:18 CST 2020
     */
    @Update({
        "update practice_station",
        "set station_name = #{stationName,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=DATE},",
          "address = #{address,jdbcType=VARCHAR},",
          "manager = #{manager,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "type_id = #{typeId,jdbcType=INTEGER},",
          "center_id = #{centerId,jdbcType=INTEGER},",
          "institute_id = #{instituteId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PracticeStation record);
    
    //查询所有文明实践站的方法  
    @Select({
        "select",
        "id, station_name, create_time, address, manager, phone, intro, type_id, center_id, ",
        "institute_id, imgs",
        "from practice_station",
    })
    @ResultMap("stationMap")
    List<PracticeStation> selectAll();
    
//    @Result(property="institutes",javaType=List.class,column="id",
//		many=@Many(select="cc.prac.dao.PracticeInstituteMapper.selectByCenterId"))
    
    //根据名称模糊查询
    @Select({
        "select",
        "id, station_name, create_time, address, manager, phone, intro, type_id, center_id, ",
        "institute_id, imgs",
        "from practice_station",
        "where station_name LIKE concat ('%', #{name},'%')"
    })
    @ResultMap("stationMap")
    List<PracticeStation> selectByStationName(String name);
    
    //根据institute_id 查询所有的信息
    @Select({
        "select",
        "id, station_name, create_time, address, manager, phone, intro, type_id, center_id, ",
        "institute_id, imgs",
        "from practice_station",
        "where institute_id = #{institute_id,jdbcType=INTEGER}"
    })
    @ResultMap("stationMap")
    List<PracticeStation> selectByInstituteId(Integer institute_id);
}