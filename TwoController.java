import java.awt.event.*;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.Timer; 




public class TwoController implements ActionListener, KeyListener {
	private TwoModel model; 
	private TwoView view; 
	private boolean winWindowShown; 
	private boolean loseWindowShown; 
	public TwoController(TwoModel m, TwoView v) {
		this.model = m; 
		this.view = v; 
		winWindowShown = false; 
		loseWindowShown = false; 
		
	}
	
	
	void doNewGame() {
         
    	
       
		view.setFocusable(true); 
	    
	    view.requestFocusInWindow(); 
    
	    model.newGame(); 
        view.repaint();
        winWindowShown = false; 
        loseWindowShown = false; 
    }
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode(); 


		if (code == KeyEvent.VK_UP) {
			
			model.moveUp(); 
		}
		else if (code == KeyEvent.VK_LEFT) {
			model.moveLeft(); 
		}
		else if (code == KeyEvent.VK_RIGHT) {
			model.moveRight(); 
		}
		else if (code == KeyEvent.VK_DOWN) {
			model.moveDown(); 
		}
		else {
			JOptionPane.showMessageDialog(view, "Please enter in arrow keys to play game"); 
			
		}
		view.repaint(); 
		if (winWindowShown == false) {
			if (model.win()) {
				JOptionPane.showMessageDialog(view, "You win! Your score is: " + model.getScore() + "\n" + "Press OK. You can keep playing if you want to keep going or press New Game if you want to start over"); 
				winWindowShown = true; 
				
			}
		}
		if (loseWindowShown == false) {
			
			if (model.lose()) {
				JOptionPane.showMessageDialog(view, "Game over. Your score is " + model.getScore() + "\n"+ "Press OK and then New Game if you want to play again");
				loseWindowShown = true; 

			 
			}
		}
		
	}
	
	public void actionPerformed(ActionEvent evt) { 
        String command = evt.getActionCommand();
        if (command.equals(view.getNewGameButtonText())) {
        	
            doNewGame(); 
     
        	view.repaint();
            
        }
		
        
    }
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	
}