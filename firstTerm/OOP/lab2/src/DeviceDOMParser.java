import java.util.Collection;
import java.util.Enumeration;
import java.util.Vector;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
public class DeviceDOMParser {
    private Vector<Component> device=new Vector();
    private static final String FILENAME = "./src/Device.xml";

    void parse() {
        DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
        try{
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder computer = factory.newDocumentBuilder();
            Document doc = computer.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();
            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");
            NodeList list = doc.getElementsByTagName("Сomponent");
            for(int i=0;i<list.getLength();i++){
                Node node = list.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    String id = element.getAttribute("id");
                    String name = element.getElementsByTagName("Name").item(0).getTextContent();
                    String origin = element.getElementsByTagName("Origin").item(0).getTextContent();
                    String price = element.getElementsByTagName("Price").item(0).getTextContent();
                    String peripheral = element.getElementsByTagName("Peripheral").item(0).getTextContent();
                    String energyConsumption = element.getElementsByTagName("EnergyConsumption").item(0).getTextContent();
                    String cooler = element.getElementsByTagName("Cooler").item(0).getTextContent();
                    String componentGroup = element.getElementsByTagName("ComponentGroup").item(0).getTextContent();
                    String ports = element.getElementsByTagName("Ports").item(0).getTextContent();
                    String critical = element.getElementsByTagName("Critical").item(0).getTextContent();

                    Component component = new Component(id,name,origin,price,peripheral,energyConsumption,cooler,componentGroup,ports,critical);
                    device.addElement(component);

                }
            }


        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    void printDevicesComponents(){
        for(int i =0;i<this.device.size();i++){
            device.get(i).printComponent();
        }
    }
}


