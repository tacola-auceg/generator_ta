import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;


class SplashWindow extends JWindow
{
    public SplashWindow(String filename, Frame f)
    {
        super(f);
        JLabel l = new JLabel(new ImageIcon(getClass().getResource(filename)));
        getContentPane().add(l, BorderLayout.CENTER);
        pack();
        Dimension screenSize =
          Toolkit.getDefaultToolkit().getScreenSize();
        Dimension labelSize = l.getPreferredSize();
        setLocation(screenSize.width/2 - (labelSize.width/2),
                    screenSize.height/2 - (labelSize.height/2));

        final Runnable closerRunner = new Runnable()
            {
                public void run()
                {
                    setVisible(false);
                    dispose();
                }
            };

        Runnable waitRunner = new Runnable()
            {
                public void run()
                {
                    try
                        {
 							new CorporateDemo();
 							SwingUtilities.invokeAndWait(closerRunner);

                        }
                    catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                }
            };

        setVisible(true);
        Thread splashThread = new Thread(waitRunner, "SplashThread");
        splashThread.start();
        splashThread.setPriority(Thread.NORM_PRIORITY);
      }
    public static void main(String a[])
       {
   		JFrame f = new JFrame();
   		new SplashWindow("atchayam.jpg",f);
	}
}