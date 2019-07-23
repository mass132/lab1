package lab2;

public class JournalPaper extends WrittenItem {
	private int year;

	public JournalPaper(int idNum, String title, int numOfCopies, String author, int year) {
		super(idNum, title, numOfCopies, author);
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JournalPaper other = (JournalPaper) obj;
		if (year != other.year)
			return false;
		return true;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "JournalPaper [year=" + year + ", hashCode()=" + hashCode() + ", getYear()=" + getYear()
				+ ", getAuthor()=" + getAuthor() + ", toString()=" + super.toString() + ", getIdNum()=" + getIdNum()
				+ ", getTitle()=" + getTitle() + ", getNumOfCopies()=" + getNumOfCopies() + ", getClass()=" + getClass()
				+ "]";
	}

	public void setYear(int year) {
		this.year = year;
	}

}
