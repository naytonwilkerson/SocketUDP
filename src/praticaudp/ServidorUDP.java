/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticaudp;

import java.util.List;
import java.io.*;
import java.net.*;
import static java.sql.DriverManager.println;
import java.util.ArrayList;

/**
 *
 * @author Nayton Wilkerson
 */
public class ServidorUDP extends Thread{
    
    
    
    private DatagramSocket conexao;
    private  static DatagramPacket recebe;
    private static List clientes;
    private String Nome;
  
    
    public ServidorUDP ( DatagramSocket s){
        conexao = s;  
    }
    
    public static void main(String[] args) throws SocketException{
        
        clientes = new ArrayList();
       DatagramSocket s = new DatagramSocket(4545);
    
        System.out.println("Servidor esperando conexão.......");
        
        String envio;
        
                       
            while(true){
               
                Thread t = new ServidorUDP(s);
                t.start();
                       
            }
   
    }
    
    public void run(){
    
        recebe = new DatagramPacket(new byte[512], 512);
        String linha = "";
        for(int i = 0; i < recebe.getLength(); i++){
            linha+=((char) recebe.getData()[i]);
        }
        clientes.add(linha);
        while((linha != null)&&!(linha.trim().equals("")))
        {
            linha = "";
            for(int i = 0; i < recebe.getLength(); i++){
                linha+=((char) recebe.getData()[i]);
            }
            sendToAll(recebe," disse: ", linha);
            
        }
        sendToAll(recebe," saiu "," do chat ");
        clientes.remove(Nome);
        conexao.close();
}

    
     private void sendToAll( DatagramPacket recebe, String acao, String linha) {

        
     }   
}