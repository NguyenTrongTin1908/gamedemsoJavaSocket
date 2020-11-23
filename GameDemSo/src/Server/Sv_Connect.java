
package Server;

import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Client.GUI;
import Client.LoginJF;

import java.io.*;

public class Sv_Connect {
	
	public static final int NUM_OF_THREAD = 4;
	public final static int SERVER_PORT = 7;
	private Socket socket = null;
	private ServerSocket server = null;
	private Integer[] arr_num = new Integer[99];
	private BufferedWriter out = null;
	private BufferedReader in = null;
	String Login[];
	OutputStream os;

	public Sv_Connect(int port) throws ClassNotFoundException {
		try {


			
			ExecutorService executor = Executors.newFixedThreadPool(NUM_OF_THREAD);
			ServerSocket serverSocket = null; 
			System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("Server started: " + serverSocket);
			System.out.println("Waiting for a client ...");
			while (true) {
				try {
					Socket socket = serverSocket.accept();
					System.out.println("Client accepted: " + socket);

					WorkerThread handler = new WorkerThread(socket);
					executor.execute(handler);
				} catch (IOException e) {
					System.err.println(" Connection Error: " + e);
				}
			

			
       
		} 
		}
		catch (IOException e1) {
			e1.printStackTrace();
		} 
	}

	
		
		
	

	public static void main(String args[]) throws ClassNotFoundException {
		Sv_Connect server = new Sv_Connect(7);
	}
}