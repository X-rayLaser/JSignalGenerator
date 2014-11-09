import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.sound.sampled.*;

class BeatsDialog implements ActionListener{
	
	private JLabel freqLabel, beatsFreqLabel, volLabel, chanLabel; 	 
	private JTextField freqField, beatsFreqField, volumeField, chanField;
  	
	private JButton okButton;
	
	GuiWindow w;
	
	BeatsDialog(GuiWindow wnd_caller){
		w= wnd_caller;
		 
		JFrame jfrm = new JFrame("JSignalGenerator"); 
		
		jfrm.setLayout(new FlowLayout());

		jfrm.setSize(300, 200);

		freqLabel = new JLabel("Frequency, hz");	
		
		beatsFreqLabel = new JLabel("Beats frequency, hz");
				
		chanLabel = new JLabel("Channel(1st or 2nd" );
		
		volLabel = new JLabel("Volume, %");
		 
		okButton = new JButton("Ok");
		
		okButton.addActionListener(this);
		
		freqField 	= new JTextField(10);	
		beatsFreqField  = new JTextField(10);	
		volumeField 	= new JTextField(10);
		chanField 	= new JTextField(5);
		
		freqField.setText("400");
		beatsFreqField.setText("10"); 
		volumeField.setText("20");
		chanField.setText("1");
		
		jfrm.add(freqLabel);
		jfrm.add(freqField );
		jfrm.add(beatsFreqLabel);
		jfrm.add(beatsFreqField);
		jfrm.add(chanLabel);
		jfrm.add(chanField);
		jfrm.add(volLabel );
		jfrm.add(volumeField );

		jfrm.add(okButton);
		
		jfrm.setVisible(true);	
	}


	public void actionPerformed(ActionEvent ae){

		int freq 	= Integer.parseInt(freqField.getText() );
		int beatsFreq   = Integer.parseInt(beatsFreqField.getText());
		int chan 	= Integer.parseInt(chanField.getText() );
		 
		int percentage  = Integer.parseInt(volumeField.getText() );
 		int vol =  32768 / 100 * percentage / 2;
		
		Beats snl = new Beats (44100);
		snl.fill_channel(freq, beatsFreq, vol, chan);
		w.addSignal(snl);   
	} 
}
