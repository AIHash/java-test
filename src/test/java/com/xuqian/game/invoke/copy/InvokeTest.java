package com.xuqian.game.invoke.copy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeTest {

	public void test(String[] str,Integer stri) {
		for (int j = 0; j < str.length; j++) {
			System.out.println(str[j]);
			System.out.println(stri.intValue());
		}
	}
	
	
	public static void main(String[] args) {

		try {
			InvokeTest invokeTest = new InvokeTest();
			Class c = invokeTest.getClass();
			
			Class[] cargs = new Class[2];
			String[] realArgs = {"aa","bb"};
			
			cargs[0] = realArgs.getClass();
			Integer in = new Integer(2);
			cargs[1]= in.getClass();
			//������test����������ֵΪMethod���� 
			Method m = c.getMethod("test", cargs);
			
			Object[] inArgs = new Object[2];
			
			inArgs[0] = realArgs;
			inArgs[1] = in;
			
			m.invoke(invokeTest, inArgs);

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
