package com.jrx.ydm.mybatisdemo.entity;

import java.util.List;

/**
 * student_info 表的实体类
 *
 * @author yudaoming
 * @version 1.0
 * @date 2019/6/4 18:06
 */
public class StudentInfo{

    /**
     * 主键  学号
     */
    private String studentId;
    /**
     * 班级号
     */
    private String classId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private char sex;
    /**
     * 年龄
     */
    private int age;

    /**
     * 一对多关系，一个学生有多个科目的考试信息
     */
    private List<TestInfo> testInfos;

    /**
     * 一对一关系，一个学生有一个考试汇总信息
     */
    private TestAll testAll;

    public List<TestInfo> getTestInfos() {
        return testInfos;
    }

    public void setTestInfos(List<TestInfo> testInfos) {
        this.testInfos = testInfos;
    }

    public TestAll getTestAll() {
        return testAll;
    }

    public void setTestAll(TestAll testAll) {
        this.testAll = testAll;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudentInfo{")
                .append("studentId='").append(studentId).append('\'')
                .append(", classId='").append(classId).append('\'')
                .append(", name='").append(name).append('\'')
                .append(", sex='").append(sex).append('\'')
                .append(", age=").append(age)
                .append('}');
        return  sb.toString();
    }
}
