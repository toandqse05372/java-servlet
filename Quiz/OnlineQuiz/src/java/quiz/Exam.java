/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 *
 * @author Trung's PC
 */
public class Exam {
    Document dom;
    public int currentQuestion = 0;
    public int totalNumberOfQuestions = 0;
    public int quizDuration = 0;
    
    public List<Integer> quizSelectionList = new ArrayList<>();

    public List<Integer> getQuizSelectionList() {
        return quizSelectionList;
    }
    
    public Map<Integer, Integer> selections = new LinkedHashMap<>();
    public ArrayList<QuizQuestion> questionList;
    
    public Exam (String test, int totalNumberOfQuestions) throws ParserConfigurationException, SAXException, IOException {
        dom = CreateDOM.getDOM(test);
        for (int i = 0; i < totalNumberOfQuestions; i++) {
            selections.put(i, -1);
        }
        questionList = new ArrayList<>(totalNumberOfQuestions);
    }
    
    public Exam(String test) throws ParserConfigurationException, SAXException, IOException {
        dom = CreateDOM.getDOM(test);
        for (int i = 0; i < totalNumberOfQuestions; i++) {
            selections.put(i, -1);
        }
        questionList = new ArrayList<>(totalNumberOfQuestions);
    }

    public Document getDom() {
        return dom;
    }
    
    public void setQuestion(int i) {
        int number = i;
        String[] options = new String[4];
        String question = null;
        int correct = 0;
        System.out.println("DOM " + dom);
        NodeList qList = dom.getElementsByTagName("question");
        NodeList childList = qList.item(i).getChildNodes();
        
        int counter = 0;
        
        for (int j = 0; j < childList.getLength(); j++) {
            Node childeNode = childList.item(j);
            if ("answer".equals(childeNode.getNodeName())) {
                options[counter] = childList.item(j).getTextContent();
                counter++;
            } else if ("quizquestion".equals(childeNode.getNodeName())) {
                question = childList.item(j).getTextContent();
            } else if ("correct".equals(childeNode.getNodeName())) {
                correct = Integer.parseInt(childList.item(j).getTextContent());
            }
        }
        for (String str : options) {
            System.out.println(str);
        }
        
        QuizQuestion quiz = new QuizQuestion();
        quiz.setQuestionNumber(number);
        quiz.setQuestion(question);
        quiz.setCorrectOptionIndex(correct);
        quiz.setQuestionOptions(options);
        questionList.add(number, quiz);
    }
    
    public ArrayList<QuizQuestion> getQuestionList() {
        return this.questionList;
    }
    
    public int getCurrentQuestion() {
        return currentQuestion;
    }
    
    public Map<Integer, Integer> getSelections() {
        return this.selections;
    }
    
    public int calculateResult(Exam exam, int taken) {
        int totalCorrect = 0;
        Map<Integer, Integer> userSelectionMap = exam.selections;
        List<Integer> userSelectionList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : userSelectionMap.entrySet()) {
            userSelectionList.add(entry.getValue());
        }
        
        quizSelectionList = userSelectionList;
        
        List<QuizQuestion> questionList = exam.questionList;
        List<Integer> correctAnswerList = new ArrayList<>();
        for (QuizQuestion question : questionList) {
            correctAnswerList.add(question.getCorrectOptionIndex());
        }
        
        for (int i = 0; i < taken - 1; i++) {
            if ((userSelectionList.get(i)-1) == correctAnswerList.get(i)) {
                totalCorrect++;
            }
        }

        return totalCorrect;
    }
    
    public int getUserSelectionForQuestion(int i) {
        Map<Integer, Integer> map = getSelections();
        return map.get(i);
    }

    public int getTotalNumberOfQuestions() {
        return totalNumberOfQuestions;
    }

    public void setTotalNumberOfQuestions(int totalNumberOfQuestions) {
        this.totalNumberOfQuestions = totalNumberOfQuestions;
    }
    
    
}
