import javax.sound.sampled.*;

class PlayerMono {
	private Clip outline;
	private AudioFormat format;

	private boolean isOpen;

	PlayerMono(double f_discret) throws LineUnavailableException
	{
		outline = AudioSystem.getClip();		
		format = new AudioFormat((float) f_discret, 16, 1, true, true);
		isOpen = false;  			 
	}

	void play(Signal snl, int loop_count)  throws LineUnavailableException
	{ 
		short[] amps = snl.get_ch1();

		int buf_size = amps.length * 2;

		byte[] snd_stream = new byte[buf_size]; 

		for (int i=0, j =0; i <= buf_size -2; i+=2, j++){
			short val = amps[j];
			snd_stream[i] = (byte) (val >> 8);
			snd_stream[i+1] = (byte) ((val << 8) >> 8);
		}

		if (isOpen)
			outline.close(); 
		

		outline.open(format, snd_stream , 0, buf_size);
		isOpen = true;
		
		outline.setFramePosition(0);
		outline.setLoopPoints(0, -1);
		outline.loop(loop_count);	
		 
	}
	
	void stop(){		
		outline.stop(); //Останавливаем 

		if (isOpen){  					
    			outline.close(); //Закрываем			
			isOpen = false;  	
		} 
	}

}