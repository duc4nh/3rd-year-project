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

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Main
{
    // initialize a neutral cat
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
    private JFrame frmCatSimulator;

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
        // open all database
        EnvironmentDatabase.openDatabase();
        InteractionDatabase.openDatabase();
        BehaviourDatabase.openDatabase();

        // GUI
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        frmCatSimulator = new JFrame();
        frmCatSimulator.setTitle("Cat Simulator");
        frmCatSimulator.getContentPane().setBackground(new Color(0, 51, 0));
        frmCatSimulator.setBounds(100, 100, 1000, 600);
        frmCatSimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCatSimulator.getContentPane().setLayout(new CardLayout(0, 0));

        final JPanel main = new JPanel();
        main.setBackground(Color.WHITE);
        frmCatSimulator.getContentPane().add(main, "name_1417370866784216000");
        main.setVisible(true);

        final JPanel newInter = new JPanel();
        newInter.setBackground(Color.WHITE);
        frmCatSimulator.getContentPane().add(newInter,
                "name_1417374299353503000");
        newInter.setLayout(null);
        newInter.setVisible(false);

        final JPanel newEnvi = new JPanel();
        newEnvi.setBackground(Color.WHITE);
        frmCatSimulator.getContentPane().add(newEnvi,
                "name_1417374268312883000");
        newEnvi.setLayout(null);
        newEnvi.setVisible(false);

        final JPanel credit = new JPanel();
        credit.setBackground(Color.WHITE);
        frmCatSimulator.getContentPane()
                .add(credit, "name_1417372166389926000");
        credit.setVisible(false);
        credit.setLayout(null);

        final JPanel simulation = new JPanel();
        simulation.setBackground(Color.WHITE);
        frmCatSimulator.getContentPane().add(simulation,
                "name_1417370866800002000");
        simulation.setLayout(null);
        simulation.setVisible(false);

        final JPanel environment = new JPanel();
        environment.setBackground(Color.WHITE);
        frmCatSimulator.getContentPane().add(environment,
                "name_1417371601176283000");
        environment.setLayout(null);
        environment.setVisible(false);

        final JPanel interaction = new JPanel();
        interaction.setBackground(Color.WHITE);
        frmCatSimulator.getContentPane().add(interaction,
                "name_1417374220953403000");
        interaction.setLayout(null);
        interaction.setVisible(false);

        final JPanel behaviour = new JPanel();
        behaviour.setBackground(Color.WHITE);
        frmCatSimulator.getContentPane().add(behaviour,
                "name_1417374241437629000");
        behaviour.setLayout(null);
        behaviour.setVisible(false);

        final JPanel result = new JPanel();
        result.setBackground(Color.WHITE);
        frmCatSimulator.getContentPane()
                .add(result, "name_1417436381075400000");
        result.setLayout(null);
        result.setVisible(false);

        // -------------------------- END of MAIN PANELS
        // -----------------------------

        JButton btnNewButton_13 = new JButton("Main Menu");
        btnNewButton_13.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                result.setVisible(false);
                main.setVisible(true);
            }
        });
        btnNewButton_13.setBounds(442, 515, 117, 29);
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
                result.setVisible(false);
                simulation.setVisible(true);

                status.setText(cat.printStatusGUI());
            }
        });
        btnNewSimulation.setBounds(313, 515, 117, 29);
        result.add(btnNewSimulation);

        // --- ---

        // --- ENVIRONMENT MENU ---

        JButton btnNewButton_10 = new JButton("Create");
        btnNewButton_10.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                newEnvi.setVisible(true);
                environment.setVisible(false);
            }
        });
        btnNewButton_10.setBounds(357, 119, 117, 29);
        environment.add(btnNewButton_10);

        JButton btnBack_2 = new JButton("Back");
        btnBack_2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                environment.setVisible(false);
                main.setVisible(true);
            }
        });
        btnBack_2.setBounds(357, 201, 117, 29);
        environment.add(btnBack_2);

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
                EnvironmentDatabase.delete(enviMenuID);
                EnvironmentDatabase.save();

                // refresh jlist
                jlistEnviModified = true;

                enviList.setListData(EnvironmentDatabase.getArray());
                scrollPaneE.revalidate();
                scrollPaneE.repaint();

                enviInfo.setText("Chosen environment object has been deleted!");
            }
        });
        btnNewButton_11.setBounds(357, 160, 117, 29);
        environment.add(btnNewButton_11);

        // --- ---

        // --- INTERACTION MENU ---

        JButton btnNewButton_12 = new JButton("Create");
        btnNewButton_12.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                newInter.setVisible(true);
                interaction.setVisible(false);
            }
        });
        btnNewButton_12.setBounds(357, 119, 117, 29);
        interaction.add(btnNewButton_12);

        JButton btnBack_3 = new JButton("Back");
        btnBack_3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                interaction.setVisible(false);
                main.setVisible(true);
            }
        });
        btnBack_3.setBounds(357, 201, 117, 29);
        interaction.add(btnBack_3);

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
                InteractionDatabase.delete(inteMenuID);
                InteractionDatabase.save();

                // refresh jlist
                jlistInteModified = true;

                inteList.setListData(InteractionDatabase.getArray());
                scrollPaneI.revalidate();
                scrollPaneI.repaint();

                inteInfo.setText("Chosen interaction object has been deleted!");
            }
        });
        btnDelete.setBounds(357, 160, 117, 29);
        interaction.add(btnDelete);

        // --- NEW INTERACTION ---

        JButton btnNewButton_7 = new JButton("Back");
        btnNewButton_7.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                newInter.setVisible(false);
                interaction.setVisible(true);
            }
        });
        btnNewButton_7.setBounds(233, 326, 117, 29);
        newInter.add(btnNewButton_7);

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
        lblFearful.setBounds(16, 219, 70, 16);
        newInter.add(lblFearful);

        JLabel lblRelieved = new JLabel("Relieved :");
        lblRelieved.setBounds(16, 247, 70, 16);
        newInter.add(lblRelieved);

        JLabel lblAngry = new JLabel("Angry :");
        lblAngry.setBounds(16, 275, 70, 16);
        newInter.add(lblAngry);

        // --- sliders

        final JTextField textFieldE = new JTextField();
        textFieldE.setText("0");
        textFieldE.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldE.setEditable(false);
        textFieldE.setColumns(10);
        textFieldE.setBounds(362, 185, 117, 28);
        newInter.add(textFieldE);

        final JTextField textFieldF = new JTextField();
        textFieldF.setText("0");
        textFieldF.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldF.setEditable(false);
        textFieldF.setColumns(10);
        textFieldF.setBounds(362, 213, 117, 28);
        newInter.add(textFieldF);

        final JTextField textFieldR = new JTextField();
        textFieldR.setText("0");
        textFieldR.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldR.setEditable(false);
        textFieldR.setColumns(10);
        textFieldR.setBounds(362, 241, 117, 28);
        newInter.add(textFieldR);

        final JTextField textFieldA = new JTextField();
        textFieldA.setText("0");
        textFieldA.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldA.setEditable(false);
        textFieldA.setColumns(10);
        textFieldA.setBounds(362, 269, 117, 28);
        newInter.add(textFieldA);

        final JSlider sliderE = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
        sliderE.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent arg0)
            {
                int value = sliderE.getValue();
                textFieldE.setText("" + value);
                newE = value;
            }
        });
        sliderE.setBounds(88, 191, 281, 22);
        newInter.add(sliderE);

        final JSlider sliderF = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
        sliderF.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                int value = sliderF.getValue();
                textFieldF.setText("" + value);
                newF = value;
            }
        });
        sliderF.setBounds(88, 219, 281, 22);
        newInter.add(sliderF);

        final JSlider sliderR = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
        sliderR.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                int value = sliderR.getValue();
                textFieldR.setText("" + value);
                newR = value;
            }
        });
        sliderR.setBounds(88, 247, 281, 22);
        newInter.add(sliderR);

        final JSlider sliderA = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
        sliderA.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                int value = sliderA.getValue();
                textFieldA.setText("" + value);
                newA = value;
            }
        });
        sliderA.setBounds(88, 275, 281, 22);
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
                String name = newNameI.getText();
                newNameI.setText("");

                // TODO invalid output
                if (name != "")
                {
                    InteractionCategory type = (InteractionCategory) newTypeI
                            .getSelectedItem();
                    Interaction inter = new Interaction(InteractionDatabase.getSize() + 1, name, type, newE, newF,
                            newR, newA);
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
        textFieldT.setText("0");
        textFieldT.setEditable(false);
        textFieldT.setBounds(393, 151, 91, 28);
        newEnvi.add(textFieldT);
        textFieldT.setColumns(10);

        final JTextField textFieldH = new JTextField();
        textFieldH.setText("0");
        textFieldH.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldH.setEditable(false);
        textFieldH.setColumns(10);
        textFieldH.setBounds(393, 179, 91, 28);
        newEnvi.add(textFieldH);

        final JTextField textFieldL = new JTextField();
        textFieldL.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldL.setText("0");
        textFieldL.setEditable(false);
        textFieldL.setColumns(10);
        textFieldL.setBounds(393, 207, 91, 28);
        newEnvi.add(textFieldL);

        final JTextField textFieldN = new JTextField();
        textFieldN.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldN.setText("0");
        textFieldN.setEditable(false);
        textFieldN.setColumns(10);
        textFieldN.setBounds(393, 235, 91, 28);
        newEnvi.add(textFieldN);

        final JSlider sliderT = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
        sliderT.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                int value = sliderT.getValue();
                textFieldT.setText("" + value);
                newT = value;
            }
        });
        sliderT.setBounds(115, 157, 281, 22);
        newEnvi.add(sliderT);

        final JSlider sliderH = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
        sliderH.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                int value = sliderH.getValue();
                textFieldH.setText("" + value);
                newH = value;
            }
        });
        sliderH.setBounds(115, 185, 281, 22);
        newEnvi.add(sliderH);

        final JSlider sliderL = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
        sliderL.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                int value = sliderL.getValue();
                textFieldL.setText("" + value);
                newL = value;
            }
        });
        sliderL.setBounds(115, 213, 281, 22);
        newEnvi.add(sliderL);

        final JSlider sliderN = new JSlider(JSlider.HORIZONTAL, MIN, MAX, INIT);
        sliderN.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                int value = sliderN.getValue();
                textFieldN.setText("" + value);
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
                String name = newNameE.getText();
                newNameE.setText("");

                // TODO invalid output
                if (name != "")
                {
                    Environment envi = new Environment(EnvironmentDatabase.getSize() + 1, name, newT, newH, newL,
                            newN);
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
        panel_2.setBorder(new TitledBorder(null, "Emotions",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(646, 262, 260, 201);
        result.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 1, 0, 0));

        final JTextArea emochange = new JTextArea();
        emochange.setLineWrap(true);
        panel_2.add(emochange);

        final JTextField textResult = new JTextField();
        textResult.setEditable(false);
        textResult.setBounds(134, 475, 840, 28);
        result.add(textResult);
        textResult.setColumns(10);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(134, 63, 500, 400);
        result.add(panel_3);
        
                // ---
        
                JLabel lblNewLabel_2 = new JLabel("");
                panel_3.add(lblNewLabel_2);
                lblNewLabel_2.setIcon(new ImageIcon(Main.class
                        .getResource("/images/tumblr_m8hv515XTT1qhlsrfo1_500.gif")));

        final JButton start = new JButton("Start");
        start.setEnabled(false);
        start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                // the simulation is here
                String[] s = Simulator.simulationResultGUI(cat,
                        EnvironmentDatabase.get(enviID),
                        InteractionDatabase.get(inteID));
                scenario.setText(s[0]);
                emochange.setText(s[1]);
                textResult.setText(s[2]);

                simulation.setVisible(false);
                result.setVisible(true);
            }
        });
        start.setBounds(288, 477, 117, 29);
        simulation.add(start);

        // ---

        JButton btnNewButton_9 = new JButton("Back");
        btnNewButton_9.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                simulation.setVisible(false);
                main.setVisible(true);
            }
        });
        btnNewButton_9.setBounds(288, 521, 117, 29);
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
                    ;

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

        JButton btnBack_4 = new JButton("Back");
        btnBack_4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
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

        JButton btnNewButton = new JButton("Start Simulation");
        btnNewButton.setBounds(321, 89, 157, 29);
        btnNewButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                main.setVisible(false);
                simulation.setVisible(true);
            }
        });

        JButton btnNewButton_1 = new JButton("Environment Library");
        btnNewButton_1.setBounds(321, 130, 157, 29);
        btnNewButton_1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                main.setVisible(false);
                environment.setVisible(true);
            }
        });

        JButton btnNewButton_2 = new JButton("Interaction Library");
        btnNewButton_2.setBounds(321, 171, 157, 29);
        btnNewButton_2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                main.setVisible(false);
                interaction.setVisible(true);
            }
        });

        JButton btnNewButton_3 = new JButton("Behaviour Library");
        btnNewButton_3.setEnabled(false);
        btnNewButton_3.setBounds(321, 212, 157, 29);
        btnNewButton_3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                main.setVisible(false);
                behaviour.setVisible(true);
            }
        });

        JButton btnNewButton_4 = new JButton("Exit");
        btnNewButton_4.setBounds(321, 294, 157, 29);
        btnNewButton_4.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.exit(0);
            }
        });

        JButton btnNewButton_5 = new JButton("Credit");
        btnNewButton_5.setBounds(321, 253, 157, 29);
        btnNewButton_5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                main.setVisible(false);
                credit.setVisible(true);
            }
        });
        main.setLayout(null);
        main.add(lblNewLabel);
        main.add(btnNewButton_3);
        main.add(btnNewButton_5);
        main.add(btnNewButton);
        main.add(btnNewButton_4);
        main.add(btnNewButton_1);
        main.add(btnNewButton_2);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBackground(Color.WHITE);
        lblNewLabel_1.setBounds(-135, 57, 500, 282);
        lblNewLabel_1.setIcon(new ImageIcon(Main.class
                .getResource("/images/tumblr_myg3nzYpL31t4wmn7o1_500.gif")));
        main.add(lblNewLabel_1);

        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setBackground(new Color(255, 255, 255));
        lblNewLabel_3
                .setIcon(new ImageIcon(
                        Main.class
                                .getResource("/images/how-to-draw-the-grumpy-cat-tard-the-grumpy-cat-step-9_1_000000122943_5.gif")));
        lblNewLabel_3.setBounds(327, 115, 130, 170);
        credit.add(lblNewLabel_3);

        JLabel lblCredit = new JLabel("CREDIT");
        lblCredit.setForeground(Color.BLACK);
        lblCredit.setBounds(6, 6, 488, 97);
        lblCredit.setFont(new Font("Lucida Grande", Font.BOLD, 24));
        lblCredit.setHorizontalAlignment(SwingConstants.CENTER);
        credit.add(lblCredit);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(340, 323, 117, 29);
        btnBack.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                main.setVisible(true);
                credit.setVisible(false);
            }
        });
        credit.add(btnBack);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(16, 115, 299, 237);
        credit.add(scrollPane_1);

        JTextArea txtrCatBehaviourSimulator = new JTextArea();
        txtrCatBehaviourSimulator
                .setText("Cat Behaviour Simulator\n\nThird Year Project\n\nUniversity of Manchester\n\nAuthor: Duc A. Nguyen\n\nSupervisor: Dr John Sargeant\n\nReference Sources:\n-\n-\n-\n-\n-\n-\n-\n-\n-\n-\n");
        scrollPane_1.setViewportView(txtrCatBehaviourSimulator);
    }
}
