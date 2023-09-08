package com.example.demo.socket.tarea;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.example.demo.socket.archivos.Client;

public class Server {
	private final Integer PORT = 13;
	private final String IP = "localhost";
	
	public Server() {
		try {
			Socket clientSocket = new Socket(IP, PORT);
			System.out.println("------------- 1 Iniciando Comunicación ---------------");
			System.out.println("Inet Address : " + clientSocket.getInetAddress());
			
			File fileOrigen = new File("C:/server/Fabbio.jpg");
			FileInputStream fis = new FileInputStream(fileOrigen);
			DataOutputStream salida = new DataOutputStream(clientSocket.getOutputStream());
			
			int byteLeidos;
			while ( (byteLeidos = fis.read())!= -1) {
				salida.write(byteLeidos);
			}
			fis.close();
			salida.close();
			
			System.out.println("------------- 2 Finalizando Comunicación -------------");
			clientSocket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new Server();
	}
}
