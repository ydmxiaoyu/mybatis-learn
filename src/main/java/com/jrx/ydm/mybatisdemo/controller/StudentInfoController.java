package com.jrx.ydm.mybatisdemo.controller;

import com.jrx.ydm.mybatisdemo.entity.StudentInfo;
import com.jrx.ydm.mybatisdemo.service.StudentInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * student_info 表的控制层访问接口
 * @author yudaoming
 */
@RestController
@RequestMapping("s")
public class StudentInfoController {

    /**
     * 操作 student_info 表的业务接口
     */
    @Autowired
    private StudentInfoService studentInfoService;

    /**
     * 日志打印对象
     */
    private static final Logger logger = LoggerFactory.getLogger(StudentInfoController.class);

    /**
     * 测试查询
     * @return 查询到的学生对象
     */
    @RequestMapping("f")
    public String findById(){

        StudentInfo s = studentInfoService.findById("1");
        String str = s.toString();
        logger.debug(str);
        return s.toString();
    }

    /**
     * 测试更新
     * @return 更新的记录条数
     */
    @RequestMapping("u")
    public String updateOne(){

        StudentInfo s = new StudentInfo();
        s.setStudentId("10000");
        s.setClassId("201928");
        s.setName("linger");
        s.setSex('M');
        s.setAge(22);
        int result = studentInfoService.updateOne(s);
        logger.debug(s.toString());
        return "更新的数据条数：" + result;
    }

    /**
     * 测试保存
     * @return 保存的记录条数
     */
    @RequestMapping("s")
    public String saveOne(){
        StudentInfo s = new StudentInfo();
        s.setStudentId("10001");
        s.setClassId("201928");
        s.setName("linger");
        s.setSex('M');
        s.setAge(22);

        int result = studentInfoService.saveOne(s);
        logger.debug(s.toString());
        return "保存的数据条数：" + result;
    }


    /**
     * 测试删除
     * @return 删除的记录条数
     */
    @RequestMapping("d")
    public String deleteOne(){
        String sid = "1";
        int result = 0;
        try {
             result = studentInfoService.deleteOne(sid);
        } catch (Exception e){
            logger.error("抓到异常，事务回滚，异常信息如下：",e);
        }

        return "删除的记录条数：" + result;
    }

}
