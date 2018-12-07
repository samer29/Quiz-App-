/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.firstwindowController.count;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import tools.myfunctions;
import static tools.myfunctions.closeStage;
import static tools.myfunctions.loadfadestage;
import static tools.myfunctions.minimiseStage;
import static tools.myfunctions.setimageIV;

/**
 * FXML Controller class
 *
 * @author samer
 */
public class ResultController implements Initializable {

    @FXML
    private AnchorPane rootAnchoreVR;
    @FXML
    private ImageView resultpic;
    @FXML
    private Label labelscore;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bootstage();
    }  
    public void bootstage(){
        labelscore.setText(count+"/10");
        if(count<5){
            setimageIV("src/icons/bad.png", resultpic);
        }else {
            setimageIV("src/icons/cong.png", resultpic);
        }
    }

    @FXML
    private void newgame(ActionEvent event) {
        count=0;
                loadfadestage(1000, rootAnchoreVR, "/views/viewfirstwindow.fxml", "", "no");
                
    }

    @FXML
    private void closeAPP(MouseEvent event) {
        closeStage(rootAnchoreVR);
    }

    @FXML
    private void minimizeAPP(MouseEvent event) {
        minimiseStage(event);
    }
    
}
