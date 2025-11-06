package com.example.zooapplicationoop2a3.Model;

/**
 * The {@code Cougar} class represents a cougar within the Zoo Management System.
 * <p>
 * This class extends the abstract {@link Animal} class, inheriting its properties such as
 * name and age. It provides a concrete implementation that can be used to create
 * cougar instances in enclosures or zoo areas.
 * </p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>
 *     Cougar cougar = new Cougar("Luna", 5);
 *     System.out.println(cougar.getName()); // Output: Luna
 * </pre>
 *
 * @author Max Gosselin
 * @version 1.0
 */
public  class Cougar extends Animal {

    public Cougar(String pName, int pAge) {
        super(pName, pAge);
    }

}
