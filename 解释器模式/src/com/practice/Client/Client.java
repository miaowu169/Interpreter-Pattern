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
 * �����ͻ�������
 * ���GUI�н��Ͱ�ť��ʾ�������������͵��û���������ģ�⣩
 * @param speechSound����xml�ļ��е�����
 * @param explainSound:������������Ϊ�ַ���
 */
public class Client {
	public static void main(String[] args) {
		//��������������
		JFrame jf = new JFrame("������");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("����");
		btn.setSize(100, 30);
		JTextArea jat = new JTextArea();
		jat.setSize(300, 200);
		
		String speechSound;
		//�������ļ�config.xml�ж�ȡ�û�������
		speechSound = (String) XMLUtilInter.getSpeechSound();
		
		String explainSound;
		//��������ʵ����
		Interpreter interpreter = new Interpreter();
		//��������������
		interpreter.Explain(speechSound);
		explainSound = interpreter.toSound();

		//��ť�¼���ʾ��������
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jat.setText("���ʽܣ�"+ explainSound);
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
