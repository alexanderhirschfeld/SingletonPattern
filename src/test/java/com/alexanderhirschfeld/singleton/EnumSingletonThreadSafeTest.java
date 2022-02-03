package com.alexanderhirschfeld.singleton;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class EnumSingletonThreadSafeTest {
	
	@Test
	public void testThreadSafeSingleton() {
		List<EnumSingleton> list = new ArrayList<EnumSingleton>();
		
		Runnable run = () -> {
			EnumSingleton instance = EnumSingleton.Instance.getInstance();
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
		
		EnumSingleton instance = EnumSingleton.Instance.getInstance();
		
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
