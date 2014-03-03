/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.p2p.sharer.handlers.ui.listeners;

import com.p2p.sharer.ui.BlueTorrent;
import java.awt.event.ActionListener;

/**
 *
 * @author axel
 */
public abstract class BluePineListener implements ActionListener {
    protected BlueTorrent blueTorrent;
    public BluePineListener(BlueTorrent bt){
        this.blueTorrent = bt;
    }
          
}
