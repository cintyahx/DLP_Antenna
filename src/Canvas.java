import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.*;
import java.awt.event.*;
import javax.swing.JComponent;

// #if Line
import java.awt.Point;
// #endif

@SuppressWarnings("serial")
public class Canvas extends JComponent implements MouseListener, MouseMotionListener {

	// #if Line
	Point start, end;
	// #endif
	protected List<Shape> shapes = new LinkedList<Shape>();
	public enum FigureTypes {NONE, LINE, RECT};
	public FigureTypes figureSelected = FigureTypes.NONE;

	/** Sets up the canvas. Do not change */
	public Canvas() {
		this.setDoubleBuffered(true); // for display efficiency
		this.addMouseListener(this); // registers the mouse listener
		this.addMouseMotionListener(this); // registers the mouse motion
											// listener
	}

	/** Sets the selected figure. Do not change. */
	public void selectedFigure(FigureTypes fig) {
		figureSelected = fig;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// refreshes the canvas
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		for (Shape s : shapes) {
			s.paint(g);
		}
	}

	// **************** Mouse Handling
	public void mouseClicked(MouseEvent e) {
	}

	// mouseClicked
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * Invoked when the mouse exits a component. Empty implementation. Do not
	 * change.
	 */
	public void mouseExited(MouseEvent e) {
	}

	
	
	
	/** Invoked when a mouse button has been pressed on a component. */

	public void mousePressed(MouseEvent e) {

		// #if Line
		if (figureSelected == FigureTypes.LINE) {
			mousePressedLine(e);
		}
		// #endif

		// #if Rectangle
//@		if (figureSelected == FigureTypes.RECT) {
//@			mousePressedRect(e);
//@		}
		// #endif
	}
	
	
	

	/** Invoked when a mouse button has been released on a component. */
	public void mouseReleased(MouseEvent e) {
		// #if Line
		if (figureSelected == FigureTypes.LINE) {
			mouseReleasedLine(e);
		}
		// #endif
		// #if Rectangle
//@		if (figureSelected == FigureTypes.RECT) {
//@			mouseReleasedRect(e);
//@		}
		// #endif
	}

	/** Invoked when the mouse is dragged over a component */
	public void mouseDragged(MouseEvent e) {
		// #if Line
		if (figureSelected == FigureTypes.LINE) {
			mouseDraggedLine(e);
		}
		// #endif
		// #if Rectangle
//@		if (figureSelected == FigureTypes.RECT) {
//@			mouseDraggedRect(e);
//@		}
		// #endif
	}

	/* Empty implementation. Do not change. */
	public void mouseMoved(MouseEvent e) {
	}

	public void wipe() {
		// #if Clear
//@		this.shapes.clear();
//@		this.repaint();
		// #endif
	}

	// #if Rectangle
//@	protected Rectangle newRect = null;
	// #endif

	// #if Rectangle
//@	public void mousePressedRect(MouseEvent e) {
//@		// If there is no line being created
//@		if (newRect == null) {
//@			newRect = new Rectangle(e.getX(), e.getY());
//@			shapes.add(newRect);
//@		}
//@	}
	// #endif

	// #if Rectangle
//@	/** Updates the end point coordinates and repaints figure */
//@	public void mouseDraggedRect(MouseEvent e) {
//@		newRect.setEnd(e.getX(), e.getY());
//@		repaint();
//@	}
	// #endif

	// #if Rectangle
//@	/** Clears the reference to the new line */
//@	public void mouseReleasedRect(MouseEvent e) {
//@		newRect = null;
//@	}
	// #endif

	// #if Line
	protected Line newLine = null;

	// #endif
	// #if Line
	public void mousePressedLine(MouseEvent e) {
		// If there is no line being created
		if (newLine == null) {
			start = new Point(e.getX(), e.getY());
			newLine = new Line(start);
			shapes.add(newLine);
		}
	}
	// #endif

	// #if Line
	/** Updates the end point coordinates and repaints figure */
	public void mouseDraggedLine(MouseEvent e) {
		newLine.setEnd(new Point(e.getX(), e.getY()));
		repaint();
	}
	// #endif

	// #if Line
	/** Clears the reference to the new line */
	public void mouseReleasedLine(MouseEvent e) {
		newLine = null;
	}
	// #endif

}
