/*
 * Class: CMSC 203
 * Instructor: Grigoriy Grinberg
 * Description: Data manager for Bob's Circus. Stores animals, persons, and buildings in ArrayLists (aggregation), displays them, sorts animals with selection sort, and searches animals by name.
 * Due: 11/23/2026
 * Platform/Compiler: Eclipse
 *
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any other source, and I have
 * not given my code to another student.
 *
 * Print your name here: Aser Wondemu
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Holds every animal, person, and building in the circus.
 */
public class Circus {
    private List<Animal> animals;
    private List<Person> persons;
    private List<Building> buildings;

    /**
     * Creates a circus with empty lists.
     */
    public Circus() {
        animals = new ArrayList<>();
        persons = new ArrayList<>();
        buildings = new ArrayList<>();
    }

    /**
     * Adds a building to the circus.
     *
     * @param building the building to add
     */
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    /**
     * Prints every building using its toString method.
     */
    public void displayAllBuildings() {
        if (buildings.isEmpty()) {
            System.out.println("No buildings in the circus.");
        }
        for (Building building : buildings) {
            System.out.println(building);
        }
    }

    /**
     * Adds a person to the circus.
     *
     * @param person the person to add
     */
    public void addPerson(Person person) {
        persons.add(person);
    }

    /**
     * Prints every person using its toString method.
     */
    public void displayAllPersons() {
        if (persons.isEmpty()) {
            System.out.println("No persons in the circus.");
        }
        for (Person person : persons) {
            System.out.println(person);
            System.out.println();
        }
    }

    /**
     * Adds an animal to the circus.
     *
     * @param animal the animal to add
     */
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    /**
     * Prints every animal using its toString method.
     */
    public void displayAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals in the circus.");
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    /**
     * Sorts the animals from youngest to oldest using selection sort.
     */
    public void sortAnimalsByAge() {
        for (int start = 0; start < animals.size() - 1; start++) {
            int minIndex = start;
            for (int i = start + 1; i < animals.size(); i++) {
                if (animals.get(i).getAge() < animals.get(minIndex).getAge()) {
                    minIndex = i;
                }
            }
            swap(start, minIndex);
        }
    }

    /**
     * Sorts the animals by name (A to Z, ignoring case) using selection sort.
     */
    public void sortAnimalsByName() {
        for (int start = 0; start < animals.size() - 1; start++) {
            int minIndex = start;
            for (int i = start + 1; i < animals.size(); i++) {
                if (animals.get(i).getName().compareToIgnoreCase(animals.get(minIndex).getName()) < 0) {
                    minIndex = i;
                }
            }
            swap(start, minIndex);
        }
    }

    /**
     * Searches for an animal by name (ignoring case) using sequential search,
     * and prints whether it was found.
     *
     * @param name the name to search for
     * @return the first animal with that name, or null if none is found
     */
    public Animal searchAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name.trim())) {
                System.out.println("Animal found: " + animal);
                return animal;
            }
        }
        System.out.println("Animal not found: " + name);
        return null;
    }

    /**
     * @return the list of animals
     */
    public List<Animal> getAnimals() {
        return animals;
    }

    /**
     * @return the list of persons
     */
    public List<Person> getPersons() {
        return persons;
    }

    /**
     * @return the list of buildings
     */
    public List<Building> getBuildings() {
        return buildings;
    }

    // Swaps two animals in the list (used by the selection sorts)
    private void swap(int i, int j) {
        Animal temp = animals.get(i);
        animals.set(i, animals.get(j));
        animals.set(j, temp);
    }
}
