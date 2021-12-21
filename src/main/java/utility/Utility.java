package utility;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.net.URL;
import java.util.Properties;

public class Utility {
    public static Object fetchPropertyValue(String key) throws IOException {
        FileInputStream file = new FileInputStream("./src/main/properties/properties");
        Properties property = new Properties();
        property.load(file);
        return property.get(key);
    }
    public static Object fetchPropertyValueXML(String key) throws IOException {
        FileInputStream file = new FileInputStream("./src/main/properties/user.xml");
        Properties property = new Properties();
        property.loadFromXML(file);
        return property.get(key);
    }
    public static double XMLParser(String file) throws FileNotFoundException, XPathExpressionException {
        InputSource doc = new InputSource(new InputStreamReader(new FileInputStream(file)));
        String  xpathExpression = "//exchangerate[@buy]";
        NodeList list = (NodeList) XPathFactory.newInstance().newXPath().evaluate(xpathExpression,doc, XPathConstants.NODESET);
        return Double.parseDouble(list.item(0).getAttributes().item(1).getNodeValue());

    }
    public static void downloadUsingStream(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

}
