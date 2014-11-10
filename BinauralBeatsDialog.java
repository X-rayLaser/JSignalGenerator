import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.sound.sampled.*;

class BinauralBeatsDialog implements ActionListener{
	
	private JLabel freqLabel, beatsFreqLabel, volLabel;	 
	private JTextField freqField, beatsFreqField, volumeField;
  	
	private JButton okButton;
	
	GuiWindow w;
	
	BinauralBeatsDialog(GuiWindow wnd_caller){
		w= wnd_caller;
		 
		JFrame jfrm = new JFrame("JSignalGenerator"); 
		
		jfrm.setLayout(new FlowLayout());

		jfrm.setSize(300, 200);

		freqLabel = new JLabel("Frequency, hz");	
		
		beatsFreqLabel = new JLabel("Beats frequency, hz");
		
		volLabel = new JLabel("Volume, %");
		 
		okButton = new JButton("Ok");
		
		okButton.addActionListener(this);
		
		freqField 	= new JTextField(10);	
		beatsFreqField  = new JTextField(10);	
		volumeField 	= new JTextField(10); 
		
		freqField.setText("400");
		beatsFreqField.setText("10"); 
		volumeField.setText("20"); 

		jfrm.add(freqLabel);
		jfrm.add(freqField );
		jfrm.add(beatsFreqLabel);
		jfrm.add(beatsFreqField);
		jfrm.add(volLabel );
		jfrm.add(volumeField );

		jfrm.add(okButton);
		
		jfrm.setVisible(true);	
	}


	public void actionPerformed(ActionEvent ae){
		try{   
			int freq 	= Integer.parseInt(freqField.getText() );
			int beatsFreq   = Integer.parseInt(beatsFreqField.getText());
			int percentage  = Integer.parseInt(volumeField.getText() );
 			int vol 	= 32768 / 100 * percentage;
		
			BinauralBeats snl = new BinauralBeats (44100, freq, beatsFreq, vol );
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
