package inheritance2;

public class Main {
	
	public static void main(String[] args ){
		A a = new C();
		String c  = a.value;
		a.printValueA();
		System.out.println(c);
		C nc = new C();
		System.out.println(nc.i);
	}
}
