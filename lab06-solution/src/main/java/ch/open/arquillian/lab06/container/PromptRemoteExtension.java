package ch.open.arquillian.lab06.container;

import org.jboss.arquillian.container.test.spi.RemoteLoadableExtension;

public class PromptRemoteExtension implements RemoteLoadableExtension {

    @Override
    public void register(ExtensionBuilder builder) {
        builder.observer(Prompter.class);
    }
}
