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
public class SearchFileListener extends BluePineListener{

    public SearchFileListener(BlueTorrent bt) {
        super(bt);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String key = this.blueTorrent.getSearchFileText().trim();
			for (String pid : this.blueTorrent.peer.getPeerKeys()) {
				this.blueTorrent.peer.sendToPeer(pid, SharerMessage.QUERY,
						this.blueTorrent.peer.getId() + " " + key + " 4",
						true);
			}

			this.blueTorrent.getSearchTextArea().requestFocusInWindow();
			this.blueTorrent.getSearchTextArea().setText("");
    }
    
}
