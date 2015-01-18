package com.timeron.WalletUploader;

import java.io.IOException;

import org.apache.log4j.Logger;

public class WalletUploader {
	
	static Logger log = Logger.getLogger(WalletUploader.class.getName());
	
	public static void main(String[] args) {
		WalletConfig config = new WalletConfig();

		if (config.run()) {
			WalletUploaderController controller = new WalletUploaderController();

			try {
				controller
						.uploadWallet("C:\\Users\\Timeron\\Desktop\\wallet.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			log.info("Config set to: false");
		}
		
		config.setDone();
	}
}
