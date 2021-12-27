package com.example.test.gson;

import com.example.test.gson.domain.ChildClass;
import com.example.test.gson.domain.ParentClass;
import com.example.test.gson.util.FieldExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GsonTest {

    private static Gson excludGson = new GsonBuilder()
        .setExclusionStrategies(
            new FieldExclusionStrategy().appendExclude(ParentClass.class, new String[]{
                "childs"
            }))
        .create();

    private static Gson excludChildGson = new GsonBuilder()
        .setExclusionStrategies(
            new FieldExclusionStrategy().appendExclude(ChildClass.class, new String[]{
                "parent"
            }))
        .setPrettyPrinting()
        .create();

    private static Gson gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();

    public static void main(String[] args) {

        ParentClass parnet = new ParentClass();
        parnet.setName("parnet");

        ChildClass child = new ChildClass();
        child.setName("child1");
        child.setParent(parnet);
        List<ChildClass> childs = new ArrayList<>();
        childs.add(child);

        ChildClass child2 = new ChildClass();
        child2.setName("child2");
        child2.setParent(parnet);
        childs.add(child2);

        parnet.setChilds(childs);

//        System.out.println(gson.toJson(parnet));
//        System.out.println(excludGson.toJson(parnet));
        System.out.println(excludChildGson.toJson(parnet));

        String jsonstr = excludChildGson.toJson(childs);


        List<ChildClass> deList2 = gson.fromJson(jsonstr, List.class); // LinkedTreeMapp 으로 변환


        TypeToken listType =  new TypeToken<List<ChildClass>>(){};
        List<ChildClass> deList = gson.fromJson(jsonstr, listType.getType());
        System.out.println("sdf");

    }

}
