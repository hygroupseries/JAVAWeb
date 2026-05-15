package javaweb02;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

public class BookXmlDemo {
    public static void main(String[] args) throws DocumentException {

        //1.创建解析器
        SAXReader reader = new SAXReader();

        //2.读取整个xml文档
        Document doc = reader.read("web/javaweb02/book.xml");

//        System.out.println(doc);

        //3.从文档对象中获取根元素
        Element docEle = doc.getRootElement();

        //4.通过根获取到根里的所有元素
        Iterator<Element> it = docEle.elementIterator();

        //5.遍历子节点
        while(it.hasNext()){

//            System.out.println(it.next());

            //获取每次遍历到的子元素
            Element book = it.next();

            //获取 书 元素
            if("书".equals(book.getName())){
                //获取 书 元素内的所有子元素
                Iterator<Element> it2 = book.elementIterator();

                while(it2.hasNext()){
//                    System.out.println(it2.next());

                    //遍历到书的每一个子元素
                    Element b = it2.next();
                    //获取书名元素及文本内容
                    if("书名".equals(b.getName())){
                        //trim 去除空白字符
                        System.out.println("书名："+b.getText().trim());
                    }


                }

            }



        }



    }
}
