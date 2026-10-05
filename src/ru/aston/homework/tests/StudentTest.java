package ru.aston.homework.tests;

import ru.aston.homework.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {


    @Test
    @DisplayName("Изменение внешней Group не влияет на Student")
    void externalGroupChange_doesNotAffectStudent() {
        Group external = new Group("A", 1);
        Student s = new Student("Max", 22, external);

        external.setName("Test");
        external.setNumber(999);

        assertEquals("A", s.getGroup().getName());
        assertEquals(1, s.getGroup().getNumber());
    }

    @Test
    @DisplayName("Изменение Group из геттера не влияет на Student")
    void groupFromGetter_isCopy() {
        Student s = new Student("Max", 22, new Group("A", 1));

        Group leaked = s.getGroup();
        leaked.setName("Test");
        leaked.setNumber(999);

        assertEquals("A", s.getGroup().getName());
        assertEquals(1, s.getGroup().getNumber());
    }

    @Test
    @DisplayName("Каждый вызов getGroup возвращает новую копию")
    void getGroup_returnsFreshCopy() {
        Student s = new Student("Max", 22, new Group("A", 1));
        assertNotSame(s.getGroup(), s.getGroup());
        assertEquals(s.getGroup(), s.getGroup());
    }

    @Test
    @DisplayName("Конструктор делает копию входной Group")
    void constructor_copiesIncomingGroup() {
        Group external = new Group("A", 1);
        Student s = new Student("Max", 22, external);
        assertNotSame(external, s.getGroup());
    }

    @Test
    @DisplayName("Возраст меньше 0 — исключение")
    void constructor_negativeAge_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("Max", -1, new Group("A", 1)));
    }

    @Test
    @DisplayName("Возраст больше 100 — исключение")
    void constructor_ageOver100_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("Max", 101, new Group("A", 1)));
    }

    @Test
    @DisplayName("Граничные значения 0 и 100 допустимы")
    void constructor_boundaryAges_allowed() {
        assertDoesNotThrow(() -> new Student("Max", 0, new Group("A", 1)));
        assertDoesNotThrow(() -> new Student("Max", 100, new Group("A", 1)));
    }

    @Test
    @DisplayName("null-имя — исключение")
    void constructor_nullName_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student(null, 22, new Group("A", 1)));
    }

    @Test
    @DisplayName("Пустое имя — исключение")
    void constructor_blankName_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("   ", 22, new Group("A", 1)));
    }


    @Test
    void constructor_storesValues() {
        Student s = new Student("Max", 22, new Group("A", 1));
        assertEquals("Max", s.getName());
        assertEquals(22, s.getAge());
        assertEquals(new Group("A", 1), s.getGroup());
    }


    @Test
    void equalsAndHashCode() {
        Student a = new Student("Max", 22, new Group("A", 1));
        Student b = new Student("Max", 22, new Group("A", 1));
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a, new Student("Alex", 22, new Group("A", 1)));
    }
}