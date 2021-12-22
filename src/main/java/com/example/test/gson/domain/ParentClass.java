package com.example.test.gson.domain;

import java.util.List;

public class ParentClass {

    private String name;
    private List<ChildClass> childs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChildClass> getChilds() {
        return childs;
    }

    public void setChilds(List<ChildClass> childs) {
        this.childs = childs;
    }
}
