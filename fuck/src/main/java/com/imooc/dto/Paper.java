package com.imooc.dto;

public class Paper {
    private int id;
    private String context;
    private String A;
    private String B;
    private String C;
    private String D;
    private String testId;
    private String testName;


    //    test.testId,test.testName,
//    exam_1.id,exam_1.context,exam_1.A,exam_1.B,exam_1.C,exam_1.D,exam_1.answer
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", context='" + context + '\'' +
                ", A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                ", testId='" + testId + '\'' +
                ", testName='" + testName + '\'' +
                '}';
    }

}
