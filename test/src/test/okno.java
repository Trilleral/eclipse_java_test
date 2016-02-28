package test;
//28.02.16
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class okno {
 public static void main(String[] args){
	 
	 myFrame okno = new myFrame();
	}		 
 }
class myFrame extends JFrame{
	public myFrame(){
		myPanel np = new myPanel();
		Container cont = getContentPane();
		cont.add(np);
		setBounds(10,10,800,600);
		setVisible(true);
		
	}
}
class myPanel extends JPanel{
	public void paintComponent(Graphics gr){
		int y = 10;
		int x = 10;
		int y1 = 40;
		int x1 = 40;
		for(int j = 1; j < 8; j++){
			x= x+40;
			y=10;
			for(int i = 1; i < 8; i++){
				y=y+40;
				
		gr.setColor(Color.BLUE);
		gr.drawRect(x, y, x1,y1  );
		if (myArr[j][i]>0) {gr.drawString("1", x+18, y+25);}
			}
		}
	}
}