/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.memoryproject;

import static com.mycompany.memoryproject.InicioJuego.i;
import static com.mycompany.memoryproject.InicioJuego.j;
import static com.mycompany.memoryproject.InicioJuego.turno;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;

/**
 *
 * @author Dell
 */
public class MainGame extends javax.swing.JFrame implements ActionListener{
    
    int i1= -1,i2=-1,j1=-1,j2=-1;
    int i = InicioJuego.i;
    int j = InicioJuego.j;
    int turno = InicioJuego.turno;
    JButton[][] tablero = new JButton[i][j]; 
    ImageIcon defimg;
    Icon def;
    final String HOST = "localhost";
    final int PUERTO = 5000;
    DataInputStream inResponse;
    DataOutputStream outRequest;
    public MainGame() throws IOException {
        this.defimg = new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\serverProject\\src\\main\\java\\com\\mycompany\\serverproject\\def.jpg");
        Image img = defimg.getImage();
        Image resized = img.getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH);
        def = new ImageIcon(resized);
        initComponents();
        jugadorGanador.setVisible(false);
        player1.setText(InicioJuego.p1);
        player2.setText(InicioJuego.p2);
        initTable();
    }

    public final void initTable(){
        
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scoreP1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scoreP2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(enviarParejaBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(tablePAN, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jugadorGanador, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1)
                    .addComponent(player2)
                    .addComponent(scoreP2)
                    .addComponent(scoreP1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jugadorGanador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(tablePAN, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(enviarParejaBtn)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarParejaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enviarParejaBtnMouseClicked
        try {
            Socket socket = new Socket(HOST,PUERTO);

            inResponse = new DataInputStream(socket.getInputStream());
            outRequest = new DataOutputStream(socket.getOutputStream());
            String request = i1 + "," + j1 + "," + i2 + "," + j2 + "," + turno;
            outRequest.writeUTF(request);

            String pathScore = inResponse.readUTF();

            ArrayList<String> data = new ArrayList<String>(Arrays.asList(pathScore.split(",")));

            String path = data.get(0);
            String ganador = data.get(2);
            
            if(ganador.equals("player1")){
                jugadorGanador.setText("Gana el jugador: " + InicioJuego.p1);
                jugadorGanador.setVisible(true);
                enviarParejaBtn.setEnabled(false);
                socket.close();
            }else if(ganador.equals("player2")){
                jugadorGanador.setText("Gana el jugador: " + InicioJuego.p1);
                jugadorGanador.setVisible(true);
                enviarParejaBtn.setEnabled(false);
                socket.close();
            }else if(ganador.equals("empate")){
                jugadorGanador.setText("Empates!");
                jugadorGanador.setVisible(true);
                enviarParejaBtn.setEnabled(false);
                socket.close();
            }
            
            int score = Integer.parseInt(data.get(1));
            
            if(!"null".equals(path)){
                BufferedImage imgicon = ImageIO.read(new File(path));
                Icon icon = new ImageIcon(imgicon);
                tablero[i1][j1].setIcon(icon);
                tablero[i2][j2].setIcon(icon);
                tablero[i1][j1].setEnabled(false);
                tablero[i2][j2].setEnabled(false);
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
            
            if(turno == 1){
                turno = 2;
                scoreP1.setText(String.valueOf(score));
            }else{
                turno = 1;
                scoreP2.setText(String.valueOf(score));
            }

        } catch (IOException ex) {
            Logger.getLogger(InicioJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_enviarParejaBtnMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainGame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviarParejaBtn;
    private javax.swing.JLabel jugadorGanador;
    private javax.swing.JLabel player1;
    private javax.swing.JLabel player2;
    private javax.swing.JLabel scoreP1;
    private javax.swing.JLabel scoreP2;
    private javax.swing.JPanel tablePAN;
    // End of variables declaration//GEN-END:variables

}
