package inheritance;

public class A {
	public int i = 0;
	public static String s = "";
	
	public A(int i){
		System.out.println(i);
		this.i = 5;
		s = s +"x";
	}
	
	public A debug(){
		if(this instanceof B){
			System.out.println("Spam");
			s += "s";
			i = i + 1;
		}
		return this;
	}
}
