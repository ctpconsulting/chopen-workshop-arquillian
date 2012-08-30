package ch.open.arquillian.lab06.client;

import org.jboss.arquillian.container.test.spi.client.deployment.AuxiliaryArchiveAppender;
import org.jboss.arquillian.core.spi.LoadableExtension;

public class PromptExtension implements LoadableExtension
{
   @Override
   public void register(ExtensionBuilder builder)
   {
      builder.service(AuxiliaryArchiveAppender.class, PromptExtensionArchiveCreator.class);
   }
}
