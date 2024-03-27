package inner;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyWindow extends JFrame{

	// 버튼 객체를 생성한다
	JButton newBtn = new JButton("새파일");
	JButton openBtn = new JButton("열기");
	JButton saveBtn = new JButton("저장");
	JButton exitBtn = new JButton("닫기");
	
	public MyWindow() {
		setLayout(new FlowLayout());
		
		// 버튼 객체를 프레임이 추가한다
		add(newBtn);
		add(openBtn);
		add(saveBtn);
		add(exitBtn);
		
		/*
		 * public interface ActionListener {
		 * 		void actionPerformed(ActionEvent event);
		 */
		
		ActionListener l1 = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "새 파일을 엽니다");
			}
		};
		
		ActionListener l2 = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
			}
		};
		
		ActionListener l3 = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JFileChooser chooser = new JFileChooser();
				chooser.showSaveDialog(null);
			}
		};
				
		newBtn.addActionListener(l1);
		openBtn.addActionListener(l2);
		saveBtn.addActionListener(l3);
		exitBtn.addActionListener(null);
		
		// 프레임의 위치와 크기를 지정한다
		// 위치는 left:100, top:100,
		// 크기는 width:300, height:100
		setBounds(200,200,300,100);
		// 프레임이 화면에 표시되게 하다
		setVisible(true);
		// 프레임의 크기를 조절할 수 없게 한다
		setResizable(false);
		// 프레임의 닫기 버튼에 대한 기본 동작을 정의한다
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyWindow();
	}
}
