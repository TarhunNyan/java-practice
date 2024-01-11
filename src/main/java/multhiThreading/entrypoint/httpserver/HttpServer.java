package multhiThreading.entrypoint.httpserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HttpServer {
	
	public static void main(String[] args) {
		new Server( ).bootstrap( );
	}
}


class Server {
	
	private AsynchronousServerSocketChannel server;
	
	private       String host        = "127.0.0.1";
	private       int    port        = 80;
	final private int    BUFFER_SIZE = 32;
	
	Server( ) { }
	
	Server(String host, int port) {
		this.port = port;
		this.host = host;
	}
	
	public void bootstrap( ) {
		InetSocketAddress inetSocketAddress = new InetSocketAddress(
				host,
				port
		);
		AsynchronousServerSocketChannel server = null;
		
		try {
			server = AsynchronousServerSocketChannel.open( );
			server.bind(inetSocketAddress);
			
			Future<AsynchronousSocketChannel> future = server.accept( );
			System.out.println("new client thread");
			
			AsynchronousSocketChannel clientChanel = future.get(
					30,
					TimeUnit.SECONDS
			);
			
			while(clientChanel!=null && clientChanel.isOpen( )) {
				ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
				String     msg    = "YES! MEASSAGE!";
				
				//				buffer.put(msg.getBytes(StandardCharsets.UTF_8));
				clientChanel.read(buffer)
				            .get( );
				//				Integer i = clientChanel.read(buffer)
				//				                        .get( );
				//				System.out.println(Character.toChars(i));
				
				buffer.flip( );
				clientChanel.write(buffer);
				clientChanel.close( );
			}
			
		} catch(IOException e) {
			throw new RuntimeException(e);
		} catch(ExecutionException e) {
			throw new RuntimeException(e);
		} catch(InterruptedException e) {
			throw new RuntimeException(e);
		} catch(TimeoutException e) {
			throw new RuntimeException(e);
		}
	}
	
}
