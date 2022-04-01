/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serverproject;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Dell
 */
public class ListaImagenes {
    Imagen anterior;
    Imagen siguiente;
    Imagen actual;
    Imagen primera;
    
    public ListaImagenes(){
        actual = null;
    }
    
    public void ingresarImagen(CategoriaImagen cat, String path) throws IOException{
        Imagen nueva = new Imagen();
        nueva.cat = cat;
        nueva.path = path;
        ImageIcon imgIcon = new ImageIcon(path);
        Image img = imgIcon.getImage();
        Image resized = img.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
        nueva.img = new ImageIcon(resized);
        if(actual == null){
            nueva.anterior = null;
            nueva.siguiente = null;
            actual = nueva;
            primera = nueva;
        }else{
            nueva.siguiente = null;
            nueva.anterior = actual;
            actual.siguiente = nueva;
            actual = nueva;
        }
    }
    
    public String getPathByImage(Icon desc){
        Imagen iterador = this.primera;
        String path = "null";
        while(iterador!=null){
            if((Icon)iterador.img == desc){
                path = iterador.path;
                return path;
            }
            iterador = iterador.siguiente;
        }
        return path;
    }
}
