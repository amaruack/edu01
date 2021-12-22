package com.example.test.gson.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FieldExclusionStrategy implements ExclusionStrategy {

	Map<Class, String[]> excludes = new HashMap<>();
	public FieldExclusionStrategy(){}

	public FieldExclusionStrategy appendExclude(Class cla, String[] fields){
		excludes.put(cla, fields);
		return this;
	}
	
	/**
	 * target 의 upper class 조회 함수
	 *
	 * @name : getUpperClass
	 * @author : pc
	 * @since : 2021-02-04 오전 9:09
	 * @param f -
	 * @return : java.lang.Class
	 * @throws
	 */
	public Class getUpperClass(FieldAttributes f){
		
		// 상위 클래스 정보 가저오기
		Class upperClass = null;
		try {
			Class cls = Class.forName(FieldAttributes.class.getName());
			Field field = cls.getDeclaredField("field");
			field.setAccessible(true);
			Field targetField = (Field)field.get(f);
			
			Class fieldClass = Class.forName(Field.class.getName());
			Field clazz = fieldClass.getDeclaredField("clazz");
			clazz.setAccessible(true);
			
			upperClass =  (Class)clazz.get(targetField);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return upperClass;
	}
	
	public boolean shouldSkipField(FieldAttributes f) {
		
		if (excludes != null) {
			
			Class upperClass = getUpperClass(f);
			
			Iterator<Class> it =  excludes.keySet().iterator();
			while (it.hasNext()) {
				Class exCla = it.next();
				if (exCla.isAssignableFrom(upperClass)) {
					
					String[] fields = excludes.get(exCla);
					if (fields != null && fields.length > 0) {
						for(String field : fields) {
							if (field.equals(f.getName())){
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}
	
}