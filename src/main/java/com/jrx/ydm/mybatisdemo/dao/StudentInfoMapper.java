package com.jrx.ydm.mybatisdemo.dao;

import com.jrx.ydm.mybatisdemo.entity.StudentInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * student_info 表的 mapper 接口
 * @author yudaoming
 */
@Mapper
@Component
public interface StudentInfoMapper {

    /**
     * 根据学生 id 查询一条学生信息
     * @param id 学号
     * @return 学生信息
     */
    @Select({"select * from student_info where student_id = #{id}"})
    @Results(value = {
            @Result(property = "studentId",column = "student_id"),
            @Result(property = "classId",column = "class_id"),
            @Result(property = "testInfos",column = "student_id",many = @Many(select = "com.jrx.ydm.mybatisdemo.dao.TestInfoMapper.findById")),
            @Result(property = "testAll",column = "student_id",one = @One(select = "com.jrx.ydm.mybatisdemo.dao.TestAllMapper.findById"))
    })
    public StudentInfo findById(String id);


    /**
     * 根据学号进行学生信息的更新
     * @param s 学生信息
     * @return 更新的数据条数
     */
    @Update({"update student_info set class_id = #{classId},name = #{name},sex = #{sex},age = #{age} where student_id = #{studentId}"})
    public int updateOne(StudentInfo s);


    /**
     * 保存一条学生信息
     * @param s 学生信息
     * @return 保存的记录条数
     */
    @Insert({"insert into student_info(student_id,class_id,name,sex,age) values(#{studentId},#{classId},#{name},#{sex},#{age})"})
    public int saveOne(StudentInfo s);


    /**
     * 根据学号删除一条学生信息
     * @param sid 学生学号
     * @return 删除的记录条数
     */
    @Delete("delete from student_info where student_id = #{sid}")
    public int deleteOne(String sid);

}
