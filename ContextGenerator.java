package com.rhino_scriptrunner;

import org.mozilla.javascript.*;
import com.rhino_scriptrunner.Counter1;

public class ContextGenerator {

	// Constructor create the context
	public ContextGenerator() throws Exception {
		this.cx = Context.enter();
		this.scope = cx.initStandardObjects();
		createGlobalObjects();
		createGlobalObjectInstance();
	}
	
	// Take a java class and define a constructor
	// and prototype for it in JavaScript
	private void createGlobalObjects() throws Exception{
		try {
			ScriptableObject.defineClass(this.scope, Counter1.class);
			ScriptableObject.defineClass(this.scope, MySystem.class);
		} catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	// Create an instance of the MySystem class and assign it to
	// the top-level variable "ms".
	// This is equivalent to the following code in JavaScript
	// ms = new MySystem();
	private void createGlobalObjectInstance() {
		Scriptable ms = cx.newObject(this.scope, "MySystem");
		scope.put("ms", scope, ms);
	}
	
	// Run a script in our new context
	public Object runScript(String script) {
		return cx.evaluateString(scope, script, "<cmd>", 1, null);
	}
	
	// Exit the script execution context after the transaction has run
	public void exitContext() {
		Context.exit();
	}
	
	private Context cx;
	private Scriptable scope;
}
