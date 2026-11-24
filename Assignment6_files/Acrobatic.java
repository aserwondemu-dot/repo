/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: An employee of the circus who works as a performer. Extends Person and adds a job title.
 * Due: 11/23/2026
 * Platform/Compiler: Eclipse
 *
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any other source, and I have
 * not given my code to another student.
 *
 * Print your name here: Aser Wondemu
 */

/**
 * A Acrobatic is a Person with a job title.
 */
public class Acrobatic extends Person {
    private String job;

    /**
     * Creates a Acrobatic.
     *
     * @param name the person's name
     * @param age the person's age
     * @param yearsWorked how many years the person has worked at the circus
     * @param job the job title
     */
    public Acrobatic(String name, int age, int yearsWorked, String job) {
        super(name, age, yearsWorked);
        this.job = job;
    }

    /**
     * @return the job title
     */
    public String getJob() {
        return job;
    }

    /**
     * @return the person's name, age, years worked, and job, one per line
     */
    @Override
    public String toString() {
        return String.format("Name: %s\nAge: %d\nYears Worked: %d\nJob: %s",
                getName(), getAge(), getYearsWorked(), job);
    }
}
