/**
 * @author  Philip Hansen
 * @version 0.1
 * @since   30-01-2019
 */
package Logging;

public class Logger implements Loggable {

    boolean logToConsole;

    public Logger(boolean logToConsole){
        this.logToConsole = logToConsole;
    }

    @Override
    public void log() {

    }

    @Override
    public void log(LogType logType) {

    }
}
