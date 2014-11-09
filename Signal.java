interface Signal {	 

	int maxChildCount = 100;
	
	int signalSize = 44100;
	void add(Signal snl);

	short[] get_ch1();
	short[] get_ch2();
}