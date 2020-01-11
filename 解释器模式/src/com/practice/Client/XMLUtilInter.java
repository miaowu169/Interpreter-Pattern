package com.practice.Client;

import java.io.File;

import javax.xml.parsers.*;
import org.w3c.dom.*;


public class XMLUtilInter {
	//�÷������ڴ�XML�����ļ�����ȡ������������������һ��ʵ������
	public static String getSpeechSound() {
		try {
			//�����ĵ�����
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("src\\com\\practice\\Client\\config.xml"));
			
			//��ȡ�����������ı��ڵ�
			NodeList nl = doc.getElementsByTagName("speechSound");
			Node classNode = nl.item(0).getFirstChild();
			String sound = classNode.getNodeValue();
			
			return sound;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
