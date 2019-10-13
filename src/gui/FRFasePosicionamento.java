package gui;

import regras.*;

import java.awt.*;
import javax.swing.*;

public class FRFasePosicionamento extends JFrame {
	final int LARG_DEFAULT=1280;
	final int ALT_DEFAULT=720;
	
	public FRFasePosicionamento(CtrlRegras c) {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setBounds(x, y,LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(new PNFasePosicionamento(c));
		setTitle("Batalha Naval");
		
		
		//setSize(1280, 720);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//getContentPane().add(new PNVelha(c));
		//setTitle("Jogo da Velha");
	}
	
	public static void main(String args[]) {
		(new FRFasePosicionamento(new CtrlRegras())).setVisible(true);
	}
}
