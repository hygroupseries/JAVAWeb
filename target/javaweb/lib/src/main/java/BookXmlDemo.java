import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;

/**
 * @Author: Kee
 * @Description:
 * @Date Created in  2026-03-09 09:38
 * @Modified By:
 */


public class BookXmlDemo {
    public static void main(String[] args) throws DocumentException {
        //1.创建解析器
        SAXReader reader =new SAXReader();
        //2.读取整个xml文档
        Document doc=reader.read("src/main/java/book.xml");

//        System.out.println(doc);
        //3.从文档对象中获取根元素
        Element docEle = doc.getRootElement();
        docEle.elementIterator();
        //4.通过根获取到根里的所有元素
        Iterator<Element> it = docEle.elementIterator();
        while(it.hasNext()){
//            System.out.println(it.next());
            //获取书元素
            Element book = it.next();
            if("书".equals(book.getName())){
                //获取书元素内的所有子元素
                Iterator<Element> it2=book.elementIterator();
                while (it2.hasNext()){
                    //获取到书的每一个子元素
                    Element b= it2.next();
                    //找到书名元素和文本内容
                    if ("书名".equals(b.getName())){
                        System.out.println("书名:"+b.getText().trim());
                    }

                }
            }
        }
    }
}
