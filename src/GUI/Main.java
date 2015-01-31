package GUI;

import database.BehaviourDatabase;
import database.EnvironmentDatabase;
import database.InteractionDatabase;
import object.*;
import simulator.Simulator;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Main application GUI
 *
 * @author DucAnh
 */
public class Main {
	// logic variables
	private Cat cat = new Cat("Tom", "Common Domestic Cat", new Emotion());
	private int enviID;
	private int inteID;
	private boolean enviChosen = false;
	private boolean inteChosen = false;
	private boolean jlistEnviModified = false;
	private boolean jlistInteModified = false;
	private Boolean firstTimeClicked = true;
	private boolean enviList_simulation_modified = false;
	private boolean inteList_simulation_modified = false;
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
	private Font customFont;

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
	// main_menu
	private JLabel tittle_main;
	private JButton btnStartSimulation;
	private JButton btnEnviLibrary;
	private JButton btnInteLibrary;
	private JButton btnBehaviourLibrary;
	private JButton btnExit;
	private JButton btnSettings;
	private JButton btnCredit;
	private JLabel mainBackground;
	private JButton btnQuickSimulation;
	private JLabel bg1;
	// settings_panel
	private JButton btnMusicToggle;
	private JButton btnSoundToggle;
	private JButton btnBack_5;
	private JButton btnTheme;
	private JLabel tittle_settings;
	// result_panel
	private JButton btnNewButton_13;
	private JLabel tittle_result;
	private JPanel catStatus;
	private JTextArea status;
	private JButton btnNewSimulation;
	// envi_menu
	private JButton btnNewButton_10;
	private JLabel tittle_envi;
	private JPanel panel;
	private JTextArea enviInfo;
	private JScrollPane scrollPaneE;
	private JList enviList;
	private JButton btnNewButton_11;
	private JButton btnBack_2;
	private JLabel pic_envi_menu;
	// inte_menu
	private JButton btnNewButton_12;
	private JLabel tittle_inte;
	private JPanel panel2;
	private JTextArea inteInfo;
	private JScrollPane scrollPaneI;
	private JList inteList;
	private JButton btnDelete;
	private JButton btnBack_3;
	private JLabel pic_inte_menu;
	// new_interaction
	private JButton btnNInteBack;
	private JLabel tittle_newInte;
	private JLabel lblInteractionName;
	private JLabel lblInteractionType;
	private JLabel lblHowDoesThis;
	private JLabel lblExicted;
	private JLabel lblFearful;
	private JLabel lblRelieved;
	private JLabel lblAngry;
	private JTextField textFieldE;
	private JTextField textFieldF;
	private JTextField textFieldR;
	private JTextField textFieldA;
	private JSlider sliderE;
	private JSlider sliderF;
	private JSlider sliderR;
	private JSlider sliderA;
	private JTextField newNameI;
	private JComboBox newTypeI;
	private JButton btnNewButton_6;
	private JLabel lblDescription;
	private JTextArea inputDescription;
	private JScrollPane scrollPane;
	// new_environment
	private JButton btnBack_1;
	private JLabel tittle_newEnvi;
	private JLabel lblNewEnvironmentDetails;
	private JLabel lblPleaseSpecifyThe;
	private JLabel lblTemperature;
	private JLabel lblHumidity;
	private JLabel lblLight;
	private JLabel lblNoise;
	private JTextField newNameE;
	private JTextField textFieldT;
	private JTextField textFieldH;
	private JTextField textFieldL;
	private JTextField textFieldN;
	private JSlider sliderT;
	private JSlider sliderH;
	private JSlider sliderL;
	private JSlider sliderN;
	private JButton btnOk;
	// simulation_menu
	private JPanel panel_1;
	private JTextArea scenario;
	private JPanel panel_2;
	private JTextArea textResult;
	private JLabel pic_envi_result;
	private JLabel pic_inte_result;
	private JLabel pic_beha_result;
	private JButton btnQuickSimulation_1;
	private JButton start;
	private JButton btnNewButton_9;
	private JLabel tittle_simulation;
	private JTextField chooseInte;
	private JScrollPane imenu;
	private JList chooseInteList;
	private JTextField chooseEnvi;
	private JScrollPane emenu;
	private JList chooseEnviList;
	private JLabel pic_envi_simulation;
	private JLabel pic_inte_simulation;
	private JLabel pic_cat_status;
	private JLabel lblNewLabel_6;
	private JLabel lblEnvironment;
	private JLabel lblInteraction;
	private JButton btnRandomEmotion;
	private JButton btnResetEmotion;
	// credit
	private JLabel pic_credit;
	private JLabel tittle_credit;
	private JButton btnBack;
	private JScrollPane scrollPaneCredit;
	private JTextArea txtrCredit;
	// behaviour
	private JButton btnBack_4;
	private JLabel tittle_beha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmCatSimulator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		// open databases
		EnvironmentDatabase.openDatabase();
		InteractionDatabase.openDatabase();
		BehaviourDatabase.openDatabase();

		// music
		sound.toggleMusic();

		// GUI
		customFont();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// --- PANELS ---
		initialize_panels();
		setTheme();

		// --- SETTINGS PANEL ---
		settings_panel();

		// --- RESULT PANEL ---
		result_panel();

		// --- ENVIRONMENT MENU ---
		envi_menu();

		// --- INTERACTION MENU ---
		inte_menu();

		// --- NEW INTERACTION ---
		new_interaction();

		// --- NEW ENVIRONMENT ---
		new_environment();

		// --- SIMULATION_MENU ---
		simulation_menu();

		// --- BEHAVIOUR MENU ---
		behaviour_menu();

		// --- MAIN MENU ---
		main_menu();

		// --- CREDIT ---
		credit();
	}

	/**
	 * Initialize panels
	 */
	private void initialize_panels() {
		frmCatSimulator = new JFrame();
		frmCatSimulator.setResizable(false);
		frmCatSimulator.setTitle("Cat Simulator");
		frmCatSimulator.setBounds(100, 100, 1000, 700);
		frmCatSimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCatSimulator.getContentPane().setLayout(new CardLayout(0, 0));

		main = new JPanel();
		frmCatSimulator.getContentPane().add(main, "name_1417370866784216000");
		main.setVisible(true);

		newInter = new JPanel();
		frmCatSimulator.getContentPane().add(newInter, "name_1417374299353503000");
		newInter.setLayout(null);
		newInter.setVisible(false);

		newEnvi = new JPanel();
		frmCatSimulator.getContentPane().add(newEnvi, "name_1417374268312883000");
		newEnvi.setLayout(null);
		newEnvi.setVisible(false);

		credit = new JPanel();
		frmCatSimulator.getContentPane().add(credit, "name_1417372166389926000");
		credit.setVisible(false);
		credit.setLayout(null);

		simulation = new JPanel();
		frmCatSimulator.getContentPane().add(simulation, "name_1417370866800002000");
		simulation.setLayout(null);
		simulation.setVisible(false);

		environment = new JPanel();
		frmCatSimulator.getContentPane().add(environment, "name_1417371601176283000");
		environment.setLayout(null);
		environment.setVisible(false);

		interaction = new JPanel();
		frmCatSimulator.getContentPane().add(interaction, "name_1417374220953403000");
		interaction.setLayout(null);
		interaction.setVisible(false);

		behaviour = new JPanel();
		frmCatSimulator.getContentPane().add(behaviour, "name_1417374241437629000");
		behaviour.setLayout(null);
		behaviour.setVisible(false);

		result = new JPanel();
		frmCatSimulator.getContentPane().add(result, "name_1417436381075400000");
		result.setLayout(null);
		result.setVisible(false);

		settings = new JPanel();
		frmCatSimulator.getContentPane().add(settings, "name_1421503030603136000");
		settings.setLayout(null);
		settings.setVisible(false);
	}

	/**
	 * A panel
	 */
	private void setTheme() {
		Color color;
		switch (theme) {
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

	/**
	 * A panel
	 */
	private void main_menu() {
		btnStartSimulation = new JButton("Start Simulation");
		btnStartSimulation.setBounds(285, 167, 157, 29);
		btnStartSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				main.setVisible(false);
				simulation.setVisible(true);

				if (!firstTimeClicked) {
					inteList_simulation_modified = true;
					enviList_simulation_modified = true;
				} else
					firstTimeClicked = false;

				chooseEnviList.setListData(EnvironmentDatabase.getArray());
				emenu.revalidate();
				emenu.repaint();
				chooseInteList.setListData(InteractionDatabase.getArray());
				imenu.revalidate();
				imenu.repaint();
			}
		});

		btnEnviLibrary = new JButton("Environment Library");
		btnEnviLibrary.setBounds(285, 208, 157, 29);
		btnEnviLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				main.setVisible(false);
				environment.setVisible(true);
			}
		});

		btnInteLibrary = new JButton("Interaction Library");
		btnInteLibrary.setBounds(285, 249, 157, 29);
		btnInteLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				main.setVisible(false);
				interaction.setVisible(true);
			}
		});

		btnBehaviourLibrary = new JButton("Behaviour Library");
		btnBehaviourLibrary.setEnabled(false);
		btnBehaviourLibrary.setBounds(559, 208, 157, 29);
		btnBehaviourLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				main.setVisible(false);
				behaviour.setVisible(true);
			}
		});

		btnExit = new JButton("Exit");
		btnExit.setBounds(559, 290, 157, 29);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sound.musicStop();
				System.exit(0);
			}
		});

		btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				main.setVisible(false);
				settings.setVisible(true);
			}
		});
		btnSettings.setBounds(285, 290, 157, 29);
		main.add(btnSettings);

		tittle_main = new JLabel("CAT SIMULATOR");
		setTittle(tittle_main);
		main.add(tittle_main);

		btnCredit = new JButton("Credit");
		btnCredit.setBounds(559, 249, 157, 29);
		btnCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				main.setVisible(false);
				credit.setVisible(true);
			}
		});
		main.setLayout(null);
		main.add(btnBehaviourLibrary);
		main.add(btnCredit);
		main.add(btnStartSimulation);
		main.add(btnExit);
		main.add(btnEnviLibrary);
		main.add(btnInteLibrary);

		btnQuickSimulation = new JButton("Quick Simulation");
		btnQuickSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				// the random simulation is here
				Cat randomCat = new Cat("Random Cat", "Common Domestic Cat", new Emotion(random(-10, 10), random(-10, 10), random(-10, 10), random(-10, 10)));
				int random_envi = random(1, EnvironmentDatabase.getSize());
				int random_inte = random(1, InteractionDatabase.getSize());
				String[] s = Simulator.simulationResultGUI(randomCat, EnvironmentDatabase.get(random_envi), InteractionDatabase.get(random_inte));
				updateResultPanel(s, random_envi, random_inte, 0);

				main.setVisible(false);
				result.setVisible(true);
			}
		});
		btnQuickSimulation.setBounds(559, 167, 157, 29);
		main.add(btnQuickSimulation);

		bg1 = new JLabel("bg1");
		bg1.setIcon(new ImageIcon("resource/images/bg1.gif"));
		bg1.setBounds(250, 335, 500, 282);
		main.add(bg1);

		mainBackground = new JLabel("");
		mainBackground.setBounds(0, 0, 1000, 678);
		main.add(mainBackground);
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				// Keep changing main background
				int id = 0;
				while (true) {
					if (id == 4)
						id = 0;
					else
						id++;
					mainBackground.setIcon(getImageIcon("envi" + id + ".jpg", 1000, 778));

					Thread.sleep(5000);
				}
			}
		};
		worker.execute();
	}

	/**
	 * A panel
	 */
	private void settings_panel() {
		btnMusicToggle = new JButton("Music: Off");
		btnMusicToggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.toggleMusic();
				sound.playButton2();
				if (sound.isMusicOn())
					btnMusicToggle.setText("Music: On");
				else
					btnMusicToggle.setText("Music: Off");
			}
		});
		btnMusicToggle.setBounds(588, 359, 150, 40);
		settings.add(btnMusicToggle);

		btnSoundToggle = new JButton("Sound: Off");
		btnSoundToggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.toggleSound();
				sound.playButton2();
				if (sound.isSoundOn())
					btnSoundToggle.setText("Sound: On");
				else
					btnSoundToggle.setText("Sound: Off");
			}
		});
		btnSoundToggle.setBounds(588, 307, 150, 40);
		settings.add(btnSoundToggle);

		btnBack_5 = new JButton("Back");
		btnBack_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				settings.setVisible(false);
				main.setVisible(true);
			}
		});
		btnBack_5.setBounds(588, 411, 150, 40);
		settings.add(btnBack_5);

		btnTheme = new JButton("Theme: Light");
		btnTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				switch (theme) {
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
		btnTheme.setBounds(588, 255, 150, 40);
		settings.add(btnTheme);

		tittle_settings = new JLabel("Settings");
		setTittle(tittle_settings);
		settings.add(tittle_settings);
	}

	/**
	 * A panel
	 */
	private void result_panel() {
		btnNewButton_13 = new JButton("Main Menu");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				result.setVisible(false);
				main.setVisible(true);
			}
		});
		btnNewButton_13.setBounds(762, 556, 150, 29);
		result.add(btnNewButton_13);

		btnQuickSimulation_1 = new JButton("Quick Simulation");
		btnQuickSimulation_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				// the random simulation is here
				Cat randomCat = new Cat("Random Cat", "Common Domestic Cat", new Emotion(random(-10, 10), random(-10, 10), random(-10, 10), random(-10, 10)));
				int random_envi = random(1, EnvironmentDatabase.getSize());
				int random_inte = random(1, InteractionDatabase.getSize());
				String[] s = Simulator.simulationResultGUI(randomCat, EnvironmentDatabase.get(random_envi), InteractionDatabase.get(random_inte));
				updateResultPanel(s, random_envi, random_inte, 0);
			}
		});
		btnQuickSimulation_1.setBounds(762, 475, 150, 29);
		result.add(btnQuickSimulation_1);

		btnNewSimulation = new JButton("Run Again");
		btnNewSimulation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				status.setText(cat.printStatusGUI());
				pic_cat_status.setIcon(getImageIcon("status" + cat.getImageNo() + ".jpg", 200, 200));
				
				result.setVisible(false);
				simulation.setVisible(true);
			}
		});
		btnNewSimulation.setBounds(762, 515, 150, 29);
		result.add(btnNewSimulation);

		tittle_result = new JLabel("Simulation Result");
		setTittle(tittle_result);
		result.add(tittle_result);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Scenario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(707, 63, 260, 187);
		result.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		scenario = new JTextArea();
		scenario.setLineWrap(true);
		panel_1.add(scenario);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Result", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(707, 262, 260, 201);
		result.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		textResult = new JTextArea();
		textResult.setLineWrap(true);
		panel_2.add(textResult);

		pic_inte_result = new JLabel("pic_inte_result");
		pic_inte_result.setLocation(20, 65);
		pic_inte_result.setSize(675, 540);
		result.add(pic_inte_result);

		pic_beha_result = new JLabel("pic_beha_result");
		pic_beha_result.setLocation(20, 65);
		pic_beha_result.setSize(675, 540);
		result.add(pic_beha_result);

		pic_envi_result = new JLabel("pic_envi_result");
		pic_envi_result.setLocation(20, 65);
		pic_envi_result.setSize(675, 540);
		result.add(pic_envi_result);
	}

	/**
	 * A panel
	 */
	private void envi_menu() {
		btnNewButton_10 = new JButton("Create");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				newEnvi.setVisible(true);
				environment.setVisible(false);
			}
		});
		btnNewButton_10.setBounds(357, 119, 117, 29);
		environment.add(btnNewButton_10);

		tittle_envi = new JLabel("Environment Library");
		setTittle(tittle_envi);
		environment.add(tittle_envi);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(26, 228, 319, 111);
		environment.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		enviInfo = new JTextArea();
		enviInfo.setLineWrap(true);
		enviInfo.setEditable(false);
		panel.add(enviInfo);

		scrollPaneE = new JScrollPane();
		scrollPaneE.setBounds(26, 105, 319, 111);
		environment.add(scrollPaneE);

		enviList = new JList();
		enviList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (!jlistEnviModified) {
						String selected = enviList.getSelectedValue().toString();
						enviMenuID = Integer.parseInt(selected.split("\\.")[0]);
						enviInfo.setText(EnvironmentDatabase.get(enviMenuID).getName() + ":\n" + EnvironmentDatabase.get(enviMenuID).getInfo());
						pic_envi_menu.setIcon(getImageIcon("envi" + enviMenuID + ".jpg", 1000, 778));
					} else
						jlistEnviModified = false;
				}
			}
		});
		enviList.setModel(new AbstractListModel() {
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			String[] values = EnvironmentDatabase.getArray();

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPaneE.setViewportView(enviList);

		btnNewButton_11 = new JButton("Delete");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				if (enviMenuID != 0) {
					EnvironmentDatabase.delete(enviMenuID);
					EnvironmentDatabase.save();

					// refresh jlist envi
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

		btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				enviInfo.setText("");
				environment.setVisible(false);
				main.setVisible(true);
			}
		});
		btnBack_2.setBounds(357, 201, 117, 29);
		environment.add(btnBack_2);

		pic_envi_menu = new JLabel("pic_envi_menu");
		pic_envi_menu.setBounds(0, 0, 1000, 678);
		pic_envi_menu.setIcon(getImageIcon("envi" + enviMenuID + ".jpg", 1000, 778));
		environment.add(pic_envi_menu);
	}

	/**
	 * A panel
	 */
	private void inte_menu() {
		btnNewButton_12 = new JButton("Create");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				newInter.setVisible(true);
				interaction.setVisible(false);
			}
		});
		btnNewButton_12.setBounds(357, 119, 117, 29);
		interaction.add(btnNewButton_12);

		tittle_inte = new JLabel("Interaction Library");
		setTittle(tittle_inte);
		interaction.add(tittle_inte);

		panel2 = new JPanel();
		panel2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel2.setLocation(2, 0);
		panel2.setBounds(26, 228, 319, 111);
		interaction.add(panel2);
		panel2.setLayout(new GridLayout(1, 0, 0, 0));

		inteInfo = new JTextArea();
		inteInfo.setLineWrap(true);
		inteInfo.setEditable(false);
		panel2.add(inteInfo);

		scrollPaneI = new JScrollPane();
		scrollPaneI.setBounds(26, 105, 319, 111);
		interaction.add(scrollPaneI);

		inteList = new JList();
		inteList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (!jlistInteModified) {
						String selected = inteList.getSelectedValue().toString();
						inteMenuID = Integer.parseInt(selected.split("\\.")[0]);
						inteInfo.setText(InteractionDatabase.get(inteMenuID).getName() + ":\n" + InteractionDatabase.get(inteMenuID).getInfo());
						pic_inte_menu.setIcon(getImageIcon("inte" + inteMenuID + ".png", 1000, 778));
					} else
						jlistInteModified = false;
				}
			}
		});
		inteList.setModel(new AbstractListModel() {
			/**
			 *
			 */
			private static final long serialVersionUID = 1L;
			String[] values = InteractionDatabase.getArray();

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPaneI.setViewportView(inteList);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				if (inteMenuID != 0) {
					InteractionDatabase.delete(inteMenuID);
					InteractionDatabase.save();

					// refresh jlist inte
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

		btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				inteInfo.setText("");
				interaction.setVisible(false);
				main.setVisible(true);
			}
		});
		btnBack_3.setBounds(357, 201, 117, 29);
		interaction.add(btnBack_3);
		
		pic_inte_menu = new JLabel("pic_inte_menu");
		pic_inte_menu.setBounds(0, 0, 1000, 678);
		pic_inte_menu.setIcon(getImageIcon("inte" + inteMenuID + ".jpg", 1000, 778));
		interaction.add(pic_inte_menu);
	}

	/**
	 * A panel
	 */
	private void new_interaction() {
		btnNInteBack = new JButton("Back");
		btnNInteBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				newInter.setVisible(false);
				interaction.setVisible(true);
			}
		});
		btnNInteBack.setBounds(233, 326, 117, 29);
		newInter.add(btnNInteBack);

		tittle_newInte = new JLabel("New Interaction");
		setTittle(tittle_newInte);
		newInter.add(tittle_newInte);

		lblInteractionName = new JLabel("Interaction Name :");
		lblInteractionName.setBounds(16, 107, 138, 16);
		newInter.add(lblInteractionName);

		lblInteractionType = new JLabel("Interaction Type :");
		lblInteractionType.setBounds(16, 135, 138, 16);
		newInter.add(lblInteractionType);

		lblHowDoesThis = new JLabel("How does this interaction affect our cat's emotion?");
		lblHowDoesThis.setBounds(16, 163, 331, 16);
		newInter.add(lblHowDoesThis);

		lblExicted = new JLabel("Excited :");
		lblExicted.setBounds(16, 191, 70, 16);
		newInter.add(lblExicted);

		lblFearful = new JLabel("Fearful :");
		lblFearful.setBounds(16, 247, 70, 16);
		newInter.add(lblFearful);

		lblRelieved = new JLabel("Relieved :");
		lblRelieved.setBounds(16, 275, 70, 16);
		newInter.add(lblRelieved);

		lblAngry = new JLabel("Angry :");
		lblAngry.setBounds(16, 303, 70, 16);
		newInter.add(lblAngry);

		textFieldE = new JTextField();
		textFieldE.setText("Neutral");
		textFieldE.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldE.setEditable(false);
		textFieldE.setColumns(10);
		textFieldE.setBounds(416, 185, 117, 28);
		newInter.add(textFieldE);

		textFieldF = new JTextField();
		textFieldF.setText("Neutral");
		textFieldF.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldF.setEditable(false);
		textFieldF.setColumns(10);
		textFieldF.setBounds(416, 213, 117, 28);
		newInter.add(textFieldF);

		textFieldR = new JTextField();
		textFieldR.setText("Neutral");
		textFieldR.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldR.setEditable(false);
		textFieldR.setColumns(10);
		textFieldR.setBounds(362, 241, 117, 28);
		newInter.add(textFieldR);

		textFieldA = new JTextField();
		textFieldA.setText("Neutral");
		textFieldA.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldA.setEditable(false);
		textFieldA.setColumns(10);
		textFieldA.setBounds(362, 269, 117, 28);
		newInter.add(textFieldA);

		sliderE = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderE.setMinorTickSpacing(1);
		sliderE.setMajorTickSpacing(2);
		sliderE.setPaintTicks(true);
		sliderE.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
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

		sliderF = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderF.setMinorTickSpacing(1);
		sliderF.setMajorTickSpacing(2);
		sliderF.setPaintTicks(true);
		sliderF.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
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

		sliderR = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderR.setMinorTickSpacing(1);
		sliderR.setMajorTickSpacing(2);
		sliderR.setPaintTicks(true);
		sliderR.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
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

		sliderA = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderA.setMinorTickSpacing(1);
		sliderA.setMajorTickSpacing(2);
		sliderA.setPaintTicks(true);
		sliderA.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
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

		newNameI = new JTextField();
		newNameI.setBounds(150, 101, 160, 28);
		newInter.add(newNameI);
		newNameI.setColumns(10);

		newTypeI = new JComboBox(InteractionCategory.values());
		newTypeI.setBounds(150, 131, 160, 27);
		newInter.add(newTypeI);

		// --- create new Interaction when button clicked

		btnNewButton_6 = new JButton("OK");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				if (newNameI.getText().equals(""))
					inteInfo.setText("Invalid input!");
				else {
					InteractionCategory type = (InteractionCategory) newTypeI.getSelectedItem();
					Interaction inter = new Interaction(InteractionDatabase.getSize() + 1, newNameI.getText(), type, newE, newF, newR, newA, inputDescription.getText());
					InteractionDatabase.add(inter);
					// save to file
					InteractionDatabase.save();

					// Refresh jlist inte
					jlistInteModified = true;
					inteList.setListData(InteractionDatabase.getArray());
					scrollPaneI.revalidate();
					scrollPaneI.repaint();

					inteInfo.setText("New interaction object has been created!");
				}
				newNameI.setText("");
				inputDescription.setText("");
				
				newInter.setVisible(false);
				interaction.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(362, 326, 117, 29);
		newInter.add(btnNewButton_6);

		lblDescription = new JLabel("Description:");
		lblDescription.setBounds(443, 107, 90, 16);
		newInter.add(lblDescription);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(555, 77, 238, 114);
		newInter.add(scrollPane);

		inputDescription = new JTextArea();
		scrollPane.setViewportView(inputDescription);
		inputDescription.setLineWrap(true);
	}

	/**
	 * A panel
	 */
	private void new_environment() {
		btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				newEnvi.setVisible(false);
				environment.setVisible(true);
			}
		});
		btnBack_1.setBounds(237, 327, 117, 29);
		newEnvi.add(btnBack_1);

		tittle_newEnvi = new JLabel("New Environment");
		setTittle(tittle_newEnvi);
		newEnvi.add(tittle_newEnvi);

		lblNewEnvironmentDetails = new JLabel("Environment Name:");
		lblNewEnvironmentDetails.setBounds(23, 101, 130, 16);
		newEnvi.add(lblNewEnvironmentDetails);

		lblPleaseSpecifyThe = new JLabel("Please specify the characteristics of this environment :");
		lblPleaseSpecifyThe.setBounds(23, 129, 375, 16);
		newEnvi.add(lblPleaseSpecifyThe);

		lblTemperature = new JLabel("Temperature :");
		lblTemperature.setBounds(23, 157, 130, 16);
		newEnvi.add(lblTemperature);

		lblHumidity = new JLabel("Humidity :");
		lblHumidity.setBounds(23, 185, 130, 16);
		newEnvi.add(lblHumidity);

		lblLight = new JLabel("Light :");
		lblLight.setBounds(23, 213, 130, 16);
		newEnvi.add(lblLight);

		lblNoise = new JLabel("Noise :");
		lblNoise.setBounds(23, 241, 130, 16);
		newEnvi.add(lblNoise);

		newNameE = new JTextField();
		newNameE.setBounds(165, 95, 168, 28);
		newEnvi.add(newNameE);
		newNameE.setColumns(10);

		textFieldT = new JTextField();
		textFieldT.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldT.setText("Neutral");
		textFieldT.setEditable(false);
		textFieldT.setBounds(393, 151, 91, 28);
		newEnvi.add(textFieldT);
		textFieldT.setColumns(10);

		textFieldH = new JTextField();
		textFieldH.setText("Neutral");
		textFieldH.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldH.setEditable(false);
		textFieldH.setColumns(10);
		textFieldH.setBounds(393, 179, 91, 28);
		newEnvi.add(textFieldH);

		textFieldL = new JTextField();
		textFieldL.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldL.setText("Neutral");
		textFieldL.setEditable(false);
		textFieldL.setColumns(10);
		textFieldL.setBounds(393, 207, 91, 28);
		newEnvi.add(textFieldL);

		textFieldN = new JTextField();
		textFieldN.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldN.setText("Neutral");
		textFieldN.setEditable(false);
		textFieldN.setColumns(10);
		textFieldN.setBounds(393, 235, 91, 28);
		newEnvi.add(textFieldN);

		sliderT = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderT.setMinorTickSpacing(1);
		sliderT.setMajorTickSpacing(2);
		sliderT.setPaintTicks(true);
		sliderT.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
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

		sliderH = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderH.setMinorTickSpacing(1);
		sliderH.setMajorTickSpacing(2);
		sliderH.setPaintTicks(true);
		sliderH.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
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

		sliderL = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderL.setMinorTickSpacing(1);
		sliderL.setMajorTickSpacing(2);
		sliderL.setPaintTicks(true);
		sliderL.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
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

		sliderN = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
		sliderN.setMinorTickSpacing(1);
		sliderN.setMajorTickSpacing(2);
		sliderN.setPaintTicks(true);
		sliderN.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
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

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				String name = newNameE.getText();
				newNameE.setText("");

				if (name.equals(""))
					enviInfo.setText("Invalid input!");
				else {
					Environment envi = new Environment(EnvironmentDatabase.getSize() + 1, name, newT, newH, newL, newN);
					EnvironmentDatabase.add(envi);
					// save to file
					EnvironmentDatabase.save();

					// Refresh jlist envi
					jlistEnviModified = true;
					enviList.setListData(EnvironmentDatabase.getArray());
					scrollPaneE.revalidate();
					scrollPaneE.repaint();

					enviInfo.setText("New environment has been created!");
				}

				newEnvi.setVisible(false);
				environment.setVisible(true);
			}
		});
		btnOk.setBounds(367, 327, 117, 29);
		newEnvi.add(btnOk);
	}

	/**
	 * A panel
	 */
	private void simulation_menu() {
		start = new JButton("Start");
		start.setEnabled(false);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				// the simulation is here
				String[] s = Simulator.simulationResultGUI(cat, EnvironmentDatabase.get(enviID), InteractionDatabase.get(inteID));
				updateResultPanel(s, enviID, inteID, 0);

				simulation.setVisible(false);
				result.setVisible(true);
			}
		});
		start.setBounds(346, 466, 117, 29);
		simulation.add(start);

		btnNewButton_9 = new JButton("Back");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();

				enviChosen = false;
				inteChosen = false;

				start.setEnabled(false);
				chooseInte.setText("");
				chooseEnvi.setText("");
				simulation.setVisible(false);
				main.setVisible(true);
			}
		});
		btnNewButton_9.setBounds(346, 507, 117, 29);
		simulation.add(btnNewButton_9);

		tittle_simulation = new JLabel("Simulation");
		setTittle(tittle_simulation);
		simulation.add(tittle_simulation);

		catStatus = new JPanel();
		catStatus.setBackground(Color.WHITE);
		catStatus.setBorder(new TitledBorder(null, "Current Cat Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		catStatus.setBounds(27, 370, 200, 136);
		catStatus.setLayout(new GridLayout(0, 1, 0, 0));
		simulation.add(catStatus);

		status = new JTextArea();
		catStatus.add(status);
		status.setLineWrap(true);
		status.setText(cat.printStatusGUI());
		status.setEditable(false);

		chooseInte = new JTextField();
		chooseInte.setHorizontalAlignment(SwingConstants.CENTER);
		chooseInte.setEditable(false);
		chooseInte.setColumns(10);
		chooseInte.setBounds(239, 411, 224, 28);
		simulation.add(chooseInte);

		imenu = new JScrollPane();
		imenu.setBounds(239, 299, 224, 100);
		simulation.add(imenu);

		chooseInteList = new JList();
		chooseInteList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (!inteList_simulation_modified) {
						String selected = chooseInteList.getSelectedValue().toString();
						chooseInte.setText(selected.substring(3));
						inteID = Integer.parseInt(selected.split("\\.")[0]);
						pic_inte_simulation.setIcon(getImageIcon("inte" + inteID + ".png", 500, 400));

						inteChosen = true;
						if (enviChosen)
							start.setEnabled(true);
					} else
						inteList_simulation_modified = false;
				}
			}
		});
		imenu.setViewportView(chooseInteList);

		chooseEnvi = new JTextField();
		chooseEnvi.setHorizontalAlignment(SwingConstants.CENTER);
		chooseEnvi.setEditable(false);
		chooseEnvi.setBounds(239, 218, 224, 28);
		simulation.add(chooseEnvi);
		chooseEnvi.setColumns(10);

		emenu = new JScrollPane();
		emenu.setBounds(239, 106, 224, 100);
		simulation.add(emenu);

		chooseEnviList = new JList();
		chooseEnviList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (!enviList_simulation_modified) {
						String selected = chooseEnviList.getSelectedValue()

								.toString();
						chooseEnvi.setText(selected.substring(3));
						enviID = Integer.parseInt(selected.split("\\.")[0]);
						pic_envi_simulation.setIcon(getImageIcon("envi" + enviID + ".jpg", 500, 400));

						enviChosen = true;
						if (inteChosen)
							start.setEnabled(true);
					} else
						enviList_simulation_modified = false;

				}
			}
		});
		emenu.setViewportView(chooseEnviList);

		pic_cat_status = new JLabel("pic_cat_status");
		pic_cat_status.setIcon(getImageIcon("status" + cat.getImageNo() + ".jpg", 200, 200));
		pic_cat_status.setBounds(27, 106, 200, 250);
		simulation.add(pic_cat_status);

		lblNewLabel_6 = new JLabel("Input information for the simulation:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(27, 78, 250, 16);
		simulation.add(lblNewLabel_6);

		lblEnvironment = new JLabel("Environment");
		lblEnvironment.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnvironment.setBounds(288, 78, 127, 16);
		simulation.add(lblEnvironment);

		lblInteraction = new JLabel("Interaction");
		lblInteraction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInteraction.setBounds(288, 271, 127, 16);
		simulation.add(lblInteraction);

		btnRandomEmotion = new JButton("Random Emotion");
		btnRandomEmotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				cat.setEmotion(random(-10, 10), random(-10, 10), random(-10, 10), random(-10, 10));
				status.setText(cat.printStatusGUI());
				pic_cat_status.setIcon(getImageIcon("status" + cat.getImageNo() + ".jpg", 200, 200));
			}
		});
		btnRandomEmotion.setBounds(27, 518, 117, 29);
		simulation.add(btnRandomEmotion);

		btnResetEmotion = new JButton("Reset Emotion");
		btnResetEmotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				cat.setEmotion(0, 0, 0, 0);
				status.setText(cat.printStatusGUI());
				pic_cat_status.setIcon(getImageIcon("status" + cat.getImageNo() + ".jpg", 200, 200));
			}
		});
		btnResetEmotion.setBounds(156, 518, 117, 29);
		simulation.add(btnResetEmotion);
		
		pic_inte_simulation = new JLabel("inte");
		pic_inte_simulation.setBounds(475, 110, 500, 400);
		simulation.add(pic_inte_simulation);
		
		pic_envi_simulation = new JLabel("pic_envi");
		pic_envi_simulation.setBounds(475, 110, 500, 400);
		pic_envi_simulation.setIcon(getImageIcon("envi" + enviMenuID + ".jpg", 500, 400));
		simulation.add(pic_envi_simulation);
	}

	/**
	 * A panel
	 */
	private void behaviour_menu() {
		btnBack_4 = new JButton("Back");
		btnBack_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				behaviour.setVisible(false);
				main.setVisible(true);
			}
		});
		btnBack_4.setBounds(675, 499, 117, 29);
		behaviour.add(btnBack_4);

		tittle_beha = new JLabel("New label");
		setTittle(tittle_beha);
		behaviour.add(tittle_beha);
	}

	/**
	 * A panel
	 */
	private void credit() {
		pic_credit = new JLabel("pic_credit");
		pic_credit.setIcon(new ImageIcon("resource/images/bg2.gif"));
		pic_credit.setBounds(682, 140, 250, 228);
		credit.add(pic_credit);

		tittle_credit = new JLabel("CREDIT");
		setTittle(tittle_credit);
		credit.add(tittle_credit);

		btnBack = new JButton("Back");
		btnBack.setBounds(759, 554, 117, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				main.setVisible(true);
				credit.setVisible(false);
			}
		});
		credit.add(btnBack);

		scrollPaneCredit = new JScrollPane();
		scrollPaneCredit.setBounds(60, 140, 567, 443);
		credit.add(scrollPaneCredit);

		txtrCredit = new JTextArea();
		txtrCredit.setText("Cat Behaviour Simulator\n\nThird Year Project\n\nUniversity of Manchester\n\nAuthor: Duc A. Nguyen\n\nSupervisor: Dr John Sargeant\n\nReference Sources:\n-\n-\n-\n-\n-\n-\n-\n-\n-\n-\n");
		scrollPaneCredit.setColumnHeaderView(txtrCredit);
	}

	private void setTittle(JLabel t) {
		t.setBounds(0, 30, 1000, 75);
		t.setForeground(Color.ORANGE);
		t.setFont(customFont);
		t.setHorizontalAlignment(SwingConstants.CENTER);

	}

	private void updateResultPanel(String[] s, int enviID, int inteID, int behaID) {
		pic_inte_result.setIcon(getImageIcon("inte" + inteID + ".png", 675,540));
		pic_beha_result.setIcon(getImageIcon("beha" + s[3] + ".png", 675,540));
		pic_envi_result.setIcon(getImageIcon("envi" + enviID + ".jpg", 675,540));
		scenario.setText(s[0]);
		textResult.setText(s[1] + " " + s[2]);
	}

	/**
	 * @return ImageIcon of the resized picture 'name'
	 */
	private ImageIcon getImageIcon(String name, int width, int height) {
		ImageIcon icon = new ImageIcon("resource/images/" + name);
		Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		icon.setImage(image);
		return icon;
	}

	/**
	 * @return a random integer in range [min,max]
	 */
	private int random(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	private void customFont() {
		// create the font
		try {
			// create the font to use. Specify the size!
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("resource/font/font1.ttf")).deriveFont(50f);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}
	}
}