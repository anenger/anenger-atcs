package atcw_20170223;
// Java0912.java
// JackO'lantern Case Study, Stage #1
// This program shows the <Pumpkin> class.


import java.awt.*;
import java.applet.*;


public class Java0912 extends Applet
{
	public void paint(Graphics g)
	{
		Pumpkin p = new Pumpkin(g);
	}
}

class Pumpkin
{
	public Pumpkin(Graphics g)
	{
		g.setColor(Color.orange);
		g.fillOval(100,100,600,450);
		g.setColor(new Color(50,200,50));
		g.fillRect(390,30,20,80);
	}
}

