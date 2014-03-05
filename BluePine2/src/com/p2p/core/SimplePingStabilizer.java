/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.p2p.core;
import com.p2p.core.interfaces.StabilizerInterface;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author axvelazq
 */
public class SimplePingStabilizer implements StabilizerInterface {
	private PeerNode peer;
	private String msgtype;
	
	public SimplePingStabilizer(PeerNode peer) {
		this(peer, "PING");
	}
	
	public SimplePingStabilizer(PeerNode peer, String msgtype) {
		this.peer = peer;
		this.msgtype = msgtype;
	}
	
	public void stabilize() {
		List<String> todelete = new ArrayList<String>();
		for (String pid : peer.getPeerKeys()) {
			boolean isconn = false;
			PeerConnection peerconn = null;
			try {
				peerconn = new PeerConnection(peer.getPeer(pid));
				peerconn.sendData(new P2PMessage(msgtype, ""));
				isconn = true;
			}
			catch (IOException e) {
				todelete.add(pid);
			}
			if (isconn)
				peerconn.close();
		}
		
		for (String pid : todelete) {
			peer.removePeer(pid);
		}
	}

    
}
