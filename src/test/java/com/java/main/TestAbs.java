package com.java.main;

public class TestAbs extends superTool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����������");
		
		new TestAbs().toolUse();
	}
	@Override
	void toolUse() {
		System.out.println(super.name1());
	}
	@Override
	public void InitBinder() {
		// TODO Auto-generated method stub
		
	}

}
 abstract class superTool implements newgame{
	static String Name = "oooo";
	public String name1() {
		return "����";
	}
	abstract void toolUse();
}
 interface newgame extends oldgame{
	 
 }
interface oldgame{
	public void InitBinder();
}
class agame extends superTool{

	@Override
	public void InitBinder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void toolUse() {
		// TODO Auto-generated method stub
		
	}
	
}