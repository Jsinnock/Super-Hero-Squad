import java.awt.Button;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.lang.Integer;
import java.util.Observer;
import java.awt.event.ActionListener;


class view implements java.util.Observer{

		private TextField myTextField;
		private Button button;
		
		view()
		{
			System.out.println("View()");
			
			Frame frame = new Frame("simple MVC");
			frame.add("North", new Label("Counter"));
			
			myTextField = new TextField();
			frame.add("Center", myTextField);
			
			Panel panel = new Panel();
			button = new Button("Press me");
			panel.add(button);
			frame.add("South", panel);
			
			frame.addWindowStateListener(new CloseListener());
			frame.setSize(400,400);
			frame.setLocation(100, 100);
			frame.setVisible(true);
		}
		public void print(String str)
		{
			System.out.println(str);
		}
		public void setValue(int v)
		{
			myTextField.setText(""+ v);
		}
		
		public void update(Observable obs, Object obj)
		{
			myTextField.setText("" + ((Integer)obj).intValue());
		}
		
		public void addController(ActionListener controller)
		{
			System.out.println("View : adding controller");
			button.addActionListener(controller);
		}
		
		public static class CloseListener extends WindowAdapter
		{
			public void windowClosing(WindowEvent e)
			{
				e.getWindow().setVisible(false);
				System.exit(0);
			}
		}
}