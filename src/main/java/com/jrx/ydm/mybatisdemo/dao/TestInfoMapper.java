package com.jrx.ydm.mybatisdemo.dao;

import com.jrx.ydm.mybatisdemo.entity.TestAll;
import com.jrx.ydm.mybatisdemo.entity.TestInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * test_info 表的 mapper 接口
 * @author yudaoming
 */
@Mapper
@Component
public interface TestInfoMapper {


    /**
     * 根据学号查询考试信息
     * @param sid 学号
     * @return 该生的所有考试信息
     */
    @Select({"select * from test_info where student_id = #{sid}"})
    @Results({
            @Result(property = "studentId",column = "student_id"),
            @Result(property = "testTime",column = "test_time"),
            @Result(property = "studentInfo",column = "student_id",one = @One(select = "com.jrx.ydm.mybatisdemo.dao.StudentInfoMapper.findById"))
    })
    public List<TestInfo> findById(String sid);


    /**
     * 根据学号生成一条考试汇总信息
     * @param sid 学号
     * @return TestAll 考试汇总信息
     */
    @Select({"select student_id,xh,sum(score) score_all,avg(score) score_avg from test_info where student_id = #{sid} group by student_id"})
    @Results({
            @Result(property = "studentId",column = "student_id"),
            @Result(property = "scoreAll",column = "score_all"),
            @Result(property = "scoreAvg",column = "score_avg")
    })
    public TestAll generateTestAll(String sid);

    /**
     * 根据学号，考试科目，考试序号来更新学生的考试信息
     * @param testInfo 考试信息
     * @return 更新的条数
     */
    @Update({"update test_info set score = #{score},test_time = #{testTime} where student_id = #{studentId} and subject = #{subject} and xh = #{xh}"})
    public int updateOne(TestInfo testInfo);

    /**
     * 保存一条考试信息
     * @param testInfo 考试信息
     * @return 保存的条数
     */
    @Insert({"insert into test_info(student_id,subject,xh,score,test_time) values(#{studentId},#{subject},#{xh},#{score},#{testTime})"})
    public int saveOne(TestInfo testInfo);

    /**
     * 根据学号和科目进行考试信息的删除
     * @param testInfo 考试信息
     * @return 删除的条数
     */
    @Delete({"delete from test_info where student_id = #{studentId} and subject = #{subject}"})
    public int deleteOne(TestInfo testInfo);

    /**
     * 删除指定学号的所有考试信息
     * @param sid 学号
     * @return 删除的记录条数
     */
    @Delete({"delete from test_info where student_id = #{sid}"})
    public int deleteAll(String sid);

}
