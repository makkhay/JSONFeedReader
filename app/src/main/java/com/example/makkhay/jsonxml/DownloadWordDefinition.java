//package com.example.makkhay.jsonxml;
//
//
//import android.os.Build;
//import android.support.annotation.RequiresApi;
//import android.util.Log;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//import java.io.IOException;
//import java.io.InputStream;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//
//public class DownloadWordDefinition extends MakeHttpUrlConnection
//{
//
//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    public String getWordDefinition(final String word)
//    {
//        String strDef = "";
//        try (InputStream is = openHttpConnection("http://services.aonaware.com/DictService/DictService.asmx/Define?word=" + word ) ) {
//
//            Document doc = null;
//
//            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//            DocumentBuilder db;
//            db = dbf.newDocumentBuilder();
//            doc = db.parse(is);
//            is.close();
//
//            NodeList nl = doc.getElementsByTagName("Definition");
//            for (int i=0; i < nl.getLength(); ++i)
//            {
//                Node n = nl.item(i);
//                if ( n.getNodeType() == Node.ELEMENT_NODE )
//                {
//                    Element de = (Element)n;
//                    NodeList wdes = de.getElementsByTagName("WordDefinition");
//                    for ( int j=0; j < wdes.getLength(); ++j )
//                    {
//                        Element wde = (Element)wdes.item(j);
//                        NodeList textNodes = (NodeList)wde.getChildNodes();
//                        strDef += ((Node)textNodes.item(0)).getNodeValue() + ".\n";
//                    }
//                }
//            }
//        } catch (ParserConfigurationException | SAXException | IOException ex)
//        {
//            Log.d("Networking", ex.getLocalizedMessage());
//            return strDef;
//        }
//        return strDef;
//    }
//}
//
