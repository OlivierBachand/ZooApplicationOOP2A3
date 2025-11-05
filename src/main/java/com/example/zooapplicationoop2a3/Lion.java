package com.example.zooapplicationoop2a3;
/**
 * The {@code Lion} class represents a Lion within the Zoo Management System.
 * <p>
 * This class extends the abstract {@link Animal} class, inheriting its properties such as
 * name and age. It provides a concrete implementation that can be used to create
 * Lion instances in enclosures or zoo areas.
 * </p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>
 *     Lion Lion = new Lion("John", 5);
 *     System.out.println(cougar.getName()); // Output: John
 * </pre>
 *
 * @author Max Gosselin
 * @version 1.0
 */
public class Lion extends Animal {
    public Lion(String pName, int pAge) {
        super(pName, pAge);
    }
}
