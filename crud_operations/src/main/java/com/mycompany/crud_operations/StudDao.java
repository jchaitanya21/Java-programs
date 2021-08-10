
package com.mycompany.crud_operations;


import java.util.*;
import java.sql.*;

public class StudDao {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static int save(Student s) {
        int status = 0;
        try {
            Connection con = StudDao.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into student(name,grade,address) values (?,?,?)");
            ps.setString(1, s.getName());
            ps.setString(2, s.getGrade());
            ps.setString(3, s.getAddress());
           

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int update(Student s) {
        int status = 0;
        try {
            Connection con = StudDao.getConnection();
            PreparedStatement ps = con.prepareStatement("update student set name=?,grade=?,address=? where id=?");
            ps.setString(1, s.getName());
            ps.setString(2, s.getGrade());
            ps.setString(3, s.getAddress());
            
            ps.setInt(4, s.getId());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            Connection con = StudDao.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from student where id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Student getStudentById(int id) {
        Student s = new Student();

        try {
            Connection con = StudDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setGrade(rs.getString(3));
                s.setAddress(rs.getString(4));
                
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return s;
    }

    public static List<Student> getAllStudents() {
        List<Student> list;
        list = new ArrayList<Student>();

        try {
            Connection con = StudDao.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setGrade(rs.getString(3));
                s.setAddress(rs.getString(4));
                
                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
