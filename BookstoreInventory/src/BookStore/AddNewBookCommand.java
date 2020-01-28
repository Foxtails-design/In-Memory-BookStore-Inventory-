package BookStore;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//Question 3.
/**
 * This class used to execute addMovie method on inventory and serialize it to file.
 */

@SuppressWarnings("serial")
public class AddNewBookCommand extends Command implements java.io.Serializable {

	private Book book;
	private String fileName = "Command.ser";//Link from Save(); save to file when perfom
	
	AddNewBookCommand(Book newBook){
	this.book = newBook; 
	}
	
	@Override
	public void execute(Inventory newInvent) {
		
		newInvent.AddNewBook(book);
		
		try
	      {
	         FileOutputStream fileOut = new FileOutputStream(fileName,true);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(this);// Save to file
	         out.close();
	         fileOut.close();
	        
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	        
	      }
	}

}
