package com.example.zooapplicationoop2a3;

public abstract class Animal {
    private String aName;
    private int aAge;

    public Animal(String pName, int pAge)
    {
        this.aName = pName;
        this.aAge = pAge;

    }
    // getters and setters

    public String getName() {
        return aName;
    }

    public int getAge() {
        return aAge;
    }

    public void setName(String pName) {
        this.aName = pName;
    }

    public void setAge(int pAge) {

        this.aAge = pAge;
    }


}
