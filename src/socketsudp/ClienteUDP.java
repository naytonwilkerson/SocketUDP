/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsudp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.internal.util.xml.impl.Input;

/**
 *
 * @author Nayton Wilkerson
 */
public class ClienteUDP{


   
    
    public ClienteUDP() {
       
    }
 
    
    public static void main(String[] args) throws SocketException, IOException {
        
        
           DatagramSocket s;
       
       
            s = new DatagramSocket();
        
           InetAddress dest = InetAddress.getByName("localhost");
       
           String envio;
           BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
           System.out.print("> ");
           envio = teclado.readLine(); 
           
           
           while(!envio.equalsIgnoreCase("")){
                
               byte[] buffer = envio.getBytes(); 
                DatagramPacket msg = new DatagramPacket(buffer,buffer.length, dest, 4545);
                s.send(msg);
                
                DatagramPacket resposta = new DatagramPacket(new byte[512], 512);
                s.receive(resposta);
                for(int i = 0; i < resposta.getLength(); i++){
                    System.out.print((char) resposta.getData()[i]);
                }
                    System.out.println();
                    
                    System.out.print("> ");
                    envio = teclado.readLine();

           }                 
           s.close();
        }
           
           
    }
  
        
        
        
    
    
    

