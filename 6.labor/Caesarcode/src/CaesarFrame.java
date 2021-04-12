import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CaesarFrame extends JFrame {
	private JComboBox jcb;
	private JTextField f1, f2;
	private JButton btn;
	private JPanel p1, p2;
	
	public CaesarFrame()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("SwingLab");
		this.setSize(400, 110);
		setResizable(true);
		Object chars[]=new Object[26];
		for(int i=(int)'A';i<=(int)'Z';i++)
			chars[i-(int)'A']=(char)i;
		GridLayout lm=new GridLayout();
		lm.setRows(2);
		lm.setColumns(1);
		this.setLayout(lm);
		p1=new JPanel(new FlowLayout());
		add(p1);
		jcb=new JComboBox(chars);
		p1.add(jcb);
		f1=new JTextField(20);
		f1.setEnabled(true); 
		p1.add(f1);
		btn=new JButton();
		btn.setText("Code!");
		setVisible(true);
		btn.addActionListener(new OkButtonActionListener());
		p1.add(btn);
		p2=new JPanel(new BorderLayout());
		add(p2);
		p2.add(new JLabel("Output:"),BorderLayout.WEST);
		f2=new JTextField(20);
		f2.setEditable(false);
		p2.add(f2);

	}
	
	private class OkButtonActionListener implements ActionListener
	{		
		public void actionPerformed(ActionEvent ae) {
				f2.setText(CaesarCode.caesarCode(f1.getText(), (char)jcb.getSelectedItem()));
		}
	}

}
