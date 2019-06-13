package com.jrx.ydm.mybatisdemo.service;

import com.jrx.ydm.mybatisdemo.dao.StudentInfoMapper;
import com.jrx.ydm.mybatisdemo.entity.StudentInfo;
import com.jrx.ydm.mybatisdemo.entity.TestAll;
import com.jrx.ydm.mybatisdemo.entity.TestInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * student_info 表的 crud 业务
 * @author yudaoming
 */
@Service
public class StudentInfoService {

    /**
     * 获取 Mapper 类实例的对象
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 操作 test_info 表的业务接口
     */
    @Autowired
    private TestInfoService testInfoService;

    /**
     * 操作 test_all 表的业务接口
     */
    @Autowired
    private TestAllService testAllService;

    /**
     * 通过 id 查找学生信息
     * @param id 学号
     * @return 找到的学生记录对应的对象
     */
    public StudentInfo findById(String id){
        StudentInfoMapper studentInfoMapper = sqlSessionTemplate.getMapper(StudentInfoMapper.class);
        return studentInfoMapper.findById(id);
    }


    /**
     * 根据学号进行学生信息的更新
     * @param s StudentInfo 对象
     * @return 更新语句影响的记录条数
     */
    public int updateOne(StudentInfo s){
        StudentInfoMapper studentInfoMapper = sqlSessionTemplate.getMapper(StudentInfoMapper.class);
        return studentInfoMapper.updateOne(s);
    }


    /**
     * 保存一个学生的信息
     * @param s 学生信息对象
     * @return 保存语句影响的记录条数
     */
    public int saveOne(StudentInfo s){
        StudentInfoMapper studentInfoMapper = sqlSessionTemplate.getMapper(StudentInfoMapper.class);
        return studentInfoMapper.saveOne(s);
    }

    /**
     * 删除一条学生信息
     * @param sid 学号
     * @return 删除的记录条数
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = {Exception.class})
    public int deleteOne(String sid){
        StudentInfoMapper studentInfoMapper = sqlSessionTemplate.getMapper(StudentInfoMapper.class);

        //如果有，就删除考试信息
        List<TestInfo> list = testInfoService.findById(sid);
        if(list != null && !list.isEmpty()){
            testInfoService.deleteAll(sid);
        }

        // 如果有，就删除考试汇总信息
        TestAll testAll = testAllService.findById(sid);
        if(testAll != null){
            testAllService.deleteOne(sid);
            throw new RuntimeException("就是要抛个异常");
        }

        return studentInfoMapper.deleteOne(sid);
    }


}
