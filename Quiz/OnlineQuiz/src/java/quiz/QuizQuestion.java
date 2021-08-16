/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author Trung's PC
 */
public class QuizQuestion {

    private int questionNumber;
    private String question;
    private String[] questionOptions;
    private int correctOptionIndex;
    private int userSelected = -1;

    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getQuestionOptions() {
        return questionOptions;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public int getUserSelected() {
        return userSelected;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setQuestionOptions(String[] questionOptions) {
        this.questionOptions = questionOptions;
    }

    public void setCorrectOptionIndex(int correctOptionIndex) {
        this.correctOptionIndex = correctOptionIndex;
    }

    public void setUserSelected(int userSelected) {
        this.userSelected = userSelected;
    }

    @Override
    public String toString() {
        String str = questionNumber + "." + getQuestion();
        for (String option : getQuestionOptions()) {
            str = str + option + "  ";
        }
        str = str + "\n Correct Answer : " + getCorrectOptionIndex();
        return str;
    }
}
