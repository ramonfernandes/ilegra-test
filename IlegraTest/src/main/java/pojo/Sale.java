package pojo;

import java.util.ArrayList;
import java.util.List;

public class Sale implements FileObject {
    private int saleID;
    private List soldItems;
    private Salesman salesman;

    public Sale(){
        this.soldItems = new ArrayList();
    }

    public Sale setSaleID(int saleID){
        this.saleID = saleID;
        return this;
    }

    public void addItamSold(ItemSold item){
        soldItems.add(item);
    }
}
