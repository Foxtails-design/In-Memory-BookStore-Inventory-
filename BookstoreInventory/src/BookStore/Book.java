package BookStore;//Question1.
@SuppressWarnings("serial")
public class Book implements java.io.Serializable{
	private String BookName;
	private static int count=0;
	private int  quantity,BookID,price;

	
	public Book(String bookName, int price, int quantity) {// Question 1.
		this.BookName = bookName;
		this.price = price;
		this.quantity = quantity;
		this.BookID = ++count;
	}
	public void changeQuantity(int change){
		
		this.quantity += change;

	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int qualtity) {
		this.quantity = qualtity;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		this.BookName = bookName;
	}
	public int getBookID() {
		return BookID;
	}
	public void setBookID(int bookID) {
		this.BookID = bookID;
	}
	
	
}
