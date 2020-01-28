package BookStore; // BookStore has many Inventory(decorator)

import java.util.Scanner;


public class BookStore {
	
public static void main(String[] args) throws MatchNotFoundException {
	int choice;
	String name;
	int id,amount,price;
	String bye;
	InventoryDecorator invent = new InventoryDecorator();
	Scanner my_choice = new Scanner(System.in);
	Scanner my_name = new Scanner(System.in);
	Scanner my_id = new Scanner(System.in);
	Scanner my_amount = new Scanner(System.in);
	Scanner my_price = new Scanner(System.in);
	
	
	do {
		System.out.println("BookStore menu");
		System.out.println("<--------------------------->");
		System.out.println("1: Add a new book");// AddNewBookCommand
		System.out.println("2: copy book");// AddCopyCommand
		System.out.println("3: Sell a Book");//SellBookCommand
		System.out.println("4: Change Book's price");//ChangePriceCommand
		System.out.println("5: Find Book's price by Name");//FindPriceByName
		System.out.println("6: Find Book's quantity by Name");//FindQuantityByName
		System.out.println("7: Find Book's price by ID");//FindBookPricewithID
		System.out.println("8: Find Book's quantity by ID");//FindQuantitywithID
		System.out.println("9: Show All Books");//Print in Foreach
		System.out.println("10: Restore");//PreviousState
		System.out.println("11: Exit");
		System.out.println("<--------------------------->");
		System.out.print("Input : ");
		choice = my_choice.nextInt();
		
		
		switch (choice) {
		case 1:
			System.out.println("AddNewBookCommand");
			System.out.print("Input Book Name : ");
			name = my_name.next();
			System.out.print("Input "+name+" Price : ");
			price = my_price.nextInt();
			System.out.print("Input "+name+" Quantity : ");
			amount = my_amount.nextInt();
			
			for(Book e : invent.getInvent().getListBook()) {
				if(e.getBookName().equalsIgnoreCase(name)) {
					System.out.println("------------------------");
					System.out.println("This Book is already exist.");
					System.out.println("------------------------");
					break;
				}
					
			}
			invent.AddNewBook(new Book(name, price, amount));


			break;
		
		case 2:
			System.out.println("AddCopyCommand");
			System.out.print("Input Book Name : ");
			name = my_name.nextLine();
			System.out.print("Input "+name+" Quantity : ");
			amount = my_amount.nextInt();
			invent.AddCopyBook(name, amount);
			break;
		
		case 3:
			System.out.println("SellBookCommand");
			System.out.print("Input Book Name : ");
			name = my_name.nextLine();
			invent.sellBook(name);
			break;
	
		case 4:
			System.out.println("ChangePriceCommand");
			System.out.print("Input Book Name : ");
			name = my_name.nextLine();
			System.out.print("Input "+name+" Price : ");
			price = my_price.nextInt();
			invent.ChangePrice(name, price);
			break;
	
		case 5:
			System.out.println("FindPriceByName");
			System.out.print("Input Book Name : ");
			name = my_name.nextLine();
			invent.FindPriceByName(name);
			break;
		
		case 6:
			System.out.println("FindQuantityByName");
			System.out.print("Input Book Name : ");
			name = my_name.nextLine();
			invent.FindQuantityByName(name);
			break;
		
		case 7:
			System.out.println("FindBookPricewithID");
			System.out.print("Input Book ID : ");
			id = my_id.nextInt();
			invent.FindBookPricewithID(id);
			break;
		
		case 8:
			System.out.println("FindQuantitywithID");
			System.out.print("Input Book ID : ");
			id = my_id.nextInt();
			invent.FindBookQuantitywithID(id);
			break;
	
		case 9:
			System.out.println("Show All Books");
			if(invent.getInvent().getListBook().isEmpty())
			{
				System.out.println("------------------------");
				System.out.println("No Data.");
				System.out.println("------------------------");
				break;
			}else {
				for(Book e : invent.getInvent().getListBook())
				{
					System.out.println("------------------------");
					System.out.println("Book Name : "+e.getBookName());
					System.out.println("Book ID   : "+e.getBookID());
					System.out.println("Amount    : "+e.getQuantity());
					System.out.println("Price     : "+e.getPrice());
					System.out.println("------------------------");
				}
				break;
			}
			
		case 10:
			invent.Restore();
			System.out.println("Restore PreviousState ");
			break;
	
		case 11:
			System.out.println("Bye Bye");
			
			break;
			
		default:
			System.out.println("Input Incorrect number. Please input number 1-11.");
			break;
			}
		System.out.print("Do you want to Continue :");
		bye=my_name.next();
	}while(bye.equalsIgnoreCase("y")||bye.equalsIgnoreCase("yes"));
	
	my_choice.close();
	my_name.close();
	my_id.close();
	my_amount.close();
	my_price.close();
    	

	}


}


/*InventoryDecorator invent = new InventoryDecorator();
Integer price;
invent.AddNewBook(new Book("Mathematic", 250, 20));
invent.AddNewBook(new Book("Japan Manga", 75, 15));
invent.AddNewBook(new Book("Light Novel", 300, 25));
invent.AddCopyBook("Mathematic", 5); 
	try{	
		price = invent.FindBookQuantitywithID(1);
		System.out.println("Match found " + price);
	}catch(MatchNotFoundException e)
	{
		System.out.println("Match not found ");
	}*/
   //invent.saveState();

/* InventoryDecorator invent2 = new InventoryDecorator();
 invent2.getState();
 invent2.AddNewBook(new Book("English", 300, 25));
invent2.sellBook("English");
try{	
		price = invent2.FindQuantityByName("English");
		System.out.println("Match found " + price);
	}catch(MatchNotFoundException e)
	{
		System.out.println(e);
	}*/
/*  try{	
		price = invent2.FindPriceByName("Light Novel");
		System.out.println("Match found " + price);
	}catch(MatchNotFoundException e)
	{
		System.out.println("Match not found ");
	}
try{	
		price = invent2.FindPriceByName("Mathematic");
		System.out.println("Match found " + price);
	}catch(MatchNotFoundException e)
	{
		System.out.println("Match not found ");
	}
try{	
		price = invent2.FindPriceByName("Japan Manga");
		System.out.println("Match found " + price);
	}catch(MatchNotFoundException e)
	{
		System.out.println("Match not found ");
	}*/
	//	price = invent.findPriceByName("MIB-4");