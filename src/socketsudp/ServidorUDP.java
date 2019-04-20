package socketsudp;

import java.io.IOException;
import java.io.PrintStream;
import static java.lang.System.out;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nayton Wilkerson
 */
public class ServidorUDP {
   
    
    public ServidorUDP (){
          
    }
   
    public static void main(String[] args) throws SocketException{
   
        
        
        DatagramSocket s = new DatagramSocket(4545);
    
        System.out.println("Servidor esperando conexão.......");
   
        DatagramPacket recebe = new DatagramPacket(new byte[512], 512);
        
        
        while(true){
             try {
                 
                s.receive(recebe);
                
                 System.out.println("Mensagem recebida: ");
                 
                 for(int i = 0; i < recebe.getLength(); i++){
                     System.out.println((char) recebe.getData()[i]);
                 }
                 System.out.println();
   
                 DatagramPacket resp = new DatagramPacket(recebe.getData(), recebe.getLength(), recebe.getAddress(), recebe.getPort());
                 s.send(resp);
                     
                 
            } catch (IOException ex) {
                Logger.getLogger(ServidorUDP.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
}    
    
}      
