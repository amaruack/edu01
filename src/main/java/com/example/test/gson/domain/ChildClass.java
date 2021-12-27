package com.example.test.gson.domain;

import com.google.gson.annotations.SerializedName;

public class ChildClass {

    @SerializedName(value = "name", alternate = {"NAME", "name", "dfsdf"})
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
