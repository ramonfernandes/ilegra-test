package com.ramonfernandes.pojo;

import com.ramonfernandes.collections.SalesmanCollection;

import java.util.ArrayList;
import java.util.List;

public class Sale implements FileObject {
    private int saleID;
    private List<ItemSold> soldItems;
    private Salesman salesman;
    private SalesmanCollection salesmanCollection;

    public Sale() {
        this.soldItems = new ArrayList<ItemSold>();
        salesmanCollection = SalesmanCollection.getInstanceOf();
    }

    public Sale setSaleID(int saleID) {
        this.saleID = saleID;
        return this;
    }

    public Sale setSalesman(String salesman) {
        List<Salesman> salesmanList = salesmanCollection.getSalesmanByName(salesman);
        if (!salesmanList.isEmpty())
            this.salesman = salesmanList.get(0);
        return this;
    }

    public void addItamSold(ItemSold item) {
        soldItems.add(item);
    }

    @Override
    public FileObject buildObject(String[] separatedString) {
        for (String separatedSale : separatedString[1].split(",")) {
            soldItems.add((ItemSold) new ItemSold().buildObject(separatedSale.split("-")));
        }
        return this
                .setSaleID(Integer.parseInt(separatedString[0]))
                .setSalesman(separatedString[2]);
    }
}
