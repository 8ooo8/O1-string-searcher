package github.eightoooeight.instantstringsearcher.trienode;

import github.eightoooeight.instantstringsearcher.trienode.ITrieNode;
import java.io.*;
import java.util.Optional;

public class TrieNodeWriter implements ITrieNodeWriter{
    protected static TrieNodeWriter _this = null;

    private TrieNodeWriter() {}

    public static TrieNodeWriter getInstance() {
        return Optional.ofNullable(_this).orElseGet(() -> { _this = new TrieNodeWriter(); return _this; });
    }

    public synchronized void write(ITrieNode node, String toWrite) {
        try {
            File nodeFile = node.getNode();
            nodeFile.getParentFile().mkdirs();
            nodeFile.createNewFile(); //create a new file if not exists
            try ( BufferedWriter writer = new BufferedWriter(new FileWriter(nodeFile, true)); ) {
                writer.write(toWrite + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
