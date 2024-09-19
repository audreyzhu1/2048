import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

	
public class TwoMain {
	

    public static void main(String[] args) {
        JFrame window = new JFrame("2048");
        
        TwoModel model = new TwoModel(); 
        TwoView view = new TwoView(model); 
        
        
        
        window.setContentPane(view);
        window.pack();  
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation( (screensize.width - window.getWidth())/2,
                (screensize.height - window.getHeight())/2 );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.setResizable(false);  
        window.setVisible(true);
    }
		
}
