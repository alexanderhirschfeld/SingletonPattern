package com.alexanderhirschfeld.singleton;

public class ClassSingleton {
	
	private static ClassSingleton Instance = new ClassSingleton();

    private Boolean info = true;

    private ClassSingleton() {}

    public static ClassSingleton getInstance() {
        return Instance;
    }
    
    public void setInfo(Boolean info) {
    	this.info = info;
    }
    
    public Boolean getInfo() {
    	return this.info;
    }
}
