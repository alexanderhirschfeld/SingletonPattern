package com.alexanderhirschfeld.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;


public class ReflectionTest {
	private ReflectionTest() {}
	
	public static <T> T reflectTo(final Object source, Class<T> type) {
		T result = null;
		try {
			for (Constructor<?> constructor : type.getDeclaredConstructors()) {
				constructor.setAccessible(true);
				try {
					result = (T)constructor.newInstance();
					break;
				} catch(Exception e) {}
			}
			// TODO
			for (Field field : source.getClass().getDeclaredFields()) {
				Field rField = result.getClass().getDeclaredField(field.getName());
				rField.setAccessible(true);
				field.setAccessible(true);
				try {
					rField.set(result, field.get(source));
				} catch(Exception e) {
					rField.set(result, reflectTo(field.get(source), rField.getType()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}