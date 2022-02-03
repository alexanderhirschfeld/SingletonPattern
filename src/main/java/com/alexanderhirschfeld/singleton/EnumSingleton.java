package com.alexanderhirschfeld.singleton;

public enum EnumSingleton {
	
	Instance(true);
	
	private Boolean info;
	
   private EnumSingleton(Boolean info) {
        this.info = info;
    }
 
    public EnumSingleton getInstance() {
        return Instance;
    }
    
    public void setInfo(Boolean info) {
    	this.info = info;
    }
    
    public Boolean getInfo() {
    	return this.info;
    }

}
