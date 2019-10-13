package regras;

public class CtrlRegras {
	int[][] tabuleiro = new int[15][15];
	String[][] matrizNavios = new String[14][19]; 
	private int posNavioSelecionado= -1;
	private String tipoNavioSelecionado = "";
	
	public CtrlRegras() 
	{
		int i;
		for(i=0;i< 15;i++)
		{
			tabuleiro[i] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		}
		for(i=0;i< 13;i++)
		{
			matrizNavios[i] = new String[]{"","","","","","","","","","","","","","","","","","",""};
		}
		
		matrizNavios[0] = new String[]{"","h","","","","h","","","","h","","","","h","","","","h",""};
		matrizNavios[1] = new String[]{"h","","h","","h","","h","","h","","h","","h","","h","","h","","h",""};
		matrizNavios[4] = new String[]{"s","","s","","s","","s","","","","","","","","","","","",""};
		matrizNavios[7] = new String[]{"d","d","","d","d","","d","d","","","","","","","","","","",""};
		matrizNavios[10] = new String[]{"cr","cr","cr","cr","","cr","cr","cr","cr","","","","","","","","","",""};
		matrizNavios[13] = new String[]{"co","co","co","co","co","","","","","","","","","","","","","",""};
	}
		
		
	
	public int[][] getTabuleiro() {
		return tabuleiro;
	}
	
	public String[][] getmatrizNavios() {
		return matrizNavios;
	}
	
	
	public void reiniciar()
	{
		/*
		 * int i,j; vez=1; numJogadas =1; for(i = 0;i < 3;i++) { for(j = 0; j <3;j++) {
		 * tabuleiro[i][j]=0; } }
		 */
	}
	
//	public int detectarVencedor()
//	{
//		//detectar soma das linahs
//		/*
//		 * int soma=0,i,j; for(j = 0;j < 3;j++) { for(i = 0; i <3;i++) { soma =
//		 * soma+tabuleiro[i][j]; } if(soma == -3) return 1000; else if(soma ==15) return
//		 * 2000; else if(numJogadas==9) return 3000; System.out.println(soma); soma =0;
//		 * } System.out.println("--------------------"); soma =0;
//		 * 
//		 * //detectar soma ds colunas for(i = 0;i < 3;i++) { for(j = 0; j <3;j++) { soma
//		 * = soma+tabuleiro[i][j]; } if(soma == -3) return 1000; else if(soma ==15)
//		 * return 2000; else if(numJogadas==9) return 3000; System.out.println(soma);
//		 * soma =0; } System.out.println("--------------------"); soma = tabuleiro[0][0]
//		 * + tabuleiro[1][1] + tabuleiro[2][2]; if(soma == -3) return 1000; else if(soma
//		 * ==15) return 2000; else if(numJogadas==9) return 3000;
//		 * System.out.println(soma); soma = tabuleiro[0][2] + tabuleiro[1][1] +
//		 * tabuleiro[2][0]; if(soma == -3) return 1000; else if(soma ==15) return 2000;
//		 * else if(numJogadas==9) return 3000; else return 4000;
//		 */
//		
//	}
	
	public boolean verificaNavioSelecionado(int i,int j)
	{
		int cont;
		if(i ==1 || i == 0)
		{
			for(cont = 1;cont<18;cont=cont+4)
			{
				if((i == 1 && (j==cont -1 || j==cont +1)) || i == 0 && j==cont)
				{
					deselecionaNavio();
					posNavioSelecionado= cont/4;
					tipoNavioSelecionado = "h";
					matrizNavios[0][cont]=matrizNavios[1][cont -1]=matrizNavios[1][cont +1]="S";
					break;
				}
			}
		}
		else if(i ==4 && (j == 0 || j == 2 || j == 4 || j == 6))
		{
				deselecionaNavio();
				posNavioSelecionado= j/2;
				tipoNavioSelecionado = "s";
				matrizNavios[i][j]="S";
		}
		else if(i ==7)
		{
			for(cont = 0;cont<7;cont=cont+3)
			{
				if(j== cont || j==cont + 1)
				{
					deselecionaNavio();
					posNavioSelecionado= cont/3;
					tipoNavioSelecionado = "d";
					matrizNavios[i][cont]=matrizNavios[i][cont +1]="S";
					break;
				}
			}
			
		}
		
		else if(i == 10)
		{
			if(j < 4)
			{
				deselecionaNavio();
				posNavioSelecionado= 0;
				tipoNavioSelecionado = "cr";
				for(cont = 0;cont < 4; cont++)
					matrizNavios[i][cont]="S";
			}
			else if(j < 9 && j!=4)
			{
				deselecionaNavio();
				posNavioSelecionado= 1;
				tipoNavioSelecionado = "cr";
				for(cont = 5;cont < 9; cont++)
					matrizNavios[i][cont]="S";
			}
		}
		
		else if(i == 13)
		{
			if(j < 5)
			{
				deselecionaNavio();
				posNavioSelecionado= 0;
				tipoNavioSelecionado = "co";
				for(cont = 0;cont < 5; cont++)
					matrizNavios[i][cont]="S";
			}
		}
		else
			return false;
		return true;
	}
	
	public void deselecionaNavio()
	{
		int cont;
		if(tipoNavioSelecionado == "h")
		{
			matrizNavios[0][posNavioSelecionado*4+1]=matrizNavios[1][posNavioSelecionado*4]=matrizNavios[1][posNavioSelecionado*4+2]="h";
		}
		
		else if(tipoNavioSelecionado == "s")
		{
			matrizNavios[4][posNavioSelecionado*2]="s";
		}
		
		else if(tipoNavioSelecionado == "d")
		{
			matrizNavios[7][posNavioSelecionado*3]=matrizNavios[7][posNavioSelecionado*3+1]="d";
		}
		else if(tipoNavioSelecionado == "cr")
		{
			for(cont = 0;cont < 4; cont++)
				matrizNavios[10][5*posNavioSelecionado+cont]="cr";
		}
		else if(tipoNavioSelecionado == "co")
		{
			for(cont = 0;cont < 5; cont++)
				matrizNavios[13][cont]="co";
		}
		posNavioSelecionado = -1;
		tipoNavioSelecionado = "";
	}
}
