package lab2;

public abstract class Item {
	private int idNum;
	private String title;
	private int numOfCopies;

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	@Override
	public String toString() {
		return "Item [idNum=" + idNum + ", title=" + title + ", numOfCopies=" + numOfCopies + "]";
	}

	public Item(int idNum, String title, int numOfCopies) {
		super();
		this.idNum = idNum;
		this.title = title;
		this.numOfCopies = numOfCopies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idNum;
		result = prime * result + numOfCopies;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (idNum != other.idNum)
			return false;
		if (numOfCopies != other.numOfCopies)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public void print() {
		System.out.println(this.toString());

	}

	public void checkIn() {
System.out.println("Checked In at");
	}

	public void checkOut() {
		System.out.println("Checked Out");

	}

	public void addItem() {
		System.out.println("addItem method called");
	}

}
