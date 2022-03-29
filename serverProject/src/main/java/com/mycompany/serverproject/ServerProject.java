/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.serverproject;

/**
 *
 * @author Dell
 */
public class ServerProject {
    
    static ListaCategorias cats = new ListaCategorias();
    static ListaImagenes listaImagenes = new ListaImagenes();
    
    public static void main(String[] args) {
        cats.ingresarCategoria("Animales");
        cats.ingresarCategoria("Estrellas");
        cats.ingresarCategoria("Vehiculos");
        
        //listaImagenes.ingresarImagen(cats.getCat("Animales"),);
    }
}
