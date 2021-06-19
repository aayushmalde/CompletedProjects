import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Homework 5 PrintQueue
 * 
 * Implement the class below as specified in the homework 5 document.
 * 
 * @author Aayush Malde (asm7yaq)
 *
 */

// Don't forget to include the appropriate import statements

public class PrintQueue {

	private LinkedList<String> toPrint; // the printer's list of documents
	private Lock documentChangeLock; // a ReentrantLock lock
	private Condition hasPrintTask; // a condition object
	private boolean isOn; // boolean variable describing if the
							// queue is on (accepting jobs)

	// TODO: Handle locking and conditions around the
	// enqueueing and dequeuing of documents
	// in this PrintQueue's document list (toPrint)
	// Note: See example in the zip folder 'Thread Example 6 - Bank Deadlock'

	/**
	 * Constructor
	 */
	public PrintQueue() {
		toPrint = new LinkedList<String>(); // create the list of documents
		isOn = true; // turn on the print queue
		documentChangeLock = new ReentrantLock(); // instantiates documentChangeLock
		hasPrintTask = documentChangeLock.newCondition();// instantiates hasPrintTask
	}

	/**
	 * This method removes the head element of the queue and returns it
	 * 
	 * @return String - returns the head element of toPrint
	 */
	public String dequeue() {
		documentChangeLock.lock();
		try {
			while (toPrint.size() == 0) {
				if (isOn == true) {
					hasPrintTask.await();
				}
			}
			return toPrint.remove(); // return the first document
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			documentChangeLock.unlock();
		}
		return null;
	}

	/**
	 * A method that adds the greeting to the end of print queue
	 * 
	 * @param s - the String that gets added to printTask
	 */
	public void enqueue(String s) {

		documentChangeLock.lock();
		try {
			toPrint.add(s); // add to the list of documents
			hasPrintTask.signalAll();
		} finally {
			documentChangeLock.unlock();
		}

	}

	/**
	 * A method that turns off the print queue
	 */
	public void turnOff() {
		documentChangeLock.lock();
		try {
			isOn = false;
			hasPrintTask.signalAll();
		} finally {
			documentChangeLock.unlock();
		}
	}

	/**
	 * A method that checks if PrintQueue is accepting jobs
	 * 
	 * @return boolean - returns true or false depending on if isOn is true
	 */
	public boolean isOn() {
		if (isOn == true) {
			return true;
		}
		return false;
	}

}
