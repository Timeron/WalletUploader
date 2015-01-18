package com.timeron.WalletUploader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.timeron.NexusDatabaseLibrary.Entity.WalletAccount;
import com.timeron.NexusDatabaseLibrary.Entity.WalletRecord;
import com.timeron.NexusDatabaseLibrary.Entity.WalletType;
import com.timeron.NexusDatabaseLibrary.dao.WalletAccountDAO;
import com.timeron.NexusDatabaseLibrary.dao.WalletRecordDAO;
import com.timeron.NexusDatabaseLibrary.dao.WalletTypeDAO;

public class Operation {
	
	protected WalletTypeDAO walletTypeDAO = new WalletTypeDAO(WalletType.class);
	protected WalletAccountDAO walletAccountDAO = new WalletAccountDAO(WalletAccount.class);
	protected WalletRecordDAO walletRecordDAO = new WalletRecordDAO(WalletRecord.class);
	
	protected WalletType addWalletType(String type){
		if(walletTypeDAO.checkIfAvailableByName(type)){
			return walletTypeDAO.getByName(type);
		}else{
			WalletType walletType = new WalletType();
			walletType.setName(type);
			walletType.setTimestamp(new Date());
			walletTypeDAO.save(walletType);
			return walletTypeDAO.getByName(type);
		}
		
	}
	
	protected Date addDate(String dateStr){
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	protected WalletAccount addWalletAccount(String account){
		if(walletAccountDAO.checkIfAvailableByName(account)){
			return walletAccountDAO.getByName(account);
		}else{
			WalletAccount walletAccount = new WalletAccount();
			walletAccount.setName(account);
			walletAccount.setTimestamp(new Date());
			walletAccount.setCurrency("PLN");	
			walletAccountDAO.save(walletAccount);
			return walletAccountDAO.getByName(account);
		}
	}
	
}
