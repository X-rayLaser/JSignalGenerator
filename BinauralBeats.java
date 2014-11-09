
class BinauralBeats implements Signal {
	private	Sinusoid sinusoid;
	
	BinauralBeats( double f_discret,
		double f_signal, 
		double f_beats,
		int amp)
	{
		sinusoid = new Sinusoid(f_discret);
	
		if ((int) f_beats % 2 == 0){
			sinusoid.fill_channel(f_signal - f_beats / 2, amp, 1);
			sinusoid.fill_channel(f_signal + f_beats / 2, amp, 2);
		}
		else{
    			sinusoid.fill_channel(f_signal, amp, 1);

			sinusoid.fill_channel(f_signal + f_beats, amp, 2);		
		}

		 


	} 
	
	public void add(Signal snl){}

	public short[] get_ch1()
	{
		return sinusoid.get_ch1();
	}

	public short[] get_ch2()
	{
		return sinusoid.get_ch2();
	}
}