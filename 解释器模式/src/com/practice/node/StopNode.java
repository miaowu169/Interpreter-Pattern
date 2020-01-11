package com.practice.node;
/*
 * 定义非终结符，当语音中有'@'.会解析为"。"
 */
public class StopNode extends SymbolNode {
	public StopNode(Node left, Node right) {
		super(left, right);
	}

	@Override
	public String interpret() {
		return "。" + super.left.interpret();
	}
}
