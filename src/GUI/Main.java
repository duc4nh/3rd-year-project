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
	private JButton btnMusicToggle;
	private JButton btnSoundToggle;
	private JButton btnBack_5;
	private JButton btnTheme;
	private JLabel tittle_settings;
	private JButton btnNewButton_13;
	private JLabel tittle_result;
	private JPanel catStatus;
	private JTextArea status;
	private JButton btnNewSimulation;
	private JPanel catStatus_result;
	private JTextArea status_result;
	private JButton create_envi_menu;
	private JLabel tittle_envi;
	private JPanel info_panel_envi_menu;
	private JTextArea enviInfo;
	private JScrollPane scrollPaneE;
	private JList enviList;
	private JButton delete_envi_menu;
	private JButton back_envi_menu;
	private JLabel pic_envi_menu;
	private JButton create_inte_menu;
	private JLabel tittle_inte;
	private JPanel info_panel_inte_menu;
	private JTextArea inteInfo;
	private JScrollPane scrollPaneI;
	private JList inteList;
	private JButton delete_inte_menu;
	private JButton back_inte_menu;
	private JLabel pic_inte_menu;
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
	private JPanel scenario_panel_reuslt;
	private JTextArea scenario;
	private JPanel textResult_panel_result;
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
	private JLabel pic_credit;
	private JLabel tittle_credit;
	private JButton btnBack;
	private JScrollPane scrollPaneCredit;
	private JTextArea txtrCredit;
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
			default:
				color = Color.DARK_GRAY;
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
		btnStartSimulation.setBounds(809, 183, 157, 29);
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
		btnEnviLibrary.setBounds(809, 306, 157, 29);
		btnEnviLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				main.setVisible(false);
				environment.setVisible(true);
			}
		});

		btnInteLibrary = new JButton("Interaction Library");
		btnInteLibrary.setBounds(809, 265, 157, 29);
		btnInteLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				main.setVisible(false);
				interaction.setVisible(true);
			}
		});

		btnBehaviourLibrary = new JButton("Behaviour Library");
		btnBehaviourLibrary.setEnabled(false);
		btnBehaviourLibrary.setVisible(false);
		btnBehaviourLibrary.setBounds(809, 540, 157, 29);
		btnBehaviourLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				main.setVisible(false);
				behaviour.setVisible(true);
			}
		});

		btnExit = new JButton("Exit");
		btnExit.setBounds(809, 429, 157, 29);
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
		btnSettings.setBounds(809, 347, 157, 29);
		main.add(btnSettings);

		tittle_main = new JLabel("CAT SIMULATOR");
		setTittle(tittle_main);
		main.add(tittle_main);

		btnCredit = new JButton("Credit");
		btnCredit.setBounds(809, 388, 157, 29);
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
				// Let the cat meet with random interaction and environment
				// Cat randomCat = new Cat("Random Cat", "Common Domestic Cat", new Emotion(random(-10, 10), random(-10, 10), random(-10, 10), random(-10, 10)));
				int random_envi = random(1, EnvironmentDatabase.getSize());
				int random_inte = random(1, InteractionDatabase.getSize());
				String[] s = Simulator.simulationResultGUI(cat, EnvironmentDatabase.get(random_envi), InteractionDatabase.get(random_inte));
				updateResultPanel(s, random_envi, random_inte, 0);

				main.setVisible(false);
				result.setVisible(true);
			}
		});
		btnQuickSimulation.setBounds(809, 224, 157, 29);
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
		btnMusicToggle.setBounds(430, 294, 150, 40);
		settings.add(btnMusicToggle);

		btnSoundToggle = new JButton("Sound: On");
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
		btnSoundToggle.setBounds(430, 242, 150, 40);
		settings.add(btnSoundToggle);

		btnBack_5 = new JButton("Back");
		btnBack_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				settings.setVisible(false);
				main.setVisible(true);
			}
		});
		btnBack_5.setBounds(430, 346, 150, 40);
		settings.add(btnBack_5);

		btnTheme = new JButton("Theme: Light");
		btnTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				switch (theme) {
					case 0:
						btnTheme.setText("Theme: Dark");
						theme = 1;
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
		btnTheme.setBounds(430, 190, 150, 40);
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
		btnNewButton_13.setBounds(793, 604, 150, 29);
		result.add(btnNewButton_13);

		btnQuickSimulation_1 = new JButton("Quick Simulation");
		btnQuickSimulation_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				// Let the cat meet with random interaction and environment
				// Cat randomCat = new Cat("Random Cat", "Common Domestic Cat", new Emotion(random(-10, 10), random(-10, 10), random(-10, 10), random(-10, 10)));
				int random_envi = random(1, EnvironmentDatabase.getSize());
				int random_inte = random(1, InteractionDatabase.getSize());
				String[] s = Simulator.simulationResultGUI(cat, EnvironmentDatabase.get(random_envi), InteractionDatabase.get(random_inte));
				updateResultPanel(s, random_envi, random_inte, 0);
			}
		});
		btnQuickSimulation_1.setBounds(793, 522, 150, 29);
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
		btnNewSimulation.setBounds(793, 563, 150, 29);
		result.add(btnNewSimulation);

		tittle_result = new JLabel("Simulation Result");
		setTittle(tittle_result);
		result.add(tittle_result);

		scenario_panel_reuslt = new JPanel();
		scenario_panel_reuslt.setBackground(Color.WHITE);
		scenario_panel_reuslt.setBorder(new TitledBorder(null, "Scenario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scenario_panel_reuslt.setBounds(717, 115, 260, 80);
		result.add(scenario_panel_reuslt);
		scenario_panel_reuslt.setLayout(new GridLayout(0, 1, 0, 0));

		scenario = new JTextArea();
		scenario.setEditable(false);
		scenario.setLineWrap(true);
		scenario_panel_reuslt.add(scenario);

		textResult_panel_result = new JPanel();
		textResult_panel_result.setBackground(Color.WHITE);
		textResult_panel_result.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Result", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		textResult_panel_result.setBounds(717, 207, 260, 140);
		result.add(textResult_panel_result);
		textResult_panel_result.setLayout(new GridLayout(0, 1, 0, 0));

		textResult = new JTextArea();
		textResult.setEditable(false);
		textResult.setLineWrap(true);
		textResult_panel_result.add(textResult);
		
		catStatus_result = new JPanel();
		catStatus_result.setBackground(Color.WHITE);
		catStatus_result.setBorder(new TitledBorder(null, "Current Cat Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		catStatus_result.setBounds(717, 359, 260, 151);
		catStatus_result.setLayout(new GridLayout(0, 1, 0, 0));
		result.add(catStatus_result);

		status_result = new JTextArea();
		status_result.setLineWrap(true);
		status_result.setEditable(false);
		catStatus_result.add(status_result);

		pic_inte_result = new JLabel("pic_inte_result");
		pic_inte_result.setLocation(30, 115);
		pic_inte_result.setSize(675, 540);
		result.add(pic_inte_result);

		pic_beha_result = new JLabel("pic_beha_result");
		pic_beha_result.setLocation(30, 115);
		pic_beha_result.setSize(675, 540);
		result.add(pic_beha_result);

		pic_envi_result = new JLabel("pic_envi_result");
		pic_envi_result.setLocation(30, 115);
		pic_envi_result.setSize(675, 540);
		result.add(pic_envi_result);
	}

	/**
	 * A panel
	 */
	private void envi_menu() {
		create_envi_menu = new JButton("Create");
		create_envi_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				newEnvi.setVisible(true);
				environment.setVisible(false);
			}
		});
		create_envi_menu.setBounds(729, 463, 117, 29);
		environment.add(create_envi_menu);

		tittle_envi = new JLabel("Environment LIB");
		setTittle(tittle_envi);
		environment.add(tittle_envi);

		info_panel_envi_menu = new JPanel();
		info_panel_envi_menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		info_panel_envi_menu.setBounds(249, 364, 400, 210);
		environment.add(info_panel_envi_menu);
		info_panel_envi_menu.setLayout(new GridLayout(1, 0, 0, 0));

		enviInfo = new JTextArea();
		enviInfo.setLineWrap(true);
		enviInfo.setEditable(false);
		info_panel_envi_menu.add(enviInfo);

		scrollPaneE = new JScrollPane();
		scrollPaneE.setBounds(249, 156, 400, 180);
		environment.add(scrollPaneE);

		enviList = new JList();
		enviList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (!jlistEnviModified) {
						String selected = enviList.getSelectedValue().toString();
						enviMenuID = Integer.parseInt(selected.split("\\.")[0]);
						enviInfo.setText(EnvironmentDatabase.get(enviMenuID).getName() + ":\n" + EnvironmentDatabase.get(enviMenuID).getInfo());
						pic_envi_menu.setIcon(getImageIcon("envi" + EnvironmentDatabase.get(enviMenuID).getId() + ".jpg", 1000, 778));
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

		delete_envi_menu = new JButton("Delete");
		delete_envi_menu.addActionListener(new ActionListener() {
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
		delete_envi_menu.setBounds(729, 504, 117, 29);
		environment.add(delete_envi_menu);

		back_envi_menu = new JButton("Back");
		back_envi_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				enviInfo.setText("");
				environment.setVisible(false);
				main.setVisible(true);
			}
		});
		back_envi_menu.setBounds(729, 545, 117, 29);
		environment.add(back_envi_menu);

		pic_envi_menu = new JLabel("pic_envi_menu");
		pic_envi_menu.setBounds(0, 0, 1000, 678);
		pic_envi_menu.setIcon(getImageIcon("envi0.jpg", 1000, 778));
		environment.add(pic_envi_menu);
	}

	/**
	 * A panel
	 */
	private void inte_menu() {
		create_inte_menu = new JButton("Create");
		create_inte_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				newInter.setVisible(true);
				interaction.setVisible(false);
			}
		});
		create_inte_menu.setBounds(750, 156, 117, 29);
		interaction.add(create_inte_menu);

		tittle_inte = new JLabel("Interaction LIB");
		setTittle(tittle_inte);
		interaction.add(tittle_inte);

		info_panel_inte_menu = new JPanel();
		info_panel_inte_menu.setBorder(new LineBorder(new Color(0, 0, 0)));
		info_panel_inte_menu.setLocation(2, 0);
		info_panel_inte_menu.setBounds(80, 364, 400, 210);
		interaction.add(info_panel_inte_menu);
		info_panel_inte_menu.setLayout(new GridLayout(1, 0, 0, 0));

		inteInfo = new JTextArea();
		inteInfo.setLineWrap(true);
		inteInfo.setEditable(false);
		info_panel_inte_menu.add(inteInfo);

		scrollPaneI = new JScrollPane();
		scrollPaneI.setBounds(80, 156, 400, 180);
		interaction.add(scrollPaneI);

		inteList = new JList();
		inteList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (!jlistInteModified) {
						String selected = inteList.getSelectedValue().toString();
						inteMenuID = Integer.parseInt(selected.split("\\.")[0]);
						inteInfo.setText(InteractionDatabase.get(inteMenuID).getName() + ":\n" + InteractionDatabase.get(inteMenuID).getInfo());
						pic_inte_menu.setIcon(getImageIcon("inte" + InteractionDatabase.get(inteMenuID).getId() + ".png", 1000, 778));
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

		delete_inte_menu = new JButton("Delete");
		delete_inte_menu.addActionListener(new ActionListener() {
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
		delete_inte_menu.setBounds(750, 197, 117, 29);
		interaction.add(delete_inte_menu);

		back_inte_menu = new JButton("Back");
		back_inte_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sound.playButton2();
				inteInfo.setText("");
				interaction.setVisible(false);
				main.setVisible(true);
			}
		});
		back_inte_menu.setBounds(750, 238, 117, 29);
		interaction.add(back_inte_menu);

		pic_inte_menu = new JLabel("pic_inte_menu");
		pic_inte_menu.setBounds(0, 0, 1000, 678);
		pic_inte_menu.setIcon(getImageIcon("inte_bg.jpeg", 1000, 778));
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
		btnNInteBack.setBounds(680, 555, 117, 29);
		newInter.add(btnNInteBack);

		tittle_newInte = new JLabel("New Interaction");
		setTittle(tittle_newInte);
		newInter.add(tittle_newInte);

		lblInteractionName = new JLabel("Interaction Name :");
		lblInteractionName.setBounds(147, 142, 138, 16);
		newInter.add(lblInteractionName);

		lblInteractionType = new JLabel("Interaction Type :");
		lblInteractionType.setBounds(147, 170, 138, 16);
		newInter.add(lblInteractionType);

		lblHowDoesThis = new JLabel("How does this interaction affect our cat's emotion?");
		lblHowDoesThis.setBounds(147, 198, 331, 16);
		newInter.add(lblHowDoesThis);

		lblExicted = new JLabel("Excited :");
		lblExicted.setBounds(215, 232, 70, 16);
		newInter.add(lblExicted);

		lblFearful = new JLabel("Fearful :");
		lblFearful.setBounds(215, 282, 70, 16);
		newInter.add(lblFearful);

		lblRelieved = new JLabel("Relieved :");
		lblRelieved.setBounds(215, 338, 70, 16);
		newInter.add(lblRelieved);

		lblAngry = new JLabel("Angry :");
		lblAngry.setBounds(215, 400, 70, 16);
		newInter.add(lblAngry);

		textFieldE = new JTextField();
		textFieldE.setText("Neutral");
		textFieldE.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldE.setEditable(false);
		textFieldE.setColumns(10);
		textFieldE.setBounds(606, 226, 120, 28);
		newInter.add(textFieldE);

		textFieldF = new JTextField();
		textFieldF.setText("Neutral");
		textFieldF.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldF.setEditable(false);
		textFieldF.setColumns(10);
		textFieldF.setBounds(606, 276, 120, 28);
		newInter.add(textFieldF);

		textFieldR = new JTextField();
		textFieldR.setText("Neutral");
		textFieldR.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldR.setEditable(false);
		textFieldR.setColumns(10);
		textFieldR.setBounds(606, 332, 120, 28);
		newInter.add(textFieldR);

		textFieldA = new JTextField();
		textFieldA.setText("Neutral");
		textFieldA.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldA.setEditable(false);
		textFieldA.setColumns(10);
		textFieldA.setBounds(606, 394, 120, 28);
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
					textFieldE.setText("Less Exited");
				else if (value < 2)
					textFieldE.setText("Neutral");
				else if (value < 4)
					textFieldE.setText("A bit Exited");
				else
					textFieldE.setText("Very Excite!!");
				newE = value;
			}
		});
		sliderE.setBounds(297, 226, 281, 50);
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
					textFieldF.setText("Less Fearful");
				else if (value < 2)
					textFieldF.setText("Neutral");
				else if (value < 4)
					textFieldF.setText("A bit Fearful");
				else
					textFieldF.setText("Very Fearful!!");
				newF = value;
			}
		});
		sliderF.setBounds(297, 276, 281, 50);
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
					textFieldR.setText("Less Relieved");
				else if (value < 2)
					textFieldR.setText("Neutral");
				else if (value < 4)
					textFieldR.setText("A bit Relieved");
				else
					textFieldR.setText("Very Relieved!!");
				newR = value;
			}
		});
		sliderR.setBounds(297, 332, 281, 50);
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
					textFieldA.setText("Less Angry");
				else if (value < 2)
					textFieldA.setText("Neutral");
				else if (value < 4)
					textFieldA.setText("A bit Angry");
				else
					textFieldA.setText("Very Angry!!");
				newA = value;
			}
		});
		sliderA.setBounds(297, 394, 281, 50);
		newInter.add(sliderA);

		// --- New interaction name and type

		newNameI = new JTextField();
		newNameI.setBounds(297, 136, 346, 28);
		newInter.add(newNameI);
		newNameI.setColumns(10);

		newTypeI = new JComboBox(InteractionCategory.values());
		newTypeI.setBounds(297, 166, 160, 27);
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
					Interaction inter = new Interaction(0, newNameI.getText(), type, newE, newF, newR, newA, inputDescription.getText());
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
		btnNewButton_6.setBounds(680, 514, 117, 29);
		newInter.add(btnNewButton_6);

		lblDescription = new JLabel("Description:");
		lblDescription.setBounds(147, 456, 90, 16);
		newInter.add(lblDescription);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(297, 456, 346, 152);
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
		btnBack_1.setBounds(678, 547, 117, 29);
		newEnvi.add(btnBack_1);

		tittle_newEnvi = new JLabel("New Environment");
		setTittle(tittle_newEnvi);
		newEnvi.add(tittle_newEnvi);

		lblNewEnvironmentDetails = new JLabel("Environment Name:");
		lblNewEnvironmentDetails.setBounds(147, 142, 130, 16);
		newEnvi.add(lblNewEnvironmentDetails);

		lblPleaseSpecifyThe = new JLabel("Please specify the characteristics of this environment :");
		lblPleaseSpecifyThe.setBounds(147, 185, 375, 16);
		newEnvi.add(lblPleaseSpecifyThe);

		lblTemperature = new JLabel("Temperature :");
		lblTemperature.setBounds(165, 225, 130, 16);
		newEnvi.add(lblTemperature);

		lblHumidity = new JLabel("Humidity :");
		lblHumidity.setBounds(165, 286, 130, 16);
		newEnvi.add(lblHumidity);

		lblLight = new JLabel("Light :");
		lblLight.setBounds(165, 340, 130, 16);
		newEnvi.add(lblLight);

		lblNoise = new JLabel("Noise :");
		lblNoise.setBounds(165, 399, 130, 16);
		newEnvi.add(lblNoise);

		newNameE = new JTextField();
		newNameE.setBounds(289, 136, 281, 28);
		newEnvi.add(newNameE);
		newNameE.setColumns(10);

		textFieldT = new JTextField();
		textFieldT.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldT.setText("Neutral");
		textFieldT.setEditable(false);
		textFieldT.setBounds(582, 219, 120, 28);
		newEnvi.add(textFieldT);
		textFieldT.setColumns(10);

		textFieldH = new JTextField();
		textFieldH.setText("Neutral");
		textFieldH.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldH.setEditable(false);
		textFieldH.setColumns(10);
		textFieldH.setBounds(582, 334, 120, 28);
		newEnvi.add(textFieldH);

		textFieldL = new JTextField();
		textFieldL.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldL.setText("Neutral");
		textFieldL.setEditable(false);
		textFieldL.setColumns(10);
		textFieldL.setBounds(582, 280, 120, 28);
		newEnvi.add(textFieldL);

		textFieldN = new JTextField();
		textFieldN.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldN.setText("Neutral");
		textFieldN.setEditable(false);
		textFieldN.setColumns(10);
		textFieldN.setBounds(582, 393, 120, 28);
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
					textFieldT.setText("A bit Cold");
				else if (value < 2)
					textFieldT.setText("Neutral");
				else if (value < 4)
					textFieldT.setText("A bit Hot");
				else
					textFieldT.setText("Very Hot!!");
				newT = value;
			}
		});
		sliderT.setBounds(289, 213, 281, 50);
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
					textFieldH.setText("A bit Humid");
				else if (value < 2)
					textFieldH.setText("Neutral");
				else if (value < 4)
					textFieldH.setText("A bit Dry");
				else
					textFieldH.setText("Very Dry!!");
				newH = value;
			}
		});
		sliderH.setBounds(289, 328, 281, 50);
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
					textFieldL.setText("A bit Dark");
				else if (value < 2)
					textFieldL.setText("Neutral");
				else if (value < 4)
					textFieldL.setText("A bit Light");
				else
					textFieldL.setText("Very Light!!");
				newL = value;
			}
		});
		sliderL.setBounds(289, 275, 281, 50);
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
					textFieldN.setText("A bit Quiet");
				else if (value < 2)
					textFieldN.setText("Neutral");
				else if (value < 4)
					textFieldN.setText("A bit Noisy");
				else
					textFieldN.setText("Very Noisy!!");
				newN = value;
			}
		});
		sliderN.setBounds(289, 387, 281, 50);
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
					Environment envi = new Environment(0, name, newT, newH, newL, newN);
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
		btnOk.setBounds(678, 506, 117, 29);
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
		start.setBounds(602, 591, 117, 29);
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
		btnNewButton_9.setBounds(731, 591, 117, 29);
		simulation.add(btnNewButton_9);

		tittle_simulation = new JLabel("Simulation");
		setTittle(tittle_simulation);
		simulation.add(tittle_simulation);

		catStatus = new JPanel();
		catStatus.setBackground(Color.WHITE);
		catStatus.setBorder(new TitledBorder(null, "Current Cat Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		catStatus.setBounds(27, 347, 200, 191);
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
		chooseInte.setBounds(239, 510, 224, 28);
		simulation.add(chooseInte);

		imenu = new JScrollPane();
		imenu.setBounds(239, 398, 224, 100);
		simulation.add(imenu);

		chooseInteList = new JList();
		chooseInteList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (!inteList_simulation_modified) {
						String selected = chooseInteList.getSelectedValue().toString();
						chooseInte.setText(selected.substring(3));
						inteID = Integer.parseInt(selected.split("\\.")[0]);
						pic_inte_simulation.setIcon(getImageIcon("inte" + InteractionDatabase.get(inteID).getId() + ".png", 500, 400));

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
		chooseEnvi.setBounds(239, 312, 224, 28);
		simulation.add(chooseEnvi);
		chooseEnvi.setColumns(10);

		emenu = new JScrollPane();
		emenu.setBounds(239, 200, 224, 100);
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
						pic_envi_simulation.setIcon(getImageIcon("envi" + EnvironmentDatabase.get(enviID).getId() + ".jpg", 500, 400));

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
		pic_cat_status.setBounds(27, 135, 200, 200);
		simulation.add(pic_cat_status);

		lblNewLabel_6 = new JLabel("Input information for the simulation:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(239, 122, 250, 16);
		simulation.add(lblNewLabel_6);

		lblEnvironment = new JLabel("Environment");
		lblEnvironment.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnvironment.setBounds(288, 172, 127, 16);
		simulation.add(lblEnvironment);

		lblInteraction = new JLabel("Interaction");
		lblInteraction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInteraction.setBounds(288, 370, 127, 16);
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
		btnRandomEmotion.setBounds(27, 591, 117, 29);
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
		btnResetEmotion.setBounds(156, 591, 117, 29);
		simulation.add(btnResetEmotion);
		
		pic_inte_simulation = new JLabel("inte");
		pic_inte_simulation.setBounds(475, 150, 500, 400);
		simulation.add(pic_inte_simulation);

		pic_envi_simulation = new JLabel("pic_envi");
		pic_envi_simulation.setBounds(475, 150, 500, 400);
		pic_envi_simulation.setIcon(getImageIcon("envi0.jpg", 500, 400));
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
		txtrCredit.setEditable(false);
		txtrCredit.setLineWrap(true);
		txtrCredit.setText("\nAbout the project:\nCat Behaviour Simulator is a Java application which simulates some aspects of domestic cat behaviour.\n\nThis is my final year project at the University of Manchester.\n\nAuthor: Duc Anh Nguyen <duc_anh_nguyen_93@yahoo.com>\n\nSupervisor: Dr John Sargeant\n\n*All images credited to Vu Dinh Trong Thang <vudinhtrongthang@gmail.com>");
		scrollPaneCredit.setColumnHeaderView(txtrCredit);
	}

	private void setTittle(JLabel t) {
		t.setBounds(0, 10, 1000, 120);
		t.setForeground(Color.BLACK);
		t.setFont(customFont);
		t.setHorizontalAlignment(SwingConstants.CENTER);
		t.setHorizontalTextPosition(JLabel.CENTER);
		t.setIcon(getImageIcon("tittle_background.png", 900, 85));
	}

	private void updateResultPanel(String[] s, int enviID, int inteID, int behaID) {
		pic_inte_result.setIcon(getImageIcon("inte" + InteractionDatabase.get(inteID).getId() + ".png", 675, 540));
		pic_beha_result.setIcon(getImageIcon("beha" + s[3] + ".png", 675, 540));
		pic_envi_result.setIcon(getImageIcon("envi" + EnvironmentDatabase.get(enviID).getId() + ".jpg", 675, 540));
		scenario.setText(s[0]);
		status_result.setText(cat.printStatusGUI());
		textResult.setText(s[1] + s[2]);
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