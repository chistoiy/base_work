package com.javaweb_02.XML_03;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsoupTest {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
//获取xml的path
        String path = JsoupTest.class.getClassLoader().getResource("com/javaweb_02/XML_03/student.xml").getPath();
        //解析xml，加载进内存
        System.out.println(path);
        Document document= (Document) Jsoup.parse(new File(path),"utf-8");

        //获取元素对象
        Elements nameElements = document.getElementsByTag("name");
        System.out.println(nameElements.size());

        Element element = nameElements.get(0);
        System.out.println(element.text());
        System.out.println(element.attr("class"));//根据属性名称获取属性值
        System.out.println(element.html());//回去标签体所有内容，包括标签
//selectoe选择器

        Elements name = nameElements.select("name");
        System.out.println(name);
        System.out.println("--------------------------");
        Elements names = document.select("[number]");//selector属性
        System.out.println(names);


        System.out.println("_________-xpath_________");
        //xpath
        JXDocument jxDocument = new JXDocument(document);
        List<JXNode> jxNodes = jxDocument.selN("//student");
        System.out.println(jxNodes);
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        System.out.println("=================namess");
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        System.out.println(jxNodes1);


    }
}
