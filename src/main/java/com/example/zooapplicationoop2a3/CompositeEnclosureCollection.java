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

    @Override
    public List<String> getItems() {
        List<String> names = new ArrayList<>();
        for (EnclosureCollection enclosureCollection : this.aEnclosureCollections) {
            if (enclosureCollection instanceof CompositeEnclosureCollection) {
                names.add(((CompositeEnclosureCollection) enclosureCollection).aName);
            }
//            else {
//                names.add(((Enclosure) enclosureCollection).aName);
//            }
        }
        return names;
    }

    @Override
    public Object get(int i) {
        return this.aEnclosureCollections.get(i);
    }
}
