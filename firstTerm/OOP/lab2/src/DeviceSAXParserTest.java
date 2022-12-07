import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Vector;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DeviceSAXParserTest {
    DeviceSAXParser deviceSAXParser;
    Vector<Component> device;

    @BeforeAll
    void setup(){
        deviceSAXParser = new DeviceSAXParser();
        deviceSAXParser.parse();
        device = deviceSAXParser.getDevice();

    }

    @Test
    void parse1() {
        assertEquals("1",device.get(0).getId());
    }

    @Test
    void parse2() {
        assertEquals("Asus PCE-AX1800",device.get(1).getName());
    }

    @Test
    void parse3() {
        assertEquals("China",device.get(2).getOrigin());
    }

    @Test
    void parse4() {
        assertEquals("1869",device.get(3).getPrice());
    }

    @Test
    void parse5() {
        assertEquals("true",device.get(4).getPeripheral());
    }

    @Test
    void parse6() {
        assertEquals("output Headphone",device.get(5).getComponentGroup());
    }

    @Test
    void parse7() {
        assertEquals("4 pin PWM",device.get(6).getPorts());
    }

    @Test
    void sortById(){
        deviceSAXParser.sortDyId();
        device = deviceSAXParser.getDevice();
        boolean check_sorted=true;
        for(int i=0;i<device.size()-1;i++){
            if(Integer.parseInt(device.get(i).getId())>Integer.parseInt(device.get(i+1).getId())){check_sorted=false;}
        }
        assertEquals(true,check_sorted);
    }

}