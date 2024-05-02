package se.mtry.iv1350.grocerystoreseminar.dto;

/**
 * Hur ett item struktur loggas och ser ut.
 * @author mtrys
 */
public class ItemDTO {
    private String id; 
    private String name;
    private String description;
    private double price; 
    private double vto;

    public ItemDTO(){
        
    }
    
    public ItemDTO(String id, String name, String description, double price, double vto){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price; 
        this.vto = vto;
    }
    
    /**
     * Return the item ID  
     * @return id of the item.
     */
    public String getID (){
        return id;
    }
    
    public double getPrice(){
        return price;
    }
    
    public double getVTO(){
        return vto;
    }
    
    public String getName (){
        return name;
    }
    
    public String getDescription (){
        return description;
    }
    
}
