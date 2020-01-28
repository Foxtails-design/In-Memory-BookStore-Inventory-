package BookStore;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;


//concreate Originator 
public class Inventory implements IInventory{
	/* State
	state = BookAdded;
	state = BookSoldout;
	state = Copied;
	state = PriceChanged;
	state = Founded;*/
	private String Inventorystate;
	private InventoryDecorator invent;
	IMemento M;
	private ArrayList<Book> ListBook = new ArrayList<Book>();
	private String CommandFileName = "Command.ser"; //Question 3.
	public ArrayList<Book> getListBook() {
		return this.ListBook;
	}
	public void setListBook(ArrayList<Book> listBook) {
		this.ListBook = listBook;
	}
	public String getInventorystate() {
		return this.Inventorystate;
	}
	public void setInventorystate(String inventorystate) {
		this.Inventorystate = inventorystate;
	}
	
	//Question 1.
	@Override
	public void AddNewBook(Book book) {
		this.ListBook.add(book);
		//Operation Change the state of the Inventory
		setInventorystate(book.getBookName()+" was added");
		this.Save();

	}
	@Override
	public void sellBook(String BookName) throws MatchNotFoundException {
		for(Book e : this.ListBook)
		{
		if(e.getBookName().equalsIgnoreCase(BookName)&&e.getQuantity()>0)
			{
				e.changeQuantity(-1);
				//Operation Change the state of the Inventory
				setInventorystate(e.getBookName()+" was sold out from Inventory");
				this.Save();

				return;//Choose to End Method
			}
		}
		throw new MatchNotFoundException("No Match Found");
	}
	@Override
	public void AddCopyBook(String name, int amountcopy) throws MatchNotFoundException {
		for(Book e : this.ListBook) {
			if(e.getBookName().equalsIgnoreCase(name)) {
				e.changeQuantity(amountcopy);
				//Operation Change the state of the Inventory
				setInventorystate(e.getBookName()+" was copied");
				this.Save();

				return;//Choose to End Method
			}
	}throw new MatchNotFoundException("No Match Found");
	}
	@Override
	public void ChangePrice(String name, int price) throws MatchNotFoundException {
		for(Book e : this.ListBook) {
			if(e.getBookName().equalsIgnoreCase(name)) {
				e.setPrice(price);
				//Operation Change the state of the Inventory
				setInventorystate(e.getBookName()+"'/s price is changed");
				this.Save();

				return;//Choose to End Method
			}
		}
		throw new MatchNotFoundException("No Match Found");
		
	}
	@Override
	public Integer FindPriceByName(String BookName) throws MatchNotFoundException {
		for(Book e : this.ListBook) {
			if(e.getBookName().equalsIgnoreCase(BookName)) {
				return e.getPrice();
			}
		}
		throw new MatchNotFoundException("No Match Found");
	}
	@Override
	public Integer FindQuantityByName(String BookName) throws MatchNotFoundException {
		for(Book e : this.ListBook) {
			if(e.getBookName().equalsIgnoreCase(BookName)) {
				return e.getQuantity();
			}
		}
		throw new MatchNotFoundException("No Match Found");
	}
	@Override
	public Integer FindBookQuantitywithID(int BookID) throws MatchNotFoundException {
		for(Book e : this.ListBook) {
			if(e.getBookID()== BookID) {
				return e.getQuantity();
			}
		}
		throw new MatchNotFoundException("No Match Found");
	}
	@Override
	public Integer FindBookPricewithID(int BookID) throws MatchNotFoundException {
		for(Book e : this.ListBook) {
			if(e.getBookID()== BookID) {
				return e.getPrice();
			}
		}
		throw new MatchNotFoundException("No Match Found");
	}

	
	//Memento setState(Restore) Question 2.
		public void setState(Inventory state) {//call from Restore so i will set inventory back
			
			this.setListBook(state.getListBook());
			this.setInventorystate(state.getInventorystate());//got Last Message*/
			 
		}
	/**
	   * This method saves the state of inventory to file  
	   * and delete the commandfile(Q3).   Question 2.
	   */
	
	@Override
	public void Save() {//Save momento
		M= new Memento();
		this.M.SaveOriginator(this); 
		File file = new File(CommandFileName);//Question 3.
		file.delete();
		try {
			file.createNewFile();// Make it serialzable
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Save Memento");
		//return M; // output for caretaker to receive
	}
	/**
	   * This method get the previous state of inventory from file  
	   * and also runs command to take inventory to original state       
	   */
	@Override
	public void Restore() {
		invent.Restore();
		this.setState(invent.getInvent());
	}
	

	
	
}


