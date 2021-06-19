/**
 * Card Printer
 * 
 * This card printer implements the Runnable interface and
 * can be run in its own thread.  It will try to read from
 * the print queue and then print a card to the terminal, 
 * formatted at 40 characters wide and surrounded by a
 * border.
 * 
 * @author YOURID
 *
 */
public class Printer implements Runnable {

	/**
	 * Print Queue
	 */
	private PrintQueue queue;
	
	/**
	 * Time to wait, in milliseconds, before printing another card
	 */
	private int waitTime;
	
	public Printer(PrintQueue q, int waitTime) {
		queue = q;
		this.waitTime = waitTime;
	}

	/**
	 * Run method
	 * 
	 * This is the main method of the Printer.  It is
	 * run when the thread is started.  It tries to
	 * read from the print queue, formats and prints the
	 * card, then waits for the given amount of time before
	 * trying to read again.
	 */
	@Override
	public void run() {
		try {
			while (queue.isOn()) {
				String verse = queue.dequeue();
				if (verse != null) {
					System.out.println(cardFormat(verse, 40));
				}
				Thread.sleep(waitTime);
			}
		} catch (InterruptedException e) {
			// do nothing but exit
		}
	}
	
	/**
	 * Format a card
	 * 
	 * Given a verse and a width, format the verse surrounded
	 * by a box, within the given width.
	 * 
	 * @param verse The verse to print on the card
	 * @param width The width of the card
	 * @return A string that represents the box-surrounded card
	 */
	private String cardFormat(String verse, int width) {
		String[] words = verse.split("\\s+");
		String formatted = "";
		String line = "| ";
		
		// Add the top border
		for (int i = 0; i < width; i++)
			formatted += "-";
		formatted += "\n";
		
		// Add the verse (appropriate lengths)
		for (String word : words) {
			if (line.length() + word.length() + 1 <= width - 4) {
				line += word + " ";
			} else {
				while (line.length() < width - 1)
					line += " ";
				formatted += line + "|\n";
				line = "| " + word + " ";
			}
		}
		
		// Finish up the last line
		while (line.length() < width - 1)
			line += " ";
		formatted += line + "|\n";

		// Add the bottom border
		for (int i = 0; i < width; i++)
			formatted += "-";
		formatted += "\n";
		
		// Return the result
		return formatted;
	}

}
