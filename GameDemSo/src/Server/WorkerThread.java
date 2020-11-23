package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.midi.ShortMessage;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;




public class WorkerThread extends Thread {
	private Socket socket;
	private Integer[] arr_num = new Integer[99];
	private BufferedWriter out = null;
	private BufferedReader in = null;
	String msg[];
	String arr_result[];
	OutputStream os;
	InputStream is;
	ObjectInputStream iis;
	ObjectOutputStream ois;
	public WorkerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		System.out.println("Processing: " + socket);
		
		
		
			try {
				is = socket.getInputStream();
				iis = new ObjectInputStream(is);
				msg = (String[])iis.readObject();
				if(msg[0].equals("cl_login"))
				{
					Login();
					

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
				
		
		
		
		

		
			
		
		
	}
	
	
	
	
	public void Random_So() throws IOException {
	       
		Random_So rd = new Random_So();
		arr_num = rd.so();
		OutputStream os =socket.getOutputStream();
		

		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(arr_num);
		oos.flush();

		
				
	
		}

	
	public void Login() throws IOException, ClassNotFoundException {
		
		
		
		
		System.out.println(msg[1]);
		System.out.println(msg[2]);
		PreparedStatement pst= null;
		Connection conn = null;
		try {
			conn =ConnectDB.getConnection();
			String sql="SELECT *FROM user WHERE username=? and password=?";
			pst=(PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, msg[1]);
			pst.setString(2, msg[2]);
			ResultSet resultSet=pst.executeQuery();
			if(resultSet.next()) {
				
				
				String[] result = new String[2];
				result[0]="success";
			
			    
				
					
				
				os = socket.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(result);
				oos.flush();
				Random_So();
				
				
			
				
//				
			}
			else {
				System.out.println("Login fail");
			}
		}
		
		catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                   
                }
            }
        }
            
}
}