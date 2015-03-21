package com.timeron.WalletUploader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.timeron.NexusDatabaseLibrary.Entity.WalletRecord;
import com.timeron.NexusDatabaseLibrary.dao.WalletRecordDAO;

public class WalletUploaderController {

	public void uploadWallet(String url) throws FileNotFoundException, IOException {
		WalletRecordDAO walletRecordDAO = new WalletRecordDAO(WalletRecord.class);
		
		Record walletOperation = new Record();
		Transfer walletTransfer = new Transfer();
		List<WalletRecord> walletRecords = new ArrayList<WalletRecord>();
		
		File file = new File(url);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		String account = br.readLine();
		String[] parts;
		while ((line = br.readLine()) != null) {
			parts = line.split(";");
			if(parts.length == 3){
				walletRecords.add(walletOperation.addOperation(account, parts[0], parts[1], parts[2]));
			}else{
				walletRecords.add(walletTransfer.addTransfer(parts[0], parts[1], parts[2], parts[3], parts[4]));
			}
		}
		br.close();
		for (WalletRecord walletRecord : walletRecords){
			walletRecordDAO.save(walletRecord);
		}
	}

}
