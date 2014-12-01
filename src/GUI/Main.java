package GUI;

import object.Cat;
import object.Emotion;
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

public class Main
{
    // initialize a neutral cat
    private Cat cat = new Cat("Tom", "Common Domestic Cat", new Emotion(0, 0,
            0, 0));
    private int enviID;
    private int inteID;
    private boolean enviChosen = false;
    private boolean inteChosen = false;
    private JFrame frmCatSimulator;

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

        // CLOSE DATABASE
        InteractionDatabase.close();
        EnvironmentDatabase.close();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        frmCatSimulator = new JFrame();
        frmCatSimulator.setTitle("Cat Simulator");
        frmCatSimulator.getContentPane().setBackground(new Color(0, 51, 0));
        frmCatSimulator.setBounds(100, 100, 500, 400);
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
        btnNewButton_13.setBounds(362, 325, 117, 29);
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
        catStatus.setBounds(16, 235, 180, 124);
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
        btnNewSimulation.setBounds(233, 325, 117, 29);
        result.add(btnNewSimulation);

        // ---

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Main.class
                .getResource("/images/tumblr_m8hv515XTT1qhlsrfo1_500.gif")));
        lblNewLabel_2.setBounds(16, 63, 228, 210);
        result.add(lblNewLabel_2);

        JButton btnNewButton_6 = new JButton("OK");
        btnNewButton_6.setBounds(362, 326, 117, 29);
        newInter.add(btnNewButton_6);

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

        JSlider slider = new JSlider();
        slider.setBounds(88, 191, 281, 22);
        newInter.add(slider);

        JSlider slider_1 = new JSlider();
        slider_1.setBounds(88, 219, 281, 22);
        newInter.add(slider_1);

        JSlider slider_2 = new JSlider();
        slider_2.setBounds(88, 247, 281, 22);
        newInter.add(slider_2);

        JSlider slider_3 = new JSlider();
        slider_3.setBounds(88, 275, 281, 22);
        newInter.add(slider_3);

        JTextField textField_2 = new JTextField();
        textField_2.setBounds(150, 101, 160, 28);
        newInter.add(textField_2);
        textField_2.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(150, 131, 160, 27);
        newInter.add(comboBox);

        JTextField textField_4 = new JTextField();
        textField_4.setEditable(false);
        textField_4.setColumns(10);
        textField_4.setBounds(362, 185, 117, 28);
        newInter.add(textField_4);

        JTextField textField_5 = new JTextField();
        textField_5.setEditable(false);
        textField_5.setColumns(10);
        textField_5.setBounds(362, 213, 117, 28);
        newInter.add(textField_5);

        JTextField textField_6 = new JTextField();
        textField_6.setEditable(false);
        textField_6.setColumns(10);
        textField_6.setBounds(362, 241, 117, 28);
        newInter.add(textField_6);

        JTextField textField_7 = new JTextField();
        textField_7.setEditable(false);
        textField_7.setColumns(10);
        textField_7.setBounds(362, 269, 117, 28);
        newInter.add(textField_7);

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

        JButton btnNewButton_11 = new JButton("Delete");
        btnNewButton_11.setBounds(357, 160, 117, 29);
        environment.add(btnNewButton_11);

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

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(26, 105, 319, 111);
        environment.add(scrollPane);

        final JList enviList = new JList();
        enviList.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent arg0)
            {
                if (!arg0.getValueIsAdjusting())
                {
                    String selected = enviList.getSelectedValue().toString();
                    enviInfo.setText(EnvironmentDatabase.get(
                            (int) selected.charAt(0) - 48).infoGUI());
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
        scrollPane.setViewportView(enviList);

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

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(357, 160, 117, 29);
        interaction.add(btnDelete);

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

        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setBounds(26, 105, 319, 111);
        interaction.add(scrollPane2);

        final JList inteList = new JList();
        inteList.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e)
            {
                if (!e.getValueIsAdjusting())
                {
                    String selected = inteList.getSelectedValue().toString();
                    inteInfo.setText(InteractionDatabase.get(
                            (int) selected.charAt(0) - 48).infoGUI());
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
        scrollPane2.setViewportView(inteList);

        // --- THE SIMULATION IS HERE ---

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        panel_1.setBorder(new TitledBorder(null, "Scenario",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(256, 63, 223, 75);
        result.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 1, 0, 0));

        final JTextArea scenario = new JTextArea();
        scenario.setLineWrap(true);
        panel_1.add(scenario);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_2.setBorder(new TitledBorder(null, "Emotions",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(256, 150, 223, 123);
        result.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 1, 0, 0));

        final JTextArea emochange = new JTextArea();
        emochange.setLineWrap(true);
        panel_2.add(emochange);

        final JTextField textResult = new JTextField();
        textResult.setEditable(false);
        textResult.setBounds(58, 285, 377, 28);
        result.add(textResult);
        textResult.setColumns(10);

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
        start.setBounds(218, 330, 117, 29);
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
        btnNewButton_9.setBounds(347, 330, 117, 29);
        simulation.add(btnNewButton_9);

        JLabel lblNewLabel_5 = new JLabel("Simulation");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD, 24));
        lblNewLabel_5.setBounds(6, 6, 488, 43);
        simulation.add(lblNewLabel_5);

        // ---

        final JTextField chooseInte = new JTextField();
        chooseInte.setHorizontalAlignment(SwingConstants.CENTER);
        chooseInte.setEditable(false);
        chooseInte.setColumns(10);
        chooseInte.setBounds(347, 290, 127, 28);
        simulation.add(chooseInte);

        JScrollPane imenu = new JScrollPane();
        imenu.setBounds(347, 106, 127, 80);
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

                    inteID = (int) selected.charAt(0) - 48;

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
        chooseEnvi.setBounds(208, 290, 127, 28);
        simulation.add(chooseEnvi);
        chooseEnvi.setColumns(10);

        JScrollPane emenu = new JScrollPane();
        emenu.setBounds(208, 106, 127, 80);
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

                    enviID = (int) selected.charAt(0) - 48;

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
        pic.setBounds(16, 55, 180, 168);
        simulation.add(pic);
        pic.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblNewLabel_7 = new JLabel("New label");
        lblNewLabel_7.setIcon(new ImageIcon(Main.class
                .getResource("/images/677dce9ec9101d08d48b4db3cf0c398e.gif")));
        pic.add(lblNewLabel_7);

        JPanel pic2 = new JPanel();
        pic2.setBounds(208, 198, 127, 80);
        simulation.add(pic2);

        JPanel pic3 = new JPanel();
        pic3.setBounds(347, 198, 127, 80);
        simulation.add(pic3);
        pic3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_6 = new JLabel(
                "Input information for the simulation:");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setBounds(218, 50, 250, 16);
        simulation.add(lblNewLabel_6);

        JLabel lblEnvironment = new JLabel("Environment");
        lblEnvironment.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnvironment.setBounds(208, 78, 127, 16);
        simulation.add(lblEnvironment);

        JLabel lblInteraction = new JLabel("Interaction");
        lblInteraction.setHorizontalAlignment(SwingConstants.CENTER);
        lblInteraction.setBounds(347, 78, 127, 16);
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
        lblNewLabel_3.setBounds(327, 115, 130, 165);
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
        JButton btnOk = new JButton("OK");
        btnOk.setBounds(367, 327, 117, 29);
        newEnvi.add(btnOk);

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

        JTextField textField_3 = new JTextField();
        textField_3.setBounds(165, 95, 168, 28);
        newEnvi.add(textField_3);
        textField_3.setColumns(10);

        JSlider slider_4 = new JSlider();
        slider_4.setBounds(115, 157, 281, 22);
        newEnvi.add(slider_4);

        JSlider slider_5 = new JSlider();
        slider_5.setBounds(115, 185, 281, 22);
        newEnvi.add(slider_5);

        JSlider slider_6 = new JSlider();
        slider_6.setBounds(115, 213, 281, 22);
        newEnvi.add(slider_6);

        JSlider slider_7 = new JSlider();
        slider_7.setBounds(115, 243, 281, 22);
        newEnvi.add(slider_7);

        JTextField textField_8 = new JTextField();
        textField_8.setEditable(false);
        textField_8.setBounds(393, 151, 91, 28);
        newEnvi.add(textField_8);
        textField_8.setColumns(10);

        JTextField textField_9 = new JTextField();
        textField_9.setEditable(false);
        textField_9.setColumns(10);
        textField_9.setBounds(393, 179, 91, 28);
        newEnvi.add(textField_9);

        JTextField textField_10 = new JTextField();
        textField_10.setEditable(false);
        textField_10.setColumns(10);
        textField_10.setBounds(393, 207, 91, 28);
        newEnvi.add(textField_10);

        JTextField textField_11 = new JTextField();
        textField_11.setEditable(false);
        textField_11.setColumns(10);
        textField_11.setBounds(393, 235, 91, 28);
        newEnvi.add(textField_11);
    }
}
