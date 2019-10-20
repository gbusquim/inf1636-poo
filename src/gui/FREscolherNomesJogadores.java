package gui;

import java.awt.Dimension;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FREscolherNomesJogadores extends JFrame {
	final int LARG_DEFAULT = 1280;
	final int ALT_DEFAULT = 720;
	
	FREscolherNomesJogadores(EscolherModoJogo jogo) {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		
		JPanel Jpanel = createPNEscolherNomesJogadores(jogo);
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setBounds(x, y-20,LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(Jpanel);
		setTitle("Escolher modo de jogo");
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	private JPanel createPNEscolherNomesJogadores(EscolherModoJogo jogo) {
		JPanel Jpanel = new JPanel();
		
		final int LARG_BOXES = 220;
		final int ALT_BOXES = 30;
		
		int xBoxes = (LARG_DEFAULT / 2) - (LARG_BOXES / 2);
		int yBoxes = (ALT_DEFAULT / 2) - (ALT_BOXES / 2);
		
		TextField jogador1Field = new TextField("Jogador 1", 50);
		jogador1Field.setBounds(xBoxes, yBoxes - ALT_BOXES, LARG_BOXES, ALT_BOXES);
		jogador1Field.setEnabled(true);
		add(jogador1Field);
		
		TextField jogador2Field = new TextField("Jogador 2", 50);
		jogador2Field.setBounds(xBoxes, yBoxes + ALT_BOXES, LARG_BOXES, ALT_BOXES);
		jogador2Field.setEnabled(true);
		add(jogador2Field);
		
		JButton iniciarButton = new JButton("Iniciar");
		iniciarButton.setBounds(xBoxes, yBoxes + 3 * ALT_BOXES, LARG_BOXES, ALT_BOXES);
		iniciarButton.setEnabled(true);
		iniciarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jogo.IniciarJogo();
	        }
		});
		add(iniciarButton);
		
		return Jpanel;
	}
}
