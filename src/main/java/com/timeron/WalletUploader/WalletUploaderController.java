package com.timeron.WalletUploader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WalletUploaderController {

	public void uploadWallet(String url) throws FileNotFoundException, IOException {
		
		Record walletOperation = new Record();
		Transfer walletTransfer = new Transfer();
		
		File file = new File(url);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		String account = br.readLine();
		String[] parts;
		while ((line = br.readLine()) != null) {
			parts = line.split(";");
			if(parts.length == 3){
				walletOperation.addOperation(account, parts[0], parts[1], parts[2]);
			}else{
				walletTransfer.addTransfer(parts[0], parts[1], parts[2], parts[3]);
			}
		}
		br.close();
		
	}

}
