package com.jrx.ydm.mybatisdemo.service;

import com.jrx.ydm.mybatisdemo.dao.TestInfoMapper;
import com.jrx.ydm.mybatisdemo.entity.TestAll;
import com.jrx.ydm.mybatisdemo.entity.TestInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * test_info 表的 crud 业务
 * @author yudaoming
 */
@Service
public class TestInfoService {

    /**
     * 获取 Mapper 类实例的对象
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 根据学号查询考试信息
     * @param sid 学号
     * @return 该生的所有考试信息
     */
    public List<TestInfo> findById(String sid){
        TestInfoMapper testInfoMapper = sqlSessionTemplate.getMapper(TestInfoMapper.class);
        return testInfoMapper.findById(sid);
    }

    /**
     * 根据学号，考试科目，考试序号来更新学生的考试信息
     * @param testInfo 考试信息
     * @return 更新的条数
     */
    public int updateOne(TestInfo testInfo){
        TestInfoMapper testInfoMapper = sqlSessionTemplate.getMapper(TestInfoMapper.class);
        return testInfoMapper.updateOne(testInfo);
    }

    /**
     * 保存一条考试信息
     * @param testInfo 考试信息
     * @return 保存的条数
     */
    public int saveOne(TestInfo testInfo){
        TestInfoMapper testInfoMapper = sqlSessionTemplate.getMapper(TestInfoMapper.class);
        return testInfoMapper.saveOne(testInfo);
    }

    /**
     * 根据学号和科目进行考试信息的删除
     * @param testInfo 考试信息
     * @return 删除的条数
     */
    public int deleteOne(TestInfo testInfo){
        TestInfoMapper testInfoMapper = sqlSessionTemplate.getMapper(TestInfoMapper.class);
        return testInfoMapper.deleteOne(testInfo);
    }

    /**
     * 根据学号生成一条考试汇总信息
     * @param sid 学号
     * @return TestAll 考试汇总信息
     */
    public TestAll generateTestAll(String sid){
        TestInfoMapper testInfoMapper = sqlSessionTemplate.getMapper(TestInfoMapper.class);
        return testInfoMapper.generateTestAll(sid);
    }

    /**
     * 删除指定学号的所有考试信息
     * @return 删除的记录条数
     */
    public int deleteAll(String sid){
        TestInfoMapper testInfoMapper = sqlSessionTemplate.getMapper(TestInfoMapper.class);
        return testInfoMapper.deleteAll(sid);
    }
}
