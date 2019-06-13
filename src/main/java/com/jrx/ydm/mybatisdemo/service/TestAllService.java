package com.jrx.ydm.mybatisdemo.service;

import com.jrx.ydm.mybatisdemo.dao.TestAllMapper;
import com.jrx.ydm.mybatisdemo.entity.TestAll;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * test_all 表的 crud 业务
 * @author yudaoming
 */
@Service
public class TestAllService {

    /**
     * 获取 Mapper 类实例的对象
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 通过学号来查询考试汇总信息
     * @param sid 学号
     * @return 该生考试汇总记录
     */
    public TestAll findById(String sid){
        TestAllMapper testAllMapper = sqlSessionTemplate.getMapper(TestAllMapper.class);
        return testAllMapper.findById(sid);
    }

    /**
     * 更新一条考试汇总信息
     * @param testAll 考试汇总信息
     * @return 更新的条数
     */
    public int updateOne(TestAll testAll){
        TestAllMapper testAllMapper = sqlSessionTemplate.getMapper(TestAllMapper.class);
        return testAllMapper.updateOne(testAll);
    }


    /**
     * 保存一条考试汇总信息
     * @param testAll 考试汇总信息
     * @return 保存的条数
     */
    public int saveOne(TestAll testAll){
        TestAllMapper testAllMapper = sqlSessionTemplate.getMapper(TestAllMapper.class);
        return testAllMapper.saveOne(testAll);
    }


    /**
     * 根据学号来删除一条考试汇总记录
     * @param sid 学号
     * @return 删除的条数
     */
    public int deleteOne(String sid){
        TestAllMapper testAllMapper = sqlSessionTemplate.getMapper(TestAllMapper.class);
        return testAllMapper.deleteOne(sid);
    }


}
