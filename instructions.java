package last;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class instructions extends JFrame{
	instructions(){
	super("설명서");
	setSize(300,200);
	setVisible(true);
	
	setLocationRelativeTo(null);
	setResizable(false);
	
	Container C = getContentPane();
	C.setLayout(new FlowLayout());
	
	JLabel l = new JLabel("PPT시작 : ");
	JLabel l1 = new JLabel("시작은 하단의 버튼클릭 또는");
	JLabel l2 = new JLabel("A 를 입력하시면 됩니다");
	JLabel l4 = new JLabel("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	JLabel l3 = new JLabel("PPT 종료 : ");
	JLabel l5 = new JLabel("종료는 키보드의 ESC입니다");
	
	C.add(l);
	C.add(l1);
	C.add(l2);
	C.add(l4);
	C.add(l3);
	C.add(l5);
	
	}

	public static void main(String[] args) {
		new instructions();
	}

}
