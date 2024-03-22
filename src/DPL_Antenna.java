import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")

public class DPL_Antenna extends JFrame {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	protected JPanel toolPanel = new JPanel();
	protected Canvas canvas = new Canvas();
	private Container contentPane;
	// #if Line
	private JButton lineButton;
	// #endif
	// #if Rectangle
//@	private JButton rectButton;
	// #endif
	// #if Clear
//@	private JButton wipeButton;
	// #endif
	// #if Clear
//@	private static final String wipeText = "   Limpar   ";
	// #endif
	// #if Rectangle
//@	private static final String rectText = "Retângulo";
	// #endif
	// #if Line
	private static final String lineText = "    Linha    ";
	// #endif

	// *** Initialization of atomic elements
	public void initAtoms() {
		// #if Line
		lineButton = new JButton(lineText);
		// #endif
		// #if Rectangle
//@		rectButton = new JButton(rectText);
		// #endif
		// #if Clear
//@		wipeButton = new JButton(wipeText);
		// #endif
	}

	// Layout components declaration

	/** Initializes layout . No need to change */
	public void initLayout() {
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.Y_AXIS));
	}

	/** Initializes the content pane */
	public void initContentPane() {
		// #if Line
		toolPanel.add(lineButton);
		// #endif
		// #if Rectangle
//@		toolPanel.add(rectButton);
		// #endif
		// #if Clear
//@		toolPanel.add(wipeButton);
		// #endif
		contentPane.add(toolPanel, BorderLayout.WEST);
		contentPane.add(canvas, BorderLayout.CENTER);
	}

	public void initListeners() {

		// #if Line
		lineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.selectedFigure(Canvas.FigureTypes.LINE);
			}
		});
		// #endif

		// #if Rectangle
//@		rectButton.addActionListener(new ActionListener() {
//@			public void actionPerformed(ActionEvent e) {
//@				canvas.selectedFigure(Canvas.FigureTypes.RECT);
//@			}
//@		});
		// #endif

		// #if Clear
//@		wipeButton.addActionListener(new ActionListener() {
//@			public void actionPerformed(ActionEvent e) {
//@				canvas.wipe();
//@			}
//@		});
		// #endif
	}

	// Initializes entire containment hierarchy
	public void init() {
		initAtoms();
		initLayout();
		initContentPane();
		initListeners();
	}

	/* Constructor. No need to modify */
	public DPL_Antenna(String appTitle) {
		super(appTitle);
		init();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setResizable(true);
		validate();
	}

	/** main method */
	public static void main(String[] args) {
		new DPL_Antenna("Draw Product Line");
	}

}
