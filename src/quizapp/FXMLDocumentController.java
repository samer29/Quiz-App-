/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import tools.myfunctions;
import static tools.myfunctions.closeStage;
import static tools.myfunctions.loadWindow;
import static tools.myfunctions.loadfadestage;

/**
 *
 * @author samer
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private AnchorPane rootAnchorPane;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loadnextScene(ActionEvent event) {
        loadfadestage(1000, rootAnchorPane, "/views/viewfirstwindow.fxml", "", "no");
    }

    @FXML
    private void closeApplication(MouseEvent event) {
        closeStage(rootAnchorPane);
    }
    
}
