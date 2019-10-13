package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import regras.*;
 
public class PNFasePosicionamento extends JPanel implements MouseListener,KeyListener {
	
	int xIni=795,yIni=75,tamanhoLado=30;
	int xIniMatriz=25,yIniMatriz=75;
	int iClick,jClick;
	Celula tab[][]=new Celula[15][15];
	Celula matriz[][]=new Celula[14][19];
	CtrlRegras ctrl;
	
	public PNFasePosicionamento(CtrlRegras c) {
		int x=xIni,y=yIni;
		int xm = xIniMatriz, ym = yIniMatriz;
		ctrl=c;
		
		for(int i=0;i<15;i++) {
			x=xIni;
			for(int j=0;j<15;j++) {
				tab[i][j]=new Celula(x,y);
				x+=tamanhoLado;
			}
			y+=tamanhoLado;
		}
		
		for(int i=0;i<14;i++) {
			xm=xIniMatriz;
			for(int j=0;j<19;j++) {
				matriz[i][j]=new Celula(xm,ym);
				xm+=tamanhoLado;
			}
			ym+=tamanhoLado;
		}
		
		addMouseListener(this);
		addKeyListener(this);
		setFocusable(true); 
		
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		Rectangle2D rt;
		int tabuleiro[][]=ctrl.getTabuleiro();
		String matrizNavios[][]=ctrl.getmatrizNavios();
		
		g.setFont (new Font ("Arial", 1, 15) );
		
		for(int j=0;j<15;j++)
		{
			g.drawString(Integer.toString(j+1),tab[0][j].x+8,yIni-5);
		}
		
		for(int i=0;i<15;i++)
		{
			g.drawString(String.valueOf((char)('A'+i)),xIni-17,tab[i][0].y+20);
		}
		

		for(int i=0;i<14;i++) 
		{
			for(int j=0;j<19;j++) 
			{
				if(matrizNavios[i][j]=="h") 
				{
	
					g2d.setPaint(new Color(0, 136, 0));
					rt=new Rectangle2D.Double(matriz[i][j].x,matriz[i][j].y,tamanhoLado,tamanhoLado);
					g2d.fill(rt);
					g2d.setPaint(Color.black);
					g2d.draw(rt);
				}
				else if(matrizNavios[i][j]=="s")
				{
					
					g2d.setPaint(new Color(0, 200, 0));
					rt=new Rectangle2D.Double(matriz[i][j].x,matriz[i][j].y,tamanhoLado,tamanhoLado);
					g2d.fill(rt);
					g2d.setPaint(Color.black);
					g2d.draw(rt);
				}
				else if(matrizNavios[i][j]=="d") 
				{
					
					g2d.setPaint(Color.yellow);
					rt=new Rectangle2D.Double(matriz[i][j].x,matriz[i][j].y,tamanhoLado,tamanhoLado);
					g2d.fill(rt);
					g2d.setPaint(Color.black);
					g2d.draw(rt);
				}
				else if(matrizNavios[i][j]=="cr") 
				{
					
					g2d.setPaint(Color.orange);
					rt=new Rectangle2D.Double(matriz[i][j].x,matriz[i][j].y,tamanhoLado,tamanhoLado);
					g2d.fill(rt);
					g2d.setPaint(Color.black);
					g2d.draw(rt);
				}
				else if(matrizNavios[i][j]=="co") 
				{
					
					g2d.setPaint(new Color(132, 85, 0));
					rt=new Rectangle2D.Double(matriz[i][j].x,matriz[i][j].y,tamanhoLado,tamanhoLado);
					g2d.fill(rt);
					g2d.setPaint(Color.black);
					g2d.draw(rt);
				}
				else if(matrizNavios[i][j]=="S") 
				{
					
					g2d.setPaint(Color.BLUE);
					rt=new Rectangle2D.Double(matriz[i][j].x,matriz[i][j].y,tamanhoLado,tamanhoLado);
					g2d.fill(rt);
					g2d.setPaint(Color.black);
					g2d.draw(rt);

				}

				
			}
		}
		for(int i=0;i<15;i++) 
		{
			for(int j=0;j<15;j++)
			{
				if(tabuleiro[i][j]==0) 
				{
					g2d.setPaint(Color.white);
					rt=new Rectangle2D.Double(tab[i][j].x,tab[i][j].y,tamanhoLado,tamanhoLado);
					g2d.fill(rt);
					g2d.setPaint(Color.black);
					g2d.draw(rt);

				}
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) 
	{
		int x=e.getX(),y=e.getY();
		x-=25;
		y-=75;
		boolean navioSelecionado;

		
		if(x>0 && y>0 && x<19*tamanhoLado && y<14*tamanhoLado) // uma arma foi selecionada
		{

			navioSelecionado = ctrl.verificaNavioSelecionado(y/tamanhoLado,x/tamanhoLado);
			if(navioSelecionado == true)
				repaint();
			
			
		}
		
		else if(x>770 && y>0 && x<1220 && y<15*tamanhoLado) // uma posicao do tabuleiro foi selecionada
		{
			System.out.println(y/tamanhoLado);
			System.out.println((x-770)/tamanhoLado);
			
		}	
	}
	
	
	public void keyTyped(KeyEvent e) 
	{

		int keyCode = e.getKeyChar();
		if (keyCode == 27)
		{//codigo da tecla ESC
			ctrl.deselecionaNavio();
			repaint();
		}
			
	}
	
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}
}