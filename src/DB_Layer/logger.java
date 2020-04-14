package DB_Layer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//Seriously why do I have to import 3 things so get the date. Java = superflous objects everywhere
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public final class logger {
    //Implements a singleton logger instance
    private static final logger instance = new logger();

    //Retrieve the execution directory. Note that this is whereever this process was launched
    public String logname = "systemLog";
    protected String env = ".";
    private static File logFile;

    public static logger getInstance() {
        return instance;
    }

    public static logger getInstance(String withName) {
        instance.logname = withName;
        instance.createLogFile();
        return instance;
    }

    public void createLogFile() {
        //Determine if a logs directory exists or not.
        File logsFolder = new File(env + '/' + "logs");
        if (!logsFolder.exists()) {
            //Create the directory
            System.err.println("INFO: Creating new logs directory in " + env);
            logsFolder.mkdir();

        }

        //Get the current date and time
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();

        //Create the name of the file from the path and current time
        logname = logname + '-' + dateFormat.format(cal.getTime()) + ".log";
        logger.logFile = new File(logsFolder.getName(), logname);
        try {
            if (logFile.createNewFile()) {
                //New file made
                System.err.println("INFO: Creating new log file");
            }
        } catch (IOException e) {
            System.err.println("ERROR: Cannot create log file");
            System.exit(1);
        }
    }

    private logger() {
        if (instance != null) {
            //Prevent Reflection
            throw new IllegalStateException("Cannot instantiate a new singleton instance of log");
        }
        this.createLogFile();
    }

    public static void log(String message) {
        try {
            FileWriter out = new FileWriter(logger.logFile, true);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String savelog = dtf.format(now) +" : "+ message + "\n";
            out.write(savelog.toCharArray());
            out.close();
        } catch (IOException e) {
            System.err.println("ERROR: Could not write to log file");
        }
    }

/*
//log use example
    public static void main(String[] args) {
        logger.log("This is my message");
        logger.log("is this working?");
    }
*/
}
