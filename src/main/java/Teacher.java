import javax.swing.*;
import java.sql.SQLException;

public class Teacher extends Course implements School {

    private int teacherId;
    private String teacherName;

    @Override
    public void createUserProfile() {
        try{
            teacherName = JOptionPane.showInputDialog("Enter teacher name: ");
            schoolRepository.createTeacher(teacherName);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void seeUserProfile() {
        try{
            teacherId = Integer.parseInt(JOptionPane.showInputDialog("Enter your teacher ID: "));
            schoolRepository.viewTeacher(teacherId);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void editUserData() {
        try{
            teacherName = JOptionPane.showInputDialog("Enter teacher name: ");
            teacherId = Integer.parseInt(JOptionPane.showInputDialog("Enter teacher ID to edit: "));
            schoolRepository.editTeacherName(teacherName, teacherId);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteUserData() {
        try{
            teacherId = Integer.parseInt(JOptionPane.showInputDialog("Enter teacher ID to delete: "));
            schoolRepository.deleteTeacherProfile(teacherId);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}