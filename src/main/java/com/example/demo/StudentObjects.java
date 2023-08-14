package com.example.demo;

import java.math.BigInteger;

public class StudentObjects {


  private int studentid;
    private String name;
    private String gender;
    private String mailid;
    private String qualification;
    private String stream;
    private BigInteger phoneno;
    private String courseinterest;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public BigInteger getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(BigInteger phoneno) {
        this.phoneno = phoneno;
    }

    public String getCourseinterest() {
        return courseinterest;
    }

    public void setCourseinterest(String courseinterest) {
        this.courseinterest = courseinterest;
    }
}
