/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticaudp;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nayton Wilkerson
 */
public class ClienteUDP extends Thread {

    private static boolean done = false;
    private DatagramSocket conexao;
    private String Nome ="";
    
    public ClienteUDP (DatagramSocket s){
        conexao = s;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        
            // TODO code application logic here
            DatagramSocket s;
            s = new DatagramSocket();
            InetAddress dest = InetAddress.getByName("localhost");
            
            Thread t = new ClienteUDP(s);
            t.start();
            
                    // entrada do teclado
            BufferedReader teclado = new BufferedReader( new InputStreamReader(System.in)); 
           
            String envio = teclado.readLine();
            
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
                  
                    s.close();
                
                
            }   
    }

  
    


