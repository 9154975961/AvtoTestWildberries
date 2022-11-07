package utils.setFile;

import java.io.FileWriter;
import java.io.IOException;

public class SetComparedFile {
    public SetComparedFile(String dataNew, String nameFile) throws IOException {

        try (
                FileWriter writer = new FileWriter(nameFile)) {
            writer.append(dataNew);
            writer.append("]}}");}
    }
}