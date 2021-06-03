
/** * Homework 3
*Malde Aayush, asm7yaq
* Sources: TA office hours 
* Big Java book , ... 
*/
import java.util.ArrayList;
import java.util.HashSet;

public class Library extends PhotoContainer {

	// Fields

	/*
	 * This field gives an unchanging integer which helps identify the library
	 */
	private final int id;
	/*
	 * This is a HashSet of albums that contain photos
	 */
	private HashSet<Album> albums;

	/*
	 * This method is a constructor, and creates the library object
	 *
	 * @param name This is the name parameter of type String
	 * 
	 * @param id This is the id parameter of type int
	 * 
	 * @return This creates a library object, and sets the private variables equal
	 * to the parameters
	 */
	public Library(String name, int id) {
		super(name);
		this.id = id;
		photos = new ArrayList<Photo>();
		albums = new HashSet<Album>();
	}

	/*
	 * This method gets value of the HashSet albums
	 * 
	 * @return It returns the HashSet albums
	 */
	public HashSet<Album> getAlbums() {
		return this.albums;
	}

	/*
	 * This method gets value of the id
	 * 
	 * @return It returns the value of the private variable id
	 */
	public int getId() {
		return this.id;
	}

	/*
	 * Method that creates a new album with a name passed in
	 * 
	 * @param albumName String that the albums name is going to be set to
	 * 
	 * @return boolean : lets you know if album was created
	 */
	public boolean createAlbum(String albumName) {
		return albums.add(new Album(albumName));

	}

	/*
	 * This method removes an album with same name as passed in
	 * 
	 * @param month String that album's name will be compared to
	 * 
	 * @return boolean : Lets you know if album was removed or not
	 */
	public boolean removeAlbum(String albumName) {
		for (Album a : albums) {
			if (a.getName().equals(albumName) == true) {
				albums.remove(a);
				return true;
			}
		}
		return false;
	}

	/*
	 * Method that adds photo p to the album with albumName if the photo was not
	 * already in that album
	 * 
	 * @param p Photo that will be added
	 * 
	 * @param albumName String that the album's name will be compared to
	 * 
	 * @return boolean : lets you know if the photo was added to the album
	 */
	public boolean addPhotoToAlbum(Photo p, String albumName) {
		if (p == null || getAlbumByName(albumName) == null) {
			return false;
		}
		for (Album a : albums) {
			if (a.getName().equals(albumName) == true && photos.contains(p) == true && a.hasPhoto(p) == false) {
				a.addPhoto(p);
				return true;
			}
		}
		return false;
	}

	/*
	 * Method that removes photo p from the album with albumName if the photo was
	 * already in that album
	 * 
	 * @param p Photo that will be removed
	 * 
	 * @param albumName String that the album's name will be compared to
	 * 
	 * @return boolean : lets you know if the photo was removed from the album
	 */
	public boolean removePhotoFromAlbum(Photo p, String albumName) {
		for (Album a : albums) {
			if (a.getName().equals(albumName) == true) {
				return a.removePhoto(p);
			}
		}
		return false;
	}

	/*
	 * Method that returns album with name passed in from the set of albums
	 * 
	 * @param albumName String that the list of albums' name will be compared to
	 * 
	 * @return Album : gives you the album whose name is equal to albumName
	 */
	private Album getAlbumByName(String albumName) {
		for (Album a : albums) {
			if (a.getName().equals(albumName) == true) {
				return a;
			}
		}
		return null;
	}

	/*
	 * The method deletes the Photo p to the list of the current object’s photos
	 * feed if and only if it was already in that list.
	 * 
	 * @param p A photo that is to be removed
	 * 
	 * @return true or false boolean: lets you know if P was removed
	 */
	public boolean removePhoto(Photo p) {
		if (photos.contains(p)) {
			photos.remove(p);
			for (Album a : albums) {
				if (a.hasPhoto(p)) {
					a.removePhoto(p);
				}
			}
			return true;
		}
		return false;
	}

	/*
	 * The method evaluates if two Library objects are equal
	 * 
	 * @param p A library that is to be evaluated
	 * 
	 * @return true or false boolean: lets you know if P was equal based on id
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false; // null check
		}
		if (o instanceof Library) {
			Library p2 = (Library) o; // casting
			// now I can use p2 as a Library
			return (this.id == (p2.id));
		} else { // is not a Library
			return false;
		}
	}

	/*
	 * The method prints out the information of Library
	 * 
	 * @return String: lets you the Library's variable values and album names
	 */
	public String toString() {
		String temp = null;
		for (Album a : albums) {
			temp = temp + a.getName();
		}
		return "<Name: " + this.name + ", " + "Id: " + this.id + ", Photos: " + this.photos + "Album Names: " + temp
				+ ">";
	}

	/*
	 * The method returns the similar photos in two arrayLists
	 * 
	 * @param a A Library to be evaluated
	 * 
	 * @param b A Library to be evaluated
	 * 
	 * @return ArrayList: ArrayList of photos common to both
	 */
	public static ArrayList<Photo> commonPhotos(Library a, Library b) {
		ArrayList<Photo> same = new ArrayList<Photo>();

		for (int i = 0; i < a.numPhotos(); i++) {
			for (int x = 0; x < b.numPhotos(); x++) {
				if (a.photos.get(i).equals(b.photos.get(x))) {
					same.add(a.photos.get(i));
				}
			}
		}
		return same;
	}

	/*
	 * The method checks how similar they are
	 * 
	 * @param a A Library to be evaluated
	 * 
	 * @param b A Library to be evaluated
	 * 
	 * @return double: number of photos common to both
	 */
	public static double similarity(Library a, Library b) {
		if (a.photos.size() == 0) {
			return 0;
		}
		if (b.photos.size() == 0) {
			return 0;
		}
		if (a.photos.size() > b.photos.size()) {
			return ((double) commonPhotos(a, b).size()) / b.photos.size();
		}
		return ((double) commonPhotos(a, b).size()) / a.photos.size();
	}

	public static void main(String[] args) {

		Library lib = new Library("Library", 5);
		Photo p1 = new Photo("dogs", "dogs on a beach");
		Photo p2 = new Photo("cats", "cats in a basket");
		Photo p3 = new Photo("cats2", "kittens", "2001-12-12", 2);
		Photo p4 = new Photo("ducks", "ducks in a circle", "1997-08-02", 2);
		lib.addPhoto(p1);
		lib.addPhoto(p2);
		lib.addPhoto(p3);
		lib.addPhoto(p4);
		ArrayList<Photo> exp = new ArrayList<Photo>();
		exp.add(p4);
		System.out.println(lib.getPhotosInMonth(12, 12));

	}

}
