package com.practice.node;
/*
 * ����������ս������ʽ�������������з���ֹ�����ʽ�Ĺ������ݺ���Ϊ
 * �ڱ�ʵ���У��������еķ���ֹ������Ӧ���������������֣�����ڸ�����
 * ������left��right����Node���͵Ķ���
 */
public abstract class SymbolNode implements Node {
	protected Node left;
	protected Node right;
	
	public SymbolNode(Node left,Node right) {
		this.left = left;
		this.right= right;
	}
}
