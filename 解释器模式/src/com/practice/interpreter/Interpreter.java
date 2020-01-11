package com.practice.interpreter;

import java.util.Stack;

import com.practice.node.CommaNode;
import com.practice.node.Node;
import com.practice.node.PauNode;
import com.practice.node.StopNode;
import com.practice.node.StringNode;
/*
 * 解释器封装类Interpreter(核心类)
 */
public class Interpreter {
	@SuppressWarnings("unused")
	//需要解释的字符串
	private String speechSound;
	@SuppressWarnings("unused")
	private Node node;
	private String sound="";
    
      //将字符串按照特定文法解释，定义了一个抽象树的结构，left保存终结符，right嵌套保存非终结符
	public void Explain(String speechSound) {
		Node left = null, right = null;
		//使用栈结构存取数据
		Stack<Object> stack = new Stack<Object>();

		char[] speechArray = speechSound.toCharArray();
		//System.out.println(speechArray[0]);
		for (int i = 0; i < speechArray.length; i++) {	
			//需要解释的字符串中有'%'解释为""
			if (speechArray[i] == '%') {
				left = (Node) stack.pop();
				String val = String.valueOf(speechArray[i]);
				right = new StringNode(val);
				stack.push(new PauNode(left, right));
			} 
			//需要解释的字符串中有'#'解释为","
			else if (speechArray[i] == '#') {
				left = (Node) stack.pop();
				//System.out.println("left:"+left.interpret());
				String val = String.valueOf(speechArray[i]);
				right = new StringNode(val);
				stack.push(new CommaNode(left, right));
			} 
			//需要解释的字符串中有'@'解释为"。"
			else if (speechArray[i] == '@') {
				left = (Node) stack.pop();
				String val = String.valueOf(speechArray[i]);
				right = new StringNode(val);
				stack.push(new StopNode(left, right));
			} else {
				if (left != null && right != null) {
					left = (Node) stack.pop();
					//System.out.println("left:"+left.interpret());
					sound = left.interpret();
				}
				stack.push(new StringNode(String.valueOf(speechArray[i]+sound)));
			}
		}
		this.node = (Node) stack.pop();
	}
	//逆转解析过的字符串（栈结构先入后出）
	 public static String reverse(String s) {
		  int length = s.length();
		  String reverse = "";
		  for (int i = 0; i < length; i++)
		   reverse = s.charAt(i) + reverse;
		  return reverse;
	 }
	 
	 public String toSound() {
		 //调用node.interpret会递归调用内部多个对象的interpret方法
		 return reverse(node.interpret());
	}
}
