package com.practice.node;
/*
 * ������ս��������������'@'.�����Ϊ"��"
 */
public class StopNode extends SymbolNode {
	public StopNode(Node left, Node right) {
		super(left, right);
	}

	@Override
	public String interpret() {
		return "��" + super.left.interpret();
	}
}
