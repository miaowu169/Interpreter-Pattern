package com.practice.Client;

import java.io.File;

import javax.xml.parsers.*;
import org.w3c.dom.*;


public class XMLUtilInter {
	//该方法用于从XML配置文件中提取具体类类名。并返回一个实例对象
	public static String getSpeechSound() {
		try {
			//创建文档对象
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("src\\com\\practice\\Client\\config.xml"));
			
			//获取包含类名的文本节点
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
