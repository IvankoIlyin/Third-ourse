import java.util.Scanner;
import java.io.Console;
public class Main {
    public static void main(String[] args) {
        String parsep_type = "DOM";
        if (parsep_type == "DOM") {
                DeviceDOMParser deviceDOMParser = new DeviceDOMParser();
                deviceDOMParser.parse();
                deviceDOMParser.sortDyId();
                deviceDOMParser.printDevicesComponents();
            }
        if (parsep_type == "SAX") {
                DeviceSAXParser deviceSAXParser = new DeviceSAXParser();
                deviceSAXParser.parse();
                deviceSAXParser.sortDyId();
                deviceSAXParser.printDevicesComponents();
            }
        if (parsep_type == "StAX") {
                DeviceStAXParser deviceStAXParser = new DeviceStAXParser();
                deviceStAXParser.parse();
                deviceStAXParser.sortDyId();
                deviceStAXParser.printDevicesComponents();
            }

        }
    }
