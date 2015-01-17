package GUI;

import object.Cat;
import object.Emotion;
import object.Environment;
import object.Interaction;
import object.InteractionCategory;
import simulator.Simulator;
import database.BehaviourDatabase;
import database.EnvironmentDatabase;
import database.InteractionDatabase;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.EtchedBorder;

/**
 * Main application GUI
 * 
 * @author DucAnh
 *
 */
public class Main
{
	// logic variables
	private Cat cat = new Cat("Tom", "Common Domestic Cat", new Emotion(0, 0,
	        0, 0));
	private int enviID;
	private int inteID;
	private boolean enviChosen = false;
	private boolean inteChosen = false;
	private boolean jlistEnviModified = false;
	private boolean jlistInteModified = false;
	private int enviMenuID;
	private int inteMenuID;
	private int newE;
	private int newF;
	private int newR;
	private int newA;
	private int newT;
	private int newH;
	private int newL;
	private int newN;
	private final int MIN = -5;
	private final int MAX = 5;
	private final int INIT = 0;

	// sound variable
	private Sound sound = new Sound();

	// Theme variable
	private int theme = 0;

	// swing variable
	private JFrame frmCatSimulator;
	private JPanel main;
	private JPanel newInter;
	private JPanel newEnvi;
	private JPanel credit;
	private JPanel simulation;
	private JPanel environment;
	private JPanel interaction;
	private JPanel behaviour;
	private JPanel result;
	private JPanel settings;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Main window = new Main();
					window.frmCatSimulator.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main()
	{
		// open databases
		EnvironmentDatabase.openDatabase();
		InteractionDatabase.openDatabase();
		BehaviourDatabase.openDatabase();

		// music
		sound.toggleMusic();

		// GUI
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		// --- PANELS ---
		panels();
		setTheme();

		// --- SETTINGS PANEL ---

		final JButton btnMusicToggle = new JButton("Music: On");
		btnMusicToggle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				sound.toggleMusic();
				sound.playButton2();
				if (sound.isMusicOn())
					btnMusicToggle.setText("Music: On");
				else
					btnMusicToggle.setText("Music: Off");
			}
		});
		btnMusicToggle.setBounds(588, 369, 131, 40);
		settings.add(btnMusicToggle);

		final JButton btnSoundToggle = new JButton("Sound: On");
		btnSoundToggle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.toggleSound();
				sound.playButton2();
				if (sound.isSoundOn())
					btnSoundToggle.setText("Sound: On");
				else
					btnSoundToggle.setText("Sound: Off");
			}
		});
		btnSoundToggle.setBounds(588, 307, 131, 40);
		settings.add(btnSoundToggle);

		JButton btnBack_5 = new JButton("Back");
		btnBack_5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				settings.setVisible(false);
				main.setVisible(true);
			}
		});
		btnBack_5.setBounds(588, 443, 117, 29);
		settings.add(btnBack_5);

		final JButton btnTheme = new JButton("Theme: Light");
		btnTheme.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				sound.playButton2();
				switch (theme)
				{
					case 0:
						btnTheme.setText("Theme: Gray");
						theme = 1;
						setTheme();
						break;
					case 1:
						btnTheme.setText("Theme: Dark");
						theme = 2;
						setTheme();
						break;
					case 2:
						btnTheme.setText("Theme: Orange");
						theme = 3;
						setTheme();
						break;
					default:
						btnTheme.setText("Theme: Light");
						theme = 0;
						setTheme();
						break;
				}
			}
		});
		btnTheme.setBounds(395, 346, 117, 29);
		settings.add(btnTheme);

		// --- RESULT PANEL ---

		JButton btnNewButton_13 = new JButton("Main Menu");
		btnNewButton_13.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				sound.playButton2();
				result.setVisible(false);
				main.setVisible(true);
			}
		});
		btnNewButton_13.setBounds(411, 515, 150, 29);
		result.add(btnNewButton_13);

		JLabel lblSimulationResult = new JLabel("Simulation Result");
		lblSimulationResult.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblSimulationResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblSimulationResult.setBounds(6, 11, 488, 40);
		result.add(lblSimulationResult);

		// ---

		JPanel catStatus = new JPanel();
		catStatus.setBackground(Color.WHITE);
		catStatus.setBorder(new TitledBorder(null, "Current Cat Status",
		        TitledBorder.LEADING, TitledBorder.TOP, null, null));
		catStatus.setBounds(27, 370, 200, 136);
		simulation.add(catStatus);
		catStatus.setLayout(new GridLayout(0, 1, 0, 0));

		final JTextArea status = new JTextArea();
		catStatus.add(status);
		status.setLineWrap(true);
		status.setText(cat.printStatusGUI());
		status.setEditable(false);

		JButton btnNewSimulation = new JButton("Run Again");
		btnNewSimulation.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				sound.playButton2();
				result.setVisible(false);
				simulation.setVisible(true);

				status.setText(cat.printStatusGUI());
			}
		});
		btnNewSimulation.setBounds(249, 515, 150, 29);
		result.add(btnNewSimulation);

		// --- ---

		// --- ENVIRONMENT MENU ---

		JButton btnNewButton_10 = new JButton("Create");
		btnNewButton_10.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				newEnvi.setVisible(true);
				environment.setVisible(false);
			}
		});
		btnNewButton_10.setBounds(357, 119, 117, 29);
		environment.add(btnNewButton_10);

		JLabel lblNewLabel_4 = new JLabel("Environment Library");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblNewLabel_4.setBounds(6, 6, 488, 101);
		environment.add(lblNewLabel_4);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(26, 228, 319, 111);
		environment.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		final JTextArea enviInfo = new JTextArea();
		panel.add(enviInfo);

		final JScrollPane scrollPaneE = new JScrollPane();
		scrollPaneE.setBounds(26, 105, 319, 111);
		environment.add(scrollPaneE);

		final JList enviList = new JList();
		enviList.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent arg0)
			{
				if (!arg0.getValueIsAdjusting())
				{
					if (!jlistEnviModified)
					{
						String selected = enviList.getSelectedValue()
						        .toString();
						enviMenuID = Integer.parseInt(selected.split("\\.")[0]);
						enviInfo.setText(EnvironmentDatabase.get(enviMenuID)
						        .infoGUI());
					} else
						jlistEnviModified = false;
				}
			}
		});
		enviList.setModel(new AbstractListModel()
		{
			String[] values = EnvironmentDatabase.getArray();

			public int getSize()
			{
				return values.length;
			}

			public Object getElementAt(int index)
			{
				return values[index];
			}
		});
		scrollPaneE.setViewportView(enviList);

		JButton btnNewButton_11 = new JButton("Delete");
		btnNewButton_11.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				if (enviMenuID != 0)
				{
					EnvironmentDatabase.delete(enviMenuID);
					EnvironmentDatabase.save();

					// refresh jlist
					jlistEnviModified = true;

					enviList.setListData(EnvironmentDatabase.getArray());
					scrollPaneE.revalidate();
					scrollPaneE.repaint();

					enviInfo.setText("Chosen environment object has been deleted!");
				} else
					enviInfo.setText("Please choose an environment to delete!");
			}
		});
		btnNewButton_11.setBounds(357, 160, 117, 29);
		environment.add(btnNewButton_11);

		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				enviInfo.setText("");
				environment.setVisible(false);
				main.setVisible(true);
			}
		});
		btnBack_2.setBounds(357, 201, 117, 29);
		environment.add(btnBack_2);

		// --- ---

		// --- INTERACTION MENU ---

		JButton btnNewButton_12 = new JButton("Create");
		btnNewButton_12.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				newInter.setVisible(true);
				interaction.setVisible(false);
			}
		});
		btnNewButton_12.setBounds(357, 119, 117, 29);
		interaction.add(btnNewButton_12);

		JLabel lblNewLabel_42 = new JLabel("Interaction Library");
		lblNewLabel_42.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_42.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblNewLabel_42.setBounds(6, 6, 488, 101);
		interaction.add(lblNewLabel_42);

		JPanel panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2.setLocation(2, 0);
		panel2.setBounds(26, 228, 319, 111);
		interaction.add(panel2);
		panel2.setLayout(new GridLayout(1, 0, 0, 0));

		final JTextArea inteInfo = new JTextArea();
		panel2.add(inteInfo);

		final JScrollPane scrollPaneI = new JScrollPane();
		scrollPaneI.setBounds(26, 105, 319, 111);
		interaction.add(scrollPaneI);

		final JList inteList = new JList();
		inteList.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				if (!e.getValueIsAdjusting())
				{
					if (!jlistInteModified)
					{
						String selected = inteList.getSelectedValue()
						        .toString();
						inteMenuID = Integer.parseInt(selected.split("\\.")[0]);
						inteInfo.setText(InteractionDatabase.get(inteMenuID)
						        .infoGUI());
					} else
						jlistInteModified = false;
				}
			}
		});
		inteList.setModel(new AbstractListModel()
		{
			String[] values = InteractionDatabase.getArray();

			public int getSize()
			{
				return values.length;
			}

			public Object getElementAt(int index)
			{
				return values[index];
			}
		});
		scrollPaneI.setViewportView(inteList);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				if (inteMenuID != 0)
				{
					InteractionDatabase.delete(inteMenuID);
					InteractionDatabase.save();

					// refresh jlist
					jlistInteModified = true;

					inteList.setListData(InteractionDatabase.getArray());
					scrollPaneI.revalidate();
					scrollPaneI.repaint();

					inteInfo.setText("Chosen interaction object has been deleted!");
				} else
					inteInfo.setText("Please choose an interation object to delete!");
			}
		});
		btnDelete.setBounds(357, 160, 117, 29);
		interaction.add(btnDelete);

		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				inteInfo.setText("");
				interaction.setVisible(false);
				main.setVisible(true);
			}
		});
		btnBack_3.setBounds(357, 201, 117, 29);
		interaction.add(btnBack_3);

		// --- NEW INTERACTION ---

		JButton btnNInteBack = new JButton("Back");
		btnNInteBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				newInter.setVisible(false);
				interaction.setVisible(true);
			}
		});
		btnNInteBack.setBounds(233, 326, 117, 29);
		newInter.add(btnNInteBack);

		JLabel lblNewLabel_9 = new JLabel("New Interaction");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblNewLabel_9.setBounds(6, 6, 488, 89);
		newInter.add(lblNewLabel_9);

		JLabel lblInteractionName = new JLabel("Interaction Name :");
		lblInteractionName.setBounds(16, 107, 138, 16);
		newInter.add(lblInteractionName);

		JLabel lblInteractionType = new JLabel("Interaction Type :");
		lblInteractionType.setBounds(16, 135, 138, 16);
		newInter.add(lblInteractionType);

		JLabel lblHowDoesThis = new JLabel(
		        "How does this interaction affect our cat's emotion?");
		lblHowDoesThis.setBounds(16, 163, 331, 16);
		newInter.add(lblHowDoesThis);

		JLabel lblExicted = new JLabel("Excited :");
		lblExicted.setBounds(16, 191, 70, 16);
		newInter.add(lblExicted);

		JLabel lblFearful = new JLabel("Fearful :");
		lblFearful.setBounds(16, 247, 70, 16);
		newInter.add(lblFearful);

		JLabel lblRelieved = new JLabel("Relieved :");
		lblRelieved.setBounds(16, 275, 70, 16);
		newInter.add(lblRelieved);

		JLabel lblAngry = new JLabel("Angry :");
		lblAngry.setBounds(16, 303, 70, 16);
		newInter.add(lblAngry);

		// --- sliders

		final JTextField textFieldE = new JTextField();
		textFieldE.setText("Neutral");
		textFieldE.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldE.setEditable(false);
		textFieldE.setColumns(10);
		textFieldE.setBounds(416, 185, 117, 28);
		newInter.add(textFieldE);

		final JTextField textFieldF = new JTextField();
		textFieldF.setText("Neutral");
		textFieldF.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldF.setEditable(false);
		textFieldF.setColumns(10);
		textFieldF.setBounds(416, 213, 117, 28);
		newInter.add(textFieldF);

		final JTextField textFieldR = new JTextField();
		textFieldR.setText("Neutral");
		textFieldR.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldR.setEditable(false);
		textFieldR.setColumns(10);
		textFieldR.setBounds(362, 241, 117, 28);
		newInter.add(textFieldR);

		final JTextField textFieldA = new JTextField();
		textFieldA.setText("Neutral");
		textFieldA.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldA.setEditable(false);
		textFieldA.setColumns(10);
		textFieldA.setBounds(362, 269, 117, 28);
		newInter.add(textFieldA);

		final JSlider sliderE = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderE.setMinorTickSpacing(1);
		sliderE.setMajorTickSpacing(2);
		sliderE.setPaintTicks(true);
		sliderE.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent arg0)
			{
				int value = sliderE.getValue();
				if (value < -3)
					textFieldE.setText("Not Excited!!");
				else if (value < -1)
					textFieldE.setText("Less Exited..");
				else if (value < 2)
					textFieldE.setText("Neutral");
				else if (value < 4)
					textFieldE.setText("A bit Exited..");
				else
					textFieldE.setText("Very Excite!!");
				newE = value;
			}
		});
		sliderE.setBounds(88, 190, 281, 50);
		newInter.add(sliderE);

		final JSlider sliderF = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderF.setMinorTickSpacing(1);
		sliderF.setMajorTickSpacing(2);
		sliderF.setPaintTicks(true);
		sliderF.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				int value = sliderF.getValue();
				if (value < -3)
					textFieldF.setText("Not Fearful!!");
				else if (value < -1)
					textFieldF.setText("Less Fearful..");
				else if (value < 2)
					textFieldF.setText("Neutral");
				else if (value < 4)
					textFieldF.setText("A bit Fearful..");
				else
					textFieldF.setText("Very Fearful!!");
				newF = value;
			}
		});
		sliderF.setBounds(88, 232, 281, 22);
		newInter.add(sliderF);

		final JSlider sliderR = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderR.setMinorTickSpacing(1);
		sliderR.setMajorTickSpacing(2);
		sliderR.setPaintTicks(true);
		sliderR.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				int value = sliderR.getValue();
				if (value < -3)
					textFieldR.setText("Not Relieved!!");
				else if (value < -1)
					textFieldR.setText("Less Relieved..");
				else if (value < 2)
					textFieldR.setText("Neutral");
				else if (value < 4)
					textFieldR.setText("A bit Relieved..");
				else
					textFieldR.setText("Very Relieved!!");
				newR = value;
			}
		});
		sliderR.setBounds(88, 260, 281, 22);
		newInter.add(sliderR);

		final JSlider sliderA = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderA.setMinorTickSpacing(1);
		sliderA.setMajorTickSpacing(2);
		sliderA.setPaintTicks(true);
		sliderA.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				int value = sliderA.getValue();
				if (value < -3)
					textFieldA.setText("Not Angry!!");
				else if (value < -1)
					textFieldA.setText("Less Angry..");
				else if (value < 2)
					textFieldA.setText("Neutral");
				else if (value < 4)
					textFieldA.setText("A bit Angry..");
				else
					textFieldA.setText("Very Angry!!");
				newA = value;
			}
		});
		sliderA.setBounds(88, 292, 281, 22);
		newInter.add(sliderA);

		// --- New interaction name and type

		final JTextField newNameI = new JTextField();
		newNameI.setBounds(150, 101, 160, 28);
		newInter.add(newNameI);
		newNameI.setColumns(10);

		final JComboBox newTypeI = new JComboBox(InteractionCategory.values());
		newTypeI.setBounds(150, 131, 160, 27);
		newInter.add(newTypeI);

		// --- create new Interaction when button clicked

		JButton btnNewButton_6 = new JButton("OK");
		btnNewButton_6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				sound.playButton2();
				String name = newNameI.getText();
				newNameI.setText("");

				// TODO invalid output
				if (name != "")
				{
					InteractionCategory type = (InteractionCategory) newTypeI
					        .getSelectedItem();
					Interaction inter = new Interaction(InteractionDatabase
					        .getSize() + 1, name, type, newE, newF, newR, newA);
					InteractionDatabase.add(inter);

					// save to file
					InteractionDatabase.save();

					// Refresh list
					jlistInteModified = true;

					inteList.setListData(InteractionDatabase.getArray());
					scrollPaneI.revalidate();
					scrollPaneI.repaint();

					inteInfo.setText("New interaction object has been created!");

				} else
					inteInfo.setText("Invalid input!");

				newInter.setVisible(false);
				interaction.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(362, 326, 117, 29);
		newInter.add(btnNewButton_6);

		// --- ---

		// --- New environment ---

		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				newEnvi.setVisible(false);
				environment.setVisible(true);
			}
		});
		btnBack_1.setBounds(237, 327, 117, 29);
		newEnvi.add(btnBack_1);

		JLabel lblNewEnvironment = new JLabel("New Environment");
		lblNewEnvironment.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewEnvironment.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblNewEnvironment.setBounds(0, 0, 488, 89);
		newEnvi.add(lblNewEnvironment);

		JLabel lblNewEnvironmentDetails = new JLabel("Environment Name:");
		lblNewEnvironmentDetails.setBounds(23, 101, 130, 16);
		newEnvi.add(lblNewEnvironmentDetails);

		JLabel lblPleaseSpecifyThe = new JLabel(
		        "Please specify the characteristics of this environment :");
		lblPleaseSpecifyThe.setBounds(23, 129, 375, 16);
		newEnvi.add(lblPleaseSpecifyThe);

		JLabel lblTemperature = new JLabel("Temperature :");
		lblTemperature.setBounds(23, 157, 130, 16);
		newEnvi.add(lblTemperature);

		JLabel lblHumidity = new JLabel("Humidity :");
		lblHumidity.setBounds(23, 185, 130, 16);
		newEnvi.add(lblHumidity);

		JLabel lblLight = new JLabel("Light :");
		lblLight.setBounds(23, 213, 130, 16);
		newEnvi.add(lblLight);

		JLabel lblNoise = new JLabel("Noise :");
		lblNoise.setBounds(23, 241, 130, 16);
		newEnvi.add(lblNoise);

		final JTextField newNameE = new JTextField();
		newNameE.setBounds(165, 95, 168, 28);
		newEnvi.add(newNameE);
		newNameE.setColumns(10);

		final JTextField textFieldT = new JTextField();
		textFieldT.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldT.setText("Neutral");
		textFieldT.setEditable(false);
		textFieldT.setBounds(393, 151, 91, 28);
		newEnvi.add(textFieldT);
		textFieldT.setColumns(10);

		final JTextField textFieldH = new JTextField();
		textFieldH.setText("Neutral");
		textFieldH.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldH.setEditable(false);
		textFieldH.setColumns(10);
		textFieldH.setBounds(393, 179, 91, 28);
		newEnvi.add(textFieldH);

		final JTextField textFieldL = new JTextField();
		textFieldL.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldL.setText("Neutral");
		textFieldL.setEditable(false);
		textFieldL.setColumns(10);
		textFieldL.setBounds(393, 207, 91, 28);
		newEnvi.add(textFieldL);

		final JTextField textFieldN = new JTextField();
		textFieldN.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldN.setText("Neutral");
		textFieldN.setEditable(false);
		textFieldN.setColumns(10);
		textFieldN.setBounds(393, 235, 91, 28);
		newEnvi.add(textFieldN);

		final JSlider sliderT = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderT.setMinorTickSpacing(1);
		sliderT.setMajorTickSpacing(2);
		sliderT.setPaintTicks(true);
		sliderT.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				int value = sliderT.getValue();
				if (value < -3)
					textFieldT.setText("Very Cold!!");
				else if (value < -1)
					textFieldT.setText("A bit Cold..");
				else if (value < 2)
					textFieldT.setText("Neutral");
				else if (value < 4)
					textFieldT.setText("A bit Hot..");
				else
					textFieldT.setText("Very Hot!!");
				newT = value;
			}
		});
		sliderT.setBounds(115, 157, 281, 22);
		newEnvi.add(sliderT);

		final JSlider sliderH = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderH.setMinorTickSpacing(1);
		sliderH.setMajorTickSpacing(2);
		sliderH.setPaintTicks(true);
		sliderH.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				int value = sliderH.getValue();
				if (value < -3)
					textFieldH.setText("Very Humid!!");
				else if (value < -1)
					textFieldH.setText("A bit Humid..");
				else if (value < 2)
					textFieldH.setText("Neutral");
				else if (value < 4)
					textFieldH.setText("A bit Dry..");
				else
					textFieldH.setText("Very Dry!!");
				newH = value;
			}
		});
		sliderH.setBounds(115, 185, 281, 22);
		newEnvi.add(sliderH);

		final JSlider sliderL = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderL.setMinorTickSpacing(1);
		sliderL.setMajorTickSpacing(2);
		sliderL.setPaintTicks(true);
		sliderL.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				int value = sliderL.getValue();
				if (value < -3)
					textFieldL.setText("Very Dark!!");
				else if (value < -1)
					textFieldL.setText("A bit Dark..");
				else if (value < 2)
					textFieldL.setText("Neutral");
				else if (value < 4)
					textFieldL.setText("A bit Light..");
				else
					textFieldL.setText("Very Light!!");
				newL = value;
			}
		});
		sliderL.setBounds(115, 213, 281, 22);
		newEnvi.add(sliderL);

		final JSlider sliderN = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderN.setMinorTickSpacing(1);
		sliderN.setMajorTickSpacing(2);
		sliderN.setPaintTicks(true);
		sliderN.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				int value = sliderN.getValue();
				if (value < -3)
					textFieldN.setText("Very Quiet!!");
				else if (value < -1)
					textFieldN.setText("A bit Quiet..");
				else if (value < 2)
					textFieldN.setText("Neutral");
				else if (value < 4)
					textFieldN.setText("A bit Noisy..");
				else
					textFieldN.setText("Very Noisy!!");
				newN = value;
			}
		});
		sliderN.setBounds(115, 243, 281, 22);
		newEnvi.add(sliderN);

		// --- create new Environment when button clicked

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				sound.playButton2();
				String name = newNameE.getText();
				newNameE.setText("");

				// TODO invalid output
				if (name != "")
				{
					Environment envi = new Environment(EnvironmentDatabase
					        .getSize() + 1, name, newT, newH, newL, newN);
					EnvironmentDatabase.add(envi);

					// save to file
					EnvironmentDatabase.save();

					// Refresh list
					jlistEnviModified = true;

					enviList.setListData(EnvironmentDatabase.getArray());
					scrollPaneE.revalidate();
					scrollPaneE.repaint();

					enviInfo.setText("New environment has been created!");

				} else
					enviInfo.setText("Invalid input!");

				newEnvi.setVisible(false);
				environment.setVisible(true);
			}
		});
		btnOk.setBounds(367, 327, 117, 29);
		newEnvi.add(btnOk);

		// --- ---

		// --- THE SIMULATION ---

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Scenario",
		        TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(646, 63, 260, 187);
		result.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		final JTextArea scenario = new JTextArea();
		scenario.setLineWrap(true);
		panel_1.add(scenario);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(
		        EtchedBorder.LOWERED, null, null), "Result",
		        TitledBorder.LEADING, TitledBorder.TOP, null,
		        new Color(0, 0, 0)));
		panel_2.setBounds(646, 262, 260, 201);
		result.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		final JTextArea textResult = new JTextArea();
		textResult.setLineWrap(true);
		panel_2.add(textResult);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(134, 63, 500, 400);
		result.add(panel_3);

		// ---

		JLabel lblNewLabel_2 = new JLabel("");
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(Main.class
		        .getResource("/images/tumblr_m8hv515XTT1qhlsrfo1_500.gif")));

		JButton btnQuickSimulation_1 = new JButton("Quick Simulation");
		btnQuickSimulation_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				// the random simulation is here
				Cat randomCat = new Cat("Random Cat", "Common Domestic Cat",
				        new Emotion(random(-10, 10), random(-10, 10), random(
				                -10, 10), random(-10, 10)));
				String[] s = Simulator.simulationResultGUI(
				        randomCat,
				        EnvironmentDatabase.get(random(1,
				                EnvironmentDatabase.getSize())),
				        InteractionDatabase.get(random(1,
				                InteractionDatabase.getSize())));
				scenario.setText(s[0]);
				textResult.setText(s[1] + " " + s[2]);
			}
		});
		btnQuickSimulation_1.setBounds(573, 515, 150, 29);
		result.add(btnQuickSimulation_1);

		final JButton start = new JButton("Start");
		start.setEnabled(false);
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				sound.playButton2();
				// the simulation is here
				String[] s = Simulator.simulationResultGUI(cat,
				        EnvironmentDatabase.get(enviID),
				        InteractionDatabase.get(inteID));
				scenario.setText(s[0]);
				textResult.setText(s[1] + " " + s[2]);

				simulation.setVisible(false);
				result.setVisible(true);
			}
		});
		start.setBounds(346, 466, 117, 29);
		simulation.add(start);

		// ---

		JButton btnNewButton_9 = new JButton("Back");
		btnNewButton_9.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				simulation.setVisible(false);
				main.setVisible(true);
			}
		});
		btnNewButton_9.setBounds(346, 507, 117, 29);
		simulation.add(btnNewButton_9);

		JLabel lblNewLabel_5 = new JLabel("Simulation");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblNewLabel_5.setBounds(6, 16, 988, 43);
		simulation.add(lblNewLabel_5);

		// ---

		final JTextField chooseInte = new JTextField();
		chooseInte.setHorizontalAlignment(SwingConstants.CENTER);
		chooseInte.setEditable(false);
		chooseInte.setColumns(10);
		chooseInte.setBounds(239, 411, 224, 28);
		simulation.add(chooseInte);

		JScrollPane imenu = new JScrollPane();
		imenu.setBounds(239, 299, 224, 100);
		simulation.add(imenu);

		final JList chooseInteList = new JList();
		chooseInteList.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				if (!e.getValueIsAdjusting())
				{
					String selected = chooseInteList.getSelectedValue()
					        .toString();
					chooseInte.setText(selected.substring(3));

					inteID = Integer.parseInt(selected.split("\\.")[0]);

					inteChosen = true;
					if (enviChosen)
						start.setEnabled(true);
				}
			}
		});
		chooseInteList.setModel(new AbstractListModel()
		{
			String[] values = InteractionDatabase.getArray();

			public int getSize()
			{
				return values.length;
			}

			public Object getElementAt(int index)
			{
				return values[index];
			}
		});
		imenu.setViewportView(chooseInteList);

		// ---

		final JTextField chooseEnvi = new JTextField();
		chooseEnvi.setHorizontalAlignment(SwingConstants.CENTER);
		chooseEnvi.setEditable(false);
		chooseEnvi.setBounds(239, 218, 224, 28);
		simulation.add(chooseEnvi);
		chooseEnvi.setColumns(10);

		JScrollPane emenu = new JScrollPane();
		emenu.setBounds(239, 106, 224, 100);
		simulation.add(emenu);

		final JList chooseEnviList = new JList();
		chooseEnviList.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				if (!e.getValueIsAdjusting())
				{
					String selected = chooseEnviList.getSelectedValue()
					        .toString();
					chooseEnvi.setText(selected.substring(3));

					enviID = Integer.parseInt(selected.split("\\.")[0]);

					enviChosen = true;
					if (inteChosen)
						start.setEnabled(true);
				}
			}
		});
		chooseEnviList.setModel(new AbstractListModel()
		{
			String[] values = EnvironmentDatabase.getArray();

			public int getSize()
			{
				return values.length;
			}

			public Object getElementAt(int index)
			{
				return values[index];
			}
		});
		emenu.setViewportView(chooseEnviList);

		// ---

		JPanel pic = new JPanel();
		pic.setBackground(Color.WHITE);
		pic.setBorder(new LineBorder(new Color(0, 0, 0)));
		pic.setBounds(27, 106, 200, 250);
		simulation.add(pic);
		pic.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(Main.class
		        .getResource("/images/677dce9ec9101d08d48b4db3cf0c398e.gif")));
		pic.add(lblNewLabel_7);

		JPanel pic2 = new JPanel();
		pic2.setBounds(475, 106, 500, 400);
		simulation.add(pic2);

		JLabel lblNewLabel_6 = new JLabel(
		        "Input information for the simulation:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(27, 78, 250, 16);
		simulation.add(lblNewLabel_6);

		JLabel lblEnvironment = new JLabel("Environment");
		lblEnvironment.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnvironment.setBounds(288, 78, 127, 16);
		simulation.add(lblEnvironment);

		JLabel lblInteraction = new JLabel("Interaction");
		lblInteraction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInteraction.setBounds(288, 271, 127, 16);
		simulation.add(lblInteraction);

		JButton btnRandomEmotion = new JButton("Random Emotion");
		btnRandomEmotion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				sound.playButton2();
				cat.setEmotion(random(-10, 10), random(-10, 10),
				        random(-10, 10), random(-10, 10));
				status.setText(cat.printStatusGUI());
			}
		});
		btnRandomEmotion.setBounds(27, 518, 117, 29);
		simulation.add(btnRandomEmotion);

		JButton btnResetEmotion = new JButton("Reset Emotion");
		btnResetEmotion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				cat.setEmotion(0, 0, 0, 0);
				status.setText(cat.printStatusGUI());
			}
		});
		btnResetEmotion.setBounds(156, 518, 117, 29);
		simulation.add(btnResetEmotion);

		JButton btnBack_4 = new JButton("Back");
		btnBack_4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				behaviour.setVisible(false);
				main.setVisible(true);
			}
		});
		btnBack_4.setBounds(353, 312, 117, 29);
		behaviour.add(btnBack_4);

		JLabel lblNewLabel = new JLabel("CAT SIMULATOR");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(6, 29, 488, 35);
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Diwan Kufi", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnStartSimulation = new JButton("Start Simulation");
		btnStartSimulation.setBounds(321, 89, 157, 29);
		btnStartSimulation.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				main.setVisible(false);
				simulation.setVisible(true);
			}
		});

		JButton btnEnviLibrary = new JButton("Environment Library");
		btnEnviLibrary.setBounds(321, 130, 157, 29);
		btnEnviLibrary.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				main.setVisible(false);
				environment.setVisible(true);
			}
		});

		JButton btnInteLibrary = new JButton("Interaction Library");
		btnInteLibrary.setBounds(321, 171, 157, 29);
		btnInteLibrary.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				main.setVisible(false);
				interaction.setVisible(true);
			}
		});

		JButton btnBehaviourLibrary = new JButton("Behaviour Library");
		btnBehaviourLibrary.setEnabled(false);
		btnBehaviourLibrary.setBounds(321, 212, 157, 29);
		btnBehaviourLibrary.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				main.setVisible(false);
				behaviour.setVisible(true);
			}
		});

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(321, 294, 157, 29);
		btnExit.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				sound.musicStop();
				// delay
				try
				{
					Thread.sleep(800);
				} catch (InterruptedException ie)
				{
				}
				System.exit(0);
			}
		});

		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				main.setVisible(false);
				settings.setVisible(true);
			}
		});
		btnSettings.setBounds(548, 253, 157, 29);
		main.add(btnSettings);

		JButton btnCredit = new JButton("Credit");
		btnCredit.setBounds(321, 253, 157, 29);
		btnCredit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				main.setVisible(false);
				credit.setVisible(true);
			}
		});
		main.setLayout(null);
		main.add(lblNewLabel);
		main.add(btnBehaviourLibrary);
		main.add(btnCredit);
		main.add(btnStartSimulation);
		main.add(btnExit);
		main.add(btnEnviLibrary);
		main.add(btnInteLibrary);

		JLabel mainBackground = new JLabel("");
		mainBackground.setBackground(Color.WHITE);
		mainBackground.setBounds(-135, 57, 500, 282);
		mainBackground.setIcon(new ImageIcon(Main.class
		        .getResource("/images/tumblr_myg3nzYpL31t4wmn7o1_500.gif")));
		main.add(mainBackground);

		JButton btnQuickSimulation = new JButton("Quick Simulation");
		btnQuickSimulation.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				// the random simulation is here
				Cat randomCat = new Cat("Random Cat", "Common Domestic Cat",
				        new Emotion(random(-10, 10), random(-10, 10), random(
				                -10, 10), random(-10, 10)));
				String[] s = Simulator.simulationResultGUI(
				        randomCat,
				        EnvironmentDatabase.get(random(1,
				                EnvironmentDatabase.getSize())),
				        InteractionDatabase.get(random(1,
				                InteractionDatabase.getSize())));
				scenario.setText(s[0]);
				textResult.setText(s[1] + " " + s[2]);

				main.setVisible(false);
				result.setVisible(true);
			}
		});
		btnQuickSimulation.setBounds(548, 171, 157, 29);
		main.add(btnQuickSimulation);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3
		        .setIcon(new ImageIcon(
		                Main.class
		                        .getResource("/images/how-to-draw-the-grumpy-cat-tard-the-grumpy-cat-step-9_1_000000122943_5.gif")));
		lblNewLabel_3.setBounds(807, 115, 130, 170);
		credit.add(lblNewLabel_3);

		JLabel lblCredit = new JLabel("CREDIT");
		lblCredit.setForeground(Color.BLACK);
		lblCredit.setBounds(6, 6, 988, 97);
		lblCredit.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblCredit.setHorizontalAlignment(SwingConstants.CENTER);
		credit.add(lblCredit);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(807, 312, 117, 29);
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				sound.playButton2();
				main.setVisible(true);
				credit.setVisible(false);
			}
		});
		credit.add(btnBack);

		JScrollPane scrollPaneCredit = new JScrollPane();
		scrollPaneCredit.setBounds(114, 115, 567, 443);
		credit.add(scrollPaneCredit);

		JTextArea txtrCredit = new JTextArea();
		txtrCredit
		        .setText("Cat Behaviour Simulator\n\nThird Year Project\n\nUniversity of Manchester\n\nAuthor: Duc A. Nguyen\n\nSupervisor: Dr John Sargeant\n\nReference Sources:\n-\n-\n-\n-\n-\n-\n-\n-\n-\n-\n");
		scrollPaneCredit.setViewportView(txtrCredit);
	}

	private void panels()
	{
		frmCatSimulator = new JFrame();
		frmCatSimulator.setTitle("Cat Simulator");
		frmCatSimulator.setBounds(100, 100, 1000, 600);
		frmCatSimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCatSimulator.getContentPane().setLayout(new CardLayout(0, 0));

		main = new JPanel();
		frmCatSimulator.getContentPane().add(main, "name_1417370866784216000");
		main.setVisible(true);

		newInter = new JPanel();
		frmCatSimulator.getContentPane().add(newInter,
		        "name_1417374299353503000");
		newInter.setLayout(null);
		newInter.setVisible(false);

		newEnvi = new JPanel();
		frmCatSimulator.getContentPane().add(newEnvi,
		        "name_1417374268312883000");
		newEnvi.setLayout(null);
		newEnvi.setVisible(false);

		credit = new JPanel();
		frmCatSimulator.getContentPane()
		        .add(credit, "name_1417372166389926000");
		credit.setVisible(false);
		credit.setLayout(null);

		simulation = new JPanel();
		frmCatSimulator.getContentPane().add(simulation,
		        "name_1417370866800002000");
		simulation.setLayout(null);
		simulation.setVisible(false);

		environment = new JPanel();
		frmCatSimulator.getContentPane().add(environment,
		        "name_1417371601176283000");
		environment.setLayout(null);
		environment.setVisible(false);

		interaction = new JPanel();
		frmCatSimulator.getContentPane().add(interaction,
		        "name_1417374220953403000");
		interaction.setLayout(null);
		interaction.setVisible(false);

		behaviour = new JPanel();
		frmCatSimulator.getContentPane().add(behaviour,
		        "name_1417374241437629000");
		behaviour.setLayout(null);
		behaviour.setVisible(false);

		result = new JPanel();
		frmCatSimulator.getContentPane()
		        .add(result, "name_1417436381075400000");
		result.setLayout(null);
		result.setVisible(false);

		settings = new JPanel();
		frmCatSimulator.getContentPane().add(settings,
		        "name_1421503030603136000");
		settings.setLayout(null);
		settings.setVisible(false);
	}

	private void setTheme()
	{
		Color color;
		switch (theme)
		{
			case 0:
				color = Color.WHITE;
				break;
			case 1:
				color = Color.GRAY;
				break;
			case 2:
				color = Color.DARK_GRAY;
				break;
			default:
				color = Color.ORANGE;
				break;
		}

		main.setBackground(color);
		newInter.setBackground(color);
		newEnvi.setBackground(color);
		credit.setBackground(color);
		simulation.setBackground(color);
		environment.setBackground(color);
		interaction.setBackground(color);
		behaviour.setBackground(color);
		result.setBackground(color);
		settings.setBackground(color);
	}

	private int random(int min, int max)
	{
		Random random = new Random();
		return random.nextInt(max - min + 1) + min; // return min -> max
	}
}
