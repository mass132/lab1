package lab2;

public class Video extends MediaItem {
private String director;
private String genre;
private int year;
	public Video(int runtime, int idNum, String title, int numOfCopies, String director, String genre, int year) {
	super(runtime, idNum, title, numOfCopies);
	this.director = director;
	this.genre = genre;
	this.year = year;
}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
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
		Video other = (Video) obj;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	@Override
public String toString() {
	return "Video [director=" + director + ", genre=" + genre + ", year=" + year + ", getDirector()=" + getDirector()
			+ ", getGenre()=" + getGenre() + ", getYear()=" + getYear() + ", hashCode()=" + hashCode()
			+ ", getRuntime()=" + getRuntime() + ", toString()=" + super.toString() + ", getIdNum()=" + getIdNum()
			+ ", getTitle()=" + getTitle() + ", getNumOfCopies()=" + getNumOfCopies() + ", getClass()=" + getClass()
			+ "]";
}
	public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
	public Video(int runtime, int idNum, String title, int numOfCopies) {
		super(runtime, idNum, title, numOfCopies);
	}

}
