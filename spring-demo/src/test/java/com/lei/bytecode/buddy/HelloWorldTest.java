package com.lei.bytecode.buddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	private void test() {
		Class<?> dynamicType = new ByteBuddy().subclass(Object.class)
				.method(ElementMatchers.named("toString"))
				.intercept(FixedValue.value("Hello World!")).make()
				.load(getClass().getClassLoader()).getLoaded();

		//assertThat(dynamicType.newInstance().toString(), is("Hello World!"));
	}
}
