/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.p2p.sharer.handlers.ui.listeners;

import com.p2p.core.P2PMessage;
import com.p2p.sharer.SharerMessage;
import com.p2p.sharer.ui.BlueTorrent;
import java.awt.event.ActionEvent;

/**
 *
 * @author axel
 */
public class RemovePeerListener extends BluePineListener{

    public RemovePeerListener(BlueTorrent bt) {
        super(bt);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
       if (this.blueTorrent.peerList != null) {
				String pid = this.blueTorrent.peerList.getSelectedValue().toString();
				this.blueTorrent.peer.sendToPeer(pid,SharerMessage.PEER_QUIT, this.blueTorrent.peer.getId(), true);
				this.blueTorrent.peer.removePeer(pid);
			}
    }
    
}
