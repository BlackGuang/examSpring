package com.imooc.mapper;

import com.imooc.vo.Exam;

import java.util.List;

public interface ExamMapper {

    List<Exam> getExam();
    List<Exam> getPaper(int number);
//    List<Paper> getPaper(int number);
    Exam getOne(int id);

    void insertQuestion(Exam question);
}
