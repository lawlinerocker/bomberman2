package bomberman.gui.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import bomberman.gui.CodeDialog;
import bomberman.gui.Frame;
import bomberman.gui.InfoDialog;
public class Game  extends JMenu
{
	public Frame frame;
	public Game(Frame frame)
	{
		super("Game");
		this.frame=frame;
		JMenuItem newgame=new JMenuItem("New Game");
		newgame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		newgame.addActionListener(new MenuActionListener(frame));
		add(newgame);
		
		JMenuItem scores=new JMenuItem("Top Scores");
		scores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));
		scores.addActionListener(new MenuActionListener(frame));
		add(scores);
		
		JMenuItem codes=new JMenuItem("Codes");
		codes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		codes.addActionListener(new MenuActionListener(frame));
		add(codes);
		
	}
	class MenuActionListener implements ActionListener
	{
		public Frame _frame;
		public MenuActionListener(Frame frame)
		{
			_frame=frame;
		}
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("New Game"))
			{
				_frame.newGame();
			}
			if(e.getActionCommand().equals("Top Scores"))
			{
				new InfoDialog(_frame,"Top Scores: ","No Top Scores Yet",JOptionPane.INFORMATION_MESSAGE);
			}
			if(e.getActionCommand().equals("Codes"))
			{
				new CodeDialog(_frame);
			}
		}
	}
}
