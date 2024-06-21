package last;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javazoom.jl.player.Player;

public class main extends JFrame implements KeyListener
{
	int x = 0 , y = 0; //�׸� ���������� ��ġ
	int width = 0;		//������ �̹��� ũ��
	int height = 0;
	
	public main() 
	{
	super("�躴ö �̷¼�");
	setSize(1300,750);
	setVisible(true);
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�⺻Ʋ
	
	Container C = getContentPane();
	C.add(new Background());  //ùȭ��
	revalidate();
	addKeyListener(this);
	
	JButton button = new JButton("PPT ����");
	add(button);
	C.add(button);
	button.addActionListener(new start());
	button.setSize(1300,60);
	button.setLocation(0,660);
	
	JButton button2 = new JButton("���� ����");
	add(button2);
	C.add(button2);

	button2.setSize(150,150);
	button2.setLocation(1150,500);
	button2.addActionListener(new action());
	}
	
	class Background extends JPanel{ //�ʱ�ȭ�� ����
		Image img;
		Background()
	{
		ImageIcon icon = new ImageIcon("image/BGI.JPG");
		img = icon.getImage();
	}
		
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(img, x, y, this);
		g.setFont(new Font("Dialog",Font.BOLD|Font.ITALIC, 50));
		g.setColor(Color.BLACK);
		g.drawString("IT�ι� �/����", 230, 180);
		g.setColor(Color.green);
		g.drawString("������ �躴ö�Դϴ�. ", 230, 230);
		g.setColor(Color.BLUE);
	}
}
	
	//6���� ���� �׸� �����ϱ�
	class case0 extends JPanel{
		Image img;
		case0()
		{
			ImageIcon icon = new ImageIcon("image/case1_1.JPG");
			img = icon.getImage();
		}
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, x, y, this);
				repaint();	//�׸��� ��� �׷������ֵ���
		}
	}
	
	class case1 extends JPanel{  
		Image img;
		case1() 
		{	
			ImageIcon icon = new ImageIcon("image/case1.JPG");
			img = icon.getImage();
		}
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, x, y, this);
				repaint();	//�׸��� ��� �׷������ֵ���
		}
	}
	
	class case2 extends JPanel{
		Image img;
		case2()
		{
			ImageIcon icon = new ImageIcon("image/case2.JPG");
			img = icon.getImage();
			}
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, x, y, this);
				repaint();
		}
	}
		
	class case3 extends JPanel{
		Image img;
		case3()
		{ 
			ImageIcon icon = new ImageIcon("image/case3.JPG");
			img = icon.getImage();
		}
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, x, y, this);
				repaint();
		}
	}
		
	class case4 extends JPanel{
		Image img;
		case4()
		{
			ImageIcon icon = new ImageIcon("image/case4.png");
			img = icon.getImage();
		}
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, x, y, this);
				repaint();
		}
	}
	
	class start implements ActionListener
	{ //���۹�ư �׼Ǹ�����

		public void actionPerformed(ActionEvent e) {
			JButton jb1= (JButton)e.getSource();
			(new MyThread()).start();  //������ ����
			
			Audio Music = new Audio("bgm.mp3", true);//�������
			Music.start();
		}
		
	}
	//�����弳��
	class MyThread extends Thread implements KeyListener
	{  
		int i=0;
		Container C = getContentPane();
		
	public void run()
	{
		addKeyListener(this);
		while(true) 
		{ 
		i++;
		System.out.println(i); //�ܼ�â Ȯ�ο�
		
			try {
				Thread.sleep(1000);
				//ȭ���� �ȳ��ö�
				revalidate();  
			}		
		catch(InterruptedException e){
			e.printStackTrace();
		}		
//Ư����Ȳ���� �����ص� Ŭ������ paintComponent�׸� �ٲٱ�	
		switch(i) {  
		
		case 1 :
			try {
	            // �̹��� ���� ���
	            File imageFile = new File("image/case1_1.JPG");

	            // �̹��� ������ BufferedImage�� �ε�
	            BufferedImage image = ImageIO.read(imageFile);
	            
	            width = image.getWidth();
	            height = image.getHeight();
 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			C.removeAll(); 
			setSize(width,height+40);	//�̹����� �°� ũ�Ⱑ ������
			setLocationRelativeTo(null);
			add(new case0());
			break;
		
		case 10 :
			//���� �׸��� ��� �׷����°� ����	
			try {
	            // �̹��� ���� ���
	            File imageFile = new File("image/case1.JPG");

	            // �̹��� ������ BufferedImage�� �ε�
	            BufferedImage image = ImageIO.read(imageFile);
	            
	            width = image.getWidth();
	            height = image.getHeight();
 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			C.removeAll(); 
			setSize(width,height+40);
			setLocationRelativeTo(null);
			add(new case1());
			break;
						
		case 20:
			try {
	            // �̹��� ���� ���
	            File imageFile = new File("image/case2.JPG");

	            // �̹��� ������ BufferedImage�� �ε�
	            BufferedImage image = ImageIO.read(imageFile);
	            
	            width = image.getWidth();
	            height = image.getHeight();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			C.removeAll(); 
			setSize(width,height+40);
			setLocationRelativeTo(null);
			add(new case2());
			break;
			
		case 30:
			try {
	            // �̹��� ���� ���
	            File imageFile = new File("image/case3.JPG");

	            // �̹��� ������ BufferedImage�� �ε�
	            BufferedImage image = ImageIO.read(imageFile);
	            
	            width = image.getWidth();
	            height = image.getHeight();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			C.removeAll(); 
			setSize(width,height+40);
			setLocationRelativeTo(null);
			add(new case3());
			break;
			
		case 40:
			try {
	            // �̹��� ���� ���
	            File imageFile = new File("image/case4.JPG");

	            // �̹��� ������ BufferedImage�� �ε�
	            BufferedImage image = ImageIO.read(imageFile);
	            
	            width = image.getWidth();
	            height = image.getHeight();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			C.removeAll(); 
			setSize(width,height+40);
			setLocationRelativeTo(null);
			add(new case4());
			break;
			
		case 50:
			i = 1; //���ѷ���
			}
		}	
	}
	@Override 									//�����峻�� Ű������
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			System.exit(0);
		}
	}
	
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {	
	}
}	
	
	public static void main(String[] args) 
	{
	main f = new main();
	}	

	public void keyPressed(KeyEvent arg0) 
	{                								          //����Ű
		if (arg0.getKeyCode() == KeyEvent.VK_A)
		{
			(new MyThread()).start();
			Audio Music = new Audio("bgm.mp3", true);//�������
			Music.start();
		}
		if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			System.exit(0);
		}
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
	}
}
//���� Ŭ����
 class Audio extends Thread 
 {
	private Player player;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	private boolean isLoop;
	
	public Audio(String name, boolean isLoop)
	{
		try 
		{	
			this.isLoop = isLoop; //���� �ݺ����
			file = new File("music/bgm.mp3"); //���Ǽ���
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}
		catch(Exception e) {
			System.out.println(e.getMessage()); //������ �޽��� ���
			}
	}
	public void run() 
	{ //����
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
 
 class action implements ActionListener
 {						
	 	//����
	public void actionPerformed(ActionEvent arg0)
	{
		JButton jb1 = (JButton)arg0.getSource();
		new instructions();
	}
	
 }