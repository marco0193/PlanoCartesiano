import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame {

    public Principal(){
        super("Ejemplo uso GridBayLayout");

        Container contenedorPrincipal = this.getContentPane();
        contenedorPrincipal.setLayout(new GridBagLayout());

        JTextArea areaTexto = new JTextArea("Texto multilinea");
        //Modificaci�n de propiedades (posici�n absoluta) mediante restricciones
        GridBagConstraints restricciones = new GridBagConstraints();
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        restricciones.gridwidth = 2; //anchura en celdas
        restricciones.gridheight = 2; //alchura en celdas
        //Agregar compo al contenedor con las restricciones
        contenedorPrincipal.add(areaTexto, restricciones);

        JButton boton1 = new JButton("Bot�n 1");
        //Modificaci�n de propiedades (posici�n absoluta) mediante restricciones
        restricciones.gridx = 2;
        restricciones.gridy = 0;
        restricciones.gridwidth = 1; //anchura en celdas
        restricciones.gridheight = 1; //alchura en celdas
        //Agregar compo al contenedor con las restricciones
        contenedorPrincipal.add(boton1, restricciones);

        JButton boton2 = new JButton("Bot�n 2");
        //Modificaci�n de propiedades (posici�n absoluta) mediante restricciones
        restricciones.gridx = 2;
        restricciones.gridy = 1;
        restricciones.gridwidth = 1; //anchura en celdas
        restricciones.gridheight = 1; //alchura en celdas
        //Agregar compo al contenedor con las restricciones
        contenedorPrincipal.add(boton2, restricciones);

        JButton boton3 = new JButton("Bot�n 3");
        //Modificaci�n de propiedades (posici�n absoluta) mediante restricciones
        restricciones.gridx = 0;
        restricciones.gridy = 2;
        restricciones.gridwidth = 1; //anchura en celdas
        restricciones.gridheight = 1; //alchura en celdas
        //Agregar compo al contenedor con las restricciones
        contenedorPrincipal.add(boton3, restricciones);

        JButton boton4 = new JButton("Bot�n 4");
        //Modificaci�n de propiedades (posici�n absoluta) mediante restricciones
        restricciones.gridx = 2;
        restricciones.gridy = 2;
        restricciones.gridwidth = 1; //anchura en celdas
        restricciones.gridheight = 1; //alchura en celdas
        //Agregar compo al contenedor con las restricciones
        contenedorPrincipal.add(boton4, restricciones);

        JTextField campoTexto = new JTextField("Campo de texto");
        //Modificaci�n de propiedades (posici�n absoluta) mediante restricciones
        restricciones.gridx = 1;
        restricciones.gridy = 2;
        restricciones.gridwidth = 1; //anchura en celdas
        restricciones.gridheight = 1; //alchura en celdas
        //Agregar compo al contenedor con las restricciones
        contenedorPrincipal.add(campoTexto, restricciones);

    }

    public static void main(String[] args){
        Principal ventana = new Principal();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);

    }




}