import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Lienzo extends JPanel
{
	
	private Color colorFondo;
	private int XOrigen=150, YOrigen=200;
	private int FigX = XOrigen - 200;
    private int FigY = YOrigen -250;
    private Graphics g;
	
	private accionesRaton oyenteRaton;
	
	public void setCoordXOrig(int XOrigen){
        this.XOrigen = XOrigen;
    }

    public void setCoordYOrig(int YOrigen){
        this.YOrigen = YOrigen;
    }
	
  public Lienzo()
  {
	  super();
	  
	  //Obtener el ancho y alto del JFrame
	  this.setPreferredSize(new Dimension(800,400));
	  this.colorFondo = Color.WHITE;
	  this.setBackground(colorFondo);
	  
	XOrigen = this.getWidth()/2;
	YOrigen = this.getHeight()/2;
	  
	  accionesRaton oyenteRaton = new accionesRaton();
	  this.addMouseListener(oyenteRaton);
	  this.addMouseMotionListener(oyenteRaton);
	  
	  this.addKeyListener(new KeyListener() {

          @Override
          public void keyPressed(KeyEvent e) {
              if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            	  FigX = FigX + 20;
                  repaint();
              }

              if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            	  FigX = FigX - 20;
                  repaint();
              }

              if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                  FigY = FigY + 20;
                  repaint();
              }

              if(e.getKeyCode() == KeyEvent.VK_UP) {
                  FigY = FigY - 20;
                  repaint();
              }
          }

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	  });
      this.setFocusable(true);
      this.requestFocusInWindow();
  }
  
  @Override
  public void paintComponent(Graphics g)
  {
	  super.paintComponent(g);
	  
	  XOrigen = this.getWidth()/2;
	  YOrigen = this.getHeight()/2;
		
	  //Colorear el fondo de la pantalla
	  g.setColor(this.colorFondo);
	  g.fillRect(0, 0, this.getWidth(), this.getHeight());
	  //XOrigen = this.getWidth()/2;
	  //YOrigen = this.getHeight()/2;
	  
	  //Creacion de la linea en X y Y
	  g.setColor(Color.BLUE);
	  g.drawLine(0, YOrigen,this.getWidth(), YOrigen);
	  g.drawLine(XOrigen, 0, XOrigen, this.getHeight());
	  
	  repaint();
	  
	  int nValoresNegY = (YOrigen/40)*-1;
	  int nValoresPosY = (this.getHeight()-YOrigen/40);
	  
	  //Dibujar la marca de eje Y
	  for(int valorY=nValoresNegY; valorY<=nValoresPosY;valorY++)
	  {
	  g.drawLine(XOrigen+10, YOrigen+(valorY*40),XOrigen-10 ,YOrigen+(valorY*40));
	  if(valorY!=0)
	  g.drawString( ""+valorY*-1,XOrigen+20,YOrigen+(valorY*40));  
	  
	 
	  }
	  
	  //Calculos
	  int nValoresNeg = (XOrigen/40)*-1;
	  int nValoresPos = (this.getWidth()-XOrigen/40);
	  
	  //Dibujar la marca de eje x
	  for(int valorX=nValoresNeg; valorX<=nValoresPos;valorX++)
	  {
	  g.drawLine(XOrigen+(valorX*40), YOrigen-10, XOrigen+(valorX*40),YOrigen+10);
	  g.drawString(""+valorX, XOrigen+(valorX*40), YOrigen+30);
	  
	  
	  dibujaGraficaSeno(g);
	  graficarFigura(g);
	  }
	  
  }
  
  public void dibujaGraficaSeno(Graphics g)
  {
	  int factorX=1, factorY=100;
	  int coordPantX, coordPantY;
	  double gradRad,seno;
	  g.setColor(Color.RED);
	  
	  for(int grad = 0; grad<361; grad++){
		  gradRad = Math.toRadians(grad);
		  
		  seno = Math.sin(gradRad);
		  
		  coordPantX = XOrigen +(grad * factorX);
		  coordPantY = (int) (YOrigen -(seno * factorY));
		  
		  //Dibujar el punto (x,y)
		  g.fillRect(coordPantX,  coordPantY,  5, 5);
	  }
  }
  
  public void graficarFigura(Graphics g){
	    g.setColor(Color.BLUE);
	    g.drawOval(FigX+323,FigY+250,50,50);

	}
  
public Color getColorFondo() {
	return colorFondo;
}

public void setColorFondo(Color colorFondo) {
	this.colorFondo = colorFondo;
}

class accionesRaton extends MouseAdapter implements  MouseMotionListener
{
	boolean bandMueveOrigen=false;
	@Override
	public void mouseClicked(MouseEvent e)
	{
		//Click derecho activa modificacion de coord origen
		if(e.getButton() == MouseEvent.BUTTON3)
		{
			if(((e.getX()>= XOrigen-20)&& (e.getX()<= XOrigen+20) )&&((e.getY()>= YOrigen-20)&& (e.getY()<= YOrigen+20) ))
			{
				bandMueveOrigen = true;
				
			}
			
		}//Click derecho desactiva modificacion de coord origen
		else if(e.getButton() == MouseEvent.BUTTON1)
		{
			bandMueveOrigen = false;
		}
		//System.out.println(" X= "+e.getX() +" Y= "+e.getY()+" Origen= ("+XOrigen+","+ YOrigen+")"+" Boton= "+e.getButton()+" mover= "+ bandMueveOrigen);
			
	}
	

	@Override
	public void mouseMoved(MouseEvent e)
	{
		//System.out.println("Pos ("+e.getX() +","+e.getY()+")"+" Origen= ("+XOrigen+","+ YOrigen+")"+" Boton= "+e.getButton()+" mover= "+ bandMueveOrigen);
		
		//Si la bandMueveOrigen esta activa
		//Cambiar x,y del origen con la posicion actual de cursor
		if(bandMueveOrigen)
		{
			XOrigen=e.getX();
			YOrigen=e.getY();
			repaint();
		}
	}
}//Donde puedo asignar el valor de XOrigen y YOrigen
}
