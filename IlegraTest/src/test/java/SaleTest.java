import com.ramonfernandes.collections.SaleCollection;
import com.ramonfernandes.collections.SalesmanCollection;
import com.ramonfernandes.factory.Factory;
import com.ramonfernandes.pojo.Customer;
import com.ramonfernandes.pojo.ItemSold;
import com.ramonfernandes.pojo.Sale;
import com.ramonfernandes.pojo.Salesman;
import org.junit.Before;
import org.junit.Test;

public class SaleTest {
    private Factory factory;
    private Salesman salesman1;
    private Salesman salesman2;
    private Salesman salesman3;
    private Sale sale1;
    private Sale sale2;
    private Sale sale3;


    @Before
    public void setup(){
        factory = Factory.getInstanceOfFactory();
    }

    @Test
    public void worstSalesmanTest(){
        salesman1 = new Salesman().setCnpj("00000000000").setName("Pedro").setSalary("1000");
        salesman2 = new Salesman().setCnpj("00000000001").setName("Zeca").setSalary("1000");
        salesman3 = new Salesman().setCnpj("00000000002").setName("Joca").setSalary("1000");

        SalesmanCollection.addSalesman(salesman1);
        SalesmanCollection.addSalesman(salesman2);
        SalesmanCollection.addSalesman(salesman3);


        sale1 = new Sale().setSaleID(0).setSalesman("Pedro");
        String itemBuilder = "0-1-100";
        sale1.addItemSold((ItemSold) new ItemSold().buildObject(itemBuilder.split("-")));

        sale2 = new Sale().setSaleID(0).setSalesman("Zeca");
        itemBuilder = "0-2-100";
        sale2.addItemSold((ItemSold) new ItemSold().buildObject(itemBuilder.split("-")));

        sale3 = new Sale().setSaleID(0).setSalesman("Joca");
        itemBuilder = "0-3-100";
        sale3.addItemSold((ItemSold) new ItemSold().buildObject(itemBuilder.split("-")));

        SaleCollection.addSale(sale1);
        SaleCollection.addSale(sale2);
        SaleCollection.addSale(sale3);

        assert(SaleCollection.getWorstSalesmanEver().getName().equals("Pedro"));
    }

}
