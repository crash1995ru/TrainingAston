package group114.moduleOne;

import java.util.Objects;

public final class Student {
    private String name;
    private final int age;
    private final Group group;

    public Student(String name, int age, Group group) {
        this.name = name;
        this.age = age;
        this.group = new Group(group.getName(), group.getNumber());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Group getGroup() {
        return new Group(group.getName(), group.getNumber());
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
