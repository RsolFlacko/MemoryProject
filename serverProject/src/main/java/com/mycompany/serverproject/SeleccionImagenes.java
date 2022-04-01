/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.serverproject;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

/**
 *
 * @author Dell
 */
public class SeleccionImagenes extends javax.swing.JFrame {

    static ArrayList<Object> seleccionadas;
    
    private int nSeleccionadas = 0;
    public static int nImagenes = 6;
    
    @SuppressWarnings("unchecked")
    public SeleccionImagenes() {
        seleccionadas = new ArrayList();
        initComponents();
        error.setVisible(false);
        error2.setVisible(false);
        cats.setPreferredSize(new Dimension(150,100));
        DefaultComboBoxModel<Icon> dm = new DefaultComboBoxModel<>();
        Imagen iterador = ServerProject.listaImagenes.primera;
        for(int i = 0; i < 24; i++){
            if(iterador.cat.nombre.equals("Carros")){
                dm.addElement(iterador.img);
            }
            iterador = iterador.siguiente;
        }
        cars.setModel(dm);
        
        stars.setPreferredSize(new Dimension(130,100));
        dm = new DefaultComboBoxModel<>();
        iterador = ServerProject.listaImagenes.primera;
        for(int i = 0; i < 24; i++){
            if(iterador.cat.nombre.equals("Estrellas")){
                dm.addElement(iterador.img);
            }
            iterador = iterador.siguiente;
        }
        stars.setModel(dm);
        
        heroes.setPreferredSize(new Dimension(130,100));
        dm = new DefaultComboBoxModel<>();
        iterador = ServerProject.listaImagenes.primera;
        for(int i = 0; i < 24; i++){
            if(iterador.cat.nombre.equals("Heroes")){
                dm.addElement(iterador.img);
            }
            iterador = iterador.siguiente;
        }
        heroes.setModel(dm);
        
        stars.setVisible(false);
        cars.setVisible(false);
        heroes.setVisible(false);
        cats.setPreferredSize(new Dimension(100,20));
        DefaultComboBoxModel<String> dmC = new DefaultComboBoxModel<>();
        CategoriaImagen iteradorCats = ServerProject.cats.primera;
        do{
            dmC.addElement(iteradorCats.nombre);
            iteradorCats = iteradorCats.siguiente;
        }while(iteradorCats != ServerProject.cats.primera);
        cats.setModel(dmC);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        heroes = new javax.swing.JComboBox<>();
        agregarImagen = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        continuar = new javax.swing.JButton();
        error2 = new javax.swing.JLabel();
        cats = new javax.swing.JComboBox<>();
        cars = new javax.swing.JComboBox<>();
        stars = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        nCartasList = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        agregarImagen.setText("Agregar");
        agregarImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarImagenMouseClicked(evt);
            }
        });

        error.setText("No puede seleccionar más imágenes!");

        continuar.setText("Continuar");
        continuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                continuarMouseClicked(evt);
            }
        });

        error2.setText("Seleccione las imágenes necesarias!");

        cats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catsActionPerformed(evt);
            }
        });

        jLabel1.setText("Número de cartas:");

        nCartasList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "16", "20" }));
        nCartasList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nCartasListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(error2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(heroes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(78, 78, 78)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(continuar)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(agregarImagen)
                                .addGap(71, 71, 71))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nCartasList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarImagen)
                    .addComponent(cats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heroes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nCartasList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(error2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(error, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(continuar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void agregarImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarImagenMouseClicked
        if(nSeleccionadas >= nImagenes){
            error.setVisible(true);
        }else{
            if(heroes.isVisible()){
                seleccionadas.add(heroes.getSelectedItem());
                heroes.removeItem(heroes.getSelectedItem());
            }
            else if(cars.isVisible()){
                seleccionadas.add(cars.getSelectedItem());
                cars.removeItem(cars.getSelectedItem());
            }
            else{
                seleccionadas.add(stars.getSelectedItem());
                stars.removeItem(stars.getSelectedItem());
            }
            
            nSeleccionadas++;
        }
    }//GEN-LAST:event_agregarImagenMouseClicked

    private void continuarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continuarMouseClicked
        if(nSeleccionadas < nImagenes){
            error2.setVisible(true);
        }else{
            this.setVisible(false);
            int rows;
            int columns;
            if(nCartasList.getSelectedItem().equals("12")){
                rows = 4;
                columns = 3;
            }else if(nCartasList.getSelectedItem().equals("16")){
                rows = 4;
                columns = 4;
            }else{
                rows = 4;
                columns = 5;
            }
            ServerProject.gl = new GameLogic(rows, columns, nImagenes);
            ServerProject.gl.setVisible(true);
            try {
                ServerProject.gl.initGame();
            } catch (IOException ex) {
                Logger.getLogger(SeleccionImagenes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_continuarMouseClicked

    private void catsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catsActionPerformed
        if(cats.getSelectedItem().equals("Carros")){
            cars.setVisible(true);
            stars.setVisible(false);
            heroes.setVisible(false);
        }
        else if(cats.getSelectedItem().equals("Heroes")){
            cars.setVisible(false);
            stars.setVisible(false);
            heroes.setVisible(true);
        }
        else{
            cars.setVisible(false);
            stars.setVisible(true);
            heroes.setVisible(false);
        }
    }//GEN-LAST:event_catsActionPerformed

    private void nCartasListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nCartasListActionPerformed
        if(nCartasList.getSelectedItem().equals("12")){
                nImagenes = 12/2;
            }else if(nCartasList.getSelectedItem().equals("16")){
                nImagenes = 16/2;
            }else{
                nImagenes = 20/2;
            }
    }//GEN-LAST:event_nCartasListActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarImagen;
    private javax.swing.JComboBox<Icon> cars;
    private javax.swing.JComboBox<String> cats;
    private javax.swing.JButton continuar;
    private javax.swing.JLabel error;
    private javax.swing.JLabel error2;
    private javax.swing.JComboBox<Icon> heroes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> nCartasList;
    private javax.swing.JComboBox<Icon> stars;
    // End of variables declaration//GEN-END:variables
}
