package com.jrx.ydm.mybatisdemo.dao;

import com.jrx.ydm.mybatisdemo.entity.TestAll;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * test_all 表的 mapper 接口
 * @author yudaoming
 */
@Mapper
@Component
public interface TestAllMapper {

    /**
     * 根据学生学号查询该生的考试汇总信息
     * @param sid 学号
     * @return TestAll
     */
    @Select({"select * from test_all where student_id = #{sid}"})
    @Results({
            @Result(property = "studentId",column = "student_id"),
            @Result(property = "scoreAll",column = "score_all"),
            @Result(property = "scoreAvg",column = "score_avg"),
            @Result(property = "studentInfo",column = "student_id",one = @One(select = "com.jrx.ydm.mybatisdemo.dao.StudentInfoMapper.findById"))
    })
    public TestAll findById(String sid);


    /**
     * 更新一条考试汇总信息
     * @param testAll 考试汇总信息
     * @return 更新的条数
     */
    @Update({"update test_all set score_all = #{scoreAll},score_avg = #{scoreAvg} where student_id = #{studentId}"})
    public int updateOne(TestAll testAll);


    /**
     * 保存一条考试汇总信息
     * @param testAll 考试汇总信息
     * @return 保存的条数
     */
    @Insert({"insert into test_all(student_id,xh,score_all,score_avg) values(#{studentId},#{xh},#{scoreAll},#{scoreAvg})"})
    public int saveOne(TestAll testAll);


    /**
     * 根据学号来删除一条考试汇总记录
     * @param sid 学号
     * @return 删除的条数
     */
    @Delete("delete from test_all where student_id = #{sid}")
    public int deleteOne(String sid);

}
