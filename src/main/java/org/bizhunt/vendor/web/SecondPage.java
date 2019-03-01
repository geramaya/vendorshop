package org.bizhunt.vendor.web;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.resource.PackageResourceReference;

public class SecondPage extends VendorBasePage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1092790933621582042L;
	private String message = "[type your message to the world here]";

	/**
	 * Constructor.
	 */
	public SecondPage() {
		// This model references the page's message property and is
		// shared by the label and form component
		PropertyModel<String> messageModel = new PropertyModel<>(this, "message");

		// Add a form to change the message. We don't need to do anything
		// else with this form as the shared model is automatically updated
		// on form submits
		Form<?> form = new Form<>("form");
		form.add(new TextField<>("msgInput", messageModel));
		// The label displays the currently set message
		form.add(new Label("msg", messageModel));

		add(form);

	}

	@Override
	public void renderHead(IHeaderResponse response) {
		// TODO Auto-generated method stub
		super.renderHead(response);
		PackageResourceReference cssFile = new PackageResourceReference(this.getClass(), "SecondPage.css");
		CssHeaderItem cssItem = CssHeaderItem.forReference(cssFile);

		response.render(cssItem);
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message + " -- " + new Date().toString();
		System.err.println("##xtime: " + new Date().toString());
		StringUtils.isEmpty("");
	}
}