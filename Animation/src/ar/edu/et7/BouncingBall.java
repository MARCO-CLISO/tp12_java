package ar.edu.et7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingBall extends JPanel implements ActionListener {
    private int ballX = 50, ballY = 50; // Coordenadas iniciales de la pelota
    private int ballDiameter = 30; // Diámetro de la pelota
    private int ballDeltaX = 2, ballDeltaY = 2; // Velocidad de la pelota

    public BouncingBall() {
        Timer timer = new Timer(10, this); // Crear un temporizador que se activa cada 10 ms
        timer.start(); // Iniciar el temporizador
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
       
     g.fillOval(ballX, ballY, ballDiameter, ballDiameter);
    	  
    	  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ballX + ballDeltaX < 0 || ballX + ballDiameter + ballDeltaX > getWidth()) {
            ballDeltaX *= -1; // Invertir la dirección horizontal si choca con el borde izquierdo o derecho
        
          
        	  ballDiameter=ballDiameter-1;
        	
        	  if( ballDiameter==0) 
              {
            	  ballDiameter=ballDiameter+30;
            			  
              }  
        	  
                  
          }
        if (ballY + ballDeltaY < 0 || ballY + ballDiameter + ballDeltaY > getHeight()) {
            ballDeltaY *= -1; // Invertir la dirección vertical si choca con el borde superior o inferior
           
          	  ballDiameter=ballDiameter-1;
          		
          	if( ballDiameter==0) 
            {
          	  ballDiameter=ballDiameter+30;
          			  
            } 
          	  
            
             
        }

        ballX += ballDeltaX; // Actualizar la posición horizontal de la pelota
        ballY += ballDeltaY; // Actualizar la posición vertical de la pelota

        repaint(); // Volver a pintar el panel
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        BouncingBall bouncingBall = new BouncingBall();
        frame.add(bouncingBall);
        frame.setSize(400, 300); // Tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
