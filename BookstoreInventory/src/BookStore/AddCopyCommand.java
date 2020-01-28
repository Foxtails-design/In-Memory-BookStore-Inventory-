package BookStore;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//Question 3.
/**
 * This class used to execute addCopy method on inventory and serialize it to file.
 */
@SuppressWarnings("serial")
public class AddCopyCommand extends Command implements java.io.Serializable {

	private String BookName;
	private int numberOfCopy;
	private String fileName = "Command.ser"; //Link from Save();
	
	AddCopyCommand(String newBookName, Integer newNumberOfCopy){
	this.BookName = newBookName; 
	this.numberOfCopy = newNumberOfCopy;
	}
	
	@Override
	public void execute(Inventory newInvent) {
		//method is throw
		try {
		    newInvent.AddCopyBook(BookName,numberOfCopy);
		} catch (MatchNotFoundException e) {
			System.out.println(e);
		}
		
		try
	      {
	         FileOutputStream fileOut = new FileOutputStream(fileName,true);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(this); // Save to file
	         out.close();
	         fileOut.close();
	        
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	        
	      }
	}

}
