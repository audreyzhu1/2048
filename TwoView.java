import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class TwoView extends JPanel{


	private TwoModel model; 
	private TwoController controller; 

    private JButton newGameButton;  
  
    private JLabel score;  
    private Twoboard board; 
    public void setMessageText(String text) {
    	this.score.setText(text);
    	
    }
    public TwoView(TwoModel m) {
    	this.model = m; 
    	this.controller = new TwoController(model, this); 
    
        setLayout(null);  
        setPreferredSize( new Dimension(350,250) );

        setBackground(new Color (248, 240, 227));
        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(controller); 
        
        score = new JLabel();
        score.setFont(new  Font("Serif", Font.BOLD, 20));
        score.setForeground(Color.black);
        score.setText("score: " + model.getScore());
        score.setBounds(200, 120, 350, 30);
        board = new Twoboard();
        
        this.addKeyListener(controller);
        setFocusable(true); 
      

        board.setBounds(20,20,164,164); 
        newGameButton.setBounds(210, 60, 120, 30);
 
        
        this.add(score); 
        this.add(board);
        this.add(newGameButton); 
   
    }
    public String getNewGameButtonText() {
 		return newGameButton.getText();
 	}
    
   
    
    public JButton getNewGameButton() {
    	return newGameButton;
    }
    private class Twoboard extends JPanel {
    	
    	Twoboard() {
                setBackground(Color.BLACK);
             
    	}

    
      
        public void paintComponent(Graphics g) {
            
            
            
      



            g.setColor(Color.black);
            g.drawRect(0,0,getSize().width-1,getSize().height-1);
            g.drawRect(1,1,getSize().width-3,getSize().height-3);
            score.setText("score:" + model.getScore());
            
            board.setFocusable(true);  
         
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    String num = Integer.toString(model.getNumber(row, col)); 

                	if (num.equals("2")) {
                	

                		g.setColor(new Color(247, 200, 195)); 
                		
                       
                		

                	}
                	else if (num.equals("4")) {
                		g.setColor(new Color(251, 196, 171)); 
                	}
                	else if (num.equals("8")) {
                		g.setColor(new Color(248, 173, 157)); 
                	}
                	else if (num.equals("16")) {
                		g.setColor(new Color(244, 151, 142));
                	}
                	else if (num.equals("32")) {
                		g.setColor(new Color(240, 143, 132)); 
                	}
                	else if (num.equals("64")) {
                		g.setColor(new Color (238, 130, 120)); 
                	}
                	else if (num.equals("128")) {
                		g.setColor(new Color(236, 115, 107)); 
                	}
                	else if (num.equals("256")) {
                		g.setColor(new Color(234, 101, 90)); 
                	}
                	else if (num.equals("512")) {
                		g.setColor(new Color(232, 85, 78)); 
                	}
                	else if (num.equals("1024")) {
                		g.setColor(new Color(230, 70, 60)); 
                	}
                	else if (num.equals("2048")) {
                		g.setColor(new Color(228, 55, 45)); 
                	}
                	
                    else {
                       g.setColor(new Color(243, 225, 223)); 
                    }
                   
                    g.fillRect(2+col*40, 2+row*40, 40, 40);
                    g.setColor(Color.LIGHT_GRAY); 
                    g.drawRect(2+col*40, 2+row*40, 40, 40);
                    g.setColor(Color.BLACK);
                    if (!(num.equals("0"))) {
                    	if (num.equals("4") || num.equals("8") || num.equals("2")) {
                    		g.drawString(num, 18 + col*40, 26 + row*40);
                    	}
                    	else if (num.equals("16") || num.equals("32") || num.equals("64")) {
                    		g.drawString(num, 14 + col*40, 26 + row*40); 
                    	}
                    	else if (num.equals("128") || num.equals("256") || num.equals("512")) {
                    		g.drawString(num, 9 + col*40, 26 + row*40); 
                    	}
                    	else if (num.equals("1024") || num.equals("1024")) {
                    		g.drawString(num, 5 + col*40, 26 + row*40); 
                    	}
                    }
                    
                    
                 }
            }
       }
    }
}
 
