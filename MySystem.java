package com.rhino_scriptrunner;

import org.mozilla.javascript.*;
import com.rhino_scriptrunner.Counter1;

public class MySystem extends ScriptableObject{
	private static final long serialVersionUID = -43652300944918575L;

	public MySystem() { }
	
	// Method jsConstructor defines the JavaScript constructor
    public void jsConstructor() {  }
	
	public int jsFunction_getTotalCounters() {
		return Counter1.getTotalCounters();
	}
	
	public void jsFunction_print(String str) {
		java.lang.System.out.println(str);
	}
	
	@Override
	public String getClassName() {
		return "MySystem";
	}

}
