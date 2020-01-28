package BookStore;

public interface IInventory {
	//Originator Interface
	void Save();
	//will do InventoryDecorator Question 4.
	void Restore(); 
	public void AddNewBook(Book book);
	public void sellBook(String BookName)throws MatchNotFoundException;
	public void AddCopyBook(String name,int amountcopy) throws MatchNotFoundException;
	public void ChangePrice(String name,int price) throws MatchNotFoundException;
	public Integer FindPriceByName(String BookName) throws MatchNotFoundException;
	public Integer FindQuantityByName(String BookName) throws MatchNotFoundException;
	public Integer FindBookQuantitywithID(int BookID) throws MatchNotFoundException;
	public Integer FindBookPricewithID(int BookID)throws MatchNotFoundException;
}
