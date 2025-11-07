package com.example.zooapplicationoop2a3.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an animal enclosure within the zoo.
 * Each enclosure contains a list of animals and a name identifier.
 * Implements {@link EnclosureCollection} to support retrieval of animal data.
 *
 * <p>This class provides functionality to add, remove, and retrieve animals,
 * as well as access enclosure details such as its name and itemized list.</p>
 *
 * @author Brody
 */
public class Enclosure implements EnclosureCollection {

    /** A list that holds all animals within this enclosure. */
    private final List<Animal> aAnimals;

    /** The name of this enclosure. */
    private final String aName;

    /**
     * Constructs an enclosure with a given name.
     *
     * @param pName the name of the enclosure
     */
    public Enclosure(String pName) {
        this.aAnimals = new ArrayList<>();
        this.aName = pName;
    }

    /**
     * Retrieves a list of animals in the enclosure formatted as strings
     * with their names and ages.
     *
     * @return a list of strings describing each animal in the enclosure
     */
    @Override
    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (Animal animal : this.aAnimals) {
            items.add(animal.getName() + " (" + animal.getAge() + ")");
        }
        return items;
    }

    /**
     * Returns the name of this enclosure.
     *
     * @return the enclosure name
     */
    @Override
    public String getName() {
        return this.aName;
    }

    /**
     * Retrieves an animal from the enclosure by index.
     *
     * @param pIndex the index of the animal in the list
     * @return the {@link Animal} at the specified index
     */
    @Override
    public Animal get(int pIndex) {
        return this.aAnimals.get(pIndex);
    }

    /**
     * Adds an animal to the enclosure.
     *
     * @param pAnimal the {@link Animal} to add
     */
    public void addAnimal(Animal pAnimal) {
        this.aAnimals.add(pAnimal);
    }

    /**
     * Removes an animal from the enclosure by its index.
     *
     * @param pIndex the index of the animal to remove
     */
    public void removeAnimal(int pIndex) {
        this.aAnimals.remove(pIndex);
    }
}