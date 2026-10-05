package ru.aston.homework;

import java.util.Objects;

public class Group {
    private String name;
    private int number;

    public Group(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Group(Group groupCopy) {
        this(groupCopy.name, groupCopy.number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return number == group.number && Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
