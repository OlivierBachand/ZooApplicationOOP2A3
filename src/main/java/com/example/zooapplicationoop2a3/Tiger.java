package com.example.zooapplicationoop2a3;
/**
 * The {@code Tiger} class represents a Tiger within the Zoo Management System.
 * <p>
 * This class extends the abstract {@link Animal} class, inheriting its properties such as
 * name and age. It provides a concrete implementation that can be used to create
 * Tiger instances in enclosures or zoo areas.
 * </p>
 *
 * <p><strong>Example Usage:</strong></p>
 * <pre>
 *     Tiger Tiger = new Tiger("Derek", 5);
 *     System.out.println(Tiger.getName()); // Output: Derek
 * </pre>
 *
 * @author Max Gosselin
 * @version 1.0
 */
public class Tiger extends Animal {
public Tiger(String pName, int pAge)
{
super(pName, pAge);}
}
