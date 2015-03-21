package com.timeron.WalletUploader;

import java.util.Date;

import org.apache.log4j.Logger;

import com.timeron.NexusDatabaseLibrary.Entity.WalletAccount;
import com.timeron.NexusDatabaseLibrary.Entity.WalletRecord;

public class Transfer extends Operation{

	static Logger log = Logger.getLogger(Transfer.class.getName());
	
	public WalletRecord addTransfer(String type, String source, String destynation, String date, String price) {
		
		WalletRecord walletRecord = new WalletRecord();
		
		float value = Float.parseFloat(price.replaceAll(",", ""));
		
		WalletAccount walletAccountSource = addWalletAccount(source);
		WalletAccount walletAccountDestination = addWalletAccount(destynation);
		
		walletRecord.setDate(addDate(date));
		walletRecord.setWalletAccount(walletAccountSource);
		walletRecord.setSourceWalletAccount(walletAccountSource);
		walletRecord.setDestinationWalletAccount(walletAccountDestination);
		walletRecord.setTransfer(true);
		walletRecord.setUpdated(new Date());
		if(value < 0){value *= -1;}
		walletRecord.setValue(value);
		
		log.info("Transfer: "+walletAccountSource.getName()+ " -> " +walletAccountDestination.getName());
		return walletRecord;
	}

}
