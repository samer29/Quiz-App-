/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import tools.myConnection;
import static tools.myfunctions.closeStage;
import static tools.myfunctions.getanswerid;
import static tools.myfunctions.loadfadestage;
import static tools.myfunctions.minimiseStage;
import static tools.myfunctions.showMaterialDialogError;
import static tools.myfunctions.unselect;
import static tools.myfunctions.writeanswers;
import java.util.concurrent.ThreadLocalRandom;


/**
 * FXML Controller class
 *
 * @author samer
 */
public class firstwindowController implements Initializable {

    @FXML
    private AnchorPane rootAnchorPaneFW;
    @FXML
    private JFXButton q1;
    @FXML
    private JFXButton q2;
    @FXML
    private JFXButton q3;
    @FXML
    private JFXButton q4;
    @FXML
    private JFXButton q5;
    @FXML
    private JFXButton q6;
    @FXML
    private JFXButton q7;
    @FXML
    private JFXButton q8;
    @FXML
    private JFXButton q9;
    @FXML
    private JFXButton q10;
    @FXML
    private Text qNo;
    @FXML
    private Text questions;
    @FXML
    private JFXRadioButton b1;
    @FXML
    private JFXRadioButton b4;
    @FXML
    private JFXRadioButton b3;
    @FXML
    private JFXRadioButton b2;
    @FXML
    private JFXButton bbnxt;
    @FXML
    private JFXButton sumbmit;
    @FXML
    private Text firstProposition;
    @FXML
    private Text fourthproposition;
    @FXML
    private Text thirdproposition;
    @FXML
    private Text secondproposition;
    String ans, question, number = "1";
    String ra = null;
    String questionnumber;
    private JFXButton q;
    private ToggleGroup tgGroup;
    int i = 1;
    static int count = 0;
    @FXML
    private StackPane rootStackPaneFW;
    int randomNum;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radiogroup();
        randomNum = ThreadLocalRandom.current().nextInt(1, 11 + 1);

        loadquestion();
        qNo.setText("Q. " + number + "|");
    }

    public void radiogroup() {
        tgGroup = new ToggleGroup();
        b1.setToggleGroup(tgGroup);
        b2.setToggleGroup(tgGroup);
        b3.setToggleGroup(tgGroup);
        b4.setToggleGroup(tgGroup);
    }

    public void loadquestion() {
        try {
            questionnumber=String.valueOf(randomNum);
            ResultSet rst = myConnection.inst3("questions", "id", questionnumber);
            while (rst.next()) {
                
                questions.setText(rst.getString(2));
                firstProposition.setText(rst.getString(3));
                secondproposition.setText(rst.getString(4));
                thirdproposition.setText(rst.getString(5));
                fourthproposition.setText(rst.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(firstwindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String answer() {
        if (b1.isSelected()) {
            ans = firstProposition.getText();
        } else if (b2.isSelected()) {
            ans = secondproposition.getText();
        } else if (b3.isSelected()) {
            ans = thirdproposition.getText();
        } else if (b4.isSelected()) {
            ans = fourthproposition.getText();
        } else {

        }

        return ans;
    }

    public void loadrightanswer(JFXButton q) {

        try {
            ResultSet rs = myConnection.instload2things("questions", "question", question, "rightanswer", ra);
            if (rs.next()) {
                q.getStyleClass().add("true_answer");
                System.out.println("TRUE ANSWER ");
                count++;
            } else {
                q.getStyleClass().add("false_answer");
                System.out.println("False ANSWER ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(firstwindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void q1Action(ActionEvent event) {
        bbnxt.setDisable(false);
        number = "1";
        loadquestion();
        qNo.setText("Q. " + number + "|");
        question = questions.getText();
        i = 1;

    }

    @FXML
    private void q2Action(ActionEvent event) {
        bbnxt.setDisable(false);
        number = "2";
        qNo.setText("Q. " + number + "|");
        loadquestion();
        question = questions.getText();
        i = 2;
    }

    @FXML
    private void q3Action(ActionEvent event) {
        bbnxt.setDisable(false);
        number = "3";
        qNo.setText("Q. " + number + "|");
        loadquestion();
        question = questions.getText();
        i = 3;
    }

    @FXML
    private void q4Action(ActionEvent event) {
        bbnxt.setDisable(false);
        number = "4";
        qNo.setText("Q. " + number + "|");
        loadquestion();
        question = questions.getText();
        i = 4;

    }

    @FXML
    private void q5Action(ActionEvent event) {
        bbnxt.setDisable(false);
        number = "5";
        qNo.setText("Q. " + number + "|");
        loadquestion();
        question = questions.getText();
        i = 5;
    }

    @FXML
    private void q6Action(ActionEvent event) {
        bbnxt.setDisable(false);
        number = "6";
        qNo.setText("Q. " + number + "|");
        loadquestion();
        question = questions.getText();
        i = 6;
    }

    @FXML
    private void q7Action(ActionEvent event) {
        bbnxt.setDisable(false);
        number = "7";
        qNo.setText("Q. " + number + "|");
        loadquestion();
        question = questions.getText();
        i = 7;
        q7.getStyleClass().add("button");
    }

    @FXML
    private void q8Action(ActionEvent event) {
        bbnxt.setDisable(false);
        number = "8";
        qNo.setText("Q. " + number + "|");
        loadquestion();
        question = questions.getText();
        i = 8;

    }

    @FXML
    private void q9Action(ActionEvent event) {
        bbnxt.setDisable(false);
        number = "9";
        qNo.setText("Q. " + number + "|");
        loadquestion();
        question = questions.getText();
        i = 9;

    }

    @FXML
    private void q10Action(ActionEvent event) {
        bbnxt.setDisable(false);
        number = "10";
        qNo.setText("Q. " + number + "|");
        loadquestion();
        question = questions.getText();
        i = 10;
    }

    @FXML
    private void groupAction(ActionEvent event) {
    }

    @FXML
    private void btnNext(ActionEvent event) {
        if (b1.isSelected() == false && b2.isSelected() == false && b3.isSelected() == false && b4.isSelected() == false) {
            JFXButton btn = new JFXButton("OK");
            showMaterialDialogError(rootStackPaneFW, rootAnchorPaneFW, Arrays.asList(btn), "ERROR", "Please Select an Answer");
        } else {
            question = questions.getText();
            System.out.println(question);
            ans = answer();
            if (i <= 10 && ans != null) {
                writeanswers("answer" + i + " is " + ans);
                ra = getanswerid(b1, b2, b3, b4);
                if ("1".equals(number)) {
                    loadrightanswer(q1);
                }
                if ("2".equals(number)) {
                    loadrightanswer(q2);
                }
                if ("3".equals(number)) {
                    loadrightanswer(q3);
                }
                if ("4".equals(number)) {
                    loadrightanswer(q4);
                }
                if ("5".equals(number)) {
                    loadrightanswer(q5);
                }
                if ("6".equals(number)) {
                    loadrightanswer(q6);
                }
                if ("7".equals(number)) {
                    loadrightanswer(q7);
                }
                if ("8".equals(number)) {
                    loadrightanswer(q8);
                }
                if ("9".equals(number)) {
                    loadrightanswer(q9);
                }
                if ("10".equals(number)) {
                    loadrightanswer(q10);
                }
                i++;
                number = i + "";
                 randomNum = ThreadLocalRandom.current().nextInt(1, 11 + 1);
questionnumber=String.valueOf(randomNum);
                loadquestion();
                qNo.setText("Q. " + number + "|");
                
               
//                questionnumber=generateRandom(11);
                unselect(b1, b2, b3, b4);
                if (i == 11) {
                    bbnxt.setDisable(true);
                    loadfadestage(1000, rootAnchorPaneFW, "/views/viewResult.fxml", "", "no");
                }

            }
        }
    }

    @FXML
    private void sumbitQuiz(ActionEvent event) {
        loadfadestage(1000, rootAnchorPaneFW, "/views/viewResult.fxml", "", "no");
    }

    @FXML
    private void closeapp(MouseEvent event) {
        closeStage(rootAnchorPaneFW);
    }

    @FXML
    private void reduceApp(MouseEvent event) {
        minimiseStage(event);
    }
}
