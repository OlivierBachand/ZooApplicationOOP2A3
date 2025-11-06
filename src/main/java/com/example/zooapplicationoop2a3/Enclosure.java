package com.example.zooapplicationoop2a3;

import java.util.ArrayList;
import java.util.List;

public class Enclosure implements EnclosureCollection {
    private final List<Animal> aAnimals;
    private String aName;

    public Enclosure(String pName) {
        this.aAnimals = new ArrayList<>();
        this.aName = pName;
    }

    @Override
    public List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (Animal animal : this.aAnimals) {
            items.add(animal.getName());
        }
        return items;
    }

    @Override
    public String getName() {
        return this.aName;
    }

    @Override
    public Object get(int pIndex) {
        return this.aAnimals.get(pIndex);
    }

    public void addAnimal(Animal pAnimal) {
        this.aAnimals.add(pAnimal);
    }

    public void removeAnimal(int pIndex) {
        this.aAnimals.remove(pIndex);
    }
}