
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
    private Vector<Component> device=new Vector();
    private Component component = null;
    private StringBuilder data = null;

    boolean bName=false;
    boolean bOrigin=false;
    boolean bPrice=false;
    boolean bPeripheral=false;
    boolean bEnergyConsumption=false;
    boolean bCooler=false;
    boolean bComponentGroup=false;
    boolean bPorts=false;
    boolean bCritical=false;

    public Vector<Component> getDevice(){
        return this.device;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("Сomponent")){
            String id = attributes.getValue("id");
            component = new Component(" "," "," "," "," "," "," "," "," "," ");
            component.setId(id);
            if(device==null){
                device = new Vector<Component>();
            }
        }
        else if(qName.equalsIgnoreCase("Name")){bName=true;}
        else if(qName.equalsIgnoreCase("Origin")){bOrigin=true;}
        else if(qName.equalsIgnoreCase("Price")){bPrice=true;}
        else if(qName.equalsIgnoreCase("Peripheral")){bPeripheral=true;}
        else if(qName.equalsIgnoreCase("EnergyConsumption")){bEnergyConsumption=true;}
        else if(qName.equalsIgnoreCase("Cooler")){bCooler=true;}
        else if(qName.equalsIgnoreCase("ComponentGroup")){bComponentGroup=true;}
        else if(qName.equalsIgnoreCase("Ports")){bPorts=true;}
        else if(qName.equalsIgnoreCase("Critical")){bCritical=true;}
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(bName){component.setName(data.toString()); bName=false;}
        else if(bOrigin){component.setOrigin(data.toString()); bOrigin=false;}
        else if(bPrice){component.setPrice(data.toString()); bPrice=false;}
        else if(bPeripheral){component.setPeripheral(data.toString()); bPeripheral=false;}
        else if(bEnergyConsumption){component.setEnergyConsumption(data.toString()); bEnergyConsumption=false;}
        else if(bCooler){component.setCooler(data.toString()); bCooler=false;}
        else if(bComponentGroup){component.setComponentGroup(data.toString()); bComponentGroup=false;}
        else if(bPorts){component.setPorts(data.toString()); bPorts=false;}
        else if(bCritical){component.setCritical(data.toString()); bCritical=false;}

        if(qName.equalsIgnoreCase("Сomponent")){device.addElement(component);}
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    }
