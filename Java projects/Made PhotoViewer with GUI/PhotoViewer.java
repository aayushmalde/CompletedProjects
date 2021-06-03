
/**
 * * Homework 4 
 * Malde Aayush, asm7yaq
 *  Sources: https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing
 *  /examples/layout/BorderLayoutDemoProject/src/layout/BorderLayoutDemo.java ,
 *  https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html
 *  https://stackoverflow.com/questions/11570356/jframe-in-full-screen-java
 *  https://stackoverflow.com/questions/16957329/borderlayout-center-doesnt-center
 * ...
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PhotoViewer extends JFrame {
	/**
	 * A PhotoContainer that is used by the myViewer in order to use the photo
	 * classes and upload photos as well as get properties
	 */
	private PhotoContainer imageLibrary;
	/**
	 * An integer called index that keeps track of the current photo, rating, and
	 * filename that is being displayed
	 */
	private int index = 0;
	/**
	 * This is the main panel in which the filename, previousButton, imgLabel, and
	 * nextButton will be on
	 */
	JPanel panel;
	/**
	 * This label will constantly be update to show the filename of the photo
	 */
	JLabel filenameLabel;
	/**
	 * This button is pressed by the user to view the previous photo
	 */
	JButton previousButton;
	/**
	 * This label will constantly be update to display the photo
	 */
	JLabel imgLabel;
	/**
	 * This button is pressed by the user to view the next photo
	 */
	JButton nextButton;
	/**
	 * This panel is at the bottom and has the captionLabel and ratingLabel
	 */
	JPanel bottomPanel;
	/**
	 * This label will constantly be update to show the caption of the photo
	 */
	JLabel captionLabel;
	/**
	 * This label will constantly be update to show the rating of the photo
	 */
	JLabel ratingLabel;
	/**
	 * This layout is used to put certain elements in concrete positions relative to
	 * each other, as supposed to the elements flowing
	 */
	BorderLayout layout;

	/**
	 * This constructor initializes the elements of the GUI
	 */
	public PhotoViewer() {
		// Assumptions made about what the buttons say
		panel = new JPanel();
		filenameLabel = new JLabel();
		filenameLabel.setHorizontalAlignment(JLabel.CENTER);
		previousButton = new JButton("Previous");
		imgLabel = new JLabel();
		nextButton = new JButton("Next");
		bottomPanel = new JPanel();
		captionLabel = new JLabel();
		ratingLabel = new JLabel();
		layout = new BorderLayout();
	}

	/**
	 * This method gets ImageLibrary, which is a PhotoContainer
	 * 
	 * @return imageLibrary : PhotoContainer that allows for access of photo
	 *         properties
	 */
	public PhotoContainer getImageLibrary() {
		return this.imageLibrary;
	}

	/**
	 * This method sets ImageLibrary, which is a PhotoContainer
	 * 
	 * @param imageLibrary : PhotoContainer that the current imageLibrary will be
	 *                     set to
	 */
	public void setImageLibrary(PhotoContainer imageLibrary) {
		this.imageLibrary = imageLibrary;
	}

	public static void main(String[] args) {

		PhotoViewer myViewer = new PhotoViewer();
		// the relative image directory (use one line from below)
		String imageDirectory = "images\\"; // for Windows

		// Creation of the photos and loading them using imageDirectory
		Photo p1 = new Photo(imageDirectory + "ronaldo.jpg", "Ronaldo", "1915-06-30", 2);
		p1.loadImageData(imageDirectory + "ronaldo.jpg");

		Photo p2 = new Photo(imageDirectory + "messi.jpg", "Messi", "1942-01-26", 1);
		p2.loadImageData(imageDirectory + "messi.jpg");

		Photo p3 = new Photo(imageDirectory + "ibra.jpg", "Ibra", "1990-11-18", 3);
		p3.loadImageData(imageDirectory + "ibra.jpg");

		Photo p4 = new Photo(imageDirectory + "diMaria.jpg", "DiMaria", "2002-06-04", 5);
		p4.loadImageData(imageDirectory + "diMaria.jpg");

		Photo p5 = new Photo(imageDirectory + "aguero.jpg", "Aguero", "2005-09-01", 4);
		p5.loadImageData(imageDirectory + "aguero.jpg");

		// Sets the imageLibrary and creates a library, which will
		// allow the imageLibrary to have access to Library methods and properties
		myViewer.setImageLibrary(new Library("Test Library", 1));

		// Adds the 5 photos to the imageLibrary of myViewer
		myViewer.getImageLibrary().addPhoto(p1);
		myViewer.getImageLibrary().addPhoto(p2);
		myViewer.getImageLibrary().addPhoto(p3);
		myViewer.getImageLibrary().addPhoto(p4);
		myViewer.getImageLibrary().addPhoto(p5);

		// use Collections.sort() to sort the photos based on the
		// written compareTo() method
		// Assumption is made that the photos should be sorted by date
		Collections.sort(myViewer.getImageLibrary().getPhotos());

		// Invoke and start the GUI
		javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI(myViewer));
	}

	/**
	 * This method sets myViewers components of the frame
	 * 
	 * @param myViewer : PhotoViewer whose JFrame properties are set
	 */
	public static void createAndShowGUI(PhotoViewer myViewer) {
		/**
		 * Assumption made that JFrame should be maximum size of screen possible
		 * Assumption made to have X option to close the frame
		 **/

		myViewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myViewer.addComponentsToPane(myViewer.getContentPane());
		myViewer.pack();
		myViewer.setVisible(true);
		myViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public void addComponentsToPane(Container pane) {

		/**
		 * This method implements the Next button by changing the photo and all of the
		 * properties to the next photo
		 * 
		 * All of the labels are updated to reflect the new properties
		 * 
		 * If the index is at 4, the photo goes back to index 0 so that the next button
		 * would "loop" back to the start
		 */
		class ButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().contentEquals("click")) {
					if (index != 4) {
						index++;
					} else {
						index = 0;
					}
					imgLabel.setIcon(new ImageIcon(imageLibrary.getPhotos().get(index).getFilename()));
					filenameLabel.setText("Filename: " + imageLibrary.getPhotos().get(index).getFilename());
					captionLabel.setText("Caption: " + imageLibrary.getPhotos().get(index).getCaption());
					ratingLabel.setText("Rating: " + imageLibrary.getPhotos().get(index).getRating());
				}
			}
		}
		/**
		 * This method implements the Previous button by changing the photo and all of
		 * the properties to the previous photo
		 * 
		 * All of the labels are updated to reflect the new properties
		 * 
		 * If the index is at 0, the photo goes back to index 4 so that the previous
		 * button would "loop" back to the end
		 */
		class ButtonListener2 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().contentEquals("click")) {
					if (index != 0) {
						index--;
					} else {
						index = 4;
					}
					imgLabel.setIcon(new ImageIcon(imageLibrary.getPhotos().get(index).getFilename()));
					filenameLabel.setText("Filename: " + imageLibrary.getPhotos().get(index).getFilename());
					captionLabel.setText("Caption: " + imageLibrary.getPhotos().get(index).getCaption());
					ratingLabel.setText("Rating: " + imageLibrary.getPhotos().get(index).getRating());
				}
			}
		}

		// add functional interface (ButtonListener) class to the next button
		ButtonListener listener = new ButtonListener();
		nextButton.setActionCommand("click");
		nextButton.addActionListener(listener);

		// add functional interface (ButtonListener) class to the previous button
		ButtonListener2 listener2 = new ButtonListener2();
		previousButton.setActionCommand("click");
		previousButton.addActionListener(listener2);

		/**
		 * This sets the initial labels to the values of the first photo
		 */

		imgLabel.setIcon(new ImageIcon(imageLibrary.getPhotos().get(index).getFilename()));
		filenameLabel.setText("Filename: " + imageLibrary.getPhotos().get(index).getFilename());
		captionLabel.setText("Caption: " + imageLibrary.getPhotos().get(index).getCaption());
		ratingLabel.setText("Rating: " + imageLibrary.getPhotos().get(index).getRating());

		/**
		 * Assumptions made about the layout/organization of the GUI
		 * 
		 * Assumed that the top should be the filename Assumed that the left should have
		 * the previousButton Assumed that the middle should have the image Assumed that
		 * the right should have the nextButton Assumed that the bottom should have the
		 * captionLabel and ratingLabel Assumed that the captionLabel should be to the
		 * left of the ratingLabel
		 */

		pane.add(panel);
		panel.setLayout(layout);
		panel.add(filenameLabel, BorderLayout.NORTH);
		panel.add(previousButton, BorderLayout.WEST);
		panel.add(imgLabel, BorderLayout.CENTER);
		panel.add(nextButton, BorderLayout.EAST);
		bottomPanel.add(captionLabel, BorderLayout.EAST);
		bottomPanel.add(ratingLabel, BorderLayout.WEST);
		panel.add(bottomPanel, BorderLayout.SOUTH);

	}
}
