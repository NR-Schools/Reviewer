
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class NonGUI {
    public static void main(String[] args) {
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path dir = Paths.get("C:\\Users\\hp\\Downloads\\Mapua\\College\\2\\1st\\CS128-8\\Week 10");
            
            try {
                WatchKey key = dir.register(watcher,
                                       ENTRY_CREATE,
                                       ENTRY_DELETE,
                                       ENTRY_MODIFY);
            } catch (IOException x) {
                System.err.println(x);
            }
            
            
            for (;;) {
                // wait for key to be signaled
                WatchKey key;
                try {
                    key = watcher.take();
                } catch (InterruptedException x) {
                    return;
                }

                for (WatchEvent<?> event: key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    // This key is registered only
                    // for ENTRY_CREATE events,
                    // but an OVERFLOW event can
                    // occur regardless if events
                    // are lost or discarded.
                    if (kind == OVERFLOW) {
                        continue;
                    }

                    // The filename is the
                    // context of the event.
                    WatchEvent<Path> ev = (WatchEvent<Path>)event;
                    Path filename = ev.context();

                    // Verify that the new
                    //  file is a text file.
                    try {
                        // Resolve the filename against the directory.
                        // If the filename is "test" and the directory is "foo",
                        // the resolved name is "test/foo".
                        Path child = dir.resolve(filename);
                        if (!Files.probeContentType(child).equals("text/plain")) {
                            System.err.format("New file '%s'" +
                                " is not a plain text file.%n", filename);
                            continue;
                        }
                        
                        // Email the file to the
                        //  specified email alias.
                        System.out.format("%s: %s\n", event.kind().name(), child);
                        //Details left to reader....
                    } catch (IOException x) {
                        System.err.println(x);
                        continue;
                    }
                }

                // Reset the key -- this step is critical if you want to
                // receive further watch events.  If the key is no longer valid,
                // the directory is inaccessible so exit the loop.
                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(NonGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
