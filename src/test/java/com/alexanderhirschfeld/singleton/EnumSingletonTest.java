package com.alexanderhirschfeld.singleton;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class EnumSingletonTest {

	@Test
	public void testSingleton() {
		EnumSingleton instance1 = EnumSingleton.Instance.getInstance();
		assertTrue(instance1 instanceof EnumSingleton);
		EnumSingleton instance2 = EnumSingleton.Instance.getInstance();
		assertTrue(instance2 instanceof EnumSingleton);
				
		instance1.setInfo(false);
		assertTrue(instance1.getInfo().equals(false));
		
		assertTrue(instance2.getInfo().equals(false));
	}
}
