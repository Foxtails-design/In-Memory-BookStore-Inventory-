package BookStore;
// THis class use with InventoryDecorator Question 4.
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*import java.util.ArrayList;
import java.util.List;*/

public class CareTaker { 
	/*//Reductant
	public List<IMemento> Histories;

	public CareTaker() {
		Histories = new ArrayList<IMemento>();
		
	}
	public void Undo() { //Cancel last momento
		if(Histories.isEmpty()) {
			System.out.println("There is no Momento");
		}else {
			for( IMemento attheEnd : Histories) {
				//Find LastHistory in History List
				IMemento LastHistory = attheEnd;
				Histories.remove(LastHistory);
			}
		}
	}
	public List<IMemento> getHistories() {
		return Histories;
	}
	public void setHistories(List<IMemento> histories) {
		Histories = histories;
	}*/
	/**
	 * This class to serialize and deserialize Memento to/from file.       Question2.
	 */
	private String temporaryFileName = "temporaryInventory.ser"; //state from memonto
	private String fileName = "Inventory.ser";
	private File tempFile = new File(temporaryFileName);
	private File file = new File(fileName);
	byte[] buf = new byte[1024];
	int bytesRead;
	private Object object;
	public void serialzeMemento(Memento state){//Momento state is parameter before write
		//before serialize caretaker will add to histories(list) but reductant
		   try
		      {
		         FileOutputStream temporaryFileOut = new FileOutputStream(temporaryFileName);
		         ObjectOutputStream out = new ObjectOutputStream(temporaryFileOut);
		       
		         out.writeObject(state);         
		         out.close();
		         temporaryFileOut.close();
		         tempFile.renameTo(file);
		      }catch(IOException i)
		      {
		          i.printStackTrace();
		      }
		   
	   }//need to try undo method.

	   public Memento deserialseMemento(){	 
		   
		   try
		      {
		         FileInputStream fileIn = new FileInputStream(fileName); //Momento object is in file
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         object = in.readObject();
		         in.close();
		         fileIn.close();
		         
		         return (Memento)object; //sent to Decorator addinCommandCollection
		      }catch(IOException i)
		      {
		         i.printStackTrace();
		         return null;
		         
		      }catch(ClassNotFoundException c)
		      {
		          System.out.println("class not found");
		          c.printStackTrace();
		          return null;
		          
		       }
		   
	   }
	   
}
