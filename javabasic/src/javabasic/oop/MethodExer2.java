package javabasic.oop;

public class MethodExer2 {

	public static void main(String[] args) {

//		System.out.println(MethodExer2.calc(10, 20, "+"));
//		System.out.println(MethodExer2.calc(10, 20, "-"));
//		System.out.println(MethodExer2.calc(10, 20, "*"));
//		System.out.println(MethodExer2.calc(10, 20, "/"));
		
		System.out.println(MethodExer2.add(10, 20));
		System.out.println(MethodExer2.sub(10, 20));
		System.out.println(MethodExer2.mul(10, 20));
		System.out.println(MethodExer2.div(10, 20));
		
	} // main
	
	static int add(int x, int y) {
		return x + y;
	}
	static int sub(int x, int y) {
		return x - y;
	}
	static int mul(int x, int y) {
		return x * y;
	}
	static int div(int x, int y) {
		return y == 0 ? 0 : x / y;
	}
	
//	static int calc(int x, int y, String oper) {
//		if (oper.equals("+")) {
//			return x + y;
//		} else if (oper.equals("-")) {
//			return x - y;
//		} else if (oper.equals("*")) {
//			return x * y;
//		} else {
//			return y == 0 ? 0 : x / y;
//		}
//	}

} // class