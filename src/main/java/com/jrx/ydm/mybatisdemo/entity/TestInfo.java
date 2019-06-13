package com.jrx.ydm.mybatisdemo.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * test_info 表的实体类
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/5 22:17
 */
public class TestInfo {

    /**
     * 主键自增 id
     */
    private int id;
    /**
     * 学生学号
     */
    private String studentId;
    /**
     * 科目
     */
    private String subject;
    /**
     * 考试序号
     */
    private String xh;
    /**
     * 考试分数
     */
    private BigDecimal score;
    /**
     * 考试时间
     */
    private Timestamp testTime;

    /**
     * 多对一关系，多条考试信息记录对应一个学生
     */
    private StudentInfo studentInfo;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(studentId).append(',')
                .append(subject).append(',')
                .append(xh).append(',')
                .append(score.toString()).append(',')
                .append(testTime.toString()).append("\r\n").toString();
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Timestamp getTestTime() {
        return testTime;
    }

    /**
     *
     * @param testTime 当从文件读入的时候传入参数是 String 类型
     */
    public void setTestTime(String testTime) {
        this.testTime = Timestamp.valueOf(testTime);
    }

}
