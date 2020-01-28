package BookStore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class testInventory {
	
	/*
	@Test
	@DisplayName ("Menu1")
	public void testAddNewBook() {
		InventoryDecorator invent = new InventoryDecorator();
		
	    Integer price, testPrice=500;
	    invent.AddNewBook(new Book("Math", 500, 5));   
	       
	    try{	
				price = invent.FindPriceByName("Math");
			}catch(MatchNotFoundException e)
			{
				System.out.println("Match not found ");
				price =0;
			}
	    assertEquals(testPrice, price);
	}

	@Test
	@DisplayName ("Menu2")
	public void testAddCopy() {
		InventoryDecorator invent = new InventoryDecorator();
	    Integer copy, testCopy=10;
	       
	    invent.AddNewBook(new Book("Math", 500, 5));
	    invent.AddCopyBook("Math", 5);  
	    try{	
				copy = invent.FindQuantityByName("Math");
			}catch(MatchNotFoundException e)
			{
				System.out.println("Match not found ");
				copy =0;
			}
	    assertEquals(testCopy, copy);
		
	}

	@Test
	@DisplayName ("Menu4")
	public void testChangePrice() {
		InventoryDecorator invent = new InventoryDecorator();
	    Integer price, testPrice=1000;
	    invent.AddNewBook(new Book("Math", 500, 5)); 
	    invent.ChangePrice("Math", 1000);
	    try{	
				price = invent.FindPriceByName("Math");
			}catch(MatchNotFoundException e)
			{
				System.out.println("Match not found ");
				price =0;
			}
	    assertEquals(testPrice, price);
	}

	@Test
	@DisplayName ("Menu3")
	public void testSellBook() {
		InventoryDecorator invent = new InventoryDecorator();

	    Integer copy, testCopy=4;
	       
	    invent.AddNewBook(new Book("Math", 500, 5)); 
	    invent.sellBook("Math"); 
	    try{	
				copy = invent.FindQuantityByName("Math");
			}catch(MatchNotFoundException e)
			{
				System.out.println("Match not found ");
				copy =0;
			}
	    assertEquals(testCopy, copy);
	}

	@Test
	@DisplayName ("Menu6")
	public void testFindQuantityByName() {
	    Integer quantity, testquantity=10;
	    InventoryDecorator invent = new InventoryDecorator();   
	    invent.AddNewBook(new Book("Math", 500, 10));   
	    try{	
	    	quantity = invent.FindQuantityByName("Math");
			}catch(MatchNotFoundException e)
			{
				System.out.println("Match not found ");
				quantity =0;
			}
	    assertEquals(testquantity, quantity);
	}
	
	@Test
	@DisplayName ("Menu5")
	public void testFindPriceByName() {
	    Integer price, testPrice=500;
	    InventoryDecorator invent = new InventoryDecorator();   
	    invent.AddNewBook(new Book("Math", 500, 5));   
	    try{	
				price = invent.FindPriceByName("Math");
			}catch(MatchNotFoundException e)
			{
				System.out.println("Match not found ");
				price =0;
			}
	    assertEquals(testPrice, price);
	}
	
	@Test
	@DisplayName ("Menu7")
	public void testFindPricewithID() {
	    Integer price, testPrice=500;
	    InventoryDecorator invent = new InventoryDecorator();   
	    invent.AddNewBook(new Book("Math", 500, 10));   
	    try{
	    	System.out.println(invent.getInvent().getListBook().get(0).getBookID());
	    	price = invent.FindBookPricewithID(5);
			}catch(MatchNotFoundException e)
			{
				System.out.println("Match not found ");
				price =0;
			}
	    assertEquals(testPrice, price);
	}
	
	@Test
	@DisplayName ("Menu8")
	public void testFindQuantitywithID() {
	    Integer quantity, testquantity=10;
	    InventoryDecorator invent = new InventoryDecorator();   
	    invent.AddNewBook(new Book("Math", 500, 10));   
	    try{
	    	System.out.println(invent.getInvent().getListBook().get(0).getBookID());
	    	quantity = invent.FindBookQuantitywithID(4);
			}catch(MatchNotFoundException e)
			{
				System.out.println("Match not found ");
				quantity =0;
			}
	    assertEquals(testquantity, quantity);
	}*/
	
	@Test
	@DisplayName ("Menu10")
	public void testRestore() {
		InventoryDecorator invent = new InventoryDecorator();
		Integer price, testPrice=500;
	       
		invent.AddNewBook(new Book("Math1", 500, 5)); 
		invent.AddNewBook(new Book("Math2", 600, 5));
	    invent.Save(); 
	    InventoryDecorator invent2 = new InventoryDecorator();
	    invent2.Restore();
	    
	    try{	
			price = invent2.FindPriceByName("Math1");
		}catch(MatchNotFoundException e)
		{
			System.out.println(e);
			price=0;
		}
	    
	    assertEquals(testPrice, price);
	    
	}

}
