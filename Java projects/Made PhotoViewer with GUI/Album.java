
/** * Homework 3
*Malde Aayush, asm7yaq
* Sources: TA office hours 
* Big Java book , ... 
*/

import java.util.ArrayList;

public class Album extends PhotoContainer {
	// Constructor
	/**
	 * Takes in a name and create an album, also instantiates the photos HashSet
	 * 
	 * @param name This is what the name of the album will be set to
	 */
	public Album(String name) {
		super(name);
		photos = new ArrayList<Photo>();
	}

}
