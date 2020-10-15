package com.turing.spring1;
/**
 * 代理方
 * @author 14997
 *
 */
public class CatServiceImplProxy implements CatService{
	//创建目标方
	private CatService target;

	public CatServiceImplProxy(CatService target) {
		super();
		this.target = target;
	}

	@Override
	public void eat() {
		target.eat();
	}

	@Override
	public void sleep() {
		System.out.println("睡前故事。。。");
		target.sleep();
		System.out.println("猫在休息。。。");
		
	}
	
	
}
