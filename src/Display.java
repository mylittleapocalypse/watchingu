import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Display extends JFrame {
	public Avatar img;
	public JLabel text;
	Display(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300, 430);
		//this.setLocation(0,0);
		this.setLocation(1920-this.getWidth(),(1080-this.getHeight())-40);
		this.setLayout(new BorderLayout(0,0));
		this.setResizable(false);
		this.init();
		this.add(img, BorderLayout.PAGE_START);
		this.add(text, BorderLayout.CENTER);
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		this.setBackground(new Color(0,0,0,0));
		this.setVisible(true);
	}
	private void init() {
		img = new Avatar("fae-blonde","png");		
		text = new JLabel("Get to work!!", SwingConstants.CENTER);
		text.setVerticalAlignment(SwingConstants.CENTER);
		text.setOpaque(true);
		text.setBackground(Color.BLACK);
		text.setForeground(Color.WHITE);
		text.setFont(new Font(text.getName(), Font.PLAIN, 22));
	}
	public void getProcesses(){
		String line;
		String pidInfo ="";
		Process p;
		try {
			p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
			BufferedReader input =  new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
			    pidInfo+=line; 
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getActiveWindow(){
		int exitVal = 0;
		try{
			Runtime rt = Runtime.getRuntime();
		    String ahkPath = "C:\\Program Files\\AutoHotkey\\AutoHotkey.exe";
		    String scriptPath = "res/GetName.ahk";
		    Process p = rt.exec(new String[] { ahkPath, scriptPath} );
		    Thread.currentThread();
		    exitVal = p.waitFor();
		}
		catch(Throwable t){
			t.printStackTrace();
		}
		return exitVal;
	}
	public static void main(String[] args) {
		Display d = new Display();
		while(true) {
			Thread.currentThread();
			try {
				int ret = d.getActiveWindow();
				if(ret == 1){
					d.img.setEmotionIcon(Avatar.UNAMUSED);
					d.text.setText("You should be Working");
				}
				else if(ret == 2){
					d.img.setEmotionIcon(Avatar.DISAPPROVING);
					d.text.setText("I hope thats educational");
				}
				else if(ret == 3){
					d.img.setEmotionIcon(Avatar.HAPPY);
					d.text.setText("Great Job!");
				}	
				else {
					d.img.setEmotionIcon(Avatar.UNINTERESTED);
				}
				Thread.sleep(1000/2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
