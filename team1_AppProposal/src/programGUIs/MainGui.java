package programGUIs;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.InputMismatchException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import engineeringEconomicsCalculator.Annuity;
import engineeringEconomicsCalculator.CompoundInterest;
import engineeringEconomicsCalculator.SimpleInterest;
import polynomialDerivativesCalculator.Polynomial;
import resistorCalculator.FiveBandResistor;
import resistorCalculator.FourBandResistor;
import resistorCalculator.Resistors;
import statisticsCalculator.StatisticsOperations;
import statisticsCalculator.Population;
import statisticsCalculator.Sample;

public class MainGui {
	static JFrame mainMenu, resistorColorCodeMainFrame, derivativesMainFrame, economicsMainFrame, statisticsMainFrame;
	static JLabel title, subtitle, resistorTitle, derivativesTitle;
	static JButton resistorButton,derivativesButton,economicsButton,statisticsButton,exitButton;
	static Icon[] buttonIcons = {
		    new ImageIcon(MainGui.class.getResource("/resistorIcon.png")),
		    new ImageIcon(MainGui.class.getResource("/derivativesIcon.png")),
		    new ImageIcon(MainGui.class.getResource("/economicsIcon.png")),
		    new ImageIcon(MainGui.class.getResource("/statisticsIcon.png"))
		};
	
	public static void main (String[] args) {
		addComponentsOnMainWindow();
		mainMenu.setVisible(true);
		mainMenu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		chooseSelection(); 
		
		exitButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int choice = JOptionPane.showConfirmDialog(
							null,
							"Are you sure you want to exit the application?",
							"Exiting Application", 
							JOptionPane.YES_NO_OPTION
							);
					if (choice == JOptionPane.YES_OPTION) {
						mainMenu.dispose();
					}
				}
			}
		);
		
		mainMenu.addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent windowEvent) {
					int choice = JOptionPane.showConfirmDialog(
							null,
							"Are you sure you want to exit the application?",
							"Exit Application",
							JOptionPane.YES_NO_OPTION
							);
					if (choice == JOptionPane.YES_OPTION) {
						mainMenu.dispose();
					}
				}
			}
		);
		
	}
	
	public static void addComponentsOnMainWindow() {
		mainMenu = createCustomJFrame(mainMenu, "Engineering Calculator", 675,750, new GridBagLayout());
		title = createCustomLabel(title, "ENGINEERING CALCULATOR", 40, "Cambria", Font.BOLD);
		subtitle = createCustomLabel(subtitle, "for your engineering needs.", 18, "Product Sans", Font.PLAIN);
		
		mainMenu.add(title, setConstraints(0,0,2,0,0,0,0,GridBagConstraints.CENTER, 0));
		mainMenu.add(subtitle, setConstraints(0,1,2,-10 ,0,0,20,GridBagConstraints.CENTER, 0));
		
		resistorButton = new JButton(buttonIcons[0]);
		derivativesButton = new JButton(buttonIcons[1]);
		economicsButton = new JButton(buttonIcons[2]);
		statisticsButton = new JButton(buttonIcons[3]);
		
		exitButton = new JButton();
		exitButton.setText("EXIT APPLICATION");
		exitButton.setPreferredSize(new Dimension(300,25));
	
		resistorButton.setFocusable(false);
		derivativesButton.setFocusable(false);
		economicsButton.setFocusable(false);
		statisticsButton.setFocusable(false);
		exitButton.setFocusable(false);
		
		mainMenu.add(resistorButton, setConstraints(0,2,1,0,0,0,0,GridBagConstraints.CENTER, 0));
		mainMenu.add(derivativesButton, setConstraints(1,2,1,0,0,0,0,GridBagConstraints.CENTER, 0));
		mainMenu.add(economicsButton, setConstraints(0,3,1,0,0,0,0,GridBagConstraints.CENTER, 0));
		mainMenu.add(statisticsButton, setConstraints(1,3,1,0,0,0,0,GridBagConstraints.CENTER, 0));
		mainMenu.add(exitButton, setConstraints(0,4,2,0,0,20,0,GridBagConstraints.CENTER, 0));
	}
	
	public static void addComponentsOnResistorColorCodeMainFrame() {
		resistorTitle = createCustomLabel(resistorTitle, "RESISTOR COLOR CODE", 40, "Cambria", Font.BOLD);
		resistorColorCodeMainFrame.add(resistorTitle, setConstraints(0,0,1,0,0,0,0,GridBagConstraints.CENTER, 0));
		
		JButton threeBand = new JButton("Three-Band");
		JButton fourBand = new JButton("Four-Band");
		JButton fiveBand = new JButton("Five-Band");
		JButton backToMenu = new JButton();
		
		threeBand.setPreferredSize(new Dimension (300,50));
		fourBand.setPreferredSize(new Dimension (300,50));
		fiveBand.setPreferredSize(new Dimension (300,50));
		
		threeBand.setFocusable(false);
		fourBand.setFocusable(false);
		fiveBand.setFocusable(false);
		
		resistorColorCodeMainFrame.add(threeBand, setConstraints(0,1,1,0,0,20,5,GridBagConstraints.CENTER, 0));
		resistorColorCodeMainFrame.add(fourBand, setConstraints(0,2,1,0,0,5,5,GridBagConstraints.CENTER, 0));
		resistorColorCodeMainFrame.add(fiveBand, setConstraints(0,3,1,0,0,5,0,GridBagConstraints.CENTER, 0));
		
		JFrame threeBandResistorFrame = createCustomJFrame(new JFrame(), "Resistor Color Code | Three-Band Resistor", 500, 500, new GridBagLayout());
		addToThreeBandResistorJFrame(threeBandResistorFrame);
		chooseResistorType(threeBand,threeBandResistorFrame);
		
		JFrame fourBandResistorFrame = createCustomJFrame(new JFrame(), "Resistor Color Code | Four-Band Resistor", 500, 500, new GridBagLayout());
		addToFourBandResistorJFrame(fourBandResistorFrame);
		chooseResistorType(fourBand,fourBandResistorFrame);
		
		JFrame fiveBandResistorFrame = createCustomJFrame(new JFrame(), "Resistor Color Code | Five-Band Resistor", 500, 500, new GridBagLayout());
		addToFiveBandResistorJFrame(fiveBandResistorFrame);
		chooseResistorType(fiveBand,fiveBandResistorFrame);
		
		backToMenu.setText("BACK TO MENU");
		backToMenu.setFocusable(false);
		resistorColorCodeMainFrame.add(backToMenu, setConstraints(0,4,1,0,0,50,0,GridBagConstraints.CENTER, 0));
		
		exitCalculatorFrame(resistorColorCodeMainFrame, backToMenu); 
	}

	public static void addComponentsOnDerivativesMainFrame() {
		derivativesTitle = createCustomLabel(derivativesTitle, "POLYNOMIAL DERIVATIVES", 40, "Cambria", Font.BOLD);
		derivativesMainFrame.add(derivativesTitle, setConstraints(0,0,1,0,0,0,30,GridBagConstraints.CENTER, 0));
		
		JLabel[] labels = new JLabel[2];	
		String[] labelTexts = { "Enter Polynomial Equation",
				"Derivative of the Polynomial"
				};
		
		JTextField polynomial = new JTextField();
		JLabel derivativeEquation;
		
		polynomial.setPreferredSize(new Dimension(400,25));
		
		for (int i = 0 ; i < labels.length ; i++) {
			labels[i] = createCustomLabel(labels[i], labelTexts[i], 15, "Courier New", Font.BOLD);
			derivativesMainFrame.add(labels[i], setConstraints(0,2*(i+1)-1,1,0,0,0,0,GridBagConstraints.CENTER, 0));	
		}
		
		derivativeEquation = createCustomLabel(new JLabel(), "- - -", 15, "Arial", Font.BOLD);
		
		derivativesMainFrame.add(polynomial, setConstraints(0,2,1,0,0,0,10,GridBagConstraints.CENTER, 0));
		derivativesMainFrame.add(derivativeEquation, setConstraints(0,4,1,0,0,0,10,GridBagConstraints.CENTER, 0));
		
		JButton calculateButton = new JButton("Calculate Derivatives");
		derivativesMainFrame.add(calculateButton, setConstraints(0,5,1,0,0,0,0,GridBagConstraints.CENTER, 0));
		
		calculateButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Polynomial polyEquation = new Polynomial();
					if (polynomial.getText().isBlank() == true) {
						JOptionPane.showMessageDialog(
								null, 
								"No Input. Please enter a polynomial equation to be derived", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					try {
						polyEquation.setOrigPolynomialEquation(polynomial.getText());
						polyEquation.getPolynomialEquationFromArray();
						derivativeEquation.setText("" + polyEquation.calculateDerivedEquation());
						
					} catch (NumberFormatException | InputMismatchException ex) {
						JOptionPane.showMessageDialog(
								null, 
								"Invalid Input. All variables must be in 'x', and make sure to follow the format 'ax^n' for every term", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
				}
			}
		);
		JButton clearInputs = new JButton("Clear Frame");
		derivativesMainFrame.add(clearInputs, setConstraints(0,7,2,0,0,5,0,GridBagConstraints.CENTER, 0));
		clearInputs.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					polynomial.setText(null);
					derivativeEquation .setText("- - -");
				}
			}
		);
		
		calculateButton.setPreferredSize(new Dimension(250,25));
		clearInputs.setPreferredSize(new Dimension(250,25));
		
		JButton backToMenu = new JButton("BACK TO MENU");
		backToMenu.setFocusable(false);
		derivativesMainFrame.add(backToMenu, setConstraints(0,8,1,0,0,30,0,GridBagConstraints.CENTER, 0));
		
		exitCalculatorFrame(derivativesMainFrame, backToMenu); 
	}
	
	public static void addComponentsOnEconomicsMainFrame() {
		JLabel economicsTitle = createCustomLabel(new JLabel(), "ENGINEERING ECONOMICS", 40, "Cambria", Font.BOLD);
		economicsMainFrame.add(economicsTitle, setConstraints(0,0,1,0,0,0,30,GridBagConstraints.CENTER, 0));
		
		JButton simpleAndCompoundInterest = new JButton("Simple and Compound Interest");
		JButton annuity = new JButton("Annuity");
		
		simpleAndCompoundInterest.setPreferredSize(new Dimension (250,35));
		annuity.setPreferredSize(new Dimension (250,35));
		
		economicsMainFrame.add(simpleAndCompoundInterest,setConstraints(0,1,1,0,0,0,5,GridBagConstraints.CENTER, 0));
		economicsMainFrame.add(annuity,setConstraints(0,2,1,0,0,0,5,GridBagConstraints.CENTER, 0));
		
		JFrame interestsFrame = createCustomJFrame(new JFrame(), "Engineering Economics | Simple and Compound Interest",800,700,new GridBagLayout());
		addToInterestsFrame(interestsFrame);
		chooseEconomicCalculation(simpleAndCompoundInterest, interestsFrame);
		
		JFrame annuityFrame = createCustomJFrame(new JFrame(), "Engineering Economics | Annuity",800,700,new GridBagLayout()); 
		addToAnnuityFrame(annuityFrame);
		chooseEconomicCalculation(annuity, annuityFrame);
		
		JButton backToMenu = new JButton("BACK TO MENU");
		backToMenu.setFocusable(false);
		economicsMainFrame.add(backToMenu, setConstraints(0,3,1,0,0,30,0,GridBagConstraints.CENTER, 0));
		
		exitCalculatorFrame(economicsMainFrame, backToMenu);
	}
	
	public static void addComponentsOnStatisticsMainFrame() {
		JLabel statisticsTitle = createCustomLabel(new JLabel(), "SIMPLE STATISTICS", 40, "Cambria", Font.BOLD);
		statisticsMainFrame.add(statisticsTitle, setConstraints(0,0,2,0,0,0,30,GridBagConstraints.CENTER, 0));
		
		JLabel dataLabel = createCustomLabel(new JLabel(), "Enter Data Here: ", 15, "Courier New", Font.BOLD);
		JLabel dataLabelSubtitle = createCustomLabel(new JLabel(), "Note: press the 'spacebar' key to separate the different data", 12, "Courier New", Font.PLAIN);
		JTextField Data = new JTextField();
		JButton getData = new JButton("Get Statistics");
		JLabel[] propertiesLabel = new JLabel[10];
		String[] labels = {"Minimum: ", "Maximum: ", "Range: ", "Mean: ", "Median: ", "Mode: ", "Pop. Variance: ", "Pop. Std. Dev.: ", "Sample Variance: ", "Sample Std. Dev.: "};
		JLabel[] properties = new JLabel[10];
		
		statisticsMainFrame.add(dataLabel, setConstraints(0,1,1,0,0,2,2,GridBagConstraints.EAST, 0));
		statisticsMainFrame.add(dataLabelSubtitle, setConstraints(0,2,2,0,0,0,5,GridBagConstraints.CENTER, 0));
		statisticsMainFrame.add(Data, setConstraints(1,1,1,5,0,2,2,GridBagConstraints.WEST, 0));
		statisticsMainFrame.add(getData, setConstraints(0,3,2,0,0,10,10,GridBagConstraints.CENTER, 0));
		
		Data.setPreferredSize(new Dimension(300,25));
		
		for (int i = 0 ; i < labels.length ; i++) {
			propertiesLabel[i] = createCustomLabel(propertiesLabel[i], labels[i], 15, "Courier New", Font.BOLD);
			properties[i] = createCustomLabel(properties[i], "- - -", 15, "Courier New", Font.BOLD);
			
			statisticsMainFrame.add(propertiesLabel[i], setConstraints(0,i+4,1,5,0,2,2,GridBagConstraints.EAST, 0));	
			statisticsMainFrame.add(properties[i], setConstraints(1,i+4,1,5,0,2,2,GridBagConstraints.WEST, 0));
		}
		
		getData.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					StatisticsOperations sample = new Sample();
					StatisticsOperations population = new Population();
					
					try{
						String input = Data.getText();
		                String[] dataArray = input.split(" ");
		                for (String numbers : dataArray) {
		                    double number = Double.parseDouble(numbers);
		                    sample.setDatum(number);
		                    population.setDatum(number);
		                }
		            } catch ( NumberFormatException | InputMismatchException ex) {
		            	JOptionPane.showMessageDialog(
								null, 
								"Invalid input format. Please enter valid numbers.", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
		            }
					
	                
	                properties[0].setText("" + sample.getMinimum());
	                properties[1].setText("" + population.getMaximum());
	                properties[2].setText("" + sample.getRange()); 
	                properties[3].setText("" + population.getMean());
	                properties[4].setText("" + sample.getMedian());
	                properties[5].setText("" + population.getMode());
	                properties[6].setText("" + population.getVariance());
	                properties[7].setText("" + population.getStandardDeviation());
	                properties[8].setText("" + sample.getVariance());
	                properties[9].setText("" + sample.getStandardDeviation());
				}
			}
		);
		
		JButton backToMenu = new JButton("BACK TO MENU");
		backToMenu.setFocusable(false);
		statisticsMainFrame.add(backToMenu, setConstraints(0,15,2,0,0,20,0,GridBagConstraints.CENTER, 0));
		
		exitCalculatorFrame(statisticsMainFrame, backToMenu);
	}
	
	public static void chooseSelection() {
		resistorButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					resistorColorCodeMainFrame = createCustomJFrame(resistorColorCodeMainFrame, "Resistor Color Code", 600,450, new GridBagLayout());
					addComponentsOnResistorColorCodeMainFrame();
					resistorColorCodeMainFrame.setVisible(true);
					mainMenu.setVisible(false);
				}
			}
		);
		derivativesButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					derivativesMainFrame = createCustomJFrame(derivativesMainFrame, "Simple Polynomial Derivatives", 625,425, new GridBagLayout());
					addComponentsOnDerivativesMainFrame();
					derivativesMainFrame.setVisible(true);
					mainMenu.setVisible(false);
				}
			}
		);
		economicsButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					economicsMainFrame = createCustomJFrame(economicsMainFrame, "Engineering Economics", 625,375, new GridBagLayout());
					addComponentsOnEconomicsMainFrame();
					economicsMainFrame.setVisible(true);
					mainMenu.setVisible(false);
				}
			}
		);
		statisticsButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					statisticsMainFrame = createCustomJFrame(statisticsMainFrame, "Engineering Statistics", 625,500, new GridBagLayout());
					addComponentsOnStatisticsMainFrame();
					statisticsMainFrame.setVisible(true);
					mainMenu.setVisible(false);
				}
			}
		);
	}
	
	public static void chooseResistorType(JButton button,JFrame frame) {
		button.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(true);
					resistorColorCodeMainFrame.setVisible(false);
				}
			}
		);
	}
	
	public static void chooseEconomicCalculation(JButton button, JFrame frame) {
		button.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(true);
					economicsMainFrame.setVisible(false);
				}
			}
		);
	}
	
	public static void addToThreeBandResistorJFrame(JFrame frame) {
		JLabel titleOfFrame = createCustomLabel(new JLabel(), "THREE-BAND RESISTOR", 30, "Cambria", Font.BOLD);
		JLabel bandLabels[] = new JLabel[3];		
		JLabel properties[] = new JLabel[3];
		JLabel tolerances[] = new JLabel[2];
		String propertiesLabel[] = {"Resistance: ", "Minimum: ", "Maximum: "};
		JTextField resistance = new JTextField();
		
		frame.add(titleOfFrame,setConstraints(0,0,2,0,0,0,20,GridBagConstraints.CENTER, 0));
		
		for (int i = 0; i < bandLabels.length; i++) {
			bandLabels[i] = createCustomLabel(bandLabels[i], "Band " + (i+1) + ": ", 15, "Courier New", Font.BOLD);
			frame.add(bandLabels[i], setConstraints(0,i+2,1,0,0,2,2,GridBagConstraints.EAST, 0));
		}
		
		for (int i = 0; i < properties.length; i++) {
			bandLabels[i] = createCustomLabel(properties[i], propertiesLabel[i], 15, "Courier New", Font.BOLD);
			frame.add(bandLabels[i], setConstraints(0,i+6,1,0,0,2,2,GridBagConstraints.EAST, 0));
		}
		
		for (int i = 0; i < tolerances.length; i++) {
			tolerances[i] = createCustomLabel(tolerances[i], "- - -", 15, "Arial", Font.PLAIN);
			frame.add(tolerances[i], setConstraints(1,i+7,1,0,0,2,2,GridBagConstraints.WEST, 0));
		}
		
		String[] colorChoices1 = {"","Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Grey", "White", "Gold", "Silver"};
		final JComboBox<String> bandChoice1 = new JComboBox<String>(colorChoices1);
		final JComboBox<String> bandChoice2 = new JComboBox<String>(colorChoices1);
		final JComboBox<String> bandChoice3 = new JComboBox<String>(colorChoices1);
		
		bandChoice1.setPreferredSize(new Dimension(200,25));
		bandChoice2.setPreferredSize(new Dimension(200,25));
		bandChoice3.setPreferredSize(new Dimension(200,25));
		resistance.setPreferredSize(new Dimension(200,25));
		
		frame.add(bandChoice1,setConstraints(1,2,1,0,0,0,0,GridBagConstraints.WEST, 0));
		frame.add(bandChoice2,setConstraints(1,3,1,0,0,0,0,GridBagConstraints.WEST, 0));
		frame.add(bandChoice3,setConstraints(1,4,1,0,0,0,0,GridBagConstraints.WEST, 0));
		frame.add(resistance, setConstraints(1,6,1,0,0,0,0,GridBagConstraints.WEST, 0));
		
		JButton calculateButton = new JButton("Calculate Resistance");
		frame.add(calculateButton, setConstraints(0,5,2,0,0,10,10,GridBagConstraints.CENTER, 0));
		
		JButton getColorCodes = new JButton("Get Color Codes");
		frame.add(getColorCodes, setConstraints(0,9,2,0,0,10,5,GridBagConstraints.CENTER, 0));
		
		JButton clearInputs = new JButton("Clear Frame");
		frame.add(clearInputs, setConstraints(0,10,2,0,0,0,10,GridBagConstraints.CENTER, 0));
		
		calculateButton.setPreferredSize(new Dimension(250,25));
		getColorCodes.setPreferredSize(new Dimension(250,25));
		clearInputs.setPreferredSize(new Dimension(250,25));
		
		calculateButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (bandChoice1.getSelectedItem().toString().equalsIgnoreCase("") || bandChoice2.getSelectedItem().toString().equalsIgnoreCase("") || bandChoice3.getSelectedItem().toString().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(
								null, 
								"Bands cannot be empty. Please select a color for each band.", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					if (bandChoice1.getSelectedItem().toString().equalsIgnoreCase("Black")) {
						JOptionPane.showMessageDialog(
								null, 
								"Band 1 cannot be 'Black'. Please select another color.", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					String colors[] = {	bandChoice1.getSelectedItem().toString(),
							bandChoice2.getSelectedItem().toString(),
							bandChoice3.getSelectedItem().toString(),
							"None"
						  };
					Resistors resistor = new FourBandResistor(colors);
					resistance.setText("" + resistor.getResistance());
					tolerances[0].setText("" + resistor.getMinimumRange());
					tolerances[1].setText("" + resistor.getMaximumRange());
					
				}
			}
		);
		
		getColorCodes.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					double resistanceValue;
					FourBandResistor resistor = new FourBandResistor();
					try{
						resistanceValue = Double.parseDouble(resistance.getText());
						resistor.setColorUsingDigits(resistanceValue);
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(
								null, 
								"Invalid Input. Enter numerical values only", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					double checker = 0;
					if (resistanceValue >= 10000){
						while (resistanceValue >= 10000) {
							resistanceValue = resistanceValue/10;
						}
					}
					
					if (resistanceValue >= 1000) {
						checker = resistanceValue%100;
					} else if (resistanceValue >= 100) {
						checker = resistanceValue%10;
					} else if (resistanceValue >= 10) {
						checker = (resistanceValue*10)%10;
					} else if (resistanceValue >= 1) {
						checker = (resistanceValue*100)%10;
					} else if (resistanceValue < 0.10) {
						checker = -1;
					}
					
					if (checker != 0) {
						JOptionPane.showMessageDialog(
								null, 
								"Invalid Input. Inputted resistance value is impossible in 3-band resistors.", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					
					
					String colors[] = resistor.getColorsArray();
					for (int i = 1; i < bandChoice1.getItemCount(); i++) {
						if (colors[0].equalsIgnoreCase(bandChoice1.getItemAt(i))) {
							bandChoice1.setSelectedIndex(i);
						}
						if (colors[1].equalsIgnoreCase(bandChoice2.getItemAt(i))) {
							bandChoice2.setSelectedIndex(i);
						}
						if (colors[2].equalsIgnoreCase(bandChoice3.getItemAt(i))) {
							bandChoice3.setSelectedIndex(i);
						}
					}
					tolerances[0].setText("" + resistor.getMinimumRange());
					tolerances[1].setText("" + resistor.getMaximumRange());
				}
			}
		);
		
		clearInputs.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bandChoice1.setSelectedIndex(0);
					bandChoice2.setSelectedIndex(0);
					bandChoice3.setSelectedIndex(0);
					resistance.setText(null);
					tolerances[0].setText("- - -");
					tolerances[1].setText("- - -");
				}
			}
		);
		
		JButton goBack = new JButton("GO BACK");
		goBack.setFocusable(false);
		frame.add(goBack, setConstraints(0,11,2,0,0,25,0,GridBagConstraints.CENTER, 0));
		goBack.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					resistorColorCodeMainFrame.setVisible(true); 
				}
			}
		);
		frame.addWindowListener(
			new WindowAdapter(){
				public void windowClosed(WindowEvent windowEvent) {
					resistorColorCodeMainFrame.setVisible(true);
				}
			}
		);
	}
	
	public static void addToFourBandResistorJFrame(JFrame frame) {
		JLabel titleOfFrame = createCustomLabel(new JLabel(), "FOUR-BAND RESISTOR", 30, "Cambria", Font.BOLD);
		JLabel bandLabels[] = new JLabel[4];		
		JLabel properties[] = new JLabel[4];
		JLabel tolerances[] = new JLabel[2];
		String propertiesLabel[] = {"Resistance: ","Tolerance: ","Minimum: ", "Maximum: "};
		JTextField resistance = new JTextField();
		
		
		frame.add(titleOfFrame,setConstraints(0,0,2,0,0,0,20,GridBagConstraints.CENTER, 0));
		
		for (int i = 0; i < bandLabels.length; i++) {
			bandLabels[i] = createCustomLabel(bandLabels[i], "Band " + (i+1) + ": ", 15, "Courier New", Font.BOLD);
			frame.add(bandLabels[i], setConstraints(0,i+2,1,0,0,2,2,GridBagConstraints.EAST, 0));
		}
		
		for (int i = 0; i < properties.length; i++) {
			bandLabels[i] = createCustomLabel(properties[i], propertiesLabel[i], 15, "Courier New", Font.BOLD);
			frame.add(bandLabels[i], setConstraints(0,i+7,1,0,0,2,2,GridBagConstraints.EAST, 0));
		}
		
		for (int i = 0; i < tolerances.length; i++) {
			tolerances[i] = createCustomLabel(tolerances[i], "- - -", 15, "Arial", Font.PLAIN);
			frame.add(tolerances[i], setConstraints(1,i+9,1,0,0,2,2,GridBagConstraints.WEST, 0));
		}
		
		String[] colorChoices1 = {"","Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Grey", "White", "Gold", "Silver"};
		String[] colorChoices2 = {"None","Gold", "Silver"};
		String[] toleranceValues = {"0.20","0.05","0.10"};
		final JComboBox<String> bandChoice1 = new JComboBox<String>(colorChoices1);
		final JComboBox<String> bandChoice2 = new JComboBox<String>(colorChoices1);
		final JComboBox<String> bandChoice3 = new JComboBox<String>(colorChoices1);
		final JComboBox<String> bandChoice4 = new JComboBox<String>(colorChoices2);
		final JComboBox<String> tolerance = new JComboBox<String>(toleranceValues);
		
		bandChoice1.setPreferredSize(new Dimension(200,25));
		bandChoice2.setPreferredSize(new Dimension(200,25));
		bandChoice3.setPreferredSize(new Dimension(200,25));
		bandChoice4.setPreferredSize(new Dimension(200,25));
		resistance.setPreferredSize(new Dimension(200,25));
		tolerance.setPreferredSize(new Dimension(200,25));
		
		frame.add(bandChoice1,setConstraints(1,2,1,0,0,0,0,GridBagConstraints.WEST, 0));
		frame.add(bandChoice2,setConstraints(1,3,1,0,0,0,0,GridBagConstraints.WEST, 0));
		frame.add(bandChoice3,setConstraints(1,4,1,0,0,0,0,GridBagConstraints.WEST, 0));
		frame.add(bandChoice4,setConstraints(1,5,1,0,0,0,0,GridBagConstraints.WEST, 0));
		frame.add(resistance, setConstraints(1,7,1,0,0,0,0,GridBagConstraints.WEST, 0));
		frame.add(tolerance, setConstraints(1,8,1,0,0,0,0,GridBagConstraints.WEST, 0));
		
		JButton calculateButton = new JButton("Calculate Resistance");
		frame.add(calculateButton, setConstraints(0,6,2,0,0,10,10,GridBagConstraints.CENTER, 0));
		
		JButton getColorCodes = new JButton("Get Color Codes");
		frame.add(getColorCodes, setConstraints(0,11,2,0,0,10,5,GridBagConstraints.CENTER, 0));
		
		JButton clearInputs = new JButton("Clear Frame");
		frame.add(clearInputs, setConstraints(0,12,2,0,0,0,10,GridBagConstraints.CENTER, 0));
		
		calculateButton.setPreferredSize(new Dimension(250,25));
		getColorCodes.setPreferredSize(new Dimension(250,25));
		clearInputs.setPreferredSize(new Dimension(250,25));
		
		calculateButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (bandChoice1.getSelectedItem().toString().equalsIgnoreCase("") || bandChoice2.getSelectedItem().toString().equalsIgnoreCase("") || bandChoice3.getSelectedItem().toString().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(
								null, 
								"Bands cannot be empty. Please select a color for each band.", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					if (bandChoice1.getSelectedItem().toString().equalsIgnoreCase("Black")) {
						JOptionPane.showMessageDialog(
								null, 
								"Band 1 cannot be 'Black'. Please select another color.", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					String colors[] = {	bandChoice1.getSelectedItem().toString(),
										bandChoice2.getSelectedItem().toString(),
										bandChoice3.getSelectedItem().toString(),
										bandChoice4.getSelectedItem().toString()
									  };
					Resistors resistor = new FourBandResistor(colors);
					
					resistance.setText("" + resistor.getResistance());
					for (int i = 0 ; i < tolerance.getItemCount() ; i++) {
						if (Double.parseDouble(tolerance.getItemAt(i)) == resistor.getTolerance()) {
							tolerance.setSelectedIndex(i);
						}
					}
					
					tolerances[0].setText("" + resistor.getMinimumRange());
					tolerances[1].setText("" + resistor.getMaximumRange());
				}
			}
		);
		
		getColorCodes.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double resistanceValue;
					FourBandResistor resistor = new FourBandResistor();
					
					try{
						resistanceValue = Double.parseDouble(resistance.getText());
						resistor.setColorUsingDigits(resistanceValue, Double.parseDouble(tolerance.getSelectedItem().toString()));
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(
								null, 
								"Invalid Input. Enter numerical values only", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					double checker = 0;
					if (resistanceValue >= 10000){
						while (resistanceValue >= 10000) {
							resistanceValue = resistanceValue/10;
						}
					}
					if (resistanceValue >= 1000) {
						checker = resistanceValue%100;
					} else if (resistanceValue >= 100) {
						checker = resistanceValue%10;
					} else if (resistanceValue >= 10) {
						checker = (resistanceValue*10)%10;
					} else if (resistanceValue >= 1) {
						checker = (resistanceValue*100)%10;
					} else if (resistanceValue < 0.10) {
						checker = -1;
					}
					
					if (checker != 0) {
						JOptionPane.showMessageDialog(
								null, 
								"Entered Resistance Value is impossible in 4-band resistors.", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					String colors[] = resistor.getColorsArray();
					for (int i = 1; i < bandChoice1.getItemCount(); i++) {
						if (colors[0].equalsIgnoreCase(bandChoice1.getItemAt(i))) {
							bandChoice1.setSelectedIndex(i);
						}
						if (colors[1].equalsIgnoreCase(bandChoice2.getItemAt(i))) {
							bandChoice2.setSelectedIndex(i);
						}
						if (colors[2].equalsIgnoreCase(bandChoice3.getItemAt(i))) {
							bandChoice3.setSelectedIndex(i);
						}
						if (colors[3].equalsIgnoreCase(bandChoice4.getItemAt(i))) {
							bandChoice4.setSelectedIndex(i);
						}
					}
					
					tolerances[0].setText("" + resistor.getMinimumRange());
					tolerances[1].setText("" + resistor.getMaximumRange());
				}
			}
		);
		
		clearInputs.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bandChoice1.setSelectedIndex(0);
					bandChoice2.setSelectedIndex(0);
					bandChoice3.setSelectedIndex(0);
					bandChoice4.setSelectedIndex(0);
					resistance.setText(null);
					tolerance.setSelectedIndex(0);
					tolerances[0].setText("- - -");
					tolerances[1].setText("- - -");
				}
			}
		);
		
		JButton goBack = new JButton("GO BACK");
		goBack.setFocusable(false);
		frame.add(goBack, setConstraints(0,13,2,0,0,25,0,GridBagConstraints.CENTER, 0));
		goBack.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					resistorColorCodeMainFrame.setVisible(true); 
				}
			}
		);
		frame.addWindowListener(
			new WindowAdapter(){
				public void windowClosed(WindowEvent windowEvent) {
					resistorColorCodeMainFrame.setVisible(true);
				}
			}
		);
	}
	
	public static void addToFiveBandResistorJFrame(JFrame frame) {
		JLabel titleOfFrame = createCustomLabel(new JLabel(), "FIVE-BAND RESISTOR", 30, "Cambria", Font.BOLD);
		JLabel bandLabels[] = new JLabel[5];		
		JLabel properties[] = new JLabel[4];
		JLabel tolerances[] = new JLabel[2];
		String propertiesLabel[] = {"Resistance: ","Tolerance: ","Minimum: ", "Maximum: "};
		JTextField resistance = new JTextField();
		
		
		frame.add(titleOfFrame,setConstraints(0,0,2,0,0,0,20,GridBagConstraints.CENTER, 0));
		
		for (int i = 0; i < bandLabels.length; i++) {
			bandLabels[i] = createCustomLabel(bandLabels[i], "Band " + (i+1) + ": ", 15, "Courier New", Font.BOLD);
			frame.add(bandLabels[i], setConstraints(0,i+2,1,0,0,2,2,GridBagConstraints.EAST, 0));
		}
		
		for (int i = 0; i < properties.length; i++) {
			bandLabels[i] = createCustomLabel(properties[i], propertiesLabel[i], 15, "Courier New", Font.BOLD);
			frame.add(bandLabels[i], setConstraints(0,i+8,1,0,0,2,2,GridBagConstraints.EAST, 0));
		}
		
		for (int i = 0; i < tolerances.length; i++) {
			tolerances[i] = createCustomLabel(tolerances[i], "- - -", 15, "Arial", Font.PLAIN);
			frame.add(tolerances[i], setConstraints(1,i+10,1,0,0,2,2,GridBagConstraints.WEST, 0));
		}
		
		String[] colorChoices1 = {"","Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Grey", "White", "Gold", "Silver"};
		String[] colorChoices2 = {"Gold", "Silver"};
		String[] toleranceValues = {"0.05","0.10"};
		final JComboBox<String> bandChoice1 = new JComboBox<String>(colorChoices1);
		final JComboBox<String> bandChoice2 = new JComboBox<String>(colorChoices1);
		final JComboBox<String> bandChoice3 = new JComboBox<String>(colorChoices1);
		final JComboBox<String> bandChoice4 = new JComboBox<String>(colorChoices1);
		final JComboBox<String> bandChoice5 = new JComboBox<String>(colorChoices2);
		final JComboBox<String> tolerance = new JComboBox<String>(toleranceValues);
		
		bandChoice1.setPreferredSize(new Dimension(200,25));
		bandChoice2.setPreferredSize(new Dimension(200,25));
		bandChoice3.setPreferredSize(new Dimension(200,25));
		bandChoice4.setPreferredSize(new Dimension(200,25));
		bandChoice5.setPreferredSize(new Dimension(200,25));
		resistance.setPreferredSize(new Dimension(200,25));
		tolerance.setPreferredSize(new Dimension(200,25));
		
		frame.add(bandChoice1,setConstraints(1,2,1,0,0,0,0,GridBagConstraints.WEST, 0));
		frame.add(bandChoice2,setConstraints(1,3,1,0,0,0,0,GridBagConstraints.WEST, 0));
		frame.add(bandChoice3,setConstraints(1,4,1,0,0,0,0,GridBagConstraints.WEST, 0));
		frame.add(bandChoice4,setConstraints(1,5,1,0,0,0,0,GridBagConstraints.WEST, 0));
		frame.add(bandChoice5,setConstraints(1,6,1,0,0,0,0,GridBagConstraints.WEST, 0));
		frame.add(resistance, setConstraints(1,8,1,0,0,0,0,GridBagConstraints.WEST, 0));
		frame.add(tolerance, setConstraints(1,9,1,0,0,0,0,GridBagConstraints.WEST, 0));
		
		JButton calculateButton = new JButton("Calculate Resistance");
		frame.add(calculateButton, setConstraints(0,7,2,0,0,10,10,GridBagConstraints.CENTER, 0));
		JButton getColorCodes = new JButton("Get Color Codes");
		frame.add(getColorCodes, setConstraints(0,12,2,0,0,10,5,GridBagConstraints.CENTER, 0));
		
		JButton clearInputs = new JButton("Clear Frame");
		frame.add(clearInputs, setConstraints(0,13,2,0,0,0,10,GridBagConstraints.CENTER, 0));
		
		calculateButton.setPreferredSize(new Dimension(250,25));
		getColorCodes.setPreferredSize(new Dimension(250,25));
		clearInputs.setPreferredSize(new Dimension(250,25));
		
		calculateButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (bandChoice1.getSelectedItem().toString().equalsIgnoreCase("") || 
						bandChoice2.getSelectedItem().toString().equalsIgnoreCase("") || 
						bandChoice3.getSelectedItem().toString().equalsIgnoreCase("") ||
						bandChoice4.getSelectedItem().toString().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(
								null, 
								"Bands cannot be empty. Please select a color for each band.", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					if (bandChoice1.getSelectedItem().toString().equalsIgnoreCase("Black")) {
						JOptionPane.showMessageDialog(
								null, 
								"Band 1 cannot be 'Black'. Please select another color.", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					String colors[] = {	bandChoice1.getSelectedItem().toString(),
										bandChoice2.getSelectedItem().toString(),
										bandChoice3.getSelectedItem().toString(),
										bandChoice4.getSelectedItem().toString(),
										bandChoice5.getSelectedItem().toString()
									  };
					Resistors resistor = new FiveBandResistor(colors);
					
					resistance.setText("" + resistor.getResistance());
					for (int i = 0 ; i < tolerance.getItemCount() ; i++) {
						if (Double.parseDouble(tolerance.getItemAt(i)) == resistor.getTolerance()) {
							tolerance.setSelectedIndex(i);
						}
					}
					
					tolerances[0].setText("" + resistor.getMinimumRange());
					tolerances[1].setText("" + resistor.getMaximumRange());
				}
			}
		);
		
		getColorCodes.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double resistanceValue;
					FiveBandResistor resistor = new FiveBandResistor();
					
					try{
						resistanceValue = Double.parseDouble(resistance.getText());
						resistor.setColorUsingDigits(resistanceValue, Double.parseDouble(tolerance.getSelectedItem().toString()));
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(
								null, 
								"Invalid Input. Enter numerical values only", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					double checker = 0;
					if (resistanceValue >= 100000){
						while (resistanceValue >= 10000) {
							resistanceValue = resistanceValue/10;
						}
					}
					if (resistanceValue >= 10000) {
						checker = resistanceValue%100;
					} else if (resistanceValue >= 1000) {
						checker = resistanceValue%10;
					} else if (resistanceValue >= 100) {
						checker = (resistanceValue*10)%10;
					} else if (resistanceValue >= 10) {
						checker = (resistanceValue*100)%10;
					} else if (resistanceValue >= 1) {
						checker = (resistanceValue*1000)%10;
					} else if (resistanceValue < 0.10) {
						checker = -1;
					}
					
					if (checker != 0) {
						JOptionPane.showMessageDialog(
								null, 
								"Entered Resistance Value is impossible in 5-band resistors.", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					String colors[] = resistor.getColorsArray();
					for (int i = 1; i < bandChoice1.getItemCount(); i++) {
						if (colors[0].equalsIgnoreCase(bandChoice1.getItemAt(i))) {
							bandChoice1.setSelectedIndex(i);
						}
						if (colors[1].equalsIgnoreCase(bandChoice2.getItemAt(i))) {
							bandChoice2.setSelectedIndex(i);
						}
						if (colors[2].equalsIgnoreCase(bandChoice3.getItemAt(i))) {
							bandChoice3.setSelectedIndex(i);
						}
						if (colors[3].equalsIgnoreCase(bandChoice4.getItemAt(i))) {
							bandChoice4.setSelectedIndex(i);
						}
						if (colors[4].equalsIgnoreCase(bandChoice5.getItemAt(i))) {
							bandChoice5.setSelectedIndex(i);
						}
					}
					
					tolerances[0].setText("" + resistor.getMinimumRange());
					tolerances[1].setText("" + resistor.getMaximumRange());
				}
			}
		);
		
		clearInputs.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bandChoice1.setSelectedIndex(0);
					bandChoice2.setSelectedIndex(0);
					bandChoice3.setSelectedIndex(0);
					bandChoice4.setSelectedIndex(0);
					bandChoice5.setSelectedIndex(0);
					resistance.setText(null);
					tolerance.setSelectedIndex(0);
					tolerances[0].setText("- - -");
					tolerances[1].setText("- - -");
				}
			}
		);
		
		JButton goBack = new JButton("GO BACK");
		goBack.setFocusable(false);
		frame.add(goBack, setConstraints(0,14,2,0,0,25,0,GridBagConstraints.CENTER, 0));
		goBack.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					resistorColorCodeMainFrame.setVisible(true); 
				}
			}
		);
		frame.addWindowListener(
			new WindowAdapter(){
				public void windowClosed(WindowEvent windowEvent) {
					resistorColorCodeMainFrame.setVisible(true);
				}
			}
		);
	}
	
	public static void addToInterestsFrame(JFrame frame) {
		JLabel frameTitle = createCustomLabel(new JLabel(), "SIMPLE & COMPOUND INTEREST", 40, "Cambria", Font.BOLD);
		JLabel[] labels = new JLabel[4];
		JTextField[] enterProperties = new JTextField[4];
		JButton calculateButton = new JButton("Solve for the Unknowns");
		JLabel simpleInterest = createCustomLabel(new JLabel(), "Simple Interest", 20, "Cambria", Font.BOLD);
		JLabel[] forSimpleInterest = new JLabel[4];
		JLabel compoundInterest = createCustomLabel(new JLabel(), "Compound Interest", 20, "Cambria", Font.BOLD);
		JLabel[] forCompoundInterest = new JLabel[4];
		JLabel[] setValues = new JLabel[8];
		
		String[] forLabels = {"Interest Rate (in decimal): ", "No. Of Periods: ", "Present Value: ", "Future Value: "};
		
		frame.add(frameTitle,setConstraints(0,0,2,0,0,0,20,GridBagConstraints.CENTER, 0));
		for (int i = 0; i < labels.length ; i++) {
			labels[i] = createCustomLabel(labels[i], forLabels[i], 15, "Courier New", Font.BOLD);
			frame.add(labels[i],setConstraints(0,i+2,1,0,0,2,2,GridBagConstraints.EAST, 0));
		}
		for (int i = 0; i < enterProperties.length ; i++) {
			enterProperties[i] = new JTextField();
			enterProperties[i].setPreferredSize(new Dimension(400, 25));
			enterProperties[i].setText("0");
			frame.add(enterProperties[i],setConstraints(1,i+2,1,10,0,2,2,GridBagConstraints.WEST,0));
		}
		
		frame.add(calculateButton, setConstraints(0,6,2,0,0,10,10,GridBagConstraints.CENTER, 0));
		frame.add(simpleInterest,setConstraints(0,7,2,0,0,10,2,GridBagConstraints.CENTER, 0));

		for (int i = 0; i < forSimpleInterest.length; i++) {
			forSimpleInterest[i] = createCustomLabel(forSimpleInterest[i], forLabels[i], 15, "Courier New", Font.BOLD);
			frame.add(forSimpleInterest[i],setConstraints(0,i+8,1,0,0,2,2,GridBagConstraints.EAST, 0));
			setValues[i] = createCustomLabel(setValues[i], "- - -", 15, "Courier New", Font.BOLD);
			frame.add(setValues[i],setConstraints(1,i+8,1,10,0,2,2,GridBagConstraints.WEST,0));
		}
		
		frame.add(compoundInterest,setConstraints(0,12,2,0,0,10,2,GridBagConstraints.CENTER, 0));
		
		for (int i = 0; i < forCompoundInterest.length; i++) {
			forCompoundInterest[i] = createCustomLabel(forCompoundInterest[i], forLabels[i], 15, "Courier New", Font.BOLD);
			frame.add(forCompoundInterest[i],setConstraints(0,i+13,1,0,0,2,2,GridBagConstraints.EAST, 0));
			setValues[i+4] = createCustomLabel(setValues[i+4], "- - -", 15, "Courier New", Font.BOLD);
			frame.add(setValues[i+4],setConstraints(1,i+13,1,10,0,2,2,GridBagConstraints.WEST,0));
		}
		
		JButton clearInputs = new JButton("Clear Frame");
		frame.add(clearInputs, setConstraints(0,17,2,0,0,25,0,GridBagConstraints.CENTER, 0));
	
		calculateButton.setPreferredSize(new Dimension(250,25));
		clearInputs.setPreferredSize(new Dimension(250,25));
		
		JButton goBack = new JButton("GO BACK");
		goBack.setFocusable(false);
		frame.add(goBack, setConstraints(0,18,2,0,0,25,0,GridBagConstraints.CENTER, 0));
		
		calculateButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double interest, period, present, future;
					try{
						
						interest = Double.parseDouble(enterProperties[0].getText());
						period = Double.parseDouble(enterProperties[1].getText());
						present = Double.parseDouble(enterProperties[2].getText());
						future = Double.parseDouble(enterProperties[3].getText());
						
					} catch (NumberFormatException ex){
						JOptionPane.showMessageDialog(
								null, 
								"Invalid Input. Enter numerical values only", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					double[] values = {interest,
							period,
							present,
							future
							};
		
					int count = 0;
					for (int i = 0; i < values.length ; i++) {
						if (values[i] == 0) {
							count++;
						}
					}
					
					if (count > 1) {
						JOptionPane.showMessageDialog(
								null, 
								"Input Error. Fill out 3 out of 4 blanks.", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					if (present > future && (interest == 0 || period == 0)) {
						JOptionPane.showMessageDialog(
								null, 
								"Input Error. Present Value must be less than the Future Value", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					SimpleInterest problemInSimpleInterest = new SimpleInterest(interest, period, present, future);
					CompoundInterest problemInCompoundInterest = new CompoundInterest(interest, period, present, future);
					
					setValues[0].setText("" + problemInSimpleInterest.getInterestRate());
					setValues[1].setText("" + problemInSimpleInterest.getPeriod());
					setValues[2].setText("" + problemInSimpleInterest.getPresentValue());
					setValues[3].setText("" + problemInSimpleInterest.getFutureValue());
					setValues[4].setText("" + problemInCompoundInterest.getInterestRate());
					setValues[5].setText("" + problemInCompoundInterest.getPeriod());
					setValues[6].setText("" + problemInCompoundInterest.getPresentValue());
					setValues[7].setText("" + problemInCompoundInterest.getFutureValue());
					
					for (int i = 0; i < enterProperties.length ; i++) {
						enterProperties[i].setText("0");
					}
				}
			}
		);
		
		clearInputs.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < enterProperties.length ; i++) {
						enterProperties[i].setText("0");
					}
					for (int i = 0; i < setValues.length ; i++) {
						setValues[i].setText("- - -");
					}
				}
			}
		);
		
		goBack.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					economicsMainFrame.setVisible(true); 
				}
			}
		);
		frame.addWindowListener(
			new WindowAdapter(){
				public void windowClosed(WindowEvent windowEvent) {
					economicsMainFrame.setVisible(true);
				}
			}
		);
	}
	
	public static void addToAnnuityFrame(JFrame frame) {
		JLabel frameTitle = createCustomLabel(new JLabel(), "ANNUITY", 40, "Cambria", Font.BOLD);
		JLabel[] labels = new JLabel[5];
		JTextField[] enterProperties = new JTextField[5];
		JButton calculateButton = new JButton("Solve for the Unknowns");
		String[] forLabels = {"Interest Rate (in decimal): ", "No. Of Periods: ", "Present Value: ", "Future Value: ", "Annuity: "};
		JLabel[] displayProperties = new JLabel[5];
		JLabel[] setValues = new JLabel[5];
		
		frame.add(frameTitle,setConstraints(0,0,2,0,0,0,20,GridBagConstraints.CENTER, 0));
		for (int i = 0; i < labels.length ; i++) {
			labels[i] = createCustomLabel(labels[i], forLabels[i], 15, "Courier New", Font.BOLD);
			frame.add(labels[i],setConstraints(0,i+2,1,0,0,2,2,GridBagConstraints.EAST, 0));
			enterProperties[i] = new JTextField();
			enterProperties[i].setPreferredSize(new Dimension(200, 25));
			enterProperties[i].setText("0");
			frame.add(enterProperties[i],setConstraints(1,i+2,1,10,0,2,2,GridBagConstraints.WEST,0));
		}
		
		frame.add(calculateButton, setConstraints(0,7,2,0,0,10,10,GridBagConstraints.CENTER, 0));
		
		for (int i = 0; i < displayProperties.length ; i++) {
			displayProperties[i] = createCustomLabel(displayProperties[i], forLabels[i], 15, "Courier New", Font.BOLD);
			frame.add(displayProperties[i],setConstraints(0,i+8,1,0,0,2,2,GridBagConstraints.EAST, 0));
			setValues[i] = createCustomLabel(setValues[i], "- - -", 15, "Courier New", Font.BOLD);
			frame.add(setValues[i],setConstraints(1,i+8,1,10,0,2,2,GridBagConstraints.WEST,0));
		}
		
		JButton clearInputs = new JButton("Clear Frame");
		frame.add(clearInputs, setConstraints(0,13,2,0,0,25,0,GridBagConstraints.CENTER, 0));
	
		calculateButton.setPreferredSize(new Dimension(250,25));
		clearInputs.setPreferredSize(new Dimension(250,25));
		
		JButton goBack = new JButton("GO BACK");
		goBack.setFocusable(false);
		frame.add(goBack, setConstraints(0,14,2,0,0,25,0,GridBagConstraints.CENTER, 0));
		
		calculateButton.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < enterProperties.length; i++) {
						String string = enterProperties[i].getText(); 
						if (string == null) {
							enterProperties[i].setText("0");
						}
					}
					
					double interest, period, present, future, annuity;
					try{
						
						interest = Double.parseDouble(enterProperties[0].getText());
						period = Double.parseDouble(enterProperties[1].getText());
						present = Double.parseDouble(enterProperties[2].getText());
						future = Double.parseDouble(enterProperties[3].getText());
						annuity = Double.parseDouble(enterProperties[4].getText());
						
					} catch (NumberFormatException ex){
						JOptionPane.showMessageDialog(
								null, 
								"Invalid Input. Enter numerical values only", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					double[] values = {interest,
							period,
							present,
							future
							};
		
					int count = 0;
					for (int i = 0; i < values.length ; i++) {
						if (values[i] == 0) {
							count++;
						}
					}
					
					if (count > 2) {
						JOptionPane.showMessageDialog(
								null, 
								"Empty Textfields. At least three text fields must be filled", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
		
					if (annuity != 0) {
						if (period == 0 || interest == 0) {
							JOptionPane.showMessageDialog(
									null, 
									"Input Error. Such economic problem cannot be solved. If the 'annuity' textbox is filled, the period and interest textboxes must also be filled.", 
									"Error", 
									JOptionPane.ERROR_MESSAGE
									);
							return;
						}	
						else if (present != 0 || future !=0 ) {
							JOptionPane.showMessageDialog(
									null, 
									"Input Error. Such economic problem cannot be solved. If the 'annuity' textbox is filled, present and future txtboxes must be empty.", 
									"Error", 
									JOptionPane.ERROR_MESSAGE
									);
							return;
						}
						
					}
					
					if (period == 0 && interest == 0 && (present != 0 || future != 0)) {
						JOptionPane.showMessageDialog(
								null, 
								"Input Error. There must be a value for either period or interest, but not BOTH.", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					if (present > future && annuity == 0 && (period == 0 ^ interest == 0)){
						JOptionPane.showMessageDialog(
								null, 
								"Input Error. Present Value must be less than the Future Value", 
								"Error", 
								JOptionPane.ERROR_MESSAGE
								);
						return;
					}
					
					Annuity annuityProblem = new Annuity(interest, period, present, future, annuity);
					
					setValues[0].setText("" + annuityProblem.getInterestRate());
					setValues[1].setText("" + annuityProblem.getPeriod());
					setValues[2].setText("" + annuityProblem.getPresentValue());
					setValues[3].setText("" + annuityProblem.getFutureValue());
					setValues[4].setText("" + annuityProblem.getAnnuity());
					
					for (int i = 0; i < enterProperties.length ; i++) {
						enterProperties[i].setText("0");
					}
				}
			}
		);
		
		clearInputs.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < enterProperties.length ; i++) {
						enterProperties[i].setText("0");
					}
					for (int i = 0; i < setValues.length ; i++) {
						setValues[i].setText("- - -");
					}
				}
			}
		);
		
		goBack.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					economicsMainFrame.setVisible(true); 
				}
			}
		);
		frame.addWindowListener(
			new WindowAdapter(){
				public void windowClosed(WindowEvent windowEvent) {
					economicsMainFrame.setVisible(true);
				}
			}
		);
	}
	
	public static JFrame createCustomJFrame(JFrame frame, String frameTitle, int width, int height, LayoutManager layout) {
		frame = new JFrame(frameTitle);
		frame.setLayout(layout);
		frame.setSize(width, height);
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		return frame;
	}
	
	public static JLabel createCustomLabel(JLabel label, String labelTitle, int fontSize, String typeface, int fontStyle) {
		label = new JLabel(labelTitle);
		label.setFont(new Font(typeface,fontStyle,fontSize));
		return label;
	}
	
	public static GridBagConstraints setConstraints(
			int xPos, int yPos, 
			int width, 
			int insetRight, int insetLeft, int insetUp, int insetDown, 
			int textAlign, int positionFill) {
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = xPos;
		constraints.gridy = yPos;
		constraints.gridwidth = width;
		constraints.insets = new Insets(insetUp, insetLeft,insetDown,insetRight);
		constraints.anchor = textAlign;
		constraints.fill = positionFill;
		
		return constraints;
	}
	
	public static void exitCalculatorFrame(JFrame frame, JButton button) {
		button.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					mainMenu.setVisible(true); 
				}
			}
		);
		
		frame.addWindowListener(
			new WindowAdapter(){
				public void windowClosed(WindowEvent windowEvent) {
					mainMenu.setVisible(true);
				}
			}
		);
	}
}   