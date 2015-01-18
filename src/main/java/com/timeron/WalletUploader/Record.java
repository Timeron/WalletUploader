package com.timeron.WalletUploader;

import java.util.Date;

import org.apache.log4j.Logger;

import com.timeron.NexusDatabaseLibrary.Entity.WalletRecord;

public class Record extends Operation{
	
	static Logger log = Logger.getLogger(Record.class.getName());
	
	public void addOperation(String account, String type, String date, String price) {
		WalletRecord walletRecord = new WalletRecord();
		
		boolean income = false;
		float value = Float.parseFloat(price.replaceAll(",", ""));
		
		if(value > 0){
			income = true;
		}
		
		walletRecord.setDate(addDate(date));
		walletRecord.setUpdated(new Date());
		walletRecord.setTransfer(false);
		walletRecord.setValue(value);
		walletRecord.setWalletType(addWalletType(type));
		walletRecord.setWalletAccount(addWalletAccount(account));
		walletRecord.setIncome(income);
		
		log.info(account+" - "+type+" - "+addDate(date)+" - "+value+" inc "+income);
		walletRecordDAO.save(walletRecord);
	}
	

}
