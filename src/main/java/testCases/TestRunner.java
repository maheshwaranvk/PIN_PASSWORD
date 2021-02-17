package testCases;

import org.testng.TestNG;

public class TestRunner {
	static TestNG testNg;
	public static void main(String[] args) {
	 testNg = new TestNG();
	 
	 testNg.setTestClasses(new Class[] {NewUser.class,VCCLinks.class});
	 testNg.run();
	}

}
