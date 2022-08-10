import javax.swing.*;

public class MenuController {

    Course course = new Course();
    Student student = new Student();
    Teacher teacher = new Teacher();
    ExamResults examResults = new ExamResults();
    int userChoice;
    String userType;
    boolean quite = false;

    public void programStart() {
        setUserType();
        printOptions(userType);
        handleUserChoice();
        printOptions(userType);
    }

    public void handleUserChoice() {

        while(!quite) {
            userChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter chosen option: "));

            switch (userChoice) {
                case 1:
                    teacher.createUserProfile();
                    break;
                case 2:
                    teacher.seeUserProfile();
                    break;
                case 3:
                    teacher.editUserData();
                    break;
                case 4:
                    teacher.deleteUserData();
                    break;
                case 5:
                    course.createUserProfile();
                    break;
                case 6:
                    course.seeUserProfile();
                    break;
                case 7:
                    course.editUserData();
                    break;
                case 8:
                    course.deleteUserData();
                    break;
                case 9:
                    examResults.putExamResult();
                    break;
                case 10:
                    examResults.editExamResults();
                    break;
                case 11:
                    examResults.viewExamResults();
                    break;
                case 20:
                    student.createUserProfile();
                    break;
                case 21:
                    student.seeUserProfile();
                    break;
                case 22:
                    student.editUserData();
                    break;
                case 23:
                    student.deleteUserData();
                    break;
                case 0:
                    quite = true;
                default:
                    System.out.println("Please enter on of the options: ");

                    printOptions(userType);
            }
        }
    }

    public String setUserType() {
        String userTypeOption[] = {"Student", "Teacher"};

        String uerType = (String) JOptionPane.showInputDialog(
                null,
                "Choose user type: ",
                "User Type",
                JOptionPane.QUESTION_MESSAGE,
                null,
                userTypeOption,
                userTypeOption[0]
        );

        if (uerType.equals("Student")) {
            return userType = "Student";
        } else {
            return userType = "Teacher";
        }
    }

    public void printOptions(String userType) {

        switch(userType) {
            case "Student":
                System.out.println("" +
                        "20. Create Student Profile\n" +
                        "21. View Student profile\n" +
                        "22. Edit Student Profile\n" +
                        "23. Delete Student Profile\n" +
                        "0. Quite");
                break;
            case "Teacher":
                System.out.println("" +
                        "1. Create Teacher Profile\n" +
                        "2. View Teacher profile\n" +
                        "3. Edit Teacher Profile\n" +
                        "4. Delete Teacher Profile\n" +
                        "5. Create course\n" +
                        "6. View Course\n" +
                        "7. Edit Course\n" +
                        "8. Delete Course\n" +
                        "9. Put Exam Results\n" +
                        "10. Edit Exam Results\n" +
                        "11. View Exam Results\n" +
                        "0. Quite"
                );
                break;
            default:
                System.out.println("Something went wrong, try again");
        }
    }
}

