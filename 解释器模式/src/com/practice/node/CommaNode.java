package com.practice.node;
/*
 * ������ս��������������'#'.�����Ϊ","
 */
public class CommaNode extends SymbolNode {
	public CommaNode(Node left, Node right) {
		super(left, right);
	}

	@Override
	public String interpret() {
		return  "," + super.left.interpret();
	}
}
