package com.jrx.ydm.mybatisdemo.entity;

import java.math.BigDecimal;

/**
 * test_all 表的实体类
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/6 11:02
 */
public class TestAll {

    /**
     * 自增主键
     */
    private int id;
    /**
     * 学号
     */
    private String studentId;
    /**
     * 考试序号
     */
    private String xh;
    /**
     * 总成绩
     */
    private BigDecimal scoreAll;
    /**
     * 平均成绩
     */
    private BigDecimal scoreAvg;

    /**
     * 一对一关系，一条考试汇总信息对应一个学生
     */
    private StudentInfo studentInfo;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(studentId).append(',')
                .append(xh).append(',')
                .append(scoreAll).append(',')
                .append(scoreAvg).append(',')
                .append("\r\n").toString();
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public BigDecimal getScoreAll() {
        return scoreAll;
    }

    public void setScoreAll(BigDecimal scoreAll) {
        this.scoreAll = scoreAll;
    }

    public BigDecimal getScoreAvg() {
        return scoreAvg;
    }

    public void setScoreAvg(BigDecimal scoreAvg) {
        this.scoreAvg = scoreAvg;
    }
}
