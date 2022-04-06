package com.mycompany.serverproject;

public class ListaCategorias {
    //lista circular
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
            //la primera es la nueva y la ultima es la nueva por ser circular
            primera = nueva;
            ultima = nueva;
            primera.siguiente = ultima;//la siguiente es la ultima por ser circular
        }else{
            ultima.siguiente = nueva;//la ultima apunta ahora a la nueva
            nueva.siguiente = primera;//la nueva es la ultima entonces la siguiente es la primera
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
        return actual;
    }
}
