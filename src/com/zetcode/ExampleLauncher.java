package com.zetcode;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class ExampleLauncher extends JFrame
{
	private static final long serialVersionUID = 1L;

	public ExampleLauncher()
	{
		initialize();
	}
	
	private void initialize()
	{
		setTitle("Example Launcher");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton pointsButton = new JButton("Points Example");
		pointsButton.addActionListener(pointsExampleLauncher);
		add(pointsButton);
	}

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new ExampleLauncher().setVisible(true);		
			}
		});
	}
	
	private final ActionListener pointsExampleLauncher = new ActionListener()
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			final Surface surface = new Surface();
			
			JFrame window = new JFrame("Points");
			window.setSize(350, 250);
			setLocationRelativeTo(null);
			
			window.add(surface);
			
			window.addWindowListener(new WindowAdapter()
			{
				@Override
				public void windowClosing(WindowEvent e)
				{
					Timer timer = surface.getTimer();
					timer.stop();
				}
			});
			
			window.setVisible(true);
		}
	};
}
