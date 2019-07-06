package lab2;

public class Example {

	public static void main(String[] args) {
		Book myBook = new Book(1, "My Book Title", 6, "Poonam");
		System.out.println(myBook.toString());
		Video myVideo = new Video(150, 12, "Avengers", 20);
		System.out.println(myVideo.toString());
		Video myVideo1 = new Video(130, 113, "Superman", 21);
		System.out.println(myVideo.equals(myVideo1));
		CD myCd = new CD(25, 12, "Music", 8, "Arman Malik", "Club");
		myCd.checkIn();
		myCd.checkOut();
		JournalPaper myJournalPaper = new JournalPaper(122, "Research", 35, "Dr. Rai", 1997);
		myJournalPaper.addItem();
		myJournalPaper.print();
	}

}
