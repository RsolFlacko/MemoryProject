/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serverproject;

/**
 *
 * @author Dell
 */
public class ListaImagenes {
    Imagen anterior;
    Imagen siguiente;
    Imagen actual;
    
    public ListaImagenes(){
        actual = null;
    }
    
    public void ingresarImagen(CategoriaImagen cat, String path){
        Imagen nueva = new Imagen();
        nueva.cat = cat;
        nueva.path = path;
        if(actual == null){
            nueva.anterior = null;
            nueva.siguiente = null;
            actual = nueva;
        }else{
            nueva.siguiente = null;
            nueva.anterior = actual;
            actual.siguiente = nueva;
            actual = nueva;
        }
    }
}
