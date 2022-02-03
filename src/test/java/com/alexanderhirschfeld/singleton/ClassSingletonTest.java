package com.alexanderhirschfeld.singleton;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ClassSingletonTest {
	
	@Test
	public void testSingleton() {
		ClassSingleton instance1 = ClassSingleton.getInstance();
		assertTrue(instance1 instanceof ClassSingleton);
		ClassSingleton instance2 = ClassSingleton.getInstance();
		assertTrue(instance2 instanceof ClassSingleton);
		
		assertTrue(instance1.getInfo().equals(instance2.getInfo()));
				
		instance1.setInfo(false);
		assertTrue(instance1.getInfo().equals(false));	
		assertTrue(instance2.getInfo().equals(false));
	}

}
