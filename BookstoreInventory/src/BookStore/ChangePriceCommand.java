package BookStore;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//Question 3.
/**
 * This class used to execute changePrice method on inventory and serialize it to file.
 */

@SuppressWarnings("serial")
public class ChangePriceCommand extends Command implements java.io.Serializable {

	private String BookName;
	private Integer numberOfCopy;
	private String fileName = "Command.ser";//Link from Save(); save to file when perfom
	
	ChangePriceCommand(String newBookName, Integer newNumberOfCopy){
	this.BookName = newBookName; 
	this.numberOfCopy = newNumberOfCopy;
	}
	
	@Override
	public void execute(Inventory newInvent) {
		
		try {
		    newInvent.ChangePrice(BookName, numberOfCopy);
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
