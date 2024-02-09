package com.company;

import javax.swing.text.html.CSS;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        // создаём хранилище
        Cash cash = new Cash();

        // закидываем туда студента
        cash.setStudent(new Student());

        // вытаскиваем студента (но уже ввиде клона)
        Student student = cash.getStudent();
    }
}

// Паттерн прототип, он позволяет не доставать объект, а клонировать его в новый
// очень полезен при работе с бд
class Student implements Cloneable{
    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}

class Cash{
    private Student student;

    public Student getStudent() throws CloneNotSupportedException{
        return student.clone(); // достанет его клон
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
