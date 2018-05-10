import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AgruparBotones extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public AgruparBotones(String titulo) {
        //Creación de los RadioButtons
        JRadioButton birdButton = new JRadioButton("Pajarito");
        birdButton.setMnemonic(KeyEvent.VK_B);
        birdButton.setActionCommand("bird");
        birdButton.setSelected(true);

        JRadioButton catButton = new JRadioButton("Gatito");
        catButton.setMnemonic(KeyEvent.VK_C);
        catButton.setActionCommand("cat");

        JRadioButton dogButton = new JRadioButton("Perrito");
        dogButton.setMnemonic(KeyEvent.VK_D);
        dogButton.setActionCommand("dog");

        JRadioButton rabbitButton = new JRadioButton("Conejito");
        rabbitButton.setMnemonic(KeyEvent.VK_R);
        rabbitButton.setActionCommand("rabbit");

        JRadioButton pigButton = new JRadioButton("Cerdito");
        pigButton.setMnemonic(KeyEvent.VK_P);
        pigButton.setActionCommand("pig");

        ButtonGroup btgAnimalitos = new ButtonGroup();

        btgAnimalitos.add(birdButton);
        btgAnimalitos.add(catButton);
        btgAnimalitos.add(dogButton);
        btgAnimalitos.add(rabbitButton);
        btgAnimalitos.add(pigButton);

        JPanel radioPanel = new JPanel();
        //radioPanel.setLayout(new GridLayout(0,1));
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);
        radioPanel.setBackground(Color.BLACK);

        JLabel picture = new JLabel(new ImageIcon("src/loro.png"));
        JPanel PanelCont2=new JPanel();
        PanelCont2.setLayout(new GridLayout(1,2));
        PanelCont2.add(radioPanel);
        PanelCont2.add(picture);
        PanelCont2.setBackground(Color.GREEN);
        
        
        JPanel ButtonPanel = new JPanel();
        //ButtonPanel.setLayout(new GridLayout(1,2));
        ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.X_AXIS));
        JButton Button1 = new JButton("Aceptar");
        JButton Button2 = new JButton("Cancelar");
        ButtonPanel.add(Button1);
        ButtonPanel.add(Button2);
        ButtonPanel.setBackground(Color.RED);
        
        /*JButton btn1 = new JButton("Boton1");
        btnAceptar.setBounds(30, 30, 100, 30);
        ButtonPanel.add(btn1);
        
        JButton btn2 = new JButton("Boton2");
        btnCancelar.setBounds(117, 150, 100, 30);
        ButtonPanel.add(btn2);*/
        
        
        
        /*BoxLayout distBoxLayout = new BoxLayout(this.getContentPane(),
                                                BoxLayout.X_AXIS);
        getContentPane().setLayout(distBoxLayout);
        */
        
        GridLayout distGrid = new GridLayout(2,0);
        getContentPane().setLayout(distGrid);
        getContentPane().add(PanelCont2);
        getContentPane().add(ButtonPanel);
        getContentPane().setBackground(Color.BLUE);

        /*
        getContentPane().add(radioPanel, BorderLayout.WEST);
        getContentPane().add(picture,BorderLayout.CENTER);
        */

       

        pack();

        setTitle(titulo);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Evento producido por " + e.getActionCommand());
    }

    public static void main (String[] args) {
        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        JFrame frame = new AgruparBotones("Curso de Java: Agrupar Botones");
        frame.addWindowListener(l);

        frame.pack();
        frame.setVisible(true);
    }
}