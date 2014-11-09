
class ComplexSignal implements Signal {
	private	Signal[] childs;
	private int count;
		
	ComplexSignal(){
		childs = new Signal[maxChildCount];
		count = 0;
	}

	public void add(Signal snl){
		if (count < maxChildCount){
			childs[count] = snl;
			count++;
		}
		
	}

	public short[] get_ch1(){

		short[] snd = new short[signalSize];
		
		for (int i = 0; i < count; i++) {
			Signal ch = childs[i];
			short[] buf_snd = ch.get_ch1();
			for (int j = 0 ; j < snd.length; j++)			 
				  snd[j] = (short) (snd[j] + buf_snd[j]);
		}
			 
		return snd;
		
	}

	public short[] get_ch2(){
		short[] snd = new short[signalSize];
		
		for (int i = 0; i < count; i++) {
			Signal ch = childs[i];
			short[] buf_snd = ch.get_ch2();
			for (int j = 0 ; j < snd.length; j++)			 
				  snd[j] = (short) (snd[j] + buf_snd[j]);
		}
			 
		return snd;
		
	}
}

