/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.p2p.sharer.handlers.ui.listeners;

import com.p2p.core.util.LoggerUtil;
import com.p2p.sharer.ui.BlueTorrent;
import java.awt.event.ActionEvent;
import java.util.logging.Level;


/**
 *
 * @author axel
 */
public class RebuildPeerListener extends BluePineListener {

    public RebuildPeerListener(BlueTorrent bt) {
        super(bt);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            String buildPeer = this.blueTorrent.getBuildPeer();
            if(buildPeer != null && !buildPeer.equals("") && !this.blueTorrent.peer.maxPeerReached()){
                String build [] = buildPeer.split(":");
                String host_name = build[0];
                int port = Integer.valueOf(build[1]);
                this.blueTorrent.peer.buildPeers(host_name, port, 3);
            }
        }catch(Exception ex){
            LoggerUtil.getLogger().log(Level.SEVERE, "->" + ex.getMessage());
        }
    }
    
}
