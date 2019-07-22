package lab11;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentPatterns {

	public static void main(String[] args) throws IOException {

		FileReader inputStream = new FileReader("source.txt");
		FileWriter outputWriter = new FileWriter("target.txt");

		ExecutorService service = Executors.newFixedThreadPool(1);
		CopyDataThread thread = new CopyDataThread(inputStream, outputWriter);
		service.execute(thread);
		service.shutdown();
	}
}
