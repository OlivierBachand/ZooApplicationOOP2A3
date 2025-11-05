package com.example.zooapplicationoop2a3;

/**
 * The {@code Animal} class represents an abstract base model for all animals in the Zoo Management System.
 * <p>
 * Each animal has a name and an age, and subclasses can extend this class to represent specific animal types
 * such as lions, tigers, or cougars. This class provides basic getter and setter methods for
 * accessing and modifying an animal's attributes.
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>
 *     public class Lion extends Animal {
 *         public Lion(String name, int age) {
 *             super(name, age);
 *         }
 *     }
 * </pre>
 *
 * @author Max Gosselin
 * @version 1.0
 */
public abstract class Animal {

    /** The name of the animal. */
    private String aName;

    /** The age of the animal. */
    private int aAge;

    /**
     * Constructs a new {@code Animal} with the specified name and age.
     *
     * @param pName the name of the animal
     * @param pAge  the age of the animal
     */
    public Animal(String pName, int pAge) {
        this.aName = pName;
        this.aAge = pAge;
    }

    /**
     * Returns the name of the animal.
     *
     * @return the animal's name
     */
    public String getName() {
        return aName;
    }

    /**
     * Returns the age of the animal.
     *
     * @return the animal's age
     */
    public int getAge() {
        return aAge;
    }

    /**
     * Sets the name of the animal.
     *
     * @param pName the new name for the animal
     */
    public void setName(String pName) {
        this.aName = pName;
    }

    /**
     * Sets the age of the animal.
     *
     * @param pAge the new age for the animal
     */
    public void setAge(int pAge) {
        this.aAge = pAge;
    }
}
