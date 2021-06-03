/** * Homework 3
*Malde Aayush, asm7yaq
* Sources: TA office hours 
* Big Java book , ... 
*/

import java.util.ArrayList;

public abstract class PhotoContainer {

	// Fields
	/**
	 * A String containing the PhotoContainer’s name in whatever form it was
	 * provided.
	 */
	protected String name;
	/**
	 * An arrayList of photos in the container
	 */
	protected ArrayList<Photo> photos;

	// Constructor
	/**
	 * Takes in a name and create an PhotoContainer, also instantiates the photos ArrayList
	 * 
	 * @param name This is what the name of the album will be set to
	 */
	public PhotoContainer(String name) {
		this.name = name;
		photos = new ArrayList<Photo>();
	}
	// Accessors

	/**
	 * This method is a getter, and gives the PhotoContainer's name
	 * 
	 * @return name : This is the name of the PhotoContainer
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * This method is a getter, and gives the ArrayList photos
	 * 
	 * @return photos : This is the ArrayList that contains photo objects
	 */
	public ArrayList<Photo> getPhotos() {
		return this.photos;
	}

	// Mutators
	/**
	 * This method is a setter, and sets the PhotoContainer's name
	 * 
	 * @param name The name is what the PhotoContainer name will get set to
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method adds p to the list of photos if it was not already in that list,
	 * and tells you if it added it or not
	 * 
	 * @param p : This is a photo
	 * @return boolean : This tells you whether the method added a photo or not
	 */
	public boolean addPhoto(Photo p) {
		if (p == null) {
			return false;
		}
		if (photos.contains(p)) {
			return false;
		} else {
			photos.add(p);
			return true;
		}

	}

	/**
	 * This method tells you if the current object has p in its set of photos
	 * 
	 * @param p : This is a photo
	 * @return boolean : This tells you whether p is in photos or not
	 */
	public boolean hasPhoto(Photo p) {
		if (photos.contains(p)) {
			return true;
		}
		return false;
	}

	/**
	 * This method removes p from the PhotoContainer if it exists in the list of
	 * photos
	 * 
	 * @param p : This is a photo
	 * @return boolean : This tells you whether it removed p or not
	 */
	public boolean removePhoto(Photo p) {
		if (photos.contains(p)) {
			photos.remove(p);
			return true;
		}
		return false;
	}

	/**
	 * This method tells you the number of photos in the current PhotoContainer
	 * 
	 * @return int : This is the size of photos
	 */
	public int numPhotos() {
		return photos.size();
	}

	/**
	 * This method says whether two PhotoContainers are equal by comparing their
	 * names
	 * 
	 * @param o : This is an object, that will get casted to PhotoContainer
	 * @return boolean : This tells you whether o is equal or not using
	 *         PhotoContainer name
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false; // null check
		}
		if (o instanceof PhotoContainer) {
			PhotoContainer p2 = (PhotoContainer) o; // casting
			// now I can use p2 as an PhotoContainer
			if (this.name.equals(p2.name)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	/**
	 * This method prints out the PhotoContainer information
	 * 
	 * @return String : This is a string with all of the PhotoContainer information
	 *         (name, filenames)
	 */
	public String toString() {
		String temp = null;
		for (Photo p : photos) {
			temp = temp + p.getFilename() + ",";
		}
		return "<Name: " + this.name + "\n" + temp;
	}

	/**
	 * This method overrides the default hashCode method
	 * 
	 * @return int : This tells the PhotoContainer's hashCode (by name)
	 */
	public int hashCode() {
		return name.hashCode();
	}
	/**
	 * This method gets an arrayList of photos that have a rating greater or equal
	 * to the given parameter
	 * 
	 * @param rating Integer that the photos ratings must have or be greater than
	 * @return arrayList : It returns an arrayList of photos with rating >= rating
	 * that was passed in
	 */
	public ArrayList<Photo> getPhotos(int rating) {
		ArrayList<Photo> temp = new ArrayList<Photo>();
		if (rating > 5 || rating < 1) {
			return null;
		}
		for (Photo p : photos) {
			if (p.getRating() >= rating) {
				temp.add(p);
			}
		}
		return temp;
	}
	/**
	 * This method gets an arrayList of photos that have the same year as the
	 * given parameter
	 * 
	 * @param year Int that the photos' years must equal
	 * @return arrayList : It returns an arrayList of photos with photos' years equal to
	 * the year that was passed in
	 */
	public ArrayList<Photo> getPhotosInYear(int year) {
		ArrayList<Photo> temp = new ArrayList<Photo>();
		if (year > 9999 || year < 0) {
			return null;
		}
		for (Photo p : photos) {
			if (Integer.parseInt(p.getDateTaken().substring(0, 4)) == year) {
				temp.add(p);
			}
		}
		return temp;
	}
	/**
	 * This method gets an arrayList of photos that have the same month and year as the
	 * given month and year parameters
	 * 
	 * @param month Int that the photos' month (from dateTaken) must equal
	 * @param year Int that photos' year (from DateTaken) must equal
	 * 
	 * @return arrayList : It returns an arrayList of photos with photos' months
	 * and years equal to the month and year that was passed in
	 */
	public ArrayList<Photo> getPhotosInMonth(int month, int year) {
		ArrayList<Photo> temp = new ArrayList<Photo>();
		if (year > 9999 || year < 0 || month > 12 || month < 1) {
			return null;
		}
		for (Photo p : photos) {
			if (Integer.parseInt(p.getDateTaken().substring(0, 4)) == year
					&& Integer.parseInt(p.getDateTaken().substring(5, 7)) == month) {
				temp.add(p);
			}
		}
		return temp;
	}
	/**
	 * This method gets an arrayList of photos between the years as the
	 * two year parameters
	 * 
	 * @param beginDate Date that the photos' date (from dateTaken) must be after
	 * @param endDate Date that photos' date (from DateTaken) must be before
	 * 
	 * @return arrayList : It returns an arrayList of photos between the 
	 * dates that were passed in as parameters
	 */
	public ArrayList<Photo> getPhotosBetween(String beginDate, String endDate) {
		
		if(DateLibrary.isValidDate(beginDate) && DateLibrary.isValidDate(endDate) && DateLibrary.compare(beginDate, endDate) < 0 && beginDate != null && endDate != null) {
			ArrayList<Photo> temp = new ArrayList<Photo>();
			for (Photo p : photos) {
				if (DateLibrary.compare(p.getDateTaken(), beginDate) >= 0
						&& DateLibrary.compare(p.getDateTaken(), endDate) <= 0) {
					temp.add(p);
				}
			}
			return temp;
		}
		return null;
	}

}
