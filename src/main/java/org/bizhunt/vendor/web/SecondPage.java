package org.bizhunt.vendor.web;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

public class SecondPage extends WebPage {
	private String message = "[type your message to the world here]";

    /**
     * Constructor.
     */
    public SecondPage()
    {
        // This model references the page's message property and is
        // shared by the label and form component
        PropertyModel<String> messageModel = new PropertyModel<>(this, "message");

        // The label displays the currently set message
        add(new Label("msg", messageModel));

        // Add a form to change the message. We don't need to do anything
        // else with this form as the shared model is automatically updated
        // on form submits
        Form<?> form = new Form("form");
        form.add(new TextField<>("msgInput", messageModel));
        add(form);
    }

    /**
     * @return the message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message)
    {
        this.message = message + " -- " + new Date().toString();
        System.err.println("##xtime: " + new Date().toString());
    }
}