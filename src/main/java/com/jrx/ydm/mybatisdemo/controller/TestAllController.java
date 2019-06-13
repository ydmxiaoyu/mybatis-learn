package com.jrx.ydm.mybatisdemo.controller;

import com.jrx.ydm.mybatisdemo.entity.TestAll;
import com.jrx.ydm.mybatisdemo.service.TestAllService;
import com.jrx.ydm.mybatisdemo.service.TestInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test_all 表的控制层访问接口
 * @author yudaoming
 */
@RestController
@RequestMapping("ta")
public class TestAllController {

    /**
     * 日志打印对象
     */
    private static final Logger logger = LoggerFactory.getLogger(TestAllController.class);

    /**
     * 操作 test_all 表的业务接口
     */
    @Autowired
    private TestAllService testAllService;

    /**
     * 操作 test_info 表的业务接口
     */
    @Autowired
    private TestInfoService testInfoService;

    /**
     * 测试查询
     * @return 指定学生的考试汇总记录
     */
    @RequestMapping("f")
    public String findById(){
        String sid = "1";
        TestAll testAll = testAllService.findById(sid);

        logger.debug(testAll == null ? "":testAll.toString());
        logger.debug(testAll == null ? "":testAll.getStudentInfo().toString());

        return testAll == null ? "":(testAll.toString() + testAll.getStudentInfo().toString());
    }

    /**
     * 测试保存
     * @return 保存的条数
     */
    @RequestMapping("s")
    public String saveOne(){
        String sid = "1";
        TestAll testAll = testInfoService.generateTestAll(sid);
        int result = testAllService.saveOne(testAll);
        return "保存的条数：" + result;
    }

    /**
     * 测试更新
     * @return 更新的条数
     */
    @RequestMapping("u")
    public String updateOne(){
        String sid = "1";
        TestAll testAll = testInfoService.generateTestAll(sid);
        int result = testAllService.updateOne(testAll);
        return "更新的条数：" + result;
    }

    /**
     * 测试删除
     * @return 删除的条数
     */
    @RequestMapping("d")
    public String deleteOne(){
        String sid = "1";
        return "删除的条数：" + testAllService.deleteOne(sid);
    }

}
