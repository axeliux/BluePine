/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.p2p.sharer.handlers.ui.listeners;

import com.p2p.sharer.ui.BlueTorrent;
import java.awt.event.ActionEvent;

/**
 *
 * @author axel
 */
public class AddFileListener extends BluePineListener {

    public AddFileListener(BlueTorrent bt) {
        super(bt);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String filename = this.blueTorrent.getAddFile().trim();
			if (!filename.equals("")) {
				blueTorrent.peer.addLocalFile(filename);
			}
			blueTorrent.getFileTextArea().requestFocusInWindow();
			blueTorrent.getFileTextArea().setText("");
			blueTorrent.updateFileList();
    }
    
}
