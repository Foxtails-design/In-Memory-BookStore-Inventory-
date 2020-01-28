package BookStore;

import java.time.LocalDateTime;

public interface IMemento {
	//Question 2.
	
		LocalDateTime  CreatedDate();
		void SaveOriginator(Inventory Originator);
		Inventory GetOriginator();
}
