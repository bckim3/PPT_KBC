package last;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class instructions extends JFrame{
	instructions(){
	super("����");
	setSize(300,200);
	setVisible(true);
	
	setLocationRelativeTo(null);
	setResizable(false);
	
	Container C = getContentPane();
	C.setLayout(new FlowLayout());
	
	JLabel l = new JLabel("PPT���� : ");
	JLabel l1 = new JLabel("������ �ϴ��� ��ưŬ�� �Ǵ�");
	JLabel l2 = new JLabel("A �� �Է��Ͻø� �˴ϴ�");
	JLabel l4 = new JLabel("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
	JLabel l3 = new JLabel("PPT ���� : ");
	JLabel l5 = new JLabel("����� Ű������ ESC�Դϴ�");
	
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
