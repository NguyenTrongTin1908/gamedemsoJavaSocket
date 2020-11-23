package Client;

import java.net.*;
import java.io.*; 

public class Cl_Connect 
{ 
	static Socket socket = null; 
	BufferedWriter out = null;
	BufferedReader in = null;
	BufferedReader stdIn = null; 
	Integer[] myMessageArray;
	String[] arr_result;
	OutputStream ostream;
	InputStream istream;

	public Cl_Connect() 
	{ 
		
       
		
	}
	
	
	
	public void Create_Socket(String address, int port) throws UnknownHostException, IOException, ClassNotFoundException
	{ 
		socket = new Socket(address, port); 
		System.out.println("Connected"); 
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       
		
	}
	
	public Boolean Login(String user,String pass) throws IOException, ClassNotFoundException
	{
		String line = "";
		String[] login = new String[3];
		login[0]="cl_login";
		login[1]=user;
		login[2]=pass;
	    
			ostream = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(ostream);
			oos.writeObject(login);
			
			
			
			
			
			istream = socket.getInputStream();  
			ObjectInputStream ois = new ObjectInputStream(istream);  
			arr_result = (String[])ois.readObject();
			
			

			
		
            
            if(arr_result[0].equals("success")) {
            	
            	return true;
            	
            }
            
            return false;

			
	
		
	
	}
	
	
	
	
	public Integer[] arraytoGUI() throws IOException, ClassNotFoundException {
		InputStream istream = socket.getInputStream();  
		ObjectInputStream oistream = new ObjectInputStream(istream);  
		myMessageArray = (Integer[])oistream.readObject();
		return myMessageArray;
	}
	
	
	

	public static void main(String args[]) throws UnknownHostException, IOException, ClassNotFoundException 
	{ 
	
	} 
} 
