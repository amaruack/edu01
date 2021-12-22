package com.example.test.gson.domain;

public class ChildClass {

    private String name;
    private String testKey;
    private ParentClass parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTestKey() {
        return testKey;
    }

    public void setTestKey(String testKey) {
        this.testKey = testKey;
    }

    public ParentClass getParent() {
        return parent;
    }

    public void setParent(ParentClass parent) {
        this.parent = parent;
    }
}
