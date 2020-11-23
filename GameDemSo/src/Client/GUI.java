package Client;




import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.Highlighter;









public class GUI implements Runnable {
	private JFrame mainJFrame;
	private JButton num_bt, num_demo,num_pp;
	private JLabel num_lbl, labelClock, lb_iconClock, Player1, Player2, Sound, Search, Start;
	private JPanel mainJPanel;
	private JTextField enterChat;
	private Timer thoigian ;//Tao doi tuong dem thoi gian
	private Integer second,minute ;

	private ArrayList<JButton> list_bt;
	
	static boolean flag=false;
	boolean winner;
	
	

	private int x = 27, y = 15, index;
	Integer[] arr;

	public GUI() {
		createAndShow();

	}

	public void createAndShow() {
		

		list_bt = new ArrayList<JButton>();
		num_pp = new JButton();
		mainJFrame = new JFrame();
		mainJPanel = new JPanel();
		labelClock = new JLabel();
		lb_iconClock = new JLabel();
		Player1 = new JLabel();
		Player2 = new JLabel();
		Sound = new JLabel();
		Start = new JLabel();
		Search = new JLabel();


		
		try {
			Cl_Connect cl = new Cl_Connect();
			arr = cl.arraytoGUI() ;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(arr[2]);
		
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {

				index = i * 10 + j - 10;
				if (index == 100)
					break;
				if (index % 2 == 0) {
					x += 27;
					y += 10;
				} else {
					x -= 27;
					y -= 20;
				}
				if (index % 7 == 0) {
					y += 10;

				}
				num_lbl = new JLabel();
				num_lbl.setHorizontalAlignment(JLabel.CENTER);
				num_lbl.setOpaque(true);
				num_lbl.setBounds(x, y, 35, 35);
				num_lbl.setBackground(new Color(0, 113, 139));
				num_lbl.setText("" + arr[index - 1]);
				num_lbl.setForeground(Color.BLACK);
				num_lbl.addMouseListener(new HighlightMouseListener());
				
//				num_bt = new JButton();
//				num_bt.setBounds(0, 0, 40, 40);
//				num_bt.setVisible(true);
//				num_bt.setEnabled(true);
//			    num_bt.setBackground(Color.YELLOW);
//			    
//				String stringCommand = Integer.toString(index);
//		        num_bt.setActionCommand(stringCommand);
//		 
//				num_lbl.add(num_bt);
//				list_bt.add(num_bt);
				mainJPanel.add(num_lbl);
//				list_bt.get(index-1).addActionListener(new ActionListener() {
//	                @Override
//	                public void actionPerformed(ActionEvent e) {
//	                    JButton button = (JButton) e.getSource();
//	                    String command = button.getActionCommand();
//	                    int id_btn = Integer.parseInt(command);
//                    num_lbl.setBackground(Color.YELLOW);
//	                    list_bt.get(index-1).setBackground(Color.YELLOW);
//	                    
//	                }
//		        });
				
				
				num_pp.setBounds(10, 40, 80, 20);
				num_pp.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    JButton button = (JButton) e.getSource();
	                    String command = button.getActionCommand();
	                    int id_btn = Integer.parseInt(command);
	                    num_lbl.setBackground(Color.YELLOW);
	                    num_pp.setBackground(Color.YELLOW);
	                    
	                }
		        });
				num_pp.setVisible(true);
				num_pp.setEnabled(true);
				
//				mainJFrame.add(num_pp);

				y += 70;
			}
			if (i % 2 == 0)
				y = 10;
			else
				y = 30;
			x += 132;
		}

//        try {

//		Calendar calendar = Calendar.getInstance();
//		String hour = (calendar.getTime().getHours() > 9) ? "" + calendar.getTime().getHours() + ""
//				: "0" + calendar.getTime().getHours();
//		String minute = (calendar.getTime().getMinutes() > 9) ? "" + calendar.getTime().getMinutes() + ""
//				: "0" + calendar.getTime().getMinutes();
//		String second = (calendar.getTime().getSeconds() > 9) ? "" + calendar.getTime().getSeconds() + ""
//				: "0" + calendar.getTime().getSeconds();
//		labelClock.setText(hour + ":" + minute + ":" + second);
////                Thread.sleep(1000);
//
////        } 
////        catch (InterruptedException e) {
////            e.printStackTrace();
////        }
		
		labelClock.setBounds(1000, 20, 80, 20);
		labelClock.setForeground(Color.WHITE);

		mainJFrame.add(labelClock);
		  second =0;
	        minute =0;
	       
	        thoigian = new Timer(1000,new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String temp = minute.toString();
	                String temp1 = second.toString();
	                if(temp.length()==1){
	                    temp = "0"+temp;
	                }
	                if(temp1.length()==1){
	                    temp1="0"+temp1;
	                }
	                if(second ==59){
	                    labelClock.setText(temp+":"+temp1);
	                    minute ++;
	                    second=0;
	                }else{
	                    labelClock.setText(temp+":"+temp1);
	                    second++;
	                }
	                
	            }
	            
	        });
	
	        
	  
	        thoigian.start();
		Player1.setBounds(400, 20, 80, 20);
		Player1.setForeground(Color.YELLOW);
		Player1.setText("Player 1" + " : " + 0);
		mainJFrame.add(Player1);

		Player2.setBounds(700, 18, 80, 20);
		Player2.setForeground(Color.CYAN);
		Player2.setText("Player 2" + " : " + 1);
		mainJFrame.add(Player2);

		try {
			BufferedImage image = ImageIO.read(new File("./image/dongho.jpg"));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(45, 45, image.SCALE_SMOOTH));
			lb_iconClock.setIcon(icon);
		} catch (IOException ex) {
		}
		lb_iconClock.setBounds(910, 0, 45, 45);
		mainJFrame.add(lb_iconClock);

		try {
			BufferedImage image = ImageIO.read(new File("./image/start.png"));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(45, 45, image.SCALE_SMOOTH));
			Start.setIcon(icon);
		} catch (IOException ex) {
		}
		Start.setBounds(90, 0, 45, 45);
		mainJFrame.add(Start);

		try {
			BufferedImage image = ImageIO.read(new File("./image/loa.png"));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(45, 45, image.SCALE_SMOOTH));
			Sound.setIcon(icon);
		} catch (IOException ex) {
		}
		Sound.setBounds(250, 0, 45, 45);
		mainJFrame.add(Sound);

		try {
			BufferedImage image = ImageIO.read(new File("./image/search.png"));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(45, 45, image.SCALE_SMOOTH));
			Search.setIcon(icon);
		} catch (IOException ex) {
		}
		Search.setBounds(560, 0, 45, 45);
		mainJFrame.add(Search);

		mainJPanel.setLayout(null);
		mainJPanel.setBounds(0, 48, 1270, 1150);
		mainJPanel.setBackground(new Color(0, 113, 139));
		mainJFrame.add(mainJPanel);
		
        
		mainJFrame.setIconImage(Images.getImage(Images.ID_BIRD_RIGHT));
		mainJFrame.setLayout(null);
		mainJFrame.setSize(1270, 1250);
		mainJFrame.setLocationRelativeTo(null);
		mainJFrame.getContentPane().setBackground(new Color(0, 74, 80));
		mainJFrame.setVisible(true);
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String arg[]) {

		GUI demso = new GUI();
		

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
	
	public class HighlightMouseListener extends MouseAdapter {
	    public JLabel previous;

	    @Override
	    public void mouseClicked(MouseEvent e) {
	        Component source = e.getComponent();
	        if (!(source instanceof JLabel)) {
	            return;
	        }
	        JLabel label = (JLabel) source;
	        if (previous != null) {
	            previous.setBackground(null);
	            previous.setForeground(null);
	            previous.setOpaque(false);
	        }
	        previous = label;
	        label.setForeground(Color.WHITE);
	        label.setBackground(Color.RED);
	        label.setOpaque(true);
	    }

	}

	


}


