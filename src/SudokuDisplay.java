import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

@SuppressWarnings("serial")
public class SudokuDisplay extends JFrame implements ActionListener {
	/*
	 * SudokuDisplay.java 		Richard Addicott (ria4@aber.ac.uk)
	 * - This class contains the majority of the code that represents
	 * and creates the graphical user interface of the program. It uses
	 * JFrame features and ActionListeners to implement buttons, panels,
	 * graphics and text fields that the user can interact with and 
	 * effectively use the program.
	 */

	// Declaration of variables
	public JTextField load = new JTextField();
	public JPanel buttonPanel, gridPanel;
	public JButton loadButton, solveButton, clearButton;
	SudokuCanvas canvas;

	public SudokuDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Display - ria4"); // Title of GUI window

		buttonPanel = new JPanel();
		load = new JTextField(); 
		loadButton = new JButton("Load");
		clearButton = new JButton("Clear");
		solveButton = new JButton("Solve");
		// Declaration and addition of GUI elements to GUI
		buttonPanel.setLayout(new GridLayout(1,4));
		buttonPanel.add(load);			
		buttonPanel.add(loadButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(solveButton);
		// Add actionListeners to GUI elements
		loadButton.addActionListener(this);
		clearButton.addActionListener(this);
		solveButton.addActionListener(this);
		setLayout(new BorderLayout());
		add(buttonPanel, BorderLayout.NORTH);

		canvas = new SudokuCanvas();
		canvas.setBorder(BorderFactory.createLineBorder(Color.black,2));
		add(canvas, BorderLayout.CENTER);
		// Sets the size of the window and makes it visible
		setSize(380,430);
		setVisible(true);
	} // ends SudokuDisplay constructor


	public void actionPerformed(ActionEvent e) { // User interaction
		// Passes in the event e and chooses appropriate statement to call
		if (e.getSource() == loadButton) {
			try {
				canvas.loadSudoku(load.getText()); // Passes textfield data into loadSudoku method
			} catch (FileNotFoundException e1) {
				// Standard error handling
				System.out.println("File " + load.getText() + " not found. Please enter a valid file.");
			} catch (IOException e1) {
				if (load.getText() == null) {
					System.out.println("No text entered. Try again.");
				} else {
					// Valid
				}
			}
		}
		if (e.getSource() == clearButton) {
			canvas.clearSudoku();
		}
		if (e.getSource() == solveButton) {
			canvas.findPossibleCandidates();
		}
	} // ends actionPerformed method


} // ends SudokuDisplay class
