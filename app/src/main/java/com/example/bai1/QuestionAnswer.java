package com.example.bai1;

import java.util.ArrayList;
import java.util.List;

public class QuestionAnswer {
    public String Question;
    public String Answer1;
    public String Answer2;
    public String Answer3;
    public String Answer4;
    public Integer CorrectA = 0;

    public QuestionAnswer(String question, String answer1, String answer2, String answer3, String answer4, Integer correctA) {
        Question = question;
        Answer1 = answer1;
        Answer2 = answer2;
        Answer3 = answer3;
        Answer4 = answer4;
        CorrectA = correctA;
    }

    public static List<QuestionAnswer> Getlist() {
        List<QuestionAnswer> list = new ArrayList<>();
        list.add(new QuestionAnswer("1. Đâu là 1 mùa trong năm?", "Đông", "Tây", "Nam", "Bắc", 1));
        list.add(new QuestionAnswer("2. Bảy chú lùn trong truyện \"Bạch tuyết bảy chú lùn\"Làm nghề gì", "Thợ sát", "Thợ mỏ", "Thợ săn", "Thợ rèn", 1));
        list.add(new QuestionAnswer("3. Thính được làm từ gì?", "Củ cải", "Gạo", "Đậu", "Tóc", 2));
        return list;
    }
}
