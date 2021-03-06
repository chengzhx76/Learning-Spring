package com.github.chengzhx76.ioc.beans.xml;

import com.github.chengzhx76.ioc.BeanReference;
import com.github.chengzhx76.ioc.beans.AbstractBeanDefinitionReader;
import com.github.chengzhx76.ioc.beans.BeanDefinition;
import com.github.chengzhx76.ioc.beans.PropertyValue;
import com.github.chengzhx76.ioc.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @desc:
 * @author: hp
 * @date: 2018/3/30
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinition(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinition(inputStream);
    }

    protected void doLoadBeanDefinition(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);

        // 解析bean
        registerBeanDefinition(doc);
        inputStream.close();
    }

    public void registerBeanDefinition(Document doc) {
        Element root = doc.getDocumentElement();
        parseBeanDefinition(root);
    }

    protected void parseBeanDefinition(Element root) {
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }

    protected void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("name");
        String className = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName(className);
        processProperty(ele, beanDefinition);
        getRegistry().put(name, beanDefinition);
    }


    private void processProperty(Element ele, BeanDefinition beanDefinition) {
        NodeList propertyNode = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                // 值引用
                if (value != null && !"".equals(value)) {
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
                }
                // 对象引用
                else {
                    String ref = propertyEle.getAttribute("ref");
                    if (ref == null || "".equals(ref)) {
                        throw new IllegalArgumentException("Configuration problem : <property> '" +
                                name + "'must specify a value or ref");
                    }
                    BeanReference beanReference = new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, beanReference));
                }
            }
        }
    }


}
