package Gavrilov.ru;
// Импортируем необходимые пакеты
import java.util.*;

// Тестовый класс
public class Main {
    public static void main(String[] args) {
        // Создаем массив объектов класса Student
        Student[] students = {
                new Student(3, 4.0),
                new Student(1, 3.5),
                new Student(2, 3.2)
        };
        // Сортируем массив по iDNumber с использованием сортировки вставками
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;

            while (j >= 0 && students[j].compareTo(key) > 0) {
                students[j + 1] = students[j];
                j = j - 1;
            }
            students[j + 1] = key;
        }

        // Выводим отсортированный массив
        for (Student student : students) {
            System.out.println("ID Number: " + student.getIDNumber() + ", GPA: " + student.getGPA());
        }

        // Создаем список объектов класса Student
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(3, 4.0));
        studentList.add(new Student(1, 3.5));
        studentList.add(new Student(2, 3.2));

        // Сортируем список с использованием алгоритма быстрой сортировки и интерфейса Comparator
        Collections.sort(studentList, new SortingStudentsByGPA());

        // Выводим отсортированный список
        for (Student student : studentList) {
            System.out.println("ID Number: " + student.getIDNumber() + ", GPA: " + student.getGPA());
        }

        // Создаем два списка данных о студентах
        List<Student> studentList1 = new ArrayList<>();
        studentList1.add(new Student(3, 4.0));
        studentList1.add(new Student(1, 3.5));

        List<Student> studentList2 = new ArrayList<>();
        studentList2.add(new Student(2, 3.2));
        studentList2.add(new Student(4, 3.8));

        // Объединяем два списка в один отсортированный список с использованием алгоритма сортировки слиянием
        List<Student> mergedList = mergeSortedList(studentList1, studentList2);

        // Выводим отсортированный список
        for (Student student : mergedList) {
            System.out.println("ID Number: " + student.getIDNumber() + ", GPA: " + student.getGPA());
        }
    }
    // Метод для объединения двух списков данных о студентах и сортировки с использованием сортировки слиянием
    public static List<Student> mergeSortedList(List<Student> list1, List<Student> list2) {
        List<Student> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).compareTo(list2.get(j)) < 0) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }
}
// Класс для сортировки списка студентов по итоговым баллам в порядке убывания с использованием алгоритма быстрой сортировки
class SortingStudentsByGPA implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student2.getGPA(), student1.getGPA());
    }
}