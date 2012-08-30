package ch.open.arquillian.lab06.container;

import java.util.logging.Logger;

import org.jboss.arquillian.core.api.annotation.Observes;
import org.jboss.arquillian.test.spi.event.suite.After;
import org.jboss.arquillian.test.spi.event.suite.Before;

public class Prompter {

    private final static Logger logger = Logger.getLogger(Prompter.class .getName());

    public void promptBefore(@Observes Before beforeTest) {
        final Prompt prompt = beforeTest.getTestMethod().getAnnotation(Prompt.class);
        if (prompt != null) {
            prompt("Before test " + prompt.before());
        }
    }

    public void promptAfter(@Observes After afterTest) {
        final Prompt prompt = afterTest.getTestMethod().getAnnotation(Prompt.class);
        if (prompt != null) {
            prompt("After test " + prompt.after());
        }
    }

    private void prompt(String message) {
        logger.info(message);
    }

}
