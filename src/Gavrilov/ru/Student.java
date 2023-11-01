package Gavrilov.ru;

// Создаем класс Student
class Student implements Comparable<Student> {
    // Поля класса
    private int iDNumber;
    private double gpa;

    // Конструктор класса
    public Student(int iDNumber, double gpa) {
        this.iDNumber = iDNumber;
        this.gpa = gpa;
    }

    // Метод для сортировки по iDNumber
    @Override
    public int compareTo(Student student) {
        return Integer.compare(this.iDNumber, student.iDNumber);
    }

    // Геттеры и сеттеры для полей класса
    public int getIDNumber() {
        return iDNumber;
    }

    public double getGPA() {
        return gpa;
    }

    public void setIDNumber(int iDNumber) {
        this.iDNumber = iDNumber;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }
}
