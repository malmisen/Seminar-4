import exceptions.InvalidCustomerIDException;
import org.junit.Before;
import org.junit.Test;
import serverSide.integration.DiscountCatalog;
import sharedDataObjects.Item;

import java.util.ArrayList;

public class DiscountCatalogTest {

    private Item apple;
    private Item tomato;
    private DiscountCatalog catalog;
    private ArrayList<Item> scannedItems;

    @Before
    public void setUp(){
        apple = new Item(1, "apple", 15, 0, 0.1 , 5);
        tomato = new Item(2, "tomato", 7, 0.03, 0, 10);
        Item burger = new Item(1, "burger", 40, 0.01, 0.1 , 5);
        Item[] items = {apple, tomato, burger};
        catalog = new DiscountCatalog(items);

        scannedItems = new ArrayList<>();
        scannedItems.add(apple);
    }

    @Test (expected = InvalidCustomerIDException.class)
    public void testInvalidCustomerID() throws InvalidCustomerIDException{
        catalog.getTotalDiscount(0, scannedItems);
    }

    @Test
    public void testValidCustomerID() throws InvalidCustomerIDException{
        catalog.getTotalDiscount(1, scannedItems);
    }
    
}
