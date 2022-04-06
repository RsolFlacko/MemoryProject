package com.mycompany.serverproject;

import java.awt.Image;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ListaImagenes {
    //lista enlazada doble
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
        //se le da la imagen
        ImageIcon imgIcon = new ImageIcon(path);
        Image img = imgIcon.getImage();
        Image resized = img.getScaledInstance(100,100, java.awt.Image.SCALE_SMOOTH);
        nueva.img = new ImageIcon(resized);
        if(actual == null){
            //los punteros anterior y siguiente son nulos ya que no hay mas items en la lista
            nueva.anterior = null;
            nueva.siguiente = null;
            actual = nueva;
            primera = nueva;
        }else{
            nueva.siguiente = null;//al ingresar otro item, este no tiene nadie mas adelante
            nueva.anterior = actual;//la anterior es la ultima ingresada
            actual.siguiente = nueva;//la siguiente de la ultima ingresada es la nueva
            actual = nueva;//la actual pasa a ser la nueva
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
