import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.sound.sampled.*;

class FreqDialog implements ActionListener{

	private JLabel freqLabel, volLabel, chanLabel; 	 
	private JTextField freqField, volumeField, chanField;
  	
	private JButton okButton;
	
	GuiWindow w;

	FreqDialog(GuiWindow wnd_caller)  
	{
		
		w= wnd_caller;
		 
		JFrame jfrm = new JFrame("JSignalGenerator"); 
		
		jfrm.setLayout(new FlowLayout());

		jfrm.setSize(300, 200);

		freqLabel = new JLabel("Frequency, hz");
		
		volLabel = new JLabel("Volume, %");

		chanLabel = new JLabel("Channel(1st or 2nd" );
	
		okButton = new JButton("Ok");
		
		okButton.addActionListener(this);
		
		freqField = new JTextField(10);	
		volumeField = new JTextField(10);
		chanField = new JTextField(5);
		
		freqField.setText("400");
		volumeField.setText("20");
		chanField.setText("1");
		
		jfrm.add(freqLabel);
		jfrm.add(freqField );
		jfrm.add(chanLabel);
		jfrm.add(chanField);
		jfrm.add(volLabel );
		jfrm.add(volumeField );
		jfrm.add(okButton);
		
		jfrm.setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent ae){
		try{
			int freq = Integer.parseInt(freqField.getText() );
			int chan = Integer.parseInt( chanField.getText() );
		 
			int percentage  = Integer.parseInt(volumeField.getText() );
 			int vol =  32768 / 100 * percentage;
		
			Sinusoid snl = new Sinusoid(44100);
			snl.fill_channel(freq , vol, chan);
			w.addSignal(snl);   
		}
		catch(NumberFormatException ob)
		{
			JOptionPane.showMessageDialog(null, "Invalid input. Number must be integer", 
							"JSignalGenerator",
							JOptionPane.INFORMATION_MESSAGE);
		}
	} 

}
