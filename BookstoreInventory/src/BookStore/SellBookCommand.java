package BookStore;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//Question 3.
/**
 * This class used to execute sellMovie method on inventory and serialize it to file.
 */

@SuppressWarnings("serial")
public class SellBookCommand extends Command implements java.io.Serializable {

	private String BookName;
	private String fileName = "Command.ser";//Link from Save(); save to file when perfom
	
	SellBookCommand(String newBookName){
	this.BookName = newBookName; 
	}
	
	@Override
	public void execute(Inventory newInvent) {
		
		try {
			  newInvent.sellBook(BookName);
		} catch (MatchNotFoundException e) {
			System.out.println(e);
		}

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
