package test;

import java.util.function.Function;

public class Generic {

	public static void main(String[] args) {
		Box<Integer> box1 = Util.boxing(100);
	    int intValue = box1.get();
	 
	    Box<String> box2 = Util.boxing("ABC");
	    String strValue = box2.get();
	    
	    System.out.println(intValue);
	    System.out.println(strValue);
	    
	}
}
