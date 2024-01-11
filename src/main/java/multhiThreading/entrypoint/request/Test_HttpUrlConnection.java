package multhiThreading.entrypoint.request;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test_HttpUrlConnection {
	
	public static void main(String[] args) {
		String urlAdress = "http" + "://google.com";
		String params    = "paramfirst=value&paramsecond=value2";
		
		URL               url        = null;
		URLConnection     connection = null;
		InputStreamReader stream     = null;
		BufferedReader    buffer     = null;
		
		try {
			url = new URL(urlAdress);
			connection = url.openConnection( );
			stream = new InputStreamReader(connection.getInputStream( ));
			buffer = new BufferedReader(stream);
			
			System.out.println(buffer.readLine( ));
		} catch(MalformedURLException e) {
			throw new RuntimeException(e);
		} catch(IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				stream.close();
				buffer.close();
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
