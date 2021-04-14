/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;

/**
 *
 * @author Ammar Ft
 */
public class Quizz {

    ResultSet rs = null;

    private Connection connect() throws SQLException {

        Connection con = null;
        String url = "jdbc:sqlite:D:/Ammarft/Database/DBProjct/project.db";
        con = DriverManager.getConnection(url);
        System.out.println("Connection Established....");
        return con;

    }

    public void add(String ResulatTest1) throws SQLException {
        //  User u = new User();
        int user_id = User.userId;
        System.out.println(user_id);
        String sql = "INSERT INTO L1quizz  (ResulatTest1, user_id) VALUES('" + ResulatTest1 + "', '" + user_id + "')";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("The Resulat Added...");

    }

    public boolean chick() throws SQLException {

        boolean x = false;
        String sql = "SELECT * FROM L1quizz";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String p = rs.getString("ResulatTest1");
            int i = Integer.parseInt(p);

            if (i >= 8) {

                x = true;
                break;
            }

        }
        st.close();
        con.close();
        return x;
    }

    public void add2(String ResulatTest2) throws SQLException {
        //  User u = new User();
        int user_id = User.userId;
        System.out.println(user_id);
        String sql = "INSERT INTO L2quizz  (ResulatTest2, user_id) VALUES('" + ResulatTest2 + "', '" + user_id + "')";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("The Resulat Added...");

    }

    public boolean chick2() throws SQLException {

        boolean x = false;
        String sql = "SELECT * FROM L2quizz";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String p = rs.getString("ResulatTest2");
            int i = Integer.parseInt(p);

            if (i >= 8) {

                x = true;
                break;
            }

        }
        st.close();
        con.close();
        return x;
    }

    public void add3(String ResulatTest3) throws SQLException {
        //  User u = new User();
        int user_id = User.userId;
        System.out.println(user_id);
        String sql = "INSERT INTO L3quizz  (ResulatTest3, user_id) VALUES('" + ResulatTest3 + "', '" + user_id + "')";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("The Resulat Added...");

    }

    public boolean chick3() throws SQLException {

        boolean x = false;
        String sql = "SELECT * FROM L3quizz";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String p = rs.getString("testResult3");
            int i = Integer.parseInt(p);

            if (i >= 8) {

                x = true;
                break;
            }

        }
        st.close();
        con.close();
        return x;
    }

    public void UsersData(ObservableList oblist) throws SQLException {

        int user_id = User.userId;
        System.out.println(user_id);

        String sql = "SELECT * FROM L1quizz";
        Connection con = this.connect();
        Statement st = con.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) //            {
        {
            int n = rs.getInt("user_id");

            if (user_id == n) {

                oblist.add(new ResulatTest1(rs.getString("ResulatTest1")));

            }
        }
//            }
        st.close();
        con.close();
        //return rs;

    }
//    
     public void UsersData2(ObservableList oblist) throws SQLException {

        int user_id = User.userId;
        System.out.println(user_id);

        String sql = "SELECT * FROM L2quizz";
        Connection con = this.connect();
        Statement st = con.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) //            {
        {
            int n = rs.getInt("user_id");

            if (user_id == n) {

                oblist.add(new ResulatTest2(rs.getString("ResulatTest2")));

            }
        }
//            }
        st.close();
        con.close();
        //return rs;

    }
//     
      public void UsersData3(ObservableList oblist) throws SQLException {

        int user_id = User.userId;
        System.out.println(user_id);

        String sql = "SELECT * FROM L3quizz";
        Connection con = this.connect();
        Statement st = con.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) //            {
        {
            int n = rs.getInt("user_id");

            if (user_id == n) {

                oblist.add(new ResulatTest3(rs.getString("ResulatTest3")));

            }
        }
//            }
        st.close();
        con.close();
        //return rs;

    }

}
