package com.rhino_scriptrunner;

import org.mozilla.javascript.*;

public class Counter1 extends ScriptableObject {
	private static final long serialVersionUID = 6746746411262511932L;

	// The zero-argument constructor used by Rhino runtime to create instances
    public Counter1() { 
    	totalCounters++;
    }
	
    // Method jsConstructor defines the JavaScript constructor
    public void jsConstructor(int a) { count = a; }
    
    // Create a property on the javascript object with the jsGet_ prefix
    public int jsGet_count() { return count; }
    
    // Create a function on the javascript object with the jsFunction_ prefix
    public void jsFunction_increment() { count++; }
    public void jsFunction_decrement() { count--; }
    public void jsFunction_resetCount() { count = 0; }
    
    public static int getTotalCounters() {
    	return totalCounters;
    }
    
	@Override
	public String getClassName() {
		return "Counter1";
	}
	
	private static int totalCounters;
	private int count;
}
