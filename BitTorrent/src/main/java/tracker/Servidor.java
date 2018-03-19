package tracker;

import java.io.File;
import java.io.FilenameFilter;
import java.net.InetSocketAddress;

import com.turn.ttorrent.tracker.TrackedTorrent;
import com.turn.ttorrent.tracker.Tracker;

public class Servidor {

	public static void main (String args[]) throws Exception{
		Tracker tracker = new Tracker(new InetSocketAddress(6969));
		
		// Then, for each torrent you wish to announce on this tracker, simply created
		// a TrackedTorrent object and pass it to the tracker.announce() method:
		FilenameFilter filter = new FilenameFilter() {
		  @Override
		  public boolean accept(File dir, String name) {
		    return name.endsWith(".torrent");
		  }
		};

		for (File f : new File("/path/to/torrent/files").listFiles(filter)) {
		  tracker.announce(TrackedTorrent.load(f));
		}

		// Once done, you just have to start the tracker's main operation loop:
		tracker.start();
	}
}
