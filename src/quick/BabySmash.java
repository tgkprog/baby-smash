import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
/**
Tushar Kapila

open BSD licence

2013
Invite you to improve and add to this project.


*/

public class BabySmash extends JFrame{
	boolean isFullScreen =false;
	public static final String EXIT_STR =  "exitnow";
	public static final String HLP_STR = "baby smash, To exit: type (on button _):" + EXIT_STR;
	Cntainer conty;


	public BabySmash (GraphicsDevice device){
		super(device.getDefaultConfiguration());
		boolean ss = true;
		if(ss){
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);//EXIT_ON_CLOSE
			isFullScreen = device.isFullScreenSupported();

		}
		setUndecorated(isFullScreen);
		setResizable(!isFullScreen);
		if (isFullScreen) {
		    // Full-screen mode
		    device.setFullScreenWindow(this);
		    validate();
		} else {
		    // Windowed mode
		    pack();
		    setVisible(true);
		}
		Container c = getContentPane();

		//setContentPane(conty);
		c.setLayout(null);
		JButton b = new JButton ("_");
		//b.add
		c.add(b);
		b.setBounds(20,12,40,40);

		conty = new Cntainer(this);
		c.add(conty);
		conty.setBounds(0,110,2220,2240);

		setTitle(HLP_STR);

		KeyBoardListen keys = new KeyBoardListen (EXIT_STR);
		b.addKeyListener(keys);
		JLabel lbl = new JLabel (HLP_STR);
		c.add(lbl);
		lbl.setBounds(20,55, 600,89);
 	}

 public static void main(String[] args) {
        GraphicsEnvironment env = GraphicsEnvironment.
            getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = env.getScreenDevices();
        // REMIND : Multi-monitor full-screen mode not yet supported
        for (int i = 0; i < 1 /* devices.length */; i++) {
            BabySmash test = new BabySmash(devices[i]);

        }
    }


    }