package ru.aston.homework;

import java.util.Objects;

public final class Student {
    private final String name;
    private final int age;
    private final Group group;

    public Student(String name, int age, Group group) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Age must be between 0 and 100");
        }
        if (Objects.isNull(group)) {
            throw new IllegalArgumentException("Group cannot be null");
        }
        this.name = name.trim();
        this.age = age;
        this.group = new Group(group);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Group getGroup() {
        return new Group(group);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", group=" + group +
                '}';
    }
}
