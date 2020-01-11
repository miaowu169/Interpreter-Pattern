package com.practice.node;
/*
 * 创建抽象非终结符类表达式，它包含了所有非终止符表达式的共有数据和行为
 * 在本实例中，由于所有的非终止符都对应左右两个操作部分，因此在该类中
 * 定义了left和right两个Node类型的对象
 */
public abstract class SymbolNode implements Node {
	protected Node left;
	protected Node right;
	
	public SymbolNode(Node left,Node right) {
		this.left = left;
		this.right= right;
	}
}
