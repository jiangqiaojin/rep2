package com.turing.spring1;

public class CatTest {

	public static void main(String[] args) {
		//创建目标方对象
		CatServiceImpl target = new CatServiceImpl();
		
		//创建代理方对象
		CatServiceImplProxy cat = new CatServiceImplProxy(target);
		
		//调用代理方法
		cat.sleep();
	}

}
