import javax.swing.*;
import java.sql.SQLException;

public class ExamResults extends Course{

    protected String subject;
    protected int grade;
    protected int studentProfile;
    protected int teacherProfile;
    protected int courseProfile;

    public ExamResults(){
    }

    public void putExamResult() {
        try {
            subject = JOptionPane.showInputDialog("Enter subject name: ");
            grade = Integer.parseInt(JOptionPane.showInputDialog("Enter exam result: "));
            courseProfile = Integer.parseInt(JOptionPane.showInputDialog("Enter course ID: "));
            teacherProfile = Integer.parseInt(JOptionPane.showInputDialog("Enter your teacher ID: "));
            studentProfile = Integer.parseInt(JOptionPane.showInputDialog("Enter your student ID: "));
            schoolRepository.putExamResults(subject, grade, courseProfile, teacherProfile, studentProfile);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public void editExamResults() {
        try{
            subject = JOptionPane.showInputDialog("Enter subject name: ");
            grade = Integer.parseInt(JOptionPane.showInputDialog("Enter exam result: "));
            courseProfile = Integer.parseInt(JOptionPane.showInputDialog("Enter course ID: "));
            teacherProfile = Integer.parseInt(JOptionPane.showInputDialog("Enter your teacher ID: "));
            studentProfile = Integer.parseInt(JOptionPane.showInputDialog("Enter your student ID: "));
            schoolRepository.editExamResults(grade, subject, teacherProfile, courseProfile, studentProfile);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public void viewExamResults() {
        try{
            courseProfile = Integer.parseInt(JOptionPane.showInputDialog("Enter course ID: "));
            schoolRepository.viewExamResults(courseProfile);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}