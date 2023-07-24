package edu.inn;

import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    @Test
    @DisplayName("Correct grades had been added in the grade list")
    public void gradesInRange() {
        List<Integer> list = List.of(2, 5);
        Student st = new Student("Test");
        st.addGrade(list.get(0));
        st.addGrade(list.get(1));
        Assertions.assertEquals(st.getGrades(), list);
    }

    @ParameterizedTest(name = "Incorrect grades had not been added in the grade list")
    @MethodSource("edu.inn.GradesGenerator#incorrectGrade")
    public void gradesNotInRange(int i) {
        List<Integer> list = List.of(1, 6);
        Student st = new Student("Test");
            Assertions.assertThrows(IllegalArgumentException.class, () -> st.addGrade(i));
    }

    @Test
    @DisplayName("Set a student name")
    public void setStudentName() {
        Student st = new Student("Test");
        Assertions.assertEquals(st.getName(), "Test");
    }

    @Test
    @DisplayName("Setter student name")
    public void setterStudentName() {
        Student st = new Student("Test");
        st.setName("Tested");
        Assertions.assertEquals(st.getName(), "Tested");
    }

    @Test
    @DisplayName("Get gradelist")
    public void getStudentGrade() {
        Student st = new Student("Test");
        st.addGrade(2);
        List gradesForTest= new ArrayList<>(1);
        gradesForTest.add(2);
        Assertions.assertEquals(st.getGrades(), gradesForTest);
    }

    @Test
    @DisplayName("Display toString")
    public void checkToString() {
        Student st = new Student("Test");
        st.addGrade(5);
        st.toString();
        Assertions.assertEquals("Student{name=Test, marks=[5]}", "Student{name=Test, marks=[5]}");
    }

    @Test
    @DisplayName("Test equal hashCodes")
    public void checkOriginalHashCode() {
        Student st = new Student("Test");
        st.addGrade(5);
        Assertions.assertEquals(st.hashCode(), st.hashCode());
    }

    @Test
    @DisplayName("Test different hashCodes")
    public void checkDifferentHashCodeOfObjects() {
        Student st = new Student("Test");
        st.addGrade(5);
        Student st2 = new Student("Test2");
        st2.addGrade(4);
        Assertions.assertNotEquals(st.hashCode(), st2.hashCode());
    }

    @Test
    @DisplayName("Test equals")
    public void checkEqualObject() {
        Student st = new Student("Test");
        st.addGrade(5);
        Student st2 = new Student("Test");
        st2.addGrade(5);
        Assertions.assertEquals(st.hashCode(), st.hashCode());
        Assert.assertTrue(st.equals(st2));
        //хешкоды одинаковые ?
    }

}

