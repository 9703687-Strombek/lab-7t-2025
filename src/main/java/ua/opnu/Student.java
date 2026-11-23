package ua.opnu;

import java.util.Arrays;

public class Student {
    private String name;
    private String lastName;
    private String group;
    private int[] marks;

    public Student(String name, String lastName, String group, int[] marks) {
        this.name = name;
        this.lastName = lastName;
        this.group = group;
        this.marks = marks;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public int[] getMarks() { return marks; }
    public void setMarks(int[] marks) { this.marks = marks; }

    @Override
    public String toString() {
        return lastName + " " + name + " (" + group + "), оцінки: " + Arrays.toString(marks);
    }
}