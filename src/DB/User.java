/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author Ammar Ft
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.ObservableList;

/**
 *
 * @author K.S.M
 */
public class User {

    public static int userId;
    ResultSet rs = null;

    private Connection connect() throws SQLException {

        Connection con = null;
        String url = "jdbc:sqlite:D:/Ammarft/Database/DBProjct/project.db";
        con = DriverManager.getConnection(url);
        System.out.println("Connection Established....");
        return con;

    }

    public void add(String user, String email, String password, String Level) throws SQLException {

        String sql = "INSERT INTO User (UserName,Email,Password, Level) VALUES('" + user + "','" + email + "','" + password + "', '" + Level + "')";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
        System.out.println("The User Added...");

    }

    public int login(String UserName, String Password) throws SQLException {

        int x = 0;
        String sql = "SELECT * FROM User";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String u = rs.getString("UserName");
            String p = rs.getString("Password");
            if (UserName.equals(u) && Password.equals(p)) {

                x = rs.getInt("id");
                break;
            }

        }
        st.close();
        con.close();
        userId = x;
        return x;
    }

    public void StudentInfo(ObservableList oblist) throws SQLException {

        String sql = "SELECT * FROM User";
        Connection con = this.connect();
        Statement st = con.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) //            {
        {
            oblist.add(new infoStudent(rs.getString("id"), rs.getString("UserName"), rs.getString("Email"), rs.getString("Password")));

        }
//            }
        st.close();
        con.close();
        //return rs;

    }

    public void SearchUser(ObservableList oblist, String UserName) throws SQLException {
//             String sql = "SELECT * FROM Users WHERE name LIKE '"+name+"%'";
        String sql = "SELECT * FROM User WHERE UserName='" + UserName + "'";
        Connection con = this.connect();
        Statement st = con.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) //            {
        {
            oblist.add(new infoStudent(rs.getString("id"), rs.getString("UserName"), rs.getString("Email"), rs.getString("Password")));
        }
//            }
        st.close();
        con.close();
    }

}


