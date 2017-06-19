package inheritance;

public class Main {
	public static void main(String []argv){
		String s = "";
		B b = new B(0,s);
		System.out.println(b.i + " " + b.s);
		s += "foo";
		A a = new B(42,s);
		System.out.println(a.i + " " + a.s );
		System.out.println(((B)a).i + " " + ((B)a).s );
		System.out.println(b.i + " " + b.s);
		System.out.println(((A)b).i + " " + ((A)b).s );
		System.out.println(b.debug().s +" "+ b.i + " " + b.s );
		System.out.println(a.debug().s + " " + a.i + " " + a.s );
	}
}
