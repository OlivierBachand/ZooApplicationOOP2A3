package com.example.zooapplicationoop2a3;

import java.util.ArrayList;
import java.util.List;

public class Enclosure implements EnclosureCollection {
    private List<Animal> aAnimals;
    private String aName;

    @Override
    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (Animal animal : this.aAnimals) {
            items.add(animal.aName);
        }
        return items;
    }

    @Override
    public String getName() {
        return this.aName;
    }

    public EnclosureCollection get(int pIndex) {
        return aAnimals.get(pIndex);
    }
}