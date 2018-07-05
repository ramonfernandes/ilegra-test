import pojo.Customer;
import factory.Factory;
import pojo.Sale;
import pojo.Salesman;
import org.junit.Before;
import org.junit.Test;

public class FactoryTest {
    private Factory factory;

    @Before
    public void setup(){
        factory = Factory.getInstanceOfFactory();
    }

    @Test
    public void getSslesmanTest(){
        assert factory.getInstanceOfFile("001") instanceof Salesman;
    }

    @Test
    public void getCustomerTest(){
        assert factory.getInstanceOfFile("002") instanceof Customer;
    }

    @Test
    public void getSsleTest(){
        assert factory.getInstanceOfFile("003") instanceof Sale;
    }
}
