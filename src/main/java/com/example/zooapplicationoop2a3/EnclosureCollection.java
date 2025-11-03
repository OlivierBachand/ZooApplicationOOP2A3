package com.example.zooapplicationoop2a3;

import java.util.List;

/**
 * Represents a component
 * @author Olivier Bachand
 */
public interface EnclosureCollection {
    /**
     * Gets an {@link Object} from a list at a certain index.
     * @param i index
     * @return An {@link Object} from a list,
     */
    Object get(int i);

    /**
     * Gets the names of the EnclosureCollections
     * @return a {@link List} of names
     */
    List<String> getItems();
}
