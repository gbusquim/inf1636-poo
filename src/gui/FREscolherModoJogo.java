package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FREscolherModoJogo extends JFrame {
	final int LARG_DEFAULT = 310;
	final int ALT_DEFAULT = 210;
	
	FREscolherModoJogo(EscolherModoJogo jogo) {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		
		JPanel Jpanel = createPNEscolherModoJogo(jogo);
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
	private JPanel createPNEscolherModoJogo(EscolherModoJogo jogo) {
		JPanel Jpanel = new JPanel();
		
		final int LARG_BUTTON = 220;
		final int ALT_BUTTON = 35;
		
		int xButton = (LARG_DEFAULT / 2) - (LARG_BUTTON / 2);
		int yButton = (ALT_DEFAULT / 2) - (ALT_BUTTON / 2);
		
		JButton novoJogoButton = new JButton("Novo Jogo");
		novoJogoButton.setBounds(xButton, yButton - ALT_BUTTON, LARG_BUTTON, ALT_BUTTON);
		novoJogoButton.setEnabled(true);
		novoJogoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jogo.NovoJogo();
	        }
		});
		add(novoJogoButton);
		
		JButton carregarJogoButton = new JButton("Carregar Jogo");
		carregarJogoButton.setBounds(xButton, yButton + ALT_BUTTON, LARG_BUTTON, ALT_BUTTON);
		carregarJogoButton.setEnabled(true);
		add(carregarJogoButton);
		
		return Jpanel;
	}
}
