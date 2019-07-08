package com.company.WordDay.model;

public class Magic {

    private Magic magic;
    private Magic question;

    public Magic(Magic magic, Magic question) {
        this.magic = magic;
        this.question = question;
    }

    private String Answers;
    private String Question;

    public String getAnswer() {
        return Answers;
    }

    public void setAnswer(String answer) {
        Answers = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }


}
