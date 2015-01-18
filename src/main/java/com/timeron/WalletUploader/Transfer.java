package com.timeron.WalletUploader;

import java.util.Date;

import org.apache.log4j.Logger;

import com.timeron.NexusDatabaseLibrary.Entity.WalletAccount;
import com.timeron.NexusDatabaseLibrary.Entity.WalletRecord;

public class Transfer extends Operation{

	static Logger log = Logger.getLogger(Transfer.class.getName());
	
	public void addTransfer(String type, String destynation, String date, String price) {
		
		WalletRecord walletRecord = new WalletRecord();
		String[] accounts;
		String separator = " → ";
		
		float value = Float.parseFloat(price.replaceAll(",", ""));
		
		accounts = destynation.split(separator);
		WalletAccount walletAccountSource = addWalletAccount(accounts[0]);
		WalletAccount walletAccountDestination = addWalletAccount(accounts[1]);
		
		walletRecord.setDate(new Date());
		walletRecord.setWalletAccount(walletAccountSource);
		walletRecord.setDestinationWalletAccount(walletAccountDestination);
		walletRecord.setTransfer(true);
		walletRecord.setUpdated(new Date());
		walletRecord.setValue(value);
		
		walletRecordDAO.save(walletRecord);
		
		log.info("Transfer: "+walletAccountSource.getName()+separator+walletAccountDestination.getName());
	}

}
