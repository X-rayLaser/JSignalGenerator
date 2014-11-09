import javax.sound.sampled.*;

class PlayerStereo {
	private Clip outline;
	private AudioFormat format;
	
	private boolean isOpen;

	PlayerStereo (double f_discret) throws LineUnavailableException
	{		
		outline = AudioSystem.getClip();		
		format = new AudioFormat((float) f_discret, 16, 2, true, true); 
		isOpen = false;
	}

	void play(Signal snl, int loop_count) throws LineUnavailableException
	{
		short[] amps1 = snl.get_ch1();
		short[] amps2 = snl.get_ch2();

		int buf_size = amps1.length * 2 + amps2.length * 2 ;

		byte[] snd_stream = new byte[buf_size]; 
		
		 
		for (int i=0, j =0; i <= buf_size - 4; i+=4, j++){
			short val_ch1 = amps1[j];
			snd_stream[i] = (byte) (val_ch1  >> 8);
			snd_stream[i+1] = (byte) ((val_ch1  << 8) >> 8);

			short val_ch2 = amps2[j];
			snd_stream[i+2] = (byte) (val_ch2  >> 8);
			snd_stream[i+3] = (byte) ((val_ch2  << 8) >> 8);

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
