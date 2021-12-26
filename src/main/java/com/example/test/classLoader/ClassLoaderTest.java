package com.example.test.classLoader;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ClassLoaderTest {

    ClassLoader loader1 = ClassLoaderTest.class.getClassLoader();
    ClassLoader loader2 = ClassLoader.getSystemClassLoader();


    @Bean
    public ClassLoaderTest test(){
        ClassLoaderTest test = new ClassLoaderTest();
        String clazz = "com.example.test.classLoader.ClassTest";

        Class targetClass1 = null;
        Class targetClass2 = null;
        try {
            targetClass1 = loader1.loadClass(clazz);
            ClassTest tmp = (ClassTest)targetClass1.newInstance();


            targetClass2 = loader2.loadClass(clazz);
            ClassTest tmp2 = (ClassTest)targetClass2.newInstance();

            System.out.println("sdf");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


        return test;
    }

    public static void main(String[] args) {

        String param = null;
        String STATIC = "TEST";

        System.out.println(STATIC.equals(param));
        System.out.println(param.equals(STATIC));


    }


//    Gson gson = new GsonBuilder().create();

//
//    @Override
//    public String convertToDatabaseColumn(AbstractCommandOption attribute) {
//        String tmp = null;
//        if (attribute != null) {
//            attribute.setClazz(attribute.getClass().getName());
//            tmp = gson.toJson(attribute);
//        }
//        return tmp;
//    }
//
//    @Override
//    public AbstractCommandOption convertToEntityAttribute(String dbData) {
//        AbstractCommandOption returnObj = null;
//        if (Strings.isNullOrEmpty(dbData)) {
//            return null;
//        }
//        JsonObject tmp = gson.fromJson(dbData, JsonObject.class);
//        String clazz = tmp.get("clazz").getAsString();
//        try {
//            Class targetClass = loader.loadClass(clazz);
//            returnObj = (AbstractCommandOption)gson.fromJson(dbData, targetClass);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return returnObj;
//    }

}
