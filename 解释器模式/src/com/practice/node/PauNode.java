package com.practice.node;
/*
 * ������ս��������������'%'.�����Ϊ""
 */
public class PauNode extends SymbolNode {
	public PauNode(Node left, Node right) {
		super(left, right);
	}

	@Override
	public String interpret() {
		return super.left.interpret() + "";
	}
}
