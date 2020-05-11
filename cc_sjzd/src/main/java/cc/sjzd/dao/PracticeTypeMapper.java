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
import cc.sjzd.entity.PracticeType;

public interface PracticeTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table practice_type
     *
     * @mbg.generated Wed Apr 01 10:07:53 CST 2020
     */
    @Delete({
        "delete from practice_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table practice_type
     *
     * @mbg.generated Wed Apr 01 10:07:53 CST 2020
     */
    @Insert({
        "insert into practice_type (type_name)",
        "values (#{typeName,jdbcType=VARCHAR})"
    })
    int insert(PracticeType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table practice_type
     *
     * @mbg.generated Wed Apr 01 10:07:53 CST 2020
     */
    @InsertProvider(type=PracticeTypeSqlProvider.class, method="insertSelective")
    int insertSelective(PracticeType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table practice_type
     *
     * @mbg.generated Wed Apr 01 10:07:53 CST 2020
     */
    @Select({
        "select",
        "id, type_name",
        "from practice_type",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results(id="typeMap",value={
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR)
    })
    PracticeType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table practice_type
     *
     * @mbg.generated Wed Apr 01 10:07:53 CST 2020
     */
    @UpdateProvider(type=PracticeTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PracticeType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table practice_type
     *
     * @mbg.generated Wed Apr 01 10:07:53 CST 2020
     */
    @Update({
        "update practice_type",
        "set type_name = #{typeName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PracticeType record);
    
    //查询所有类型的方法  
    @Select({
        "select",
        "id, type_name",
        "from practice_type",
    })
    @ResultMap("typeMap")
    List<PracticeType> selectAll();
    
//    @Result(property="institutes",javaType=List.class,column="id",
//		many=@Many(select="cc.prac.dao.PracticeInstituteMapper.selectByCenterId"))
    
    //根据名称模糊查询
    @Select({
        "select",
        "id, type_name",
        "from practice_type",
        "where type_name LIKE concat ('%', #{name},'%')"
    })
    @ResultMap("typeMap")
    List<PracticeType> selectByCenterName(String name);
}