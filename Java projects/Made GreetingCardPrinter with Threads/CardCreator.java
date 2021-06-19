import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Homework 5 Card Creator
 * 
 * This class defines the thread task that will "come up with" and submit
 * greeting card ideas to the print queue. We have added the code necessary to
 * read from the file, but it's up to you to handle turning off the printer
 * (keeping track of how many threads are open) and adding the read-in line from
 * the inspiration file to the queue.
 * 
 * @author Aayush Malde (asm7yaq)
 *
 */
public class CardCreator implements Runnable {

	/**
	 * Print queue to add new card ideas
	 */
	private PrintQueue printQueue;

	/**
	 * Inspiration file name
	 */
	private String filename;
	/**
	 * private int ct which keeps track of the thread
	 */
	private static int ct;

	/**
	 * CardCreator constructor
	 */
	public CardCreator(PrintQueue d, String filename) {
		printQueue = d;
		this.filename = filename;
	}

	/**
	 * Run method that is the main method for the thread
	 */
	@Override
	public void run() {
		ct = ct + 1;

		Scanner s = null;
		try {
			s = new Scanner(new FileReader(filename));
			while (s.hasNextLine()) {
				printQueue.enqueue(s.nextLine());
				Thread.sleep(1000);
			}
		} catch (IOException | InterruptedException e) {
			System.out.println("Could not read file");
		} finally {
			if (s != null)
				s.close();

			ct = ct - 1;
			if (ct == 0)
				printQueue.turnOff();
		}
	}

}
