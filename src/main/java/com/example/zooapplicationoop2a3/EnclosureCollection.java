package com.example.zooapplicationoop2a3;

import java.util.List;

/**
 * Represents a component.
 * @author Olivier Bachand
 */
public interface EnclosureCollection {
    /**
     * Gets the {@code aName} of the instance
     * @return An {@link String} containing the name.
     */
    String getName();

    /**
     * Gets the items of the EnclosureCollections as strings.
     * @return a {@link List} of strings each containing a name and/or other information.
     */
    List<String> getItems();
}
