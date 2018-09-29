package org.bizhunt.vendor.web;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;


public class VendorBasePage extends WebPage {
	private static final long serialVersionUID = -3900297384685561512L;
	public VendorBasePage() {
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
	    response.render(CssHeaderItem.forUrl("https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"));

	    // First render the JQuery reference
	    // response.render(JavaScriptHeaderItem.forReference(getApplication().getJavaScriptLibrarySettings().getJQueryReference()));
	    response.render(JavaScriptHeaderItem.forUrl("https://code.jquery.com/jquery-3.2.1.slim.min.js"));

	    // Then render the dependent JavaScript libraries
	    response.render(JavaScriptHeaderItem.forUrl("https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"));
	    response.render(JavaScriptHeaderItem.forUrl("https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"));
	    
	    
	}
}
