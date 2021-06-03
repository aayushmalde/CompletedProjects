
/** * Homework 3
*Malde Aayush, asm7yaq
* Sources: TA office hours 
* Big Java book , ... 
*/

import java.util.Comparator;

public class PhotoRatingComparator implements Comparator<Photo> {
	/**
	 * This method implements the Comparable interface and compares two photos by
	 * rating If the ratings are identical, it compares them by caption
	 * 
	 * @param p  : This is a photo that will be compared
	 * @param p2 : This is a photo that will be compared
	 * @return int : This tells you the order of the photos
	 */

	public int compare(Photo p, Photo p2) {
		if (p.getRating() == (p2.getRating())) {
			return p.getCaption().compareTo(p2.getCaption());
		}
		return p2.getRating() - p.getRating();
	}

}
