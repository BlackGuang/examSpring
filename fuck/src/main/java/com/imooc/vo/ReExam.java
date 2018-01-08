package com.imooc.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReExam {

    private int id;
    private String context;
//    private String []array_1= new String[4];
    private int testId;
    private String testName;
    private int vaule;
    private List<QuestionOption> questionOption= new ArrayList<QuestionOption>();

    public List<QuestionOption> getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(List<QuestionOption> questionOption) {
        this.questionOption = questionOption;
    }

    public int getVaule() {
        return vaule;
    }

    public void setVaule(int vaule) {
        this.vaule = vaule;
    }


    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

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


}
