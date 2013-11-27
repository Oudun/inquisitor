package org.helico.inquisitor.util;

/**
 * Created with IntelliJ IDEA.
 * User: ddreval
 * Date: 27.11.13
 * Time: 17:06
 * To change this template use File | Settings | File Templates.
 */
public class Logger {

    private static Logger logger;

    public static Logger getLogger(Class klass) {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    private Logger() {

    }

    public void error(String str, Throwable e) {
        e.printStackTrace();
    }

    public void debug(String str) {
        System.out.println(str);
    }

}
