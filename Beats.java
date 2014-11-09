
class Beats implements Signal {	
	private short[] snd_ch1;
	private short[] snd_ch2;

	private double f_discr;

	Beats(double f_discret){
		f_discr = f_discret;		 
		snd_ch1 = new short[signalSize ];  
		snd_ch2 = new short[signalSize ];  
		
	}

	void fill_channel(double f_signal, 
		double f_beats,
		int amp, 
		int chan_num)
	{
		double dt;


    		dt=1.0/f_discr;

		double PI = 3.14159;
			
		double w1, w2;		
		if ((int) f_beats % 2 == 0){
    			w1=2*PI*(f_signal - (int) f_beats / 2);
			w2=2*PI*(f_signal + (int) f_beats / 2);
		}
		else{
    			w1=2*PI*(f_signal);
			w2=2*PI*(f_signal + (int) f_beats);		
		}
    		double t=0;

		if (chan_num == 1)
    			for ( int i=0; i < snd_ch1.length; i++,t+=dt)
       				snd_ch1[i] = (short) (amp*(Math.sin(w1*t) + Math.sin(w2*t)) );
		else
			for ( int i=0; i < snd_ch2.length; i++,t+=dt)
       				snd_ch2[i] = (short) (amp*(Math.sin(w1*t) + Math.sin(w2*t)) );
	}

	
	public void add(Signal snl){}

	public short[] get_ch1()
	{
		return snd_ch1;
	}

	public short[] get_ch2()
	{
		return snd_ch2;
	}

}