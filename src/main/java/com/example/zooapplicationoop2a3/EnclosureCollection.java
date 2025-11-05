package com.example.zooapplicationoop2a3;

import java.util.List;

/**
 * Represents a component that can be in a {@link CompositeEnclosureCollection}.
 * @author Olivier Bachand
 */
public interface EnclosureCollection {
    /**
     * Gets the {@code aName} of the instance
     * @return a {@link String} containing the name.
     */
    String getName();

    /**
     * Gets the items of the EnclosureCollections as strings.
     * @return a {@link List} of strings each containing a name and other information if necessary.
     */
    List<String> getItems();

    /**
     * Gets a EnclosureCollection from a list with the index.
     * @return an {@link EnclosureCollection}.
     */
    EnclosureCollection getEnclosureCollection(int pIndex);
}
