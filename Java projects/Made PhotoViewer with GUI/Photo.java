import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * * Homework 3 Malde Aayush, asm7yaq Sources: TA office hours Big Java book ,
 * ...
 */

public class Photo implements Comparable<Photo> {

	// Fields
	/**
	 * A String containing the Photo’s caption in whatever form it was provided.
	 */
	private final String caption;
	/**
	 * A String containing the Photo’s filename in whatever form it was provided.
	 */
	private final String filename;
	/**
	 * A String containing the Photo’s dateTaken in whatever form it was provided.
	 */
	private final String dateTaken;
	/**
	 * A int containing the Photo’s rating in whatever form it was provided.
	 */
	private int rating;
	/**
	 * A BufferedImage object that contains the image's data
	 */
	protected BufferedImage imageData;

	// Constructors
	/**
	 * This method creates a Photo object given a filename and caption
	 * 
	 * @param filename : String that Photo's filename will get set to
	 * @param caption  : String that Photo's caption will get set to
	 */
	public Photo(String filename, String caption) {
		this.filename = filename;
		this.caption = caption;
		this.rating = 1;
		this.dateTaken = "1901-01-01";
	}

	/**
	 * This method creates a Photo object given a filename, caption, dateTaken, and
	 * rating
	 * 
	 * @param filename  : String that Photo's filename will get set to
	 * @param caption   : String that Photo's caption will get set to
	 * @param dateTaken : String that Photo's dateTaken will get set to
	 * @param rating    : int that Photo's rating will get set to
	 */
	public Photo(String filename, String caption, String dateTaken, int rating) {
		this.filename = filename;
		this.caption = caption;
		if (DateLibrary.isValidDate(dateTaken) == true) {
			this.dateTaken = dateTaken;
		} else {
			this.dateTaken = "1901-01-01";
		}
		if (setRating(rating) == false) {
			this.rating = 1;
		}

	}

	// Accessors
	/**
	 * This method gives you the caption of a Photo
	 * 
	 * @return String : This is the value of the caption field of Photo
	 */
	public String getCaption() {
		return this.caption;
	}

	/**
	 * This method gives you the filename of a Photo
	 * 
	 * @return String : This is the value of the filename field of Photo
	 */
	public String getFilename() {
		return this.filename;
	}

	/**
	 * This method gives you the dateTaken of a Photo
	 * 
	 * @return String : This is the value of the dateTaken field of Photo
	 */
	public String getDateTaken() {
		return this.dateTaken;
	}

	/**
	 * This method gives you the rating of a Photo
	 * 
	 * @return int : This is the value of the rating field of Photo
	 */
	public int getRating() {
		return this.rating;
	}

	/**
	 * This method gives you the imageData of a BufferedImage
	 * 
	 * @return BufferedImage : This is the imageData for the BufferedImage
	 */
	public BufferedImage getImageData() {
		return this.imageData;
	}

	//Mutators
	/**
	 * This method sets the imageData of a BufferedImage
	 * 
	 * @param imageData : This is the imageData that the BufferedImage's imageData
	 * will be set to
	 */
	public void setImageData(BufferedImage imageData) {
		this.imageData = imageData;
	}

	// Other Methods
	/**
	 * This method sets the rating field of a Photo
	 * 
	 * @param newRating: int that rating will be set to
	 * @return boolean : This lets you know if the rating was set to newRating
	 */
	public boolean setRating(int newRating) {
		if (newRating <= 5 && newRating >= 1 && newRating != rating) {
			this.rating = newRating;
			return true;
		}
		return false;
	}

	/**
	 * This method says whether two photos are equal by comparing their filenames
	 * 
	 * @param o : This is an object, that will get casted to photo
	 * @return boolean : This tells you whether o is equal or not using photo
	 *         filename
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false; // null check
		}
		if (o instanceof Photo) { // are you a photo?
			Photo p2 = (Photo) o; // casting
			// now I can use p2 as a Photo
			if (this.filename.equals(p2.filename) && (this.caption.equals(p2.caption))) {
				return true;
			} else { // is not a Photo
				return false;
			}
		}
		return false;
	}

	// Override
	/**
	 * This method prints out the photo information
	 * 
	 * @return String : This is a string with all of the album information
	 *         (filename, caption, rating)
	 */
	public String toString() {
		return "<Filename: " + this.filename + ", " + "Caption: " + this.caption + ", Rating: " + this.rating + ">";
	}

	/**
	 * This method overrides the default hashCode method
	 * 
	 * @return int : This tells the photo's hashCode (by filename)
	 */
	public int hashCode() {
		return filename.hashCode();
	}

	/**
	 * This method compares two photo objects based on their dateTaken, and then
	 * returns the comparison of the photos' captions if they are even
	 * 
	 * @param p : This is a photo, that is used for the comparison
	 * @return int : This tells you the order based on either the dateTaken or the
	 *         caption
	 */
	public int compareTo(Photo p) {
		if (this.dateTaken.compareTo(p.getDateTaken()) == 0) {
			return this.caption.compareTo(p.getCaption());
		}
		return this.dateTaken.compareTo(p.getDateTaken());
	}

	/**
	 * This method loads the Image data from a file given the filename and lets you
	 * know whether it successfully did or not
	 * 
	 * @param filename : This is a string, that is the name of the file that will be
	 *                 loaded
	 * @return boolean : This tells you whether the image data was loaded
	 */
	public boolean loadImageData(String filename) {

		try {
			BufferedImage img = ImageIO.read(new File(filename));
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public static void main(String[] args) {

		Photo phot1 = new Photo("chickens", "cute baby chickens");
		Photo phot2 = new Photo("penguins", "two penguins eating fish", "2001-11-11", 4);
		Photo phot3 = new Photo("chickens", "cute baby chickens");
		System.out.println(phot1);
		System.out.println(phot2);
		System.out.println(phot3);

		// Testing the setRating
		System.out.println(phot1.setRating(8));
		System.out.println(phot1.setRating(2));
		System.out.println(phot1.setRating(2));

		// Testing the equals
		System.out.println(phot1.equals(phot2));
		System.out.println(phot1.equals(phot3));

		// Final values
		System.out.println(phot1);
		System.out.println(phot2);
		System.out.println(phot3);

	}

}
