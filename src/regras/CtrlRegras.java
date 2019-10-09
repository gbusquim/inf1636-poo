package regras;

public class CtrlRegras {
	int[][] tabuleiro= new int[15][15]; 
	//int tabuleiro [][]= {{0,0,0},{0,0,0},{0,0,0}};
	int vez=5;
	private int numJogadas =1;
	
	public CtrlRegras() {
		for(int i =0;i< 15;i++)
		{
			tabuleiro[i] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		}
	}
	
	public int[][] getMatriz() {
		return tabuleiro;
	}
	
	public int getVez() {
		return vez;
	}
	
	public void reiniciar()
	{
		int i,j;
		vez=1;
		numJogadas =1;
		for(i = 0;i < 3;i++)
		{
			for(j = 0; j <3;j++)
			{
				tabuleiro[i][j]=0;
			}
		}
	}
	
	public int detectarVencedor()
	{
		//detectar soma das linahs
		int soma=0,i,j;
		for(j = 0;j < 3;j++)
		{
			for(i = 0; i <3;i++)
			{
				soma = soma+tabuleiro[i][j];
			}
			if(soma == -3)
				return 1000;
			else if(soma ==15)
				return 2000;
			else if(numJogadas==9)
				return 3000;
			System.out.println(soma);
			soma =0;
		}
		System.out.println("--------------------");
		soma =0;
		
		//detectar soma ds colunas
		for(i = 0;i < 3;i++)
		{
			for(j = 0; j <3;j++)
			{
				soma = soma+tabuleiro[i][j];
			}
			if(soma == -3)
				return 1000;
			else if(soma ==15)
				return 2000;
			else if(numJogadas==9)
				return 3000;
			System.out.println(soma);
			soma =0;
		}
		System.out.println("--------------------");
		soma = tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2];
		if(soma == -3)
			return 1000;
		else if(soma ==15)
			return 2000;
		else if(numJogadas==9)
			return 3000;
		System.out.println(soma);
		soma = tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0];
		if(soma == -3)
			return 1000;
		else if(soma ==15)
			return 2000;
		else if(numJogadas==9)
			return 3000;
		else
			return 4000;
		
	}
	
	public int telaClicada(int i,int j)
	{
		int vencedor;
		System.out.println("AAQA");
		System.out.println(numJogadas);
		if(tabuleiro[i][j] == 0)
		{
			if(vez ==5)
			{
				tabuleiro[i][j] = 5;
				vencedor = detectarVencedor();
				if(vencedor == 1000)
					return 1000;
				if(vencedor == 2000)
					return 2000;
				if(vencedor == 3000)
					return 3000;
				else
				{
					vez =-1 ;
					numJogadas++;
					return 0;
				}

			}	
			else
			{
				tabuleiro[i][j] = -1;
				vencedor = detectarVencedor();
				if(vencedor == 1000)
					return 1000;
				if(vencedor == 2000)
					return 2000;
				if(vencedor == 3000)
					return 3000;
				else
				{
					vez =5 ;
					numJogadas++;
					return 0;
				}
				
			}
			
		}

		return 0;
	}
}
