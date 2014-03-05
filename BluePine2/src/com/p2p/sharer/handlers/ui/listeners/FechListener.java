/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.p2p.sharer.handlers.ui.listeners;

import com.p2p.core.P2PMessage;
import com.p2p.core.PeerInfo;
import com.p2p.core.util.LoggerUtil;
import com.p2p.sharer.SharerMessage;
import com.p2p.sharer.ui.BlueTorrent;
import java.awt.event.ActionEvent;
import java.util.*;
import java.io.*;

/**
 *
 * @author axel
 */
public class FechListener extends BluePineListener {

    public FechListener(BlueTorrent bt) {
        super(bt);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
       if(this.blueTorrent.fileList.getSelectedValue() != null)
			{
				String selected = this.blueTorrent.fileList.getSelectedValue().toString();
				String filename = selected.substring(0, selected.indexOf(':'));
				String pid = this.blueTorrent.peer.getFileOwner(filename);
				String[] ownerData = pid.split(":");
				String host = ownerData[0];
				int port = Integer.parseInt(ownerData[1]);
				LoggerUtil.getLogger().fine("Fetching " + filename + " from " + host + ":" + port);
				PeerInfo pd = new PeerInfo(host, port);
				List<P2PMessage> resplist = this.blueTorrent.peer.connectAndSend(pd, SharerMessage.FILE_GET, filename, true);
				LoggerUtil.getLogger().fine("FETCH RESPONSE TYPE: " + resplist.get(0).getMsgType());
				if (resplist.size() > 0 && resplist.get(0).getMsgType().equals(SharerMessage.REPLY)) {
					try {
						FileOutputStream outfile = new FileOutputStream(filename);
						outfile.write(resplist.get(0).getMsgDataBytes());
						outfile.close();
						this.blueTorrent.peer.addLocalFile(filename);
					} catch (IOException ex) {
						LoggerUtil.getLogger().warning("Fetch error: " + ex);
					}
				}

			}
    }

   
    
}
