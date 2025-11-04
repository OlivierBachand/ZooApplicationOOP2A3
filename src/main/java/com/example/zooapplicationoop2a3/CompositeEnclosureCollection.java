package com.example.zooapplicationoop2a3;

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

    public void add(EnclosureCollection pEnclosureCollection) {
        this.aEnclosureCollections.add(pEnclosureCollection);
    }

    public void remove(int pIndex) {
        this.aEnclosureCollections.remove(pIndex);
    }

    @Override
    public List<String> getNames() {
        List<String> items = new ArrayList<>();
        for (EnclosureCollection enclosureCollection : this.aEnclosureCollections) {
            if (enclosureCollection instanceof CompositeEnclosureCollection) {
                items.add(((CompositeEnclosureCollection) enclosureCollection).aName);
            }
//            else {
//                items.add(((Enclosure) enclosureCollection).aName);
//            }
        }
        return items;
    }

    @Override
    public Object get(int i) {
        return this.aEnclosureCollections.get(i);
    }
}
