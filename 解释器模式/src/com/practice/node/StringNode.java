package com.practice.node;
/*
 * 创建终结符表达式类(字符串类节点)
 * StringNode是终结符表达式类，对应终结符的操作
 * 实现了在抽象表达式中声明的interpret()方法
 */
public class StringNode implements Node {
	private String sound;
	
	public StringNode(String sound) {
		this.sound = sound;
	}
	
	@Override
	public String interpret() {
		return this.sound;
	}
}
