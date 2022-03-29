/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serverproject;

/**
 *
 * @author Dell
 */
public class ListaCategorias {
    CategoriaImagen primera;
    CategoriaImagen ultima;
    
    public ListaCategorias(){
        primera = null;
        ultima = null;
    }
    
    public void ingresarCategoria(String nombre){
        CategoriaImagen nueva = new CategoriaImagen();
        nueva.nombre = nombre;
        
        if(primera == null){
            primera = nueva;
            ultima = nueva;
            primera.siguiente = ultima;
        }else{
            ultima.siguiente = nueva;
            nueva.siguiente = primera;
            ultima = nueva;
        }
    }
    
    public void displayList(){
        CategoriaImagen actual = primera;
        
        do{
            System.out.println(actual.nombre + "\n");
            actual = actual.siguiente;
        }while(actual != primera);
    }
    
    public CategoriaImagen getCat(String nombre){
        CategoriaImagen actual = primera;
        do{
            if(actual.nombre.equals(nombre)){
                return actual;
            }
            actual = actual.siguiente;
        }while(actual != primera);
        return null;
    }
}
