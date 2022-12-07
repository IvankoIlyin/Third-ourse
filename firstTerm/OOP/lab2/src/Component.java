
public class Component {
    public  String id;
    private  String name;
    private  String origin;
    private  String price;
    private  String peripheral;
    private  String energyConsumption;
    private  String cooler;
    private  String componentGroup;
    private  String ports;
    private  String critical;
    public Component(String id, String name, String origin, String price, String peripheral, String energyConsumption, String cooler, String componentGroup, String ports, String critical) {
        this.id =id;
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.peripheral = peripheral;
        this.energyConsumption = energyConsumption;
        this.cooler = cooler;
        this.componentGroup = componentGroup;
        this.ports = ports;
        this.critical = critical;

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPeripheral(String peripheral) {
        this.peripheral = peripheral;
    }

    public void setEnergyConsumption(String energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public void setCooler(String cooler) {
        this.cooler = cooler;
    }

    public void setComponentGroup(String componentGroup) {
        this.componentGroup = componentGroup;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public void printComponent() {
        System.out.println("Component №" + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Origin: " + this.origin);
        System.out.println("Price: " + this.price + "UAH");
        System.out.println("Is peripheral: " + this.peripheral);
        System.out.println("Energy consumption: " + this.energyConsumption + "W");
        System.out.println("Presence of a cooler: " + this.cooler);
        System.out.println("Group component: "+this.componentGroup);
        System.out.println("Ports: " + this.ports);
        System.out.println("Is critical: " + this.critical);
        System.out.println("--------------------------------------");
    }

    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getOrigin(){
        return this.origin;
    }
    public String getPrice(){
        return this.price;
    }
    public String getPeripheral(){
        return this.peripheral;
    }
    public String getCooler(){
        return this.cooler;
    }
    public String getComponentGroup(){
        return this.componentGroup;
    }
    public String getPorts(){
        return this.ports;
    }
    public String getCritical(){
        return this.critical;
    }


}
