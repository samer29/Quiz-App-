/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapp;

import javafx.application.Application;
import javafx.stage.Stage;
import static tools.myfunctions.loadWindow;

/**
 *
 * @author samer
 */
public class QuizApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {        
        loadWindow(getClass().getResource("FXMLDocument.fxml"), "Quiz APP", null, "no");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
