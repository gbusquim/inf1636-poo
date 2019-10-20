package gui;

import regras.*;

public class EscolherModoJogo {
	
	FREscolherModoJogo emjFrame;
	FREscolherNomesJogadores enjFrame;
	FRFasePosicionamento fpFrame;

	EscolherModoJogo( ) {
		emjFrame = new FREscolherModoJogo(this);
	}
	public void NovoJogo( ) {
		emjFrame.setVisible(false);
		enjFrame = new FREscolherNomesJogadores(this);
	}
	public void IniciarJogo( ) {
		enjFrame.setVisible(false);
		fpFrame = new FRFasePosicionamento(new CtrlRegras());
		fpFrame.setVisible(true);
	}
	public static void main(String[] args) {
		new EscolherModoJogo();
	}
}
