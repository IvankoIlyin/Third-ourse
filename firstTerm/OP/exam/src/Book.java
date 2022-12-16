public class Book {

    private int id;
    private String name;
    private String author;
    private String publish_house;
    private int publish_year;
    private int pages;
    private int price;
    private String binding_type;

    public Book(int id,String name,String author,String publish_house,int publish_year,int pages,int price,String binding_type){
        this.id=id;
        this.name =name;
        this.author=author;
        this.publish_house=publish_house;
        this.publish_year=publish_year;
        this.pages=pages;
        this.price=price;
        this.binding_type=binding_type;
    }

    public void set_id(int id){this.id=id;}
    public void set_name(String name){this.name=name;}
    public void set_author(String author){this.author=author;}
    public void set_publish_house(String publish_house){this.publish_house=publish_house;}
    public void set_publish_year(int publish_year){this.publish_year=publish_year;}
    public void set_pages(int pages){this.pages=pages;}
    public void set_price(int price){this.price=price;}
    public void set_binding_type(String binding_type){this.binding_type=binding_type;}

    public int get_id(){return this.id;}
    public String get_name(){return this.name;}
    public String get_author(){return this.author;}
    public String get_publish_house(){return this.publish_house;}
    public int get_publish_year(){return this.publish_year;}
    public int get_pages(){return this.pages;}
    public int get_price(){return this.price;}
    public String get_binding_type(){return this.binding_type;}

    public void print_book(){
        System.out.println("id: " +this.id);
        System.out.println("name: " +this.name);
        System.out.println("author: " +this.author);
        System.out.println("publishing house: " +this.publish_house);
        System.out.println("publishing year: " +this.publish_year);
        System.out.println("pages: " +this.pages);
        System.out.println("price: " +this.price+ " UAH");
        System.out.println("binding type: " +this.binding_type);
        System.out.println("--------------------------------");
    }

}
