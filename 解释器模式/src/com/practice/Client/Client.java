package com.practice.Client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.practice.interpreter.Interpreter;
/*
 * 创建客户测试类
 * 点击GUI中解释按钮显示经过解释器解释的用户的语音（模拟）
 * @param speechSound：从xml文件中的语音
 * @param explainSound:经解释器解析为字符串
 */
public class Client {
	public static void main(String[] args) {
		//创建解释器窗口
		JFrame jf = new JFrame("解释器");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("解释");
		btn.setSize(100, 30);
		JTextArea jat = new JTextArea();
		jat.setSize(300, 200);
		
		String speechSound;
		//从配置文件config.xml中读取用户的语音
		speechSound = (String) XMLUtilInter.getSpeechSound();
		
		String explainSound;
		//将解释器实例化
		Interpreter interpreter = new Interpreter();
		//解释器解释语音
		interpreter.Explain(speechSound);
		explainSound = interpreter.toSound();

		//按钮事件显示语音内容
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jat.setText("狄仁杰："+ explainSound);
			}
		});
		jf.setLayout(new BorderLayout());
		jf.setLocation(600,200);
		jf.setSize(300,300);
		jf.add(jat,BorderLayout.CENTER);
		jf.add(btn,BorderLayout.SOUTH);
		jf.setVisible(true);
	}
}
