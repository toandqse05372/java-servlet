/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import quiz.Exam;
import quiz.QuizQuestion;

/**
 *
 * @author Trung's PC
 */
@WebServlet("/exam")
public class ExamController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean finish = false;

        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("currentExam") == null) {
                session = request.getSession();
                String selectedExam = (String) request.getSession().getAttribute("exam");
                Object ob = session.getAttribute("totalNumberOfQuizQuestions");
                String sob = (String) ob;
                System.out.println("Setting Exam " + selectedExam);
                Exam newExam = new Exam(selectedExam, Integer.parseInt(sob));
                session.setAttribute("currentExam", newExam);
                String sq = (String) request.getSession().getAttribute("totalNumberOfQuizQuestions");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a");
                Date date = new Date();
                String started = dateFormat.format(date);
                session.setAttribute("started", started);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Exam exam = (Exam) request.getSession().getAttribute("currentExam");

        if (exam.currentQuestion == 0) {
            exam.setQuestion(exam.currentQuestion);
            QuizQuestion quiz = exam.questionList.get(exam.currentQuestion);
            session.setAttribute("quest", quiz);
        }
        String action = request.getParameter("action");

        System.out.println("Value of Action " + action + " " + request.getParameter("minute"));
        int minute = -1;
        int second = -1;
        if (request.getParameter("minute") != null) {
            minute = Integer.parseInt(request.getParameter("minute"));
            second = Integer.parseInt(request.getParameter("second"));
            request.getSession().setAttribute("min", request.getParameter("minute"));
            request.getSession().setAttribute("sec", request.getParameter("second"));
        }

        String radio = request.getParameter("answer");
        int selectedRadio = -1;
        exam.selections.put(exam.currentQuestion, selectedRadio);
        if ("1".equals(radio)) {
            selectedRadio = 1;
            exam.selections.put(exam.currentQuestion, selectedRadio);
            exam.questionList.get(exam.currentQuestion).setUserSelected(selectedRadio);
            System.out.println("You selected " + selectedRadio);
        } else if ("2".equals(radio)) {
            selectedRadio = 2;
            exam.selections.put(exam.currentQuestion, selectedRadio);
            exam.questionList.get(exam.currentQuestion).setUserSelected(selectedRadio);
            System.out.println("You selected " + selectedRadio);
        } else if ("3".equals(radio)) {
            selectedRadio = 3;
            exam.selections.put(exam.currentQuestion, selectedRadio);
            exam.questionList.get(exam.currentQuestion).setUserSelected(selectedRadio);
            System.out.println("You selected " + selectedRadio);
        } else if ("4".equals(radio)) {
            selectedRadio = 4;
            exam.selections.put(exam.currentQuestion, selectedRadio);
            exam.questionList.get(exam.currentQuestion).setUserSelected(selectedRadio);
            System.out.println("You selected " + selectedRadio);
        }

        if ("Next".equals(action)) {
            exam.currentQuestion++;
            exam.setQuestion(exam.currentQuestion);
            QuizQuestion quiz = exam.questionList.get(exam.currentQuestion);
            session.setAttribute("quest", quiz);
        } else if ("Previous".equals(action)) {
            System.out.println("You clicked previous button");
            exam.currentQuestion--;
            QuizQuestion quiz = exam.questionList.get(exam.currentQuestion);
            session.setAttribute("quest", quiz);
        } else if ("Finish Exam".equals(action) || (minute == 0 && second == 0)) {
            finish = true;
            int result = exam.calculateResult(exam, exam.questionList.size());
            request.setAttribute("result", result);
            //request.getSession().setAttribute("currentExam", null);
            request.getRequestDispatcher("/WEB-INF/jsps/result.jsp").forward(request, response);
        }

        if (finish != true) {
            request.getRequestDispatcher("/WEB-INF/jsps/exam.jsp").forward(request, response);
        }
    }
}
