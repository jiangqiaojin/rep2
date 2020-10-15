package com.turing.spring3;

import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Calendar;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyFactory implements MethodInterceptor{
	//创建目标方
	private Object target;
	
	
	public ProxyFactory(Object target) {
		super();
		this.target = target;
	}
	
	//创建代理对象
	public Object getProxy() {
		//创建一个增强器
		Enhancer en = new Enhancer();
		//设置类加载器
		en.setClassLoader(target.getClass().getClassLoader());		
		//设置代理方的父类
		en.setSuperclass(target.getClass());
		//设置拦截方法
		en.setCallback(this);
		//创建代理对象
		return en.create();
	}
	
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		Object o = null;
		if (method.getName().equals("")) {
			o = method.invoke(target, args);
		}else {
			System.out.println("开启事务。。。");
			o = method.invoke(target, args);
			System.out.println("关闭事务。。。");
		}
		return o;
	}

}
