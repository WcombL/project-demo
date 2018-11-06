package com.lei.base.jvm;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.Proxy;

/**
 * -Xmx10m -XX:MaxPermSize=5m -XX:MaxDirectMemorySize=5m -XX:+PrintGCDetails
 * 
 * @author zrkj
 *
 */
public class BlowUpJVM {
	
	public static void main(String[] args) {
//		testStackOverFlow();
		
//		testPergemOutOfMemory1();
//		testPergemOutOfMemory2();
//		testPergemOutOfMemory3();
		
//		testNativeMethodOutOfMemory();
		
		testStackOutOfMemory();
	}

	/**
	 * 栈深度溢出
	 */
	public static void testStackOverFlow() {
		BlowUpJVM.testStackOverFlow();
	}

	/**
	 * 永久代内存溢出 - 失败
	 * 
	 * JDK1.7后常量池放到了堆里，也能进行垃圾回收了
	 */
	public static void testPergemOutOfMemory1() {
		// 方法一失败
		List<String> list = new ArrayList<String>();

		while (true) {
			list.add(UUID.randomUUID().toString().intern());
		}
	}

	// Class把老年代取堆满 - 并没有GG
	public static void testPergemOutOfMemory2() {
		try {
			while (true) {
				Enhancer enhancer = new Enhancer();
				enhancer.setSuperclass(OOM.class);
				enhancer.setUseCache(false);
				enhancer.setCallback(new MethodInterceptor() {
					@Override
					public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
						return proxy.invokeSuper(obj, args);
					}
				});
				enhancer.create();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// JDK动态代理产生的类能不能撑爆
	// 答案是不行！会进行回收。JDK动态代理产生的类信息，不会放到永久代中，而是放在堆中
	public static void testPergemOutOfMemory3() {
		while (true) {
			final OOM oom = new OOM();
			Proxy.newProxyInstance(oom.getClass().getClassLoader(), oom.getClass().getInterfaces(), new InvocationHandler() {
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					Object result = method.invoke(oom, args);
					return result;
				}
			});
		}
	}

	// 本地方法栈溢出
	public static void testNativeMethodOutOfMemory() {
		int j = 0;
		while (true) {
			//System.out.println(j++);
			ExecutorService executors = Executors.newFixedThreadPool(50);
			int i = 0;
			while (i++ < 10) {
				executors.submit(new Runnable() {
					public void run() {
					}
				});
			}
		}
	}

	// JVM栈内存溢出
	public static void testStackOutOfMemory() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					while (true) {
					}
				}
			});
			thread.start();
		}
	}

	// 堆溢出
	public static void testOutOfHeapMemory() {
		List<StringBuffer> list = new ArrayList<StringBuffer>();
		while (true) {
			StringBuffer B = new StringBuffer();
			for (int i = 0; i < 10000; i++) {
				B.append(i);
			}
			list.add(B);
		}
	}

}

class OOM {

}
