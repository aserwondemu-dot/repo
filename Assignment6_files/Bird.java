/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: A bird in the circus. Implements Animal.
 * Due: 11/23/2026
 * Platform/Compiler: Eclipse
 *
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any other source, and I have
 * not given my code to another student.
 *
 * Print your name here: Aser Wondemu
 */

import java.util.Objects;

/**
 * A Bird that performs in the circus.
 */
public class Bird implements Animal {
    private String name;
    private int age;
    private String species;
    private String color;

    /**
     * Creates a Bird.
     *
     * @param name the animal's name
     * @param age the animal's age in years
     * @param species the species or breed
     * @param color the animal's color
     */
    public Bird(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }

    /**
     * Prints how this animal moves.
     */
    @Override
    public void move() {
        System.out.println(name + " flies through the tent.");
    }

    /**
     * Prints the sound this animal makes.
     */
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet!");
    }

    /**
     * @return the animal's name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return the animal's age
     */
    @Override
    public int getAge() {
        return age;
    }

    /**
     * @return the species or breed
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @return the animal's color
     */
    public String getColor() {
        return color;
    }

    /**
     * Two Birds are equal if their name, age, species, and color all match.
     *
     * @param obj the object to compare to
     * @return true if the objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        // Check for reference equality
        if (this == obj) {
            return true;
        }
        // Check for null or different class
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // Compare fields for logical equality
        Bird other = (Bird) obj;
        return age == other.age
                && Objects.equals(name, other.name)
                && Objects.equals(species, other.species)
                && Objects.equals(color, other.color);
    }

    /**
     * @return a hash code that matches equals
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age, species, color);
    }

    /**
     * @return the animal's type, name, age, species, and color
     */
    @Override
    public String toString() {
        return "Bird [Name: " + name + ", Age: " + age + ", Species: " + species
                + ", Color: " + color + "]";
    }
}
