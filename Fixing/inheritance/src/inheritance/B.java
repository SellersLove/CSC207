package inheritance;

public class B extends A {
	public int i = 100;
	public static String s = "s";
	public B(int i, String s) {
		super(i);
		this.i += 5;
		this.s = s;
		
		// TODO Auto-generated constructor stub
	}

}
