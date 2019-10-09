package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import regras.*;
 
public class PNVelha extends JPanel implements MouseListener {
	int xIni=1000,yIni=125,larg=30,alt=30,espLinha=5;
	int iClick,jClick;
	Celula tab[][]=new Celula[15][15];
	Line2D.Double ln[]=new Line2D.Double[4];
	CtrlRegras ctrl;
	
	public PNVelha(CtrlRegras c) {
		int x=xIni,y=yIni;
		ctrl=c;
		
		for(int i=0;i<15;i++) {
			x=xIni;
			for(int j=0;j<15;j++) {
				tab[i][j]=new Celula(x,y);
				x+=larg;
			}
			y+=alt;
		}
		
		addMouseListener(this);
		
//		ln[0]=new Line2D.Double(155.0,75.0,155.0,325.0);
//		ln[1]=new Line2D.Double(240.0,75.0,240.0,325.0);
//		ln[2]=new Line2D.Double(75.0,155.0,325.0,155.0);
//		ln[3]=new Line2D.Double(75.0,240.0,325.0,240.0);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		Rectangle2D rt;
		int mat[][]=ctrl.getMatriz();
		int vez=ctrl.getVez();
		g.setFont (new Font ("Arial", 1, 15) );
		
		for(int j=0;j<15;j++)
		{
			g.drawString(Integer.toString(j+1),tab[0][j].x+31,yIni+15);
		}
		
		for(int i=0;i<15;i++)
		{
			g.drawString(String.valueOf((char)('A'+i)),xIni,tab[i][0].y+46);
		}
		

//		g2d.setStroke(new BasicStroke(5.0f,
//               BasicStroke.CAP_BUTT,
//                BasicStroke.JOIN_MITER,
//                10.0f));
		
		if(vez==-1)
			g2d.setPaint(Color.green);
		else			
			g2d.setPaint(Color.red);

		
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(mat[i][j]==0) {
					g2d.setPaint(Color.white);
					rt=new Rectangle2D.Double(tab[i][j].x+25.0,tab[i][j].y+25.0,larg,alt);
					
					g2d.fill(rt);
					g2d.setPaint(Color.black);
					g2d.draw(rt);

				}
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		int x=e.getX(),y=e.getY();
		x-=75;
		y-=75;
		int vencedor=0;
		if (x>0 && y>0 && x<250 && y < 250)
		{

			vencedor = ctrl.telaClicada(y/80,x/80);
		}
		
		if(vencedor==1000)
		{
			repaint();
			JOptionPane.showMessageDialog(
			        this,"Verde ganhou");
			ctrl.reiniciar();
		}
		else if(vencedor==2000)
		{
			repaint();
			JOptionPane.showMessageDialog(
			        this,"Vermelho ganhou");
			ctrl.reiniciar();
		}
		else if(vencedor==3000)
			{
			repaint();
			JOptionPane.showMessageDialog(
			        this,"Empate");
			ctrl.reiniciar();

		}
		repaint();
	}
	
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}