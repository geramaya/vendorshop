package org.bizhunt.vendor;

import org.apache.wicket.protocol.http.WebApplication;

import com.giffing.wicket.spring.boot.context.extensions.ApplicationInitExtension;
import com.giffing.wicket.spring.boot.context.extensions.WicketApplicationInitConfiguration;

@ApplicationInitExtension
public class VendorConfiguration implements WicketApplicationInitConfiguration {

  @Override
  public void init(WebApplication webApplication) {

	// if you want to customize bootstrap:
//	BootstrapSettings settings = new BootstrapSettings();
//	Bootstrap.install(webApplication, settings);
  }

}