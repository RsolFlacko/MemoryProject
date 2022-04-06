package com.mycompany.serverproject;

 /**
 * Se importan las bibliotecas
 */
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Servidor representa al servidor del socket 
 * @author Roger Solano
 */
public class ServerProject {
    
    //clase que corre todo el juego
    public static ListaCategorias cats = new ListaCategorias();
    public static ListaImagenes listaImagenes = new ListaImagenes();
    public static GameLogic gl = null;
    private static SeleccionImagenes si = null;
    private static ImageIcon defimg;
    private static Icon def;
    public static void main(String[] args) throws IOException {
        defimg = new ImageIcon("C:\\Users\\pc\\OneDrive\\Documentos\\Ingenieria en computadores TEC\\I semestre 2022\\Estructuras y algoritmos de datos 1\\serverProject\\src\\main\\java\\com\\mycompany\\serverproject\\def.jpg");
        Image img = defimg.getImage();
        Image resized = img.getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH);
        def = new ImageIcon(resized);
        //se ingresan las categorias
        cats.ingresarCategoria("Carros");
        cats.ingresarCategoria("Estrellas");
        cats.ingresarCategoria("Heroes");
        //se ingresan todas las imagenes
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
        
        //se pasa a seleccionar las imagenes
        si = new SeleccionImagenes();
        si.setVisible(true);
        selectCards();//luego se empieza el juego en si
    }
    
    public static void selectCards() throws IOException{
        int cartasRestantes = 100;
        ServerSocket server = null;
        Socket socket = null;
        final int PUERTO = 5000;
        DataInputStream inRequest;
        DataOutputStream outResponse;
        server = new ServerSocket(PUERTO);
        String pathScore;
        while(cartasRestantes > 0){//mientras que hayan cartas por encontrar se reciben respuestas
            socket = server.accept();
            if(cartasRestantes == 100){
                cartasRestantes = SeleccionImagenes.nImagenes;//se obtiene el numero de cartas restantes real
            }
            inRequest = new DataInputStream(socket.getInputStream());
            outResponse = new DataOutputStream(socket.getOutputStream());

            String coordsString = inRequest.readUTF();//se recibe la peticion por parte del cliente
            //se separa en diferentes strings separandolos por ,
            ArrayList<String> coords = new ArrayList<String>(Arrays.asList(coordsString.split(",")));
            //cordenadas de la carta clickeada
            int i1 = Integer.parseInt(coords.get(0));
            int j1 = Integer.parseInt(coords.get(1));
            int i2 = Integer.parseInt(coords.get(2));
            int j2 = Integer.parseInt(coords.get(3));
            //turno del jugador
            int turn = Integer.parseInt(coords.get(4));
            //powerup seleccionado
            String powerUp = coords.get(5);
            //para guardar el nombre del jpg del icono de la carta de un tablero
            String fileName;
            
            if(powerUp.equals("verCarta")){//en caso de que quiera ver una carta
                //se le envia el path de la carta y no cambia nada mas
                Icon desc = GameLogic.tablero[i1][j1].getIcon();
                fileName = listaImagenes.getPathByImage(desc);
                if(turn == 1){
                    pathScore = fileName + "," + gl.player1score + "," + "null" + "," + "1";
                }else{
                    pathScore = fileName + "," + gl.player1score + "," + "null" + "," + "2";
                }
                outResponse.writeUTF(pathScore);
                continue;
            }
            //si encuentra una carta
            if(GameLogic.tablero[i1][j1].getIcon().toString().equals(GameLogic.tablero[i2][j2].getIcon().toString())){
                //se le envia el path
                Icon desc = GameLogic.tablero[i1][j1].getIcon();
                fileName = listaImagenes.getPathByImage(desc);
                cartasRestantes -=1;
                gl.imgs.remove(gl.tablero[i1][j1].getIcon());
                GameLogic.tablero[i1][j1].setIcon(gl.def);
                GameLogic.tablero[i2][j2].setIcon(gl.def);
                //se indica en el servidor que ya se encontro la carta
                GameLogic.tablero[i1][j1].setText("Encontrada");
                GameLogic.tablero[i2][j2].setText("Encontrada");
                gl.nImagenes -= 1;//se saca la carta de la lista de imagenes
                gl.mixTable();//se hace un mix de las cartas
                if(turn == 1){
                    //si se eligio el power up de puntos dobles. se les da
                    if("puntosDobles".equals(powerUp)){
                        gl.player1score += 20;
                    }
                    else{
                        gl.player1score += 10;
                    }
                 
                }else{
                    if("puntosDobles".equals(powerUp)){
                        gl.player2score += 20;
                    }else{
                        gl.player2score += 10;
                    }
                }
            }else{
                fileName = "null";// si no se encuetra una pareja el filename es nulo
            }
                      
            gl.p1score.setText(String.valueOf(gl.player1score));
            gl.p2score.setText(String.valueOf(gl.player2score));
            if(cartasRestantes<=0){//en caso de ya no hayan cartas se saca el ganador
                if(turn == 1 && gl.player1score > gl.player2score){
                    pathScore = fileName + "," + gl.player1score + "," + "player1" + "," + "1";
                }else if(turn == 1 && gl.player1score < gl.player2score){
                    pathScore = fileName + "," + gl.player1score + "," + "player2" + "," + "1";
                }else if(turn == 1){
                    pathScore = fileName + "," + gl.player1score + "," + "empate" + "," + "1";
                }else if(turn == 2 && gl.player1score > gl.player2score){
                    pathScore = fileName + "," + gl.player1score + "," + "player1" + "," + "1";
                }else if(turn == 2 && gl.player1score < gl.player2score){
                    pathScore = fileName + "," + gl.player2score + "," + "player2" + "," + "1";
                }else{
                    pathScore = fileName + "," + gl.player2score + "," + "empate" + "," + "1";
                }
            }else{
                
                if(turn == 1){
                    //si hay turno doble el turno no cambia, se le envia al cliente el path, la puntuacion, el ganador y el turno
                    if("turnoDoble".equals(powerUp)){
                        pathScore = fileName + "," + gl.player1score + "," + "null" + "," + "1";
                    }else{
                        pathScore = fileName + "," + gl.player1score + "," + "null" + "," + "2";
                    }
                }else{
                    if("turnoDoble".equals(powerUp)){
                        pathScore = fileName + "," + gl.player2score + "," + "null" + "," + "2";
                    }else{
                        pathScore = fileName + "," + gl.player2score + "," + "null" + "," + "1";
                    }
                }
            }
            outResponse.writeUTF(pathScore);//se escribe la respuesta
            socket.close();// cierro el socket
        }
        server.close();
        
    }
    
    
}
