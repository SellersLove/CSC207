package test;

public class Main {
	public static void throwit1(){
		throw new RuntimeException();
	}
	
	public static void throwit2() throws Exception{
		throw new Exception();
	}
	
	public static void main(String args[]) throws Exception{
		test3();
		String s  = "";
		s += "s";
		s += "s";
		System.out.println(s);
		Circle c = new ThisCircle();
		System.out.println((new ThisCircle()).radius);
	}
	
	public static void test1() throws Exception{
		try{
			System.out.println("hello");
			throwit2();
			System.out.println("Done");
		}finally{
			System.out.println("finally");
		}
	}
	
	public static void test2(){
		Integer i = new Integer(42);
		Integer j = new Integer(42);
		System.out.println((i == j) + " " + i.equals(j));
	}
	public static void test3(){
		Static sta = new Static();
		System.out.println(Static.geti());
	}
}
