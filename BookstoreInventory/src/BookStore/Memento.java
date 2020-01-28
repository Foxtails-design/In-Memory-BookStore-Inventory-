package BookStore;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class Memento implements IMemento ,Serializable {
	
	//question 2.
	
		//Make Memento to file
		private Inventory originator  ;// Use Memento to save state in Inventory(All Data)
		private LocalDateTime LastPatchedDate;
		DateTimeFormatter FormatDate = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
		@SuppressWarnings("unused")
		private String LastPatchedlogDate; //create date in momento
		@Override
		public LocalDateTime CreatedDate() {
			LocalDateTime logDate =LocalDateTime.now();
			return logDate;
		}



		@Override
		public Inventory GetOriginator() {
			return this.originator;	//return to Inventorydecorator
		}
		
		@Override
		public void SaveOriginator(Inventory o) {
			this.originator = o;
			this.LastPatchedDate = (this.CreatedDate());//Save StateTime
			this.LastPatchedlogDate=(LastPatchedDate.format(FormatDate));//CurrentDisplayText Ref.
		}


		
		
	}
