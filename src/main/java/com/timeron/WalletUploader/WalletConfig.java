package com.timeron.WalletUploader;

import com.timeron.NexusDatabaseLibrary.dao.NexusConfigDAO;
import com.timeron.NexusDatabaseLibrary.dao.Enum.Config;

public class WalletConfig {

	NexusConfigDAO nexusConfigDAO = new NexusConfigDAO(NexusConfigDAO.class);
	
	public boolean run(){
    	String runStr = nexusConfigDAO.getParametr(Config.WALLET_UPLOADER_RUN).getValue();
    	Boolean runBool = Boolean.parseBoolean(runStr);
    	if(runBool!=null){
    		return runBool;
    	}
		return false;
	}

	public void setDone() {
		nexusConfigDAO.done();
		
	}
	
}
