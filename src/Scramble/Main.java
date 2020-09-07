package Scramble;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * 
 * @author jgued
 * @version 1.0
 *
 */
public class Main extends Composite {
	private Text input;
	private Text output;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(1, false));
		Main main = new Main(shell, SWT.NONE);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();

		}
		display.dispose();
	}
	
	/**
	 * 
	 * @param parent
	 * @param style
	 */
	public Main(Composite parent, int style) {
		super(parent, style);
		setLayout(null);
		
		Label lblScrammble = new Label(this, SWT.CENTER);
		lblScrammble.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblScrammble.setBounds(140, 0, 164, 39);
		lblScrammble.setText("Scrammble");
		
		input = new Text(this, SWT.BORDER);
		input.setBounds(174, 48, 266, 24);
		
		Label lblEnterUpTo = new Label(this, SWT.NONE);
		lblEnterUpTo.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblEnterUpTo.setBounds(4, 48, 164, 24);
		lblEnterUpTo.setText("Enter up to 7 letters:");
		
		Button btnEnter = new Button(this, SWT.NONE);
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Scram.scram(input.getText());
				output.setText(Scram.getAns());
			}
		});
		btnEnter.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		btnEnter.setBounds(156, 89, 95, 39);
		btnEnter.setText("Enter");
		
		output = new Text(this, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
		output.setBounds(10, 177, 430, 113);
		
		Label lblScrammbledLetters = new Label(this, SWT.NONE);
		lblScrammbledLetters.setBounds(10, 155, 121, 16);
		lblScrammbledLetters.setText("Scrammbled letters");

	}
}
