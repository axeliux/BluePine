package com.p2p.core.socket;
// MUST check if  SocketFactory at javax.net will work better for SocketFactory 
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

import com.p2p.core.interfaces.SocketInterface;
/**
 * @author axvelazq
 */
public class PeerSocketFactory extends SocketFactory {

	
	@Override
	public SocketInterface makeSocket(Socket socket)throws IOException {
		return new PeerSocket(socket);
	}

	@Override
	public SocketInterface makeSocket(String host, int port)throws IOException, UnknownHostException {
		return new PeerSocket(host, port);
	}

}
