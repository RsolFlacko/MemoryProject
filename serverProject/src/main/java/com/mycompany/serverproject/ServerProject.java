package com.mycompany.serverproject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Icon;

public class ServerProject {
    
    
    public static ListaCategorias cats = new ListaCategorias();
    public static ListaImagenes listaImagenes = new ListaImagenes();
    public static GameLogic gl = null;
    private static SeleccionImagenes si = null;
    public static void main(String[] args) throws IOException {
        
        cats.ingresarCategoria("Carros");
        cats.ingresarCategoria("Estrellas");
        cats.ingresarCategoria("Heroes");
        listaImagenes.ingresarImagen(
        cats.getCat("Carros"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Carros\\GTR.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Carros"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Carros\\Mustang.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Carros"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Carros\\mazda_rx7.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Carros"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Carros\\mitsubishi_evo.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Carros"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Carros\\supra.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Carros"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Carros\\370z.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Carros"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Carros\\Corvette.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Carros"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Carros\\Ford-GT.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Estrellas"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Estrellas\\blue_giant.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Estrellas"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Estrellas\\brown_dwarf.jpg"
        );
           
        listaImagenes.ingresarImagen(
        cats.getCat("Estrellas"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Estrellas\\neutron_star.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Estrellas"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Estrellas\\red-giant-star.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Estrellas"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Estrellas\\white_dwarf.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Estrellas"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Estrellas\\Vega.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Estrellas"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Estrellas\\Spica.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Estrellas"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Estrellas\\supernova.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Heroes"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Heroes\\Spiderman.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Heroes"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Heroes\\batman.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Heroes"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Heroes\\iron man.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Heroes"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Heroes\\superman.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Heroes"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Heroes\\wolverine.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Heroes"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Heroes\\Aquaman.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Heroes"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Heroes\\Captain America.jpg"
        );
        
        listaImagenes.ingresarImagen(
        cats.getCat("Heroes"), "C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\Imagenes\\Heroes\\Hawkeye.jpg"
        );
        
        si = new SeleccionImagenes();
        si.setVisible(true);
        
        selectCards();
    }
    
    public static void selectCards() throws IOException{
        int cartasRestantes = si.nImagenes;
        ServerSocket server = null;
        Socket socket = null;
        final int PUERTO = 5000;
        DataInputStream inRequest;
        DataOutputStream outResponse;
        server = new ServerSocket(PUERTO);
        while(cartasRestantes > 0){
            socket = server.accept();

            inRequest = new DataInputStream(socket.getInputStream());
            outResponse = new DataOutputStream(socket.getOutputStream());

            String coordsString = inRequest.readUTF();
            ArrayList<String> coords = new ArrayList<String>(Arrays.asList(coordsString.split(",")));

            int i1 = Integer.parseInt(coords.get(0));
            int j1 = Integer.parseInt(coords.get(1));
            int i2 = Integer.parseInt(coords.get(2));
            int j2 = Integer.parseInt(coords.get(3));
            int turn = Integer.parseInt(coords.get(4));
            String fileName;
            if(GameLogic.tablero[i1][j1].getIcon().toString().equals(GameLogic.tablero[i2][j2].getIcon().toString())){
                Icon desc = GameLogic.tablero[i1][j1].getIcon();
                fileName = listaImagenes.getPathByImage(desc);
                cartasRestantes -=1;
                if(turn == 1){
                    gl.player1score += 10;
                }else{
                    gl.player2score +=10;
                }
            }else{
                fileName = "null";
            }
            String pathScore;
                       
            gl.p1score.setText(String.valueOf(gl.player1score));
            gl.p2score.setText(String.valueOf(gl.player2score));
            if(cartasRestantes<=0){
                if(turn == 1 && gl.player1score > gl.player2score){
                    pathScore = fileName + "," + gl.player1score + "," + "player1";
                }else if(turn == 1 && gl.player1score < gl.player2score){
                    pathScore = fileName + "," + gl.player1score + "," + "player2";
                }else if(turn == 1){
                    pathScore = fileName + "," + gl.player1score + "," + "empate";
                }else if(turn == 2 && gl.player1score > gl.player2score){
                    pathScore = fileName + "," + gl.player1score + "," + "player1";
                }else if(turn == 2 && gl.player1score < gl.player2score){
                    pathScore = fileName + "," + gl.player2score + "," + "player2";
                }else{
                    pathScore = fileName + "," + gl.player2score + "," + "empate";
                }
            }else{
                if(turn == 1){
                    pathScore = fileName + "," + gl.player1score + "," + "null";
                }else{
                    pathScore = fileName + "," + gl.player2score + "," + "null";
                }
            }
            outResponse.writeUTF(pathScore);
            socket.close();
        }
        server.close();
        
    }
    
    
}
