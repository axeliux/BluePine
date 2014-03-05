/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.p2p.core;

import com.p2p.core.interfaces.RouterInterface;

/**
 *
 * @author axvelazq
 */
public class SimpleRouter implements RouterInterface {
    private PeerNode peer;
	
	public SimpleRouter(PeerNode peer) {
		this.peer = peer;
	}
	
	public PeerInfo route(String peerid) {
		for (String key : peer.getPeerKeys())
			if (peer.getPeer(key).getId().equals(peerid))
				return peer.getPeer(peerid);
		return null;
	}
}
