package com.mycompany.memoryproject;
 /**
 * Se importan las bibliotecas
 */
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Main Frame del juego 
 * @author Roger Solano
 */
public class MainGame extends javax.swing.JFrame implements ActionListener{
    
    private int i1= -1,i2=-1,j1=-1,j2=-1;//para seleccionar las cartas
    private int i = InicioJuego.i;//tamaño del tablero
    private int j = InicioJuego.j;
    private int turno = InicioJuego.turno;//turno del jugador
    public JButton[][] tablero = new JButton[i][j]; //tablero
    private ImageIcon defimg;
    private Icon def;
    private final String HOST = "localhost";
    private final int PUERTO = 5000;
    private DataInputStream inResponse;
    private DataOutputStream outRequest;
    private String powerUp = "null";
    public MainGame() throws IOException {
        this.defimg = new ImageIcon("C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\com\\mycompany\\serverproject\\def.jpg");
        Image img = defimg.getImage();
        Image resized = img.getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH);
        def = new ImageIcon(resized);//imagen default
        initComponents();//inicializan los componentes del Jform
        errorCarta2.setVisible(false);//los errores estan invisbiles al prinicipio
        errorCarta.setVisible(false);
        errorCarta1.setVisible(false);
        turnoJuego.setText("Juega el jugador número: " + turno);
        jugadorGanador.setVisible(false);
        player1.setText(InicioJuego.p1);
        player2.setText(InicioJuego.p2);
        initTable();
    }

    public final void initTable(){
        //inicia el tablero, lo llena de botones con el icono default
        for(int i = 0; i < this.i; i++){
            for(int j = 0; j < this.j; j++){
                tablero[i][j] = new JButton();
                tablero[i][j].setIcon(def);
                tablero[i][j].addActionListener(this);
                tablero[i][j].setSize(150,150);
                tablePAN.add(tablero[i][j]);
            }
        }
        validate();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        for(int i = 0; i < this.i; i++){
            for(int j = 0; j < this.j; j++){
                if(ae.getSource() == tablero[i][j]){
                    //cada vez que un boton es clickeado se cambian los indices para obtener la posicion de 
                    //la carta clickeada
                    //aqui esta el bug ya que si se escogen dos cartas, ya no se pueden elegir otras
                    //dos pares pues los inidices no se resetean
                    if(i1 ==-1 && j1 == -1){
                        i1 = i;
                        j1 = j;
                    }else if(i2 ==-1 && j2 == -1){
                        i2 = i;
                        j2 = j;
                    }else{
                        i1 = i;
                        j1 = j;
                    }
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePAN = new javax.swing.JPanel();
        player1 = new javax.swing.JLabel();
        player2 = new javax.swing.JLabel();
        scoreP2 = new javax.swing.JLabel();
        scoreP1 = new javax.swing.JLabel();
        enviarParejaBtn = new javax.swing.JButton();
        jugadorGanador = new javax.swing.JLabel();
        puntosDobles1 = new javax.swing.JButton();
        puntosDobles2 = new javax.swing.JButton();
        turnoDoble1 = new javax.swing.JButton();
        turnoDoble2 = new javax.swing.JButton();
        turnoJuego = new javax.swing.JLabel();
        verCarta1 = new javax.swing.JButton();
        verCarta2 = new javax.swing.JButton();
        errorCarta = new javax.swing.JLabel();
        errorCarta1 = new javax.swing.JLabel();
        errorCarta2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablePAN.setLayout(new java.awt.GridLayout(4, 3));

        player1.setText("Player 1:");

        player2.setText("Player 2:");

        scoreP2.setText("0");

        scoreP1.setText("0");

        enviarParejaBtn.setText("Seleccionar pareja");
        enviarParejaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enviarParejaBtnMouseClicked(evt);
            }
        });

        jugadorGanador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jugadorGanador.setText("jLabel1");

        puntosDobles1.setText("Puntos dobles");
        puntosDobles1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                puntosDobles1MouseClicked(evt);
            }
        });

        puntosDobles2.setText("Puntos dobles");
        puntosDobles2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                puntosDobles2MouseClicked(evt);
            }
        });

        turnoDoble1.setText("Doble turno");
        turnoDoble1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                turnoDoble1MouseClicked(evt);
            }
        });

        turnoDoble2.setText("Doble turno");
        turnoDoble2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                turnoDoble2MouseClicked(evt);
            }
        });

        turnoJuego.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        turnoJuego.setText("jLabel1");

        verCarta1.setText("Ver carta");
        verCarta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verCarta1MouseClicked(evt);
            }
        });

        verCarta2.setText("Ver carta");
        verCarta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verCarta2MouseClicked(evt);
            }
        });

        errorCarta.setText("Seleccione una carta");

        errorCarta1.setText("Seleccione una carta");

        errorCarta2.setText("Seleccione dos cartas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(verCarta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(puntosDobles1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scoreP1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(turnoDoble1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addComponent(errorCarta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(turnoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jugadorGanador, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scoreP2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(tablePAN, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(turnoDoble2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(puntosDobles2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(verCarta2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorCarta1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enviarParejaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errorCarta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1)
                    .addComponent(player2)
                    .addComponent(scoreP2)
                    .addComponent(scoreP1)
                    .addComponent(turnoJuego))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jugadorGanador)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablePAN, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(puntosDobles1)
                        .addGap(32, 32, 32)
                        .addComponent(turnoDoble1)
                        .addGap(34, 34, 34)
                        .addComponent(verCarta1)
                        .addGap(18, 18, 18)
                        .addComponent(errorCarta))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(puntosDobles2)
                        .addGap(30, 30, 30)
                        .addComponent(turnoDoble2)
                        .addGap(33, 33, 33)
                        .addComponent(verCarta2)
                        .addGap(18, 18, 18)
                        .addComponent(errorCarta1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorCarta2)
                .addGap(18, 18, 18)
                .addComponent(enviarParejaBtn)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarParejaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviarParejaBtnMouseClicked
        if(i1 == -1 || i2 == -1){//en caso de no escoger cartas
            errorCarta2.setVisible(true);
            i1 = -1;
            j1 = -1;
            i2 = -1;
            j2 = -1;
            return;
        }
        try {
            errorCarta2.setVisible(false);
            Socket socket = new Socket(HOST,PUERTO);

            inResponse = new DataInputStream(socket.getInputStream());
            outRequest = new DataOutputStream(socket.getOutputStream());
            //string para enviar info al server
            String request = i1 + "," + j1 + "," + i2 + "," + j2 + "," + turno + "," + powerUp;
            outRequest.writeUTF(request);

            String pathScore = inResponse.readUTF();//se lee la respuesta del server
            //se separa el string de respuesta
            ArrayList<String> data = new ArrayList<>(Arrays.asList(pathScore.split(",")));
            String path = data.get(0);
            String ganador = data.get(2);
            int score = Integer.parseInt(data.get(1));
            //se despliegan las puntuaciones
            if(turno == 1){
                scoreP1.setText(String.valueOf(score));
            }else{
                scoreP2.setText(String.valueOf(score));
            }
            //el turno que manda el servidor
            turno = Integer.parseInt(data.get(3));
            //en caso de que haya un ganador
            switch (ganador) {
                case "player1" -> {
                    jugadorGanador.setText("Gana el jugador: " + InicioJuego.p1);
                    jugadorGanador.setVisible(true);
                    enviarParejaBtn.setEnabled(false);
                    socket.close();
                }
                case "player2" -> {
                    jugadorGanador.setText("Gana el jugador: " + InicioJuego.p2);
                    jugadorGanador.setVisible(true);
                    enviarParejaBtn.setEnabled(false);
                    socket.close();
                }
                case "empate" -> {
                    jugadorGanador.setText("Empates!");
                    jugadorGanador.setVisible(true);
                    enviarParejaBtn.setEnabled(false);
                    socket.close();
                }
                default -> {
                }
                    
            }
            //si la path que devuelve es valida se cambian los iconos y los botones se deshabilitan
            if(!"null".equals(path)){
                ImageIcon imgIcon = new ImageIcon(path);
                Image img = imgIcon.getImage();
                Image resized = img.getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(resized);
                tablero[i1][j1].setIcon(icon);
                tablero[i2][j2].setIcon(icon);
                tablero[i1][j1].setEnabled(false);
                tablero[i2][j2].setEnabled(false);
                i1 = -1;
                i2 = -1;
                j1 = -1;
                j2 = -1;
            }else{
                tablero[i1][j1].setIcon(def);
                tablero[i2][j2].setIcon(def);
                i1 = -1;
                i2 = -1;
                j1 = -1;
                j2 = -1;
            }
            turnoJuego.setText("Juega el jugador número: " + turno);
            powerUp = "null";

        } catch (IOException ex) {
            Logger.getLogger(InicioJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_enviarParejaBtnMouseClicked

    private void puntosDobles1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_puntosDobles1MouseClicked
        powerUp = "puntosDobles";
        puntosDobles1.setEnabled(false);
    }//GEN-LAST:event_puntosDobles1MouseClicked

    private void turnoDoble1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_turnoDoble1MouseClicked
        powerUp = "turnoDoble";
        turnoDoble1.setEnabled(false);
    }//GEN-LAST:event_turnoDoble1MouseClicked

    private void puntosDobles2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_puntosDobles2MouseClicked
        powerUp = "puntosDobles";
        puntosDobles2.setEnabled(false);
    }//GEN-LAST:event_puntosDobles2MouseClicked

    private void turnoDoble2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_turnoDoble2MouseClicked
        powerUp = "turnoDoble";
        turnoDoble2.setEnabled(false);
    }//GEN-LAST:event_turnoDoble2MouseClicked

    private void verCarta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verCarta1MouseClicked
        if(i1 == -1 || j1 == -1){//si no selecciona una carta se le indica
            errorCarta.setVisible(true);
            return;
        }
        powerUp = "verCarta";
        verCarta1.setEnabled(false);
        try {
            errorCarta.setVisible(false);
            Socket socket = new Socket(HOST,PUERTO);

            inResponse = new DataInputStream(socket.getInputStream());
            outRequest = new DataOutputStream(socket.getOutputStream());
            String request = i1 + "," + j1 + "," + i2 + "," + j2 + "," + 1 + "," + powerUp;//se el envia info al server
            outRequest.writeUTF(request);

            String pathScore = inResponse.readUTF();//se recibe la respuesta

            ArrayList<String> data = new ArrayList<>(Arrays.asList(pathScore.split(",")));

            String path = data.get(0);
            //en esta funcion solo ocupamos el path para mostrar la carta
            if(!"null".equals(path)){
                ImageIcon imgIcon = new ImageIcon(path);
                Image img = imgIcon.getImage();
                Image resized = img.getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(resized);
                tablero[i1][j1].setIcon(icon);
                i1 = -1;
                i2 = -1;
                j1 = -1;
                j2 = -1;
            }else{
                i1 = -1;
                i2 = -1;
                j1 = -1;
                j2 = -1;
            }
            powerUp = "null";   
        } catch (IOException ex) {
            Logger.getLogger(InicioJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_verCarta1MouseClicked

    private void verCarta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verCarta2MouseClicked
        //lo mismo que la funcion anterior
        if(i1 == -1 || j1 == -1){
            errorCarta1.setVisible(true);
            return;
        }
        verCarta2.setEnabled(false);
        powerUp = "verCarta";
        try {
            errorCarta1.setVisible(false);
            Socket socket = new Socket(HOST,PUERTO);

            inResponse = new DataInputStream(socket.getInputStream());
            outRequest = new DataOutputStream(socket.getOutputStream());
            String request = i1 + "," + j1 + "," + i2 + "," + j2 + "," + 2 + "," + powerUp;
            outRequest.writeUTF(request);
            
            String pathScore = inResponse.readUTF();

            ArrayList<String> data = new ArrayList<>(Arrays.asList(pathScore.split(",")));

            String path = data.get(0);
            
            if(!"null".equals(path)){
                ImageIcon imgIcon = new ImageIcon(path);
                Image img = imgIcon.getImage();
                Image resized = img.getScaledInstance(60,60, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(resized);
                tablero[i1][j1].setIcon(icon);
                i1 = -1;
                i2 = -1;
                j1 = -1;
                j2 = -1;
            }else{
                i1 = -1;
                i2 = -1;
                j1 = -1;
                j2 = -1;
            }
            powerUp = "null";
                
        } catch (IOException ex) {
            Logger.getLogger(InicioJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_verCarta2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviarParejaBtn;
    private javax.swing.JLabel errorCarta;
    private javax.swing.JLabel errorCarta1;
    private javax.swing.JLabel errorCarta2;
    private javax.swing.JLabel jugadorGanador;
    private javax.swing.JLabel player1;
    private javax.swing.JLabel player2;
    private javax.swing.JButton puntosDobles1;
    private javax.swing.JButton puntosDobles2;
    private javax.swing.JLabel scoreP1;
    private javax.swing.JLabel scoreP2;
    private javax.swing.JPanel tablePAN;
    private javax.swing.JButton turnoDoble1;
    private javax.swing.JButton turnoDoble2;
    private javax.swing.JLabel turnoJuego;
    private javax.swing.JButton verCarta1;
    private javax.swing.JButton verCarta2;
    // End of variables declaration//GEN-END:variables

}
