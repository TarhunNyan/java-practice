package generic;

import com.sun.jdi.IntegerType;

import java.awt.*;
import java.util.List;

public class PECS <T> {
	
	private class Class1 {}
	
	private class Class2 extends Class1 {}
	
	private class Class3 extends Class2 {}
	
	private class Class4 extends Class3 {}
	
	private class Class5 extends Class4 {}
	
	public void extendsClass3(List<? extends Class3> parameter) {
		Class1 class1 = parameter.get(0);
		Class2 class2 = parameter.get(0);
		Class3 class3 = parameter.get(0);
		Class4 class4 = (Class4) parameter.get(0);
		Class5 class5 = (Class5) parameter.get(0);
		parameter.add(new Class1());
		parameter.add(new Class2());
		parameter.add(new Class3());
		parameter.add(new Class4());
		parameter.add(new Class5());
	}
	
	public T method(T a) {
		return a;
	}
	
	public static <G extends Number>String method2(G a, G b) {
		String s      = a.toString( ) + b.toString( );
		return (String) s;
	}
	
	public static <G extends Number>String method3(G a, Class<G> test) {
		return a.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(method2(2, 3) );
		
		// System.out.println(method3(100, Float.class) ); // int указать
		// нельзя, потому что вторым параметром передаем Float
		System.out.println(method3(100.0f, Float.class) );
	}
}
