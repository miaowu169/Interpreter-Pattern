package com.practice.node;
/*
 * �����ս�����ʽ��(�ַ�����ڵ�)
 * StringNode���ս�����ʽ�࣬��Ӧ�ս���Ĳ���
 * ʵ�����ڳ�����ʽ��������interpret()����
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
