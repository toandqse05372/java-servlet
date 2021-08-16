/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import quiz.Exam;
import quiz.QuizQuestion;

/**
 *
 * @author Trung's PC
 */
@WebServlet("/exam/review")
public class ReviewController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ReviewController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Exam exam=(Exam)request.getSession().getAttribute("currentExam");
        System.out.println("Exam size: " + exam.getTotalNumberOfQuestions());
        request.setAttribute("totalQuestion", exam.getTotalNumberOfQuestions());

        ArrayList<QuizQuestion> reviewQuestionList = new ArrayList<>();

        Document document = exam.getDom();

        for (int i = 0; i < exam.getTotalNumberOfQuestions(); i++) {
            int number = i;
            String options[] = new String[4];
            String question = null;
            int correct = 0;
            
            NodeList qList = document.getElementsByTagName("question");
            NodeList childList = qList.item(i).getChildNodes();
            
            int counter = 0;
            
            for (int j = 0; j < childList.getLength(); j++) {
                Node childNode = childList.item(j);
                if ("answer".equals(childNode.getNodeName())) {
                    options[counter] = childList.item(j).getTextContent();
                    counter++;
                } else if ("quizquestion".equals(childNode.getNodeName())) {
                    question = childList.item(j).getTextContent();
                } else if ("correct".equals(childNode.getNodeName())) {
                    correct = Integer.parseInt(childList.item(j).getTextContent());
                }
            }
            
            QuizQuestion q = new QuizQuestion();
            q.setQuestionNumber(number);
            q.setQuestion(question);
            q.setCorrectOptionIndex(correct);
            q.setQuestionOptions(options);
            q.setUserSelected(exam.getUserSelectionForQuestion(i));
            reviewQuestionList.add(number, q);
        }
        System.out.println("Review Question List: " + reviewQuestionList.size());
        request.setAttribute("reviewQuestions", reviewQuestionList);
        request.getRequestDispatcher("/WEB-INF/jsps/examReview.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
    }
}
