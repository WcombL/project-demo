package com.lei.bytecode.buddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class CreateClass {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		DynamicType.Unloaded<?> dynamicType = new ByteBuddy().with(new NamingStrategy.AbstractBase() {
			@Override
			protected String name(TypeDescription superClass) {
				return "i.love.ByteBuddy." + superClass.getSimpleName();
			}
		}).subclass(Object.class).name("example.Type").make();

		System.out.println(dynamicType.toString());

		Class<?> dynamicType1 = new ByteBuddy().with(new NamingStrategy.AbstractBase() {
			@Override
			protected String name(TypeDescription superClass) {
				return "i.love.ByteBuddy." + superClass.getSimpleName();
			}
		}).subclass(Object.class).method(ElementMatchers.named("toString")).intercept(FixedValue.value("Hello World!")).make()
				.load(CreateClass.class.getClassLoader()).getLoaded();
		System.out.println(dynamicType1.newInstance().toString());
		System.out.println(dynamicType1.newInstance().getClass().getName());
	}

}
