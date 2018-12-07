/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.events.JFXDialogEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author samer
 */
public class myfunctions {

    public static final String ICON_IMAGE_LOC = "/icons/logo.png";
    public static AnchorPane pane;

    public static void setStageIcon(Stage stage) {
        stage.getIcons().add(new javafx.scene.image.Image(ICON_IMAGE_LOC));
        //import javafx.scene.image.Image;
    }

    public static void unselect(JFXRadioButton r1, JFXRadioButton r2, JFXRadioButton r3, JFXRadioButton r4) {
        if (r1.isSelected()) {
            r1.setSelected(false);
        } else if (r2.isSelected()) {
            r2.setSelected(false);
        } else if (r3.isSelected()) {
            r3.setSelected(false);
        } else if (r4.isSelected()) {
            r4.setSelected(false);
        }
    }

    public static String getanswerid(JFXRadioButton r1, JFXRadioButton r2, JFXRadioButton r3, JFXRadioButton r4) {
        String idanswer = null;
        if (r1.isSelected()) {
            idanswer = "a";
        } else if (r2.isSelected()) {
            idanswer = "b";
        } else if (r3.isSelected()) {
            idanswer = "c";
        } else if (r4.isSelected()) {
            idanswer = "d";
        }
        return idanswer;
    }
    

    public static Object loadWindow(URL loc, String title, Stage parentStage, String test) {
        Object controller = null;

        try {
            FXMLLoader loader = new FXMLLoader(loc);
            Parent parent = loader.load();
            controller = loader.getController();
            Stage stage = null;
            if (parentStage != null) {
                stage = parentStage;
            } else {
                stage = new Stage(StageStyle.UNDECORATED);
            }
            stage.setTitle(title);
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
            setStageIcon(stage);
            if ("yes".equals(test)) {
                stage.setMaximized(true);
            } else {
                stage.setMaximized(false);
            }

        } catch (IOException ex) {
            Logger.getLogger(myfunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return controller;
    }

    @FXML
    public static void closeStage(AnchorPane ap) { //dispose when you login 
        ((Stage) ap.getScene().getWindow()).close();
    }

    public static void loadinto(String loc, StackPane spc) {
        try {
            pane = FXMLLoader.load(myfunctions.class.getResource(loc));
            spc.getChildren().clear();
            spc.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(myfunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void writeanswers(String answer) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("answers.txt", true)));
            out.println(answer);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(myfunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void loadfadestage(int time,AnchorPane ap,String URI,String title,String test){
        FadeTransition ft=new FadeTransition();
        ft.setDuration(Duration.millis(time));
        ft.setNode(ap);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadWindow(getClass().getResource(URI), title, null, test);
                closeStage(ap);
            }
        });
        ft.play();
    }
    
    public static void setimageIV(String url,ImageView iv){
        File file = new File(url);
        Image image = new Image(file.toURI().toString());      
        iv.setImage(image);
    }
    
    public static void minimiseStage(MouseEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
    
    public static void showMaterialDialogError(StackPane root, Node nodeToBeBlurred, List<JFXButton> controls, String header, String body) {
        BoxBlur blur = new BoxBlur(3, 3, 3);
        if (controls.isEmpty()) {
            controls.add(new JFXButton("Okay"));
        }
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        JFXDialog dialog = new JFXDialog(root, dialogLayout, JFXDialog.DialogTransition.LEFT);

        controls.forEach(controlButton -> {
            controlButton.getStyleClass().add("dialog-button-error");
            controlButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                dialog.close();
            });
        });
        dialogLayout.setHeading(new Label(header));
        dialogLayout.setBody(new Label(body));
        dialogLayout.setActions(controls);
        dialog.show();
        dialog.setOnDialogClosed((JFXDialogEvent event1) -> {
            nodeToBeBlurred.setEffect(null);
        });
        nodeToBeBlurred.setEffect(blur);
    }
}
