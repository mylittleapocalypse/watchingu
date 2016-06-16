import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Avatar extends JLabel {
	public static final int HAPPY = 0;
	public static final int UNAMUSED = 1;
	public static final int DISAPPROVING = 2;
	public static final int UNINTERESTED = 3;
	private ImageIcon[] emotions = new ImageIcon[10];
	private String lPath = "res/avatars/";
	Avatar(String name, String fileExt){
		super();
		emotions[HAPPY] = new ImageIcon(lPath+name+"-happy."+fileExt);
		emotions[UNAMUSED] = new ImageIcon(lPath+name+"-unamused."+fileExt);
		emotions[DISAPPROVING] = new ImageIcon(lPath+name+"-disapproving."+fileExt);
		emotions[UNINTERESTED] = new ImageIcon(lPath+name+"-uninterested."+fileExt);
		this.setIcon(emotions[UNINTERESTED]);
	}

	public void setEmotionIcon(int e){
		this.setIcon(emotions[e]);
	}
}
