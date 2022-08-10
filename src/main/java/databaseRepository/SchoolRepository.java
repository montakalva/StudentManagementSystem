package databaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SchoolRepository {

    Connection connection = new DatabaseManager().getConnection();

    public void createCourse(String courseName) throws SQLException {

        String query = "INSERT INTO course (courseName) VALUES (?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, courseName);

        preparedStatement.execute();
    }

    public void viewCourse(int courseId) throws SQLException {

        String query = "SELECT * FROM course WHERE courseId = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery(query);

        while (resultSet.next()) {
            String courseName = resultSet.getString("courseName");

            String output = "Course: \t ID | %d \t Name | %s";
            System.out.println(String.format(output, courseId, courseName));
        }
    }

    public void editCourseName(String courseName, int courseId) throws SQLException {

        String query = "UPDATE course SET courseName = ? WHERE courseId = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, courseName);
        preparedStatement.setInt(2, courseId);

        preparedStatement.execute();
    }

    public void deleteCourseProfile(int courseId) throws SQLException {
        String query = "DELETE FROM course WHERE courseId = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, courseId);

        if (preparedStatement.executeUpdate() == 0) {
            throw new SQLException("Could not delete item with ID " + courseId + " item not found");
        }
    }

    public void createStudent(String studentName) throws SQLException {
        String query = "INSERT INTO students (studentName) VALUES (?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, studentName);

        preparedStatement.execute();
    }

    public void viewStudent(int studentId) throws SQLException {
        String query = "SELECT * FROM students WHERE studentId = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery(query);

        while (resultSet.next()) {
            String studentName = resultSet.getString("studentName");

            String output = "Student: \t ID | %d \t Name | %s";
            System.out.println(String.format(output, studentId, studentName));
        }
    }

    public void editStudentName(String studentName, int studentId) throws SQLException {

        String query = "UPDATE students SET studentName = ? WHERE studentId = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, studentName);
        preparedStatement.setInt(2, studentId);

        preparedStatement.execute();
    }

    public void deleteStudentProfile(int studentId) throws SQLException {
        String query = "DELETE FROM students WHERE studentId = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, studentId);

        if (preparedStatement.executeUpdate() == 0){
            throw new SQLException("Could not delete item with ID " + studentId + " item not found");
        }
    }

    public void createTeacher(String teacherName) throws SQLException {
        String query = "INSERT INTO teachers (teacherName) VALUES (?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, teacherName);
        preparedStatement.execute();
    }

    public void viewTeacher(int teacherId) throws SQLException {
        String query = "SELECT * FROM teachers WHERE teacherId = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery(query);

        while (resultSet.next()) {
            String teacherName = resultSet.getString("teacherName");

            String output = "Teacher: \t ID | %d \t Name | %s";
            System.out.println(String.format(output, teacherId, teacherName));
        }
    }

    public void editTeacherName(String teacherName, int teacherId) throws SQLException {

        String query = "UPDATE teachers SET teacherName = ? WHERE teacherId = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, teacherName);
        preparedStatement.setInt(2, teacherId);

        preparedStatement.execute();
    }

    public void deleteTeacherProfile(int teacherId) throws SQLException {
        String query = "DELETE FROM teachers WHERE teacherId = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, teacherId);

        if (preparedStatement.executeUpdate() == 0){
            throw new SQLException("Could not delete item with ID " + teacherId + " item not found");
        }
    }

    public void putExamResults(String subjectName, int grade, int courseProfile, int teacherProfile, int studentProfile) throws SQLException {

     String query = " INSERT INTO examResults (subjectName, grade,  courseProfile, teacherProfile, studentProfile) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,subjectName);
        preparedStatement.setInt(2,grade);
        preparedStatement.setInt(3,courseProfile);
        preparedStatement.setInt(4,teacherProfile);
        preparedStatement.setInt(5,studentProfile);

        preparedStatement.execute();
    }

    public void editExamResults(int grade, String subjectName,  int teacherProfile, int courseProfile, int studentProfile) throws SQLException {

        String query = "UPDATE examResults SET grade = ? WHERE subjectName = ? AND teacherProfile = ? AND courseProfile = ? AND studentProfile = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, grade);
        preparedStatement.setString(2, subjectName);
        preparedStatement.setInt(3, teacherProfile);
        preparedStatement.setInt(4, courseProfile);
        preparedStatement.setInt(5, studentProfile);

        preparedStatement.execute();
    }

    public void viewExamResults(int courseProfile) throws SQLException {

        String query = "SELECT * FROM examResults WHERE courseProfile = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
       ResultSet resultSet = preparedStatement.executeQuery(query);

       while ((resultSet.next())){
           int studentProfile = resultSet.getInt("studentProfile");
           int teacherProfile = resultSet.getInt("teacherProfile");
           String subjectName = resultSet.getString("subjectName");
           int grade = resultSet.getInt("grade");

           String output = "Student: \t ID | %d \t Teacher ID | %d \t Course ID | %d \t Subject | %s \t Grade | %d";
           System.out.println(String.format(output, studentProfile, teacherProfile, courseProfile, subjectName, grade));
       }
    }
}