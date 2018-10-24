package com.lei.base.jvm;

import java.util.List;

import com.google.common.collect.Lists;


/**
 *
 *
 * @author wujunbo
 * @date 2018年10月23日 下午6:58:28
 */
public class JVMHeap {

	public static void main(String[] args) throws Exception {
		Thread.sleep(10000);
		new Thread(new MyThread0(), "thread-0").start();
		new Thread(new MyThread1(), "thread-1").start();
	}

	static class MyThread0 implements Runnable {
		@Override
		public void run() {
			List<byte[]> bytesList = Lists.newArrayList();
			while (true) {
				bytesList.add(new byte[1024]);
			}
		}
	}

	static class MyThread1 implements Runnable {
		@Override
		public void run() {
			List<byte[]> bytesList = Lists.newArrayList();
			while (true) {
				try {
					bytesList.add(new byte[1024]);
					Thread.sleep(1000);
					System.out.println("================");
				} catch (Exception e) {
				}
			}
		}
	}

}
