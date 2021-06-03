
/** * Homework 3
*Malde Aayush, asm7yaq
* Sources: TA office hours 
* Big Java book , ... 
*/

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

public class LibraryTest {

	/*
	 * The method tests getPhotos()
	 */

	@Test
	public void getPhotosTest() {
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
		exp.add(p3);
		exp.add(p4);
		assertEquals("fail", exp, lib.getPhotos(2));
	}

	/*
	 * The method tests getPhotos()
	 */
	@Test
	public void getPhotosTest2() {
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
		exp.add(p1);
		exp.add(p2);
		exp.add(p3);
		exp.add(p4);
		assertEquals("fail", exp, lib.getPhotos(1));
	}

	/*
	 * The method tests getPhotosinMonth()
	 */
	@Test
	public void getPhotosInMonth() {
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
		assertEquals("fail", exp, lib.getPhotosInMonth(11, 12));
	}

	/*
	 * The method tests getPhotosinMonth()
	 */
	@Test
	public void getPhotosInMonth2() {
		Library lib = new Library("Library", 5);
		Photo p1 = new Photo("dogs", "dogs on a beach");
		Photo p2 = new Photo("cats", "cats in a basket");
		Photo p3 = new Photo("cats2", "kittens", "2001-12-12", 2);
		Photo p4 = new Photo("ducks", "ducks in a circle", "1997-08-02", 2);
		lib.addPhoto(p1);
		lib.addPhoto(p2);
		lib.addPhoto(p3);
		lib.addPhoto(p4);
		assertEquals("fail", null, lib.getPhotosInMonth(31, 13));
	}

	/*
	 * The method tests getPhotosBetween()
	 */
	@Test
	public void getPhotosBetweenTest() {
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
		exp.add(p3);
		assertEquals("fail", exp, lib.getPhotosBetween("2000-12-12", "2002-12-12"));
	}

	/*
	 * The method tests getPhotosBetween()
	 */
	@Test
	public void getPhotosBetweenTest2() {
		Library lib = new Library("Library", 5);
		Photo p1 = new Photo("dogs", "dogs on a beach");
		Photo p2 = new Photo("cats", "cats in a basket");
		Photo p3 = new Photo("cats2", "kittens", "2001-12-12", 2);
		Photo p4 = new Photo("ducks", "ducks in a circle", "1997-08-02", 2);
		lib.addPhoto(p1);
		lib.addPhoto(p2);
		lib.addPhoto(p3);
		lib.addPhoto(p4);
		assertEquals("fail", null, lib.getPhotosBetween("2002-12-12", "2002-12-12"));
	}

	/*
	 * The method tests deletePhoto()
	 */
	@Test
	public void removePhotoTest() {
		Library lib = new Library("Library", 5);
		Photo p1 = new Photo("dogs", "dogs on a beach");
		Photo p2 = new Photo("cats", "cats in a basket");
		Photo p3 = new Photo("cats2", "kittens", "2001-12-12", 2);
		Photo p4 = new Photo("ducks", "ducks in a circle", "1997-08-02", 2);
		lib.addPhoto(p1);
		lib.addPhoto(p2);
		lib.addPhoto(p3);
		lib.addPhoto(p4);
		assertEquals("fail", true, lib.removePhoto(p3));
	}

	/*
	 * The method tests deletePhoto()
	 */
	@Test
	public void removePhotoTest2() {
		Library lib = new Library("Library", 5);
		Photo p1 = new Photo("dogs", "dogs on a beach");
		Photo p2 = new Photo("cats", "cats in a basket");
		Photo p3 = new Photo("cats2", "kittens", "2001-12-12", 2);
		Photo p4 = new Photo("ducks", "ducks in a circle", "1997-08-02", 2);
		lib.addPhoto(p1);
		lib.addPhoto(p2);
		lib.addPhoto(p3);
		assertEquals("fail", false, lib.removePhoto(p4));
	}

	/*
	 * The method tests similarity()
	 */
	@Test
	public void similarityTest() {
		Library lib = new Library("Library", 5);
		Photo p1 = new Photo("dogs", "dogs on a beach");
		Photo p2 = new Photo("cats", "cats in a basket");
		Photo p3 = new Photo("cats2", "kittens", "2001-12-12", 2);
		Photo p4 = new Photo("ducks", "ducks in a circle", "1997-08-02", 2);
		lib.addPhoto(p1);
		lib.addPhoto(p2);
		lib.addPhoto(p3);
		lib.addPhoto(p4);
		Library lib2 = new Library("Library 2", 4);
		lib2.addPhoto(p1);
		lib2.addPhoto(p2);
		assertEquals("fail", 1.0, Library.similarity(lib, lib2), 0.0000001);
	}

	/*
	 * The method tests similarity()
	 */
	@Test
	public void similarityTest2() {
		Library lib = new Library("Library", 5);
		Photo p1 = new Photo("dogs", "dogs on a beach");
		Photo p2 = new Photo("cats", "cats in a basket");
		Photo p3 = new Photo("cats2", "kittens", "2001-12-12", 2);
		Photo p4 = new Photo("ducks", "ducks in a circle", "1997-08-02", 2);
		lib.addPhoto(p1);
		lib.addPhoto(p2);
		Library lib2 = new Library("Library 2", 4);
		lib2.addPhoto(p3);
		lib2.addPhoto(p4);
		assertEquals("fail", 0.0, Library.similarity(lib, lib2), 0.0000001);
	}

	/*
	 * This method tests removePhoto()
	 */
	@Test
	public void testremovePhoto() {
		Library lib = new Library("Library", 5);
		Photo p1 = new Photo("dogs", "dogs on a beach");
		Photo p2 = new Photo("cats", "cats in a basket");
		Photo p3 = new Photo("cats2", "kittens", "2001-12-12", 2);
		Photo p4 = new Photo("ducks", "ducks in a circle", "1997-08-02", 2);
		lib.addPhoto(p1);
		lib.addPhoto(p2);
		lib.addPhoto(p3);
		lib.addPhoto(p4);
		assertEquals("fail", true, lib.removePhoto(p3));
	}

	/*
	 * This method tests removePhoto()
	 */
	@Test
	public void testremovePhoto2() {
		Library lib = new Library("Library", 5);
		Photo p1 = new Photo("dogs", "dogs on a beach");
		Photo p2 = new Photo("cats", "cats in a basket");
		Photo p3 = new Photo("cats2", "kittens", "2001-12-12", 2);
		Photo p4 = new Photo("ducks", "ducks in a circle", "1997-08-02", 2);
		lib.addPhoto(p1);
		lib.addPhoto(p2);
		lib.addPhoto(p3);
		assertEquals("fail", false, lib.removePhoto(p4));
	}

	/*
	 * This method tests compareTo()
	 */
	@Test
	public void testcompareTo() {
		Photo p1 = new Photo("dogs", "dogs on a beach");
		Photo p2 = new Photo("cats", "cats in a basket");
		assertEquals("fail", 1, p1.compareTo(p2));
	}
	/*
	 * This method tests compareTo()
	 */
	@Test
	public void testcompareTo2() {
		Photo p1 = new Photo("dogs", "dogs on a beach");
		Photo p2 = new Photo("cats", "cats in a basket");
		assertEquals("fail", -1, p2.compareTo(p1));
	}
	/*
	 * This method tests PhotoCaption's compare()
	 */
	@Test
	public void testcompare() {
		Photo p1 = new Photo("dogs", "dogs on a beach");
		Photo p2 = new Photo("cats", "cats in a basket");
		PhotoCaptionComparator c = new PhotoCaptionComparator();
		assertEquals("fail", 1 ,c.compare(p1, p2));

	}
	/*
	 * This method tests PhotoCaption's compare)
	 */
	@Test
	public void testcompare2() {
		Photo p3 = new Photo("cats", "cats in a basket", "2001-12-12", 2);
		Photo p2 = new Photo("cats", "cats in a basket");
		PhotoCaptionComparator c = new PhotoCaptionComparator();
		assertEquals("fail", -1 ,c.compare(p3, p2));
	}
	/*
	 * This method tests PhotoRating's compare()
	 */
	@Test
	public void testcompare3() {
		Photo p1 = new Photo("dogs", "dogs on a beach");
		Photo p2 = new Photo("cats", "cats in a basket");
		PhotoRatingComparator c = new PhotoRatingComparator();
		assertEquals("fail", 1 ,c.compare(p1, p2));

	}
	/*
	 * This method tests PhotoRating's compare)
	 */
	@Test
	public void testcompare4() {
		Photo p3 = new Photo("cats", "cats in a basket", "2001-12-12", 2);
		Photo p2 = new Photo("cats", "cats in a basket");
		PhotoRatingComparator c = new PhotoRatingComparator();
		assertEquals("fail", -1 ,c.compare(p3, p2));
	}

}
