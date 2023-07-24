package edu.inn;

public class Start {
    public static void main(String[] args) {
        Student st1 = new Student("Vasya");
        st1.addGrade(5);
        st1.getGrades().add(123);// - сломана инкапсуляция
        //st1.addGrade(133);
        st1.setName("Marks");
        System.out.println(st1.toString());
    }
}
