package test;

public class Static {
	public static int i = 0;
	
	public Static(){
		i = i+1;
	}
	public static int geti(){
		return i;
	}
}
