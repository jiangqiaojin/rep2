package com.turing.spring3;

public class WorkTest {

	public static void main(String[] args) {
		//创建目标方对象
		WorkServiceImpl target = new WorkServiceImpl();
		//创建代理方对象
		WorkServiceImpl proxy = (WorkServiceImpl)new ProxyFactory(target).getProxy();
		//调用代理方法
		proxy.crud();
	}

}
