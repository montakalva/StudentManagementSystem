import javax.swing.*;
import java.sql.SQLException;

public class Student extends Course implements School {

    public Student() {
    }

    @Override
    public void createUserProfile() {
        try{
            studentName = JOptionPane.showInputDialog("Enter student name surname: ");
            schoolRepository.createStudent(studentName);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void seeUserProfile() {
        try{
            studentId = Integer.parseInt(JOptionPane.showInputDialog("Enter your student ID: "));
            schoolRepository.viewStudent(studentId);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void editUserData() {
        try{
            studentName = JOptionPane.showInputDialog("Enter new name of student: ");
            studentId = Integer.parseInt(JOptionPane.showInputDialog("Enter student ID: "));
            schoolRepository.editStudentName(studentName, studentId);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteUserData() {
        try{
            studentId = Integer.parseInt(JOptionPane.showInputDialog("Enter student ID: "));
            schoolRepository.deleteStudentProfile(studentId);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}