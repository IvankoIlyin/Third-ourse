import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Vector;

public class DeviceStAXParser {
    private static final String FILENAME = "./src/Device.xml";

    private Vector<Component> device=new Vector();



    public void parse(){
        try {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        factory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(FILENAME));
        int eventType = reader.getEventType();
            Component component=new Component(" "," "," "," "," "," "," "," "," "," ");
            while (reader.hasNext()) {
            eventType = reader.next();
            if (eventType == XMLEvent.START_ELEMENT) {
                switch (reader.getName().getLocalPart()) {
                    case "Сomponent":
                         component=new Component(" "," "," "," "," "," "," "," "," "," ");
                        String id = reader.getAttributeValue(null, "id");
                        component.setId(id);
                        break;
                    case "Name":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            component.setName(reader.getText());
                        }
                        break;

                    case "Origin":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            component.setOrigin(reader.getText());

                        }
                        break;

                    case "Price":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            component.setPrice(reader.getText());

                        }
                        break;

                    case "Peripheral":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            component.setPeripheral(reader.getText());

                        }
                        break;

                    case "EnergyConsumption":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            component.setEnergyConsumption(reader.getText());

                        }
                        break;

                    case "Cooler":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            component.setCooler(reader.getText());

                        }
                        break;

                    case "ComponentGroup":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            component.setComponentGroup(reader.getText());

                        }
                        break;

                    case "Ports":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            component.setPorts(reader.getText());

                        }
                        break;

                    case "Critical":
                        eventType = reader.next();
                        if (eventType == XMLEvent.CHARACTERS) {
                            component.setCritical(reader.getText());
                        }
                        device.addElement(component);
                        break;
                }

            }

        }
    }
        catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    void printDevicesComponents(){
        for(int i =0;i<this.device.size();i++){
            device.get(i).printComponent();
        }
    }

}
