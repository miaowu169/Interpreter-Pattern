package com.practice.interpreter;

import java.util.Stack;

import com.practice.node.CommaNode;
import com.practice.node.Node;
import com.practice.node.PauNode;
import com.practice.node.StopNode;
import com.practice.node.StringNode;
/*
 * ��������װ��Interpreter(������)
 */
public class Interpreter {
	@SuppressWarnings("unused")
	//��Ҫ���͵��ַ���
	private String speechSound;
	@SuppressWarnings("unused")
	private Node node;
	private String sound="";
    
      //���ַ��������ض��ķ����ͣ�������һ���������Ľṹ��left�����ս����rightǶ�ױ�����ս��
	public void Explain(String speechSound) {
		Node left = null, right = null;
		//ʹ��ջ�ṹ��ȡ����
		Stack<Object> stack = new Stack<Object>();

		char[] speechArray = speechSound.toCharArray();
		//System.out.println(speechArray[0]);
		for (int i = 0; i < speechArray.length; i++) {	
			//��Ҫ���͵��ַ�������'%'����Ϊ""
			if (speechArray[i] == '%') {
				left = (Node) stack.pop();
				String val = String.valueOf(speechArray[i]);
				right = new StringNode(val);
				stack.push(new PauNode(left, right));
			} 
			//��Ҫ���͵��ַ�������'#'����Ϊ","
			else if (speechArray[i] == '#') {
				left = (Node) stack.pop();
				//System.out.println("left:"+left.interpret());
				String val = String.valueOf(speechArray[i]);
				right = new StringNode(val);
				stack.push(new CommaNode(left, right));
			} 
			//��Ҫ���͵��ַ�������'@'����Ϊ"��"
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
	//��ת���������ַ�����ջ�ṹ��������
	 public static String reverse(String s) {
		  int length = s.length();
		  String reverse = "";
		  for (int i = 0; i < length; i++)
		   reverse = s.charAt(i) + reverse;
		  return reverse;
	 }
	 
	 public String toSound() {
		 //����node.interpret��ݹ�����ڲ���������interpret����
		 return reverse(node.interpret());
	}
}
