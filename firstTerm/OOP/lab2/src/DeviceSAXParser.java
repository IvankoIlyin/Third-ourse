import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import java.util.Vector;
public class DeviceSAXParser {
    private static final String FILENAME = "./src/Device.xml";
    private Vector<Component> device=new Vector();

    public void parse(){
    SAXParserFactory factory = SAXParserFactory.newInstance();
    try {
        SAXParser saxParser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        saxParser.parse(new File(FILENAME), handler);
        device = handler.getDevice();
    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
    }
}

    void printDevicesComponents(){
        for(int i =0;i<this.device.size();i++){
            device.get(i).printComponent();
        }
    }

    Vector<Component> getDevice(){
        return this.device;
    }

    public void sortDyId(){
        this.device.sort((a,b)->a.getId().compareTo(b.getId()));
    }
}


