import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
// dispose(); 와 System.exit(0); 차이
//* 하나의 Frame에서 다른 Frame을 열어야 할 경우가 있는데
//* 각각 Frame의 종료 이벤트가 Exit로 설정되어 있을경우 다른 창까지 모두 종료되기 때문에
//* 원하는 하나의 Frame만 종료 시키기 위해서는 dispose() 메소드를 사용하여야 한다.

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("Difference between Exit and Dispose First Frame");
        setSize(430, 110);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        JButton btnDispose = new JButton("Dispose");
        btnDispose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        btnDispose.setBounds(10, 10, 100, 50);
        getContentPane().add(btnDispose);
         
        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        btnExit.setBounds(120, 10, 100, 50);
        getContentPane().add(btnExit);
         
        JButton btnShow = new JButton("Show Another Frame");
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new AnotherFrame();
            }
        });
        btnShow.setBounds(230, 10, 170, 50);
        getContentPane().add(btnShow);
 
        setVisible(true);
    }
    public static void main(String[] args) {
		new MyFrame();
	}
}