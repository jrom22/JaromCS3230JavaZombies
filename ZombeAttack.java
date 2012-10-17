package zombies;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class ZombeAttack 
{

	protected Shell shlZombieAttack;
	private Text txtZombies;
	private Text txtHumans;
	private Text txtDays;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			ZombeAttack window = new ZombeAttack();
			window.open();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() 
	{
		Display display = Display.getDefault();
		createContents();
		shlZombieAttack.open();
		shlZombieAttack.layout();
		while (!shlZombieAttack.isDisposed())
		{
			if (!display.readAndDispatch()) 
			{
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents()
	{
		shlZombieAttack = new Shell();
		shlZombieAttack.setSize(403, 198);
		shlZombieAttack.setText("Zombie Attack!!!");
		
		Button btnRun = new Button(shlZombieAttack, SWT.NONE);
		btnRun.addSelectionListener(new SelectionAdapter() 
		{
			
			public void widgetSelected(SelectionEvent e) 
			{
				Enviroment city = new Enviroment(txtDays.getText(),txtHumans.getText(),txtZombies.getText());
				city.run();
			}
		});
		btnRun.setBounds(307, 130, 75, 25);
		btnRun.setText("RUN");
		
		txtZombies = new Text(shlZombieAttack, SWT.BORDER);
		txtZombies.setBounds(306, 15, 76, 21);
		
		Label lblNewLabel = new Label(shlZombieAttack, SWT.NONE);
		lblNewLabel.setBounds(10, 18, 290, 15);
		lblNewLabel.setText("Enter the number of Zombies that will start in the city:");
		
		Label lblNewLabel_1 = new Label(shlZombieAttack, SWT.NONE);
		lblNewLabel_1.setBounds(10, 55, 290, 15);
		lblNewLabel_1.setText("Enter the number of humans that will start in the city:");
		
		txtHumans = new Text(shlZombieAttack, SWT.BORDER);
		txtHumans.setBounds(306, 52, 76, 21);
		
		Label lblEnterTheNumber = new Label(shlZombieAttack, SWT.NONE);
		lblEnterTheNumber.setBounds(10, 93, 207, 15);
		lblEnterTheNumber.setText("Enter the number of days to simulate:");
		
		txtDays = new Text(shlZombieAttack, SWT.BORDER);
		txtDays.setBounds(223, 90, 76, 21);

	}
}
