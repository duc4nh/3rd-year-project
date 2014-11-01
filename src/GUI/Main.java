package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Main {

	private JFrame frame;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToMy = new JLabel("Welcome to MY CAT SIMULATOR");
		lblWelcomeToMy.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToMy.setFont(new Font("Nyala", Font.BOLD, 16));
		lblWelcomeToMy.setBounds(10, 11, 414, 32);
		frame.getContentPane().add(lblWelcomeToMy);
		
		JButton btnStartSimulator = new JButton("Start Simulator");
		btnStartSimulator.setBounds(288, 54, 115, 23);
		frame.getContentPane().add(btnStartSimulator);
		
		JButton btnViewLibraby = new JButton("View Libraby");
		btnViewLibraby.setBounds(288, 88, 115, 23);
		frame.getContentPane().add(btnViewLibraby);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnExit.setBounds(288, 156, 115, 23);
		frame.getContentPane().add(btnExit);
		
		JButton btnCredit = new JButton("Credits");
		btnCredit.setBounds(288, 122, 115, 23);
		frame.getContentPane().add(btnCredit);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
