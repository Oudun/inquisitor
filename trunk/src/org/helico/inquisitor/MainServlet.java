package org.helico.inquisitor;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by IntelliJ IDEA.
 * User: Denis
 * Date: Oct 23, 2008
 * Time: 1:10:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(MainServlet.class);

    private static final int MS_TO_DELIVER_KBYTE = 3;

    public void service (HttpServletRequest req, HttpServletResponse res) {

        int contentLength = req.getContentLength();

        try {
            int delay = Integer.parseInt(getInitParameter("response-delay"));
            //int delay = (contentLength*MS_TO_DELIVER_KBYTE)/1000;
            logger.debug("Sleeping " + delay + " milliseconds in emulate delivery");
            Thread.sleep(delay);
        } catch (InterruptedException ie) {
            logger.error("Failed to sleep", ie);
        } catch (Exception e) {
            logger.error("Failed to sleep", e);
        }

    }

}
