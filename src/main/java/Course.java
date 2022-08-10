import databaseRepository.SchoolRepository;

import javax.swing.*;
import java.sql.SQLException;

public class Course implements School {

    SchoolRepository schoolRepository = new SchoolRepository();

    protected int courseId;
    protected String courseName;
    protected int teacherId;
    protected String teacherName;
    protected int studentId;
    protected String studentName;

    public Course() {
    }

    @Override
    public void createUserProfile() {
        try{
            courseName = JOptionPane.showInputDialog("Enter course name: ");
            schoolRepository.createCourse(courseName);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
      }

    @Override
    public void seeUserProfile() {
        try{
            courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter course ID: "));
            schoolRepository.viewCourse(courseId);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void editUserData() {
        try{
            courseName = JOptionPane.showInputDialog("Enter new name of course: ");
            courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter course ID: "));
            schoolRepository.editCourseName(courseName, courseId);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteUserData() {
        try{
            courseId = Integer.parseInt(JOptionPane.showInputDialog("Enter course ID to delete: "));
            schoolRepository.deleteCourseProfile(courseId);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
