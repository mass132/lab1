package lab2;

public abstract class MediaItem extends Item {
	private int runtime;

	public MediaItem(int runtime, int idNum, String title, int numOfCopies) {
		super(idNum, title, numOfCopies);
		this.runtime = runtime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + runtime;
		return result;
	}

	public MediaItem(int idNum, String title, int numOfCopies, int runtime) {
		super(idNum, title, numOfCopies);
		this.runtime = runtime;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MediaItem other = (MediaItem) obj;
		if (runtime != other.runtime)
			return false;
		return true;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	@Override
	public String toString() {
		return "MediaItem [runtime=" + runtime + ", getIdNum()=" + getIdNum() + ", getTitle()=" + getTitle()
				+ ", getNumOfCopies()=" + getNumOfCopies() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
