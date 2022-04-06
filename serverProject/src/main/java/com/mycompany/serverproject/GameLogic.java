package com.mycompany.serverproject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameLogic extends javax.swing.JFrame{

    static JButton[][] tablero;//el tablero
    ImageIcon def = new ImageIcon("def.jpg");//iconos para la logica
    ImageIcon def2 = new ImageIcon("def2.jpg");
    static ArrayList<Object> imgs = SeleccionImagenes.seleccionadas;
    static int player1score = 0;//los puntajes comienzan en cero
    static int player2score = 0;
    static int r;//rows
    static int c;//columns
    public static int nImagenes;
    
    public GameLogic(int rows , int columns, int nImagenes){
        c = columns;
        r = rows;
        this.nImagenes = nImagenes;
        tablero = new JButton[c][r];
        initComponents();
        tablePAN.setLayout(new java.awt.GridLayout(r, c));
        initTable();//se inicia el tablero
        int colocadas = 0;
        while(colocadas < nImagenes){//mientras que no se hayan colocado todas las cartas
            int i1 = ThreadLocalRandom.current().nextInt(0,c);//se generan coordenadas random
            int j1 = ThreadLocalRandom.current().nextInt(0,r);
            int i2 = ThreadLocalRandom.current().nextInt(0,c);
            int j2 = ThreadLocalRandom.current().nextInt(0,r);
            
            if(tablero[i1][j1].getIcon() != def || tablero[i2][j2].getIcon() != def ||//en caso de que haya una carta 
                    (j1 == j2 && i2 == i1)){                                        //o las coordenadas sean iguales
                continue;
            }
            //se cambian los iconos
            tablero[i1][j1].setIcon((Icon) imgs.get(colocadas));
            tablero[i2][j2].setIcon((Icon) imgs.get(colocadas));
            
            colocadas++;//se incrementan las colocadas
        }
    }
    
    public JButton[][] mixTable(){
        int colocadas = 0;
        for(int i = 0; i < c; i++){
            for(int j = 0; j < r; j++){
                if(tablero[i][j].getIcon() == def){
                    continue;
                }
                tablero[i][j].setIcon(def2);//se cambia el icono de las cartas par identificar cuales cambiar
            }
        }
        while(colocadas < nImagenes){
            int i1 = ThreadLocalRandom.current().nextInt(0,c);
            int j1 = ThreadLocalRandom.current().nextInt(0,r);
            int i2 = ThreadLocalRandom.current().nextInt(0,c);
            int j2 = ThreadLocalRandom.current().nextInt(0,r);
            //se hace lo mismo que cuando se inicia el tablero
            if(tablero[i1][j1].getIcon() != def2 || tablero[i2][j2].getIcon() != def2 || 
                    (j1 == j2 && i2 == i1) ||(tablero[i1][j1].getIcon() == def || tablero[i2][j2].getIcon() == def)){
                continue;
            }
            
            tablero[i1][j1].setIcon((Icon) imgs.get(colocadas));
            tablero[i2][j2].setIcon((Icon) imgs.get(colocadas));
            
            colocadas++;
        }
        return tablero;
    }
    
    public final void initTable(){
        
        for(int i = 0; i < c; i++){
            for(int j = 0; j < r; j++){
                tablero[i][j] = new JButton();
                tablero[i][j].setIcon(def);
                tablero[i][j].setSize(150,150);
                tablePAN.add(tablero[i][j]);
            }
        }
        validate();
    }
    
    void initGame() throws IOException{
        //se pone al servidor a esperar un cliente
        ServerSocket server = null;
        Socket socket = null;
        final int PUERTO = 5555;
        DataInputStream inRequest;
        DataOutputStream outResponse;
        
        server = new ServerSocket(PUERTO);
        
        socket = server.accept();

        inRequest = new DataInputStream(socket.getInputStream());
        outResponse = new DataOutputStream(socket.getOutputStream());

        String playerString = inRequest.readUTF();
        ArrayList<String> players = new ArrayList<String>(Arrays.asList(playerString.split(",")));

        String tamaño = c + "," + r + "," + ThreadLocalRandom.current().nextInt(1,3);//se escribe en el string de 
                                                                                     //respuesta la info necesaria
        outResponse.writeUTF(tamaño);
        
        player1.setText(players.get(0));
        player2.setText(players.get(1));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePAN = new javax.swing.JPanel();
        player1 = new javax.swing.JLabel();
        player2 = new javax.swing.JLabel();
        p1score = new javax.swing.JLabel();
        p2score = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tablePAN.setLayout(new java.awt.GridLayout(4, 3));

        player1.setText("Player 1");

        player2.setText("Player 2");

        p1score.setText("0");

        p2score.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablePAN, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(p1score, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(229, 229, 229)
                        .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p2score, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1)
                    .addComponent(player2)
                    .addComponent(p1score)
                    .addComponent(p2score))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(tablePAN, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel p1score;
    public javax.swing.JLabel p2score;
    private javax.swing.JLabel player1;
    private javax.swing.JLabel player2;
    private javax.swing.JPanel tablePAN;
    // End of variables declaration//GEN-END:variables

}
