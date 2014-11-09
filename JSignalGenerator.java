import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Container;
import javax.swing.BoxLayout;

class JSignalGenerator {
   public static void main(String args[]){	
			
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GuiWindow();
			}
		});
   }
}
