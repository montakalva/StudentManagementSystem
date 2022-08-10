CREATE DATABASE IF NOT EXISTS StudentManagementSystem;

USE StudentManagementSystem;

CREATE TABLE IF NOT EXISTS students (
    studentId int not null auto_increment,
    studentName text not null,
    primary key (studentId)
);

CREATE TABLE IF NOT EXISTS teachers (
    teacherId int not null auto_increment,
    teacherName text not null,
    primary key (teacherId)
);

CREATE TABLE IF NOT EXISTS course (
    courseId int not null auto_increment,
    courseName text not null,
    primary key (courseId)
);

CREATE TABLE IF NOT EXISTS examResults (
    studentProfile int not null REFERENCES students(studentId),
    teacherProfile int not null REFERENCES teachers(teacherId),
    courseProfile int not null REFERENCES course(courseId),
    subjectName text not null,
    grade int not null,
    primary key (studentProfile, teacherProfile, courseProfile)
);

