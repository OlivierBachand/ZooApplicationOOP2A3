package com.example.zooapplicationoop2a3.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains {@link EnclosureCollection}s in a list.
 * Can add or get {@link EnclosureCollection}
 * @author Olivier Bachand
 */
public class CompositeEnclosureCollection implements EnclosureCollection {
    /**
     * Represents a {@link List} of {@link EnclosureCollection}
     */
    private final List<EnclosureCollection> aEnclosureCollections;

    /**
     * Represents the name of the {@link CompositeEnclosureCollection}
     */
    private final String aName;

    /**
     * Initializes {@code aEnclosureCollections} and {@code aName}
     * @param pName is the name of the {@link CompositeEnclosureCollection}
     */
    public CompositeEnclosureCollection(String pName) {
        this.aEnclosureCollections = new ArrayList<>();
        this.aName = pName;
    }

    /**
     * Adds an {@link EnclosureCollection} to {@code aEnclosureCollections}
     * @param pEnclosureCollection will be added to the list.
     */
    public void addCollection(EnclosureCollection pEnclosureCollection) {
        this.aEnclosureCollections.add(pEnclosureCollection);
    }

    /**
     * Makes a {@link List} and puts all the names of the {@link EnclosureCollection} in it
     * using their getName() method.
     * @return a {@link List} of strings
     */
    @Override
    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (EnclosureCollection enclosureCollection : this.aEnclosureCollections) {
            items.add(enclosureCollection.getName());
        }
        return items;
    }

    /**
     * Gets the name of the instance.
     * @return {@code aName}
     */
    @Override
    public String getName() {
        return this.aName;
    }

    /**
     * Gets an {@link EnclosureCollection} from {@code aEnclosureCollections} from an index.
     * @param pIndex index of the List
     * @return The {@link EnclosureCollection} at the {@code pIndex}
     */
    @Override
    public EnclosureCollection get(int pIndex) {
        return this.aEnclosureCollections.get(pIndex);
    }
}
