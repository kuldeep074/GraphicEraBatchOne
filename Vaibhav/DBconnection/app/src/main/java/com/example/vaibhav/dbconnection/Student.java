package com.example.vaibhav.dbconnection;

/**
 * Created by vaibhav on 11/7/17.
 */

public class Student {
    private int studentId;
    private String studentName;
    private int studentRollNo;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(int studentRollNo) {
        this.studentRollNo = studentRollNo;
    }
}