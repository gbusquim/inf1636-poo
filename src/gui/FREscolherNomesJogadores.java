package gui;

import java.awt.Dimension;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class FREscolherNomesJogadores extends JFrame {
	final int LARG_DEFAULT = 310;
	final int ALT_DEFAULT = 210;
	
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
		setTitle("Jogadores");
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	private JPanel createPNEscolherNomesJogadores(EscolherModoJogo jogo) {
		JPanel Jpanel = new JPanel();
		
		final int LARG_FIELD = 150;
		final int ALT_FIELD = 30;

		final int LARG_BUTTON = 110;
		final int ALT_BUTTON = 35;
		
		int xFields = (LARG_DEFAULT / 2) - (LARG_FIELD / 2);
		int yFields = 50;
		
		int xButton = (LARG_DEFAULT / 2) - (LARG_BUTTON / 2);
		int yButton = yFields + 80;
		
		JLabel label1 = new JLabel("Jogador 1:");
		label1.setBounds(xFields - 50, yFields - ALT_FIELD, 60, ALT_FIELD);
		label1.setEnabled(true);
		add(label1);
		
		JLabel label2 = new JLabel("Jogador 2:");
		label2.setBounds(xFields - 50, yFields + 20, 60, ALT_FIELD);
		label2.setEnabled(true);
		add(label2);
		
		TextField jogador1Field = new TextField("Jogador 1", 50);
		jogador1Field.setBounds(xFields + 50, yFields - ALT_FIELD, LARG_FIELD, ALT_FIELD);
		jogador1Field.setEnabled(true);
		add(jogador1Field);
		
		TextField jogador2Field = new TextField("Jogador 2", 50);
		jogador2Field.setBounds(xFields + 50, yFields + 20, LARG_FIELD, ALT_FIELD);
		jogador2Field.setEnabled(true);
		add(jogador2Field);
		
		JButton iniciarButton = new JButton("Começar");
		iniciarButton.setBounds(xButton, yButton, LARG_BUTTON, ALT_BUTTON);
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
