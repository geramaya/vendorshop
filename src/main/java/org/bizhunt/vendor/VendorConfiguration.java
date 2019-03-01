package org.bizhunt.vendor;

import org.apache.wicket.protocol.http.WebApplication;
import org.bizhunt.vendor.web.HomePage;
import org.bizhunt.vendor.web.SecondPage;

import com.giffing.wicket.spring.boot.context.extensions.ApplicationInitExtension;
import com.giffing.wicket.spring.boot.context.extensions.WicketApplicationInitConfiguration;

@ApplicationInitExtension
public class VendorConfiguration implements WicketApplicationInitConfiguration {

	@Override
	public void init(WebApplication webApplication) {

		webApplication.getJavaScriptLibrarySettings()
				.setJQueryReference(org.apache.wicket.resource.JQueryResourceReference.getV3());

		// if you want to customize bootstrap:
		// BootstrapSettings settings = new BootstrapSettings();
		// Bootstrap.install(webApplication, settings);
		
		// mount nice urls on wicket pages!
		webApplication.mountPage("/home", HomePage.class);
		webApplication.mountPage("/second", SecondPage.class);
	}

}