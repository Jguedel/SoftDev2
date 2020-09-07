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

/**
 * 
 * @author jgued
 * @version 1.0
 *
 */
public class PasswordStrength extends Composite {
	private Text Input;
	private Text output;

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(1, false));
		PasswordStrength strength = new PasswordStrength(shell, SWT.NONE);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();

		}
		display.dispose();
	}

	public PasswordStrength(Composite parent, int style) {
		super(parent, style);
		setLayout(null);

		Label lblPasswordChecker = new Label(this, SWT.NONE);
		lblPasswordChecker.setBounds(143, 10, 106, 16);
		lblPasswordChecker.setText("Password Checker");

		Label lblPassword = new Label(this, SWT.NONE);
		lblPassword.setBounds(10, 85, 56, 16);
		lblPassword.setText("Password");

		Input = new Text(this, SWT.BORDER);
		Input.setBounds(72, 83, 306, 16);

		output = new Text(this, SWT.BORDER | SWT.WRAP);
		output.setEditable(false);
		output.setBounds(10, 173, 387, 90);

		Label lblQuality = new Label(this, SWT.NONE);
		lblQuality.setBounds(10, 148, 56, 16);
		lblQuality.setText("Quality");

		Button btnCheck = new Button(this, SWT.NONE);
		btnCheck.addMouseListener(new MouseAdapter() {
			@Override
			//GET INPUT TEXT
			//SEND INPUT TO CHECK
			//DISPLAY ANS
			public void mouseUp(MouseEvent e) {
				String input = Input.getText();
				Check.check(input);
				output.setText(Check.getAns());

			}
		});
		btnCheck.setBounds(159, 119, 70, 21);
		btnCheck.setText("Check");

	}
}
