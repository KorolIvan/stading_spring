package spring.learn.loggers;

import org.apache.commons.io.FileUtils;
import spring.learn.beans.Event;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) {
        try{
            FileUtils.writeStringToFile(file, event.toString(), true);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException {
        file = new File(fileName);
        if(file.exists() && !file.canWrite()){
            throw new IllegalArgumentException("Cannot write to file " + fileName);
        }else if(!file.exists()) {
            try{
                file.createNewFile();
            }catch (Exception e) {
                throw new IllegalArgumentException("Cannot create file", e);
            }
        }
    }
}
