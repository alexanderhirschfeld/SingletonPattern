package com.alexanderhirschfeld.singleton;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ClassSingletonThreadSafeTest {
	
	@Test
	public void testThreadSafeSingleton() {
		List<ClassSingleton> list = new ArrayList<ClassSingleton>();
		
		Runnable run = () -> {
			ClassSingleton instance = ClassSingleton.getInstance();
			list.add(instance);
		};
		
		new Thread(run).start();
		new Thread(run).start();
		new Thread(run).start();
		new Thread(run).start();
		new Thread(run).start();
		new Thread(run).start();
		new Thread(run).start();
		new Thread(run).start();
		new Thread(run).start();
		new Thread(run).start();
		
		
		ClassSingleton instance = ClassSingleton.getInstance();
		
		assertTrue(instance.getInfo().equals(true));
		list.forEach(singleton -> {
			assertTrue(singleton.getInfo().equals(true));
		});
		
		instance.setInfo(false);
		assertTrue(instance.getInfo().equals(false));
		list.forEach(singleton -> {
			assertTrue(singleton.getInfo().equals(false));
		});
		
	}
}
