package com.jrx.ydm.mybatisdemo.controller;

import com.jrx.ydm.mybatisdemo.entity.TestInfo;
import com.jrx.ydm.mybatisdemo.service.TestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * test_info 表的控制层访问接口
 * @author yudaoming
 */
@RestController
@RequestMapping("ti")
public class TestInfoController {

    /**
     * 操作 test_info 表的业务接口
     */
    @Autowired
    private TestInfoService testInfoService;


    /**
     * 测试查询
     * @return 查询到的考试信息
     */
    @RequestMapping("f")
    public String findById(){
        String sid = "1";
        List<TestInfo> list = testInfoService.findById(sid);
        StringBuilder sb = new StringBuilder();
        for (TestInfo t:list) {
            sb.append(t.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * 测试更新
     * @return 更新的记录条数
     */
    @RequestMapping("u")
    public String updateOne(){
        TestInfo testInfo = new TestInfo();
        testInfo.setStudentId("1");
        testInfo.setSubject("化学");
        testInfo.setScore(BigDecimal.valueOf(88));
        testInfo.setXh("2019000001");
        int result = testInfoService.updateOne(testInfo);
        return "更新的条数：" + result;
    }

    /**
     * 测试保存
     * @return 保存的记录条数
     */
    @RequestMapping("s")
    public String saveOne(){
        TestInfo testInfo = new TestInfo();
        testInfo.setStudentId("1");
        testInfo.setSubject("化学");
        testInfo.setScore(BigDecimal.valueOf(80));
        testInfo.setXh("2019000001");
        int result = testInfoService.saveOne(testInfo);
        return "保存的条数：" + result;
    }


    /**
     * 测试删除
     * @return 删除的条数
     */
    @RequestMapping("d")
    public String deleteOne(){
        TestInfo testInfo = new TestInfo();
        testInfo.setStudentId("1");
        testInfo.setSubject("化学");
        testInfo.setScore(BigDecimal.valueOf(80));
        testInfo.setXh("2019000001");
        int result = testInfoService.deleteOne(testInfo);
        return "删除的条数：" + result;
    }

}
