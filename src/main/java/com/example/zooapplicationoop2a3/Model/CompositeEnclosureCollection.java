package com.example.zooapplicationoop2a3.Model;

import java.util.ArrayList;
import java.util.List;

public class CompositeEnclosureCollection implements EnclosureCollection {
    private final List<EnclosureCollection> aEnclosureCollections;
    private String aName;

    public CompositeEnclosureCollection(String pName) {
        this.aEnclosureCollections = new ArrayList<>();
        this.aName = pName;
    }

    public void addCollection(EnclosureCollection pEnclosureCollection) {
        this.aEnclosureCollections.add(pEnclosureCollection);
    }

    @Override
    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (EnclosureCollection enclosureCollection : this.aEnclosureCollections) {
            items.add(enclosureCollection.getName());
        }
        return items;
    }

    @Override
    public String getName() {
        return this.aName;
    }

    @Override
    public EnclosureCollection get(int pIndex) {
        return this.aEnclosureCollections.get(pIndex);
    }
}
