package BookStore;
import java.io.EOFException;
import java.io.File;
//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class InventoryDecorator implements IInventory{ //interact with Memento and Caretaker
	private IMemento memento = new Memento();
	private Inventory invent = new Inventory();//Retrieve data from inventory
	private FileInputStream fileIn ;
	private ArrayList<Command> commandCollection = new ArrayList<Command>();//collect each command prevent data lost from crash
	private CareTaker careTaker = new CareTaker(); //use with decorator for every change in Inventory
	private String CommandFileName = "Command.ser"; // Link from Save();
	
	
	public Inventory getInvent() {
		
		return this.invent;
	}

	public void setInvent(Inventory invent) {
		
		this.invent = invent;
	}
	// Question 4
	//These has print Error in command class
	public void AddNewBook(Book book) { //did not throw match not found
		
		AddNewBookCommand addBook= new AddNewBookCommand(book);
	    addBook.execute(this.invent);
	}
	
	public void AddCopyBook(String name, int amountcopy){
		
		AddCopyCommand addCopy = new AddCopyCommand(name,amountcopy);
		addCopy.execute(this.invent);
		
	}
	
	public void ChangePrice(String name, int price) {
	
		ChangePriceCommand changePrice = new ChangePriceCommand(name, price);
		changePrice.execute(this.invent);
		
	}
	public void sellBook(String BookName) {
		
		SellBookCommand sellBook = new SellBookCommand(BookName);
		sellBook.execute(this.invent);
	}
	
	//Below this method did not have command class it is necessary to print not found
	@Override
	public Integer FindPriceByName(String BookName) throws MatchNotFoundException{
		
		try {
			
			return invent.FindPriceByName(BookName);
			
		} catch (MatchNotFoundException e) {
			
			System.out.println(e);
			return null;
		}
	}
	@Override
	public Integer FindBookPricewithID(int BookID) throws MatchNotFoundException{
		
		try {
			
			return invent.FindBookPricewithID(BookID);
			
		} catch (MatchNotFoundException e) {
			
			System.out.println(e);
			return null;
		}
	}
	@Override
	public Integer FindQuantityByName(String BookName) throws MatchNotFoundException{
		
		try {
			
			return invent.FindQuantityByName(BookName);
			
		} catch (MatchNotFoundException e) {
			
			System.out.println(e);
			return null;
		}
	}
	@Override
	public Integer FindBookQuantitywithID(int BookID) throws MatchNotFoundException{
		
		try {
			 
			return invent.FindBookQuantitywithID(BookID);
			
		} catch (MatchNotFoundException e) {
			
			System.out.println(e);
			return null;
		}
	}
		
	/**
	   * This method get the commands from file  
	   * and also runs them to inventory object       
	   */
	
	private void replyCommands(Inventory invent){
			
		try {
				  fileIn = new FileInputStream(CommandFileName);
				  while (true) {
					ObjectInputStream input = new ObjectInputStream(fileIn);
				    commandCollection.add((Command) input.readObject()); // get from file load last command
				  }  
				}catch (EOFException e) {
					
					try{	
						fileIn.close();
					}catch(IOException i)
					{
						i.printStackTrace();
					}
					
				}catch(IOException i)
				{
					i.printStackTrace();
				}catch(ClassNotFoundException c)
				{
					System.out.println("class not found");
					c.printStackTrace();
				}
			
			for(Command command : commandCollection){
		         command.execute(invent); // replaying all command
			}
		}

	@Override
	public void Save() { //data point to inventor.java
		memento.SaveOriginator(invent);
		careTaker.serialzeMemento((Memento)memento);
		File file = new File(CommandFileName);
		file.delete();
		
		try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		System.out.println("Save Inventory state");
		//return memento;//--> sent to care taker to list
	}

	@Override
	public void Restore() {// get previous state of inventory
		memento = careTaker.deserialseMemento(); // get 1 memento from CareTaker
		invent.setListBook(memento.GetOriginator().getListBook());
		invent.setInventorystate(memento.GetOriginator().getInventorystate());
		//invent.setState(this.memento.GetOriginator());
		this.replyCommands(invent); //Finish get Last Memento to get operation
	}







}