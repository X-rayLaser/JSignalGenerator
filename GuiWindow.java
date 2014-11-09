import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.sound.sampled.*;

class GuiWindow implements ActionListener {
	private JButton jbtnPlay;
	private JButton jbtnStop;
	private JButton jbtnFreq;
	private JButton jbtnBeats;
	private JButton jbtnBinBeats;
	private ComplexSignal s;
	private int    count;
	private PlayerStereo player;

	GuiWindow () 
	{

		count = 0;
		
		try{
			player = new PlayerStereo (44100);
		} 
		catch(LineUnavailableException ob)
		{
		}

		s = new ComplexSignal ();

		JFrame jfrm = new JFrame("JSignalGenerator"); 
		//jfrm.setLayout(new FlowLayout());
			
		jfrm.setSize(340, 200);
		
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jbtnPlay = new JButton("Play");
		
		jbtnStop = new JButton("Stop");

		jbtnFreq = new JButton("Add frequency");
		
		jbtnBeats = new JButton("Add beats");
		
		jbtnBinBeats = new JButton("Add binaural beats");

		jfrm.add(jbtnPlay, BorderLayout.NORTH  );		
		jfrm.add(jbtnStop, BorderLayout.SOUTH);
		jfrm.add(jbtnFreq, BorderLayout.WEST );
		jfrm.add(jbtnBeats,BorderLayout.CENTER  );	
		jfrm.add(jbtnBinBeats, BorderLayout.EAST  ); 
		
		jbtnPlay.addActionListener(this);		
		jbtnStop.addActionListener(this);	
		jbtnFreq.addActionListener(this);	
		jbtnBeats.addActionListener(this);	
		jbtnBinBeats.addActionListener(this);	

		jfrm.setVisible(true);
	}

	public void addSignal(Signal snl){
		s.add(snl); 
	}
	
	public void actionPerformed(ActionEvent ae)  
	{
		if(ae.getActionCommand().equals("Play") ) 
		{		
			try{	 
				player.play(s, 60);
			}
			catch(LineUnavailableException ob)
			{
				System.out.println("unavailable");
			}
			
		}
		else if  ( ae.getActionCommand().equals("Stop") ){
				player.stop();
		}
		else if ( ae.getActionCommand().equals("Add frequency") )
		{			
			FreqDialog dialog = new FreqDialog(this);
		} 
		else if ( ae.getActionCommand().equals("Add beats")) {
			BeatsDialog dialog = new BeatsDialog(this);
		}
		else if ( ae.getActionCommand().equals("Add binaural beats")) {
			BinauralBeatsDialog  dialog = new BinauralBeatsDialog(this);
		}
	}
	
}