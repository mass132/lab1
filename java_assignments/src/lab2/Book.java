package lab2;

public class Book extends WrittenItem {

	@Override
	public String toString() {
		return "Book [getAuthor()=" + getAuthor() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ ", getIdNum()=" + getIdNum() + ", getTitle()=" + getTitle() + ", getNumOfCopies()=" + getNumOfCopies()
				+ ", getClass()=" + getClass() + "]";
	}

	public Book(int idNum, String title, int numOfCopies, String author) {
		super(idNum, title, numOfCopies, author);
	}

}
