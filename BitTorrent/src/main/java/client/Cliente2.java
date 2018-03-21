package client;

import java.io.File;
import java.net.InetAddress;

import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.client.SharedTorrent;

public class Cliente {
	
	public static void main(String []args) throws Exception{
		InetAddress address = InetAddress.getLocalHost();
		SharedTorrent torrent = SharedTorrent.fromFile(new File("./files/in/sintel.torrent"), new File("./files/in"));
		Client client = new Client(address, torrent);
		
		client.setMaxDownloadRate(50.0);
		client.setMaxUploadRate(50.0);
		
		client.download();
		
		client.share();
	}

}
