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
	int x = 0 , y = 0; //그림 설정을위한 위치
	int width = 0;		//쓰레드 이미지 크기
	int height = 0;
	
	public main() 
	{
	super("김병철 이력서");
	setSize(1300,750);
	setVisible(true);
	setLocationRelativeTo(null);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //기본틀
	
	Container C = getContentPane();
	C.add(new Background());  //첫화면
	revalidate();
	addKeyListener(this);
	
	JButton button = new JButton("PPT 시작");
	add(button);
	C.add(button);
	button.addActionListener(new start());
	button.setSize(1300,60);
	button.setLocation(0,660);
	
	JButton button2 = new JButton("조작 설명서");
	add(button2);
	C.add(button2);

	button2.setSize(150,150);
	button2.setLocation(1150,500);
	button2.addActionListener(new action());
	}
	
	class Background extends JPanel{ //초기화면 설정
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
		g.drawString("IT부문 운영/개발", 230, 180);
		g.setColor(Color.green);
		g.drawString("지원자 김병철입니다. ", 230, 230);
		g.setColor(Color.BLUE);
	}
}
	
	//6개의 패턴 그림 설정하기
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
				repaint();	//그림이 계속 그려질수있도록
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
				repaint();	//그림이 계속 그려질수있도록
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
	{ //시작버튼 액션리스너

		public void actionPerformed(ActionEvent e) {
			JButton jb1= (JButton)e.getSource();
			(new MyThread()).start();  //쓰레드 시작
			
			Audio Music = new Audio("bgm.mp3", true);//음악재생
			Music.start();
		}
		
	}
	//쓰레드설정
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
		System.out.println(i); //콘솔창 확인용
		
			try {
				Thread.sleep(1000);
				//화면이 안나올때
				revalidate();  
			}		
		catch(InterruptedException e){
			e.printStackTrace();
		}		
//특정상황마다 설정해둔 클래스의 paintComponent그림 바꾸기	
		switch(i) {  
		
		case 1 :
			try {
	            // 이미지 파일 경로
	            File imageFile = new File("image/case1_1.JPG");

	            // 이미지 파일을 BufferedImage로 로드
	            BufferedImage image = ImageIO.read(imageFile);
	            
	            width = image.getWidth();
	            height = image.getHeight();
 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			C.removeAll(); 
			setSize(width,height+40);	//이미지에 맞게 크기가 조절됨
			setLocationRelativeTo(null);
			add(new case0());
			break;
		
		case 10 :
			//이전 그림이 계속 그려지는거 방지	
			try {
	            // 이미지 파일 경로
	            File imageFile = new File("image/case1.JPG");

	            // 이미지 파일을 BufferedImage로 로드
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
	            // 이미지 파일 경로
	            File imageFile = new File("image/case2.JPG");

	            // 이미지 파일을 BufferedImage로 로드
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
	            // 이미지 파일 경로
	            File imageFile = new File("image/case3.JPG");

	            // 이미지 파일을 BufferedImage로 로드
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
	            // 이미지 파일 경로
	            File imageFile = new File("image/case4.JPG");

	            // 이미지 파일을 BufferedImage로 로드
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
			i = 1; //무한루프
			}
		}	
	}
	@Override 									//쓰레드내부 키리스너
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
	{                								          //조작키
		if (arg0.getKeyCode() == KeyEvent.VK_A)
		{
			(new MyThread()).start();
			Audio Music = new Audio("bgm.mp3", true);//음악재생
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
//음악 클래스
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
			this.isLoop = isLoop; //음악 반복재생
			file = new File("music/bgm.mp3"); //음악선택
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}
		catch(Exception e) {
			System.out.println(e.getMessage()); //오류시 메시지 출력
			}
	}
	public void run() 
	{ //실행
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
	 	//설명서
	public void actionPerformed(ActionEvent arg0)
	{
		JButton jb1 = (JButton)arg0.getSource();
		new instructions();
	}
	
 }