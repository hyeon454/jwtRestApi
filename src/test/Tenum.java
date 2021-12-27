package test;

public enum Tenum {
	A(1, "A");
	
	private final int key;
	private final String value;
	
	Tenum(int key, String value){
		this.key = key;
		this.value = value;
	}
	
	public int key(){
		return key;
	}
	
	public String value(){
		return value;
	}
}
