package com.turing.spring1;
/**
 * 目标方
 * @author 14997
 *
 */
public class CatServiceImpl implements CatService{
	@Override
   public void eat(){
	System.out.println("猫在吃鱼");
   }
	
   @Override
   public void sleep(){
	System.out.println("猫在睡觉");
   }
}
