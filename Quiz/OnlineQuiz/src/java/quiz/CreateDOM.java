/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Trung's PC
 */
public class CreateDOM {
    
    public static Document getDOM(String test) throws ParserConfigurationException, SAXException, IOException {
        Document dom = null;
        File quizFile = null;
        
        quizFile = new File("C:\\quizzes\\" + test + "-quiz-1.xml");
        System.out.println("Quiz file absolute's pth: " + quizFile.getAbsolutePath());
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        try {
            dom = db.parse(quizFile);
        } catch (FileNotFoundException e) {
            System.err.println("Error: Quiz File not found" + e);
        }
        dom.getDocumentElement().normalize();
        return dom;
    }
}
