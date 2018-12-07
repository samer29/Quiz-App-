/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


/**
 *
 * @author samer
 */
public class myConnection {
    static Connection cnx;
    static Statement st;
    static ResultSet rst;
    public static int passe = 0;
     public static Connection connecterDB() {
        try {
            //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver oki");
            //System.out.println("Driver oki");
            /*
            String url = "jdbc:mysql://sql151.main-hosting.eu.:3306/u708697835_gctes";
            String user = "u708697835_root";
            String password = "imgoingunder";*/
            String url = "jdbc:mysql://127.0.0.1:3306/quizapp";
            //String msAccDB = "gcdb.accdb";
            //String dbURL = "jdbc:ucanaccess://" + msAccDB; 
            String user = "root";
            String password = "";
            Connection cnx2=null;
            cnx2 = DriverManager.getConnection(url, user, password);
            //Connection cnx=DriverManager.getConnection(dbURL);
            System.out.println("Connexion bien établié");
            return cnx2;
        } catch (ClassNotFoundException | SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Message d'errreur");
            alert.setHeaderText(null);
            alert.setContentText("verifier que le server est lancé");
            Optional<ButtonType> showAndWait = alert.showAndWait();

            //JOptionPane.showMessageDialog(null, "VERIFIER QUE LE SERVER EST LANCE", "ERREUR", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    static public ResultSet inst(String table) {        
        try {
            if (cnx == null) {
                cnx = connecterDB();
            }
            st = cnx.createStatement();
            rst = st.executeQuery("SELECT * FROM " + table);
        } catch (SQLException ex) {

        }
        return rst;
    }
    static public ResultSet inst2(String d, String table, String clm) {
        try {
            if (cnx == null) {
                cnx = connecterDB();
            }
            st = cnx.createStatement();
            rst = st.executeQuery("SELECT * FROM  " + table + " where " + clm + " LIKE '%" + d + "%'");
        } catch (SQLException ex) {
        }
        return rst;
    }
    static public ResultSet inst3(String table, String clm, String nom) {
        try {
            if (cnx == null) {
                cnx = connecterDB();
            }
            st = cnx.createStatement();
            rst = st.executeQuery("SELECT * FROM  " + table + " where " + clm + "='" + nom + "'");
        } catch (SQLException ex) {
        }
        return rst;
    }
    static public ResultSet instload2things(String from, String close1, String nom, String close2, String passowrd) {
        try {
            if (cnx == null) {
                cnx = connecterDB();
            }
            st = cnx.createStatement();
            String myQuery = "select * from " + from + " where " + close1 + " ='" + nom + "' and " + close2 + "='" + passowrd + "'";
            rst = st.executeQuery(myQuery);
        } catch (SQLException ex) {
            Logger.getLogger(myConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rst;
    }
    
    
}
