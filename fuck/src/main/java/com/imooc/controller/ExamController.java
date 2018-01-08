package com.imooc.controller;

import com.imooc.dto.Paper;
import com.imooc.mapper.ExamMapper;
import com.imooc.vo.Exam;
import com.imooc.vo.QuestionOption;
import com.imooc.vo.ReExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.util.*;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/exam")
public class ExamController {

    @Autowired
    private ExamMapper examMapper;

    @RequestMapping(value = "/getExam")
    public List<ReExam> getExam(
                               HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Exam> exams=examMapper.getExam();
        List<ReExam> reExams= new ArrayList<ReExam>();
        ReExam reExam;
        String []array_1= new String[4];
        for(int i=0;i<exams.size();i++){
            reExam=new ReExam();                //这句代码具有大意义

            array_1=new String [4];
            array_1[0]=exams.get(i).getA();
            array_1[1]=exams.get(i).getB();
            array_1[2]=exams.get(i).getC();
            array_1[3]=exams.get(i).getD();
            reExam.setId(exams.get(i).getId());
            reExam.setContext(exams.get(i).getContext());
//            reExam.setArray_1(array_1);
            reExams.add(reExam);             //这样的话因为添加的都是一个东西，所以会导致前面的更新，最后都是一样的结果
        }
        return reExams;
    }



    @RequestMapping(value = "/getExamTest")
    public ReExam[] getExamTest(
            HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Exam> exams=examMapper.getExam();
        String []array_1= new String[4];
        ReExam []reExams1=new ReExam[2];
        reExams1[0]=new ReExam();
        reExams1[1]=new ReExam();
        for(int i=0;i<exams.size();i++){
            array_1[0]=exams.get(i).getA();
            array_1[1]=exams.get(i).getB();
            array_1[2]=exams.get(i).getC();
            array_1[3]=exams.get(i).getD();
            reExams1[i].setId(exams.get(i).getId());
            reExams1[i].setContext(exams.get(i).getContext());
//            reExams1[i].setArray_1(array_1);
            System.out.println(reExams1[i].toString()+"dadiao");
            System.out.println(reExams1[i].toString()+"dadiao1");
        }
        for(int i=0;i<2;i++){
            System.out.println(reExams1[i].toString()+"dadiaoceshi");
        }
        return reExams1;
    }


    @RequestMapping(value = "/getPaperT")
    public List<ReExam> getPaperT(
            HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        //试卷编号
        Random rand = new Random();
        int testID = rand.nextInt(); //int范围类的随机数
        testID = rand.nextInt(3); //生成0-100以内的随机数

        testID = (int)(Math.random() * 3); //0-3以内的随机数，用Matn.random()方式
//        int testID=(int) Math.random()*2+1;
        if(testID==0)
            testID=1;
        List<Exam> exams=examMapper.getPaper(testID);
        List<ReExam> reExams= new ArrayList<ReExam>();
        ReExam reExam;

        for(int i=0;i<exams.size();i++){
            reExam=new ReExam();                //这句代码具有大意义

            List<QuestionOption> questionOptions=new ArrayList<QuestionOption>();
            questionOptions.add(new QuestionOption("A",exams.get(i).getA()));
            questionOptions.add(new QuestionOption("B",exams.get(i).getB()));
            questionOptions.add(new QuestionOption("C",exams.get(i).getC()));
            questionOptions.add(new QuestionOption("D",exams.get(i).getD()));

            reExam.setVaule(-1);
            reExam.setId(exams.get(i).getId());
            reExam.setContext(exams.get(i).getContext());
            reExam.setQuestionOption(questionOptions);
//            reExam.setArray_1();
            reExam.setTestId(testID);
            reExam.setTestName(exams.get(i).getTest().getTestName());
            reExams.add(reExam);             //这样的话因为添加的都是一个东西，所以会导致前面的更新，最后都是一样的结果
        }
        System.out.println(testID);
        return reExams;
    }


    @RequestMapping(value = "/getPaper")
    public List<ReExam> getPaper(
            HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Random rand = new Random();
        int testID = rand.nextInt(5); //生成1-5以内的随机数
        testID = (int)(Math.random() * 5+1); //1-5以内的随机数，用Matn.random()方式
        List<Exam> exams=examMapper.getPaper(testID);  //根据生成的随机id在数据库中挑选题目
        List<ReExam> reExams= new ArrayList<ReExam>();
        ReExam reExam;
        for(int i=0;i<exams.size();i++){
            reExam=new ReExam();                //这句代码具有大意义
            List<QuestionOption> questionOptions=new ArrayList<QuestionOption>();
            questionOptions.add(new QuestionOption("A",exams.get(i).getA()));
            questionOptions.add(new QuestionOption("B",exams.get(i).getB()));
            questionOptions.add(new QuestionOption("C",exams.get(i).getC()));
            questionOptions.add(new QuestionOption("D",exams.get(i).getD()));
            reExam.setVaule(-1);
            reExam.setId(exams.get(i).getId());
            reExam.setContext(exams.get(i).getContext());
            reExam.setQuestionOption(questionOptions);
            reExam.setTestId(testID);
            reExam.setTestName(exams.get(i).getTest().getTestName());
            reExams.add(reExam);
        }
        System.out.println(testID);
        return reExams;
    }


    @RequestMapping(value = "/getOne/{id}")
    public ReExam getOne(@PathVariable("id") int id,
                         HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        Exam exam=examMapper.getOne(id);
        String []array_1= new String[4];

        array_1[0]=exam.getA();
        array_1[1]=exam.getB();
        array_1[2]=exam.getC();
        array_1[3]=exam.getD();

        ReExam reExam=new ReExam();

        reExam.setId(exam.getId());
        reExam.setContext(exam.getContext());
//        reExam.setArray_1(array_1);
        System.out.println(array_1[1]);
        return reExam;
    }

    @RequestMapping(value = "/submitPaper/{userAnswer}")
    public String getScore(@PathVariable("userAnswer") String userAnswer,
                        HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        int testID=1;
        int userScore=0;
        int []meUserAnswer=new int[10];
        List<Exam> exams=examMapper.getPaper(testID);
        int[] answer = new int[10];
        for(int i=0;i<10;i++){
            String c = userAnswer.substring(i, i+1);
            answer[i]=Integer.valueOf(c).intValue();
        }
        for(int i=0;i<exams.size();i++){
            System.out.println("题目"+exams.get(i).getContext());
            System.out.println("用户答案"+answer[i]);
            System.out.println("正确答案"+exams.get(i).getAnswer());
            if(answer[i]==exams.get(i).getAnswer()){
                userScore=userScore+10;
            }
        }
        System.out.println("用户得分"+userScore);
        String userscore_s=Integer.toString(userScore);
        return userscore_s;
    }

    @RequestMapping(value = "/submitPaperT")
    public String getScoreT(
                        HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        int testID=1;
        int userScore=0;
        int []meUserAnswer=new int[10];
        List<Exam> exams=examMapper.getPaper(testID);

        String userAnswer="#1#";
        String[] ans = userAnswer.split("\\#");

        int[] answer = new int[10];

        for(int i=0;i<10;i++) {
            answer[i] = Integer.valueOf(ans[i]).intValue();
        }
        String userscore_s=Integer.toString(userScore);
        return userscore_s;
    }

    @RequestMapping(value = "/insertQuestion")
    public void insertQuestion(){
        Exam question=new Exam();
        examMapper.insertQuestion(question);
    }
}
