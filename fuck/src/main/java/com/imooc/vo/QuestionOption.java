package com.imooc.vo;

public class QuestionOption {


    private String questionTitle;
    private String questionContext;


    public QuestionOption(String questionTitle, String questionContext) {
        this.questionTitle = questionTitle;
        this.questionContext = questionContext;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionContext() {
        return questionContext;
    }

    public void setQuestionContext(String questionContext) {
        this.questionContext = questionContext;
    }


}
