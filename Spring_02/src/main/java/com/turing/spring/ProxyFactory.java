package com.turing.spring;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * 代理工厂
 * @author 14997
 *
 */
public class ProxyFactory implements MethodInterceptor{
	private Object target;
	
	

	public ProxyFactory(Object target) {
		super();
		this.target = target;
	}




	//代理方法
	public Object getProxy() {
		//创建一个增强器
		Enhancer en = new Enhancer();
		
		//设置类加载器
		en.setClassLoader(target.getClass().getClassLoader());
		//设置代理方的父类
		en.setSuperclass(target.getClass());
		//设置拦截方法
		en.setCallback(this);
		//创建代理方
		return en.create();
	}
	
	
	
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		//判断
		if (method.getName().equals("")) {
			obj = method.invoke(target, args);
		}else {
			System.out.println("开启事务");
			obj = method.invoke(target, args);
			System.out.println("结束事务");
		}
		return obj;
	}
	
	
}
