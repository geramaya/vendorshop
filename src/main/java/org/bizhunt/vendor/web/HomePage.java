package org.bizhunt.vendor.web;

import java.util.ArrayList;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.protocol.ws.api.WebSocketBehavior;
import org.apache.wicket.protocol.ws.api.WebSocketRequestHandler;
import org.apache.wicket.protocol.ws.api.message.IWebSocketPushMessage;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.bizhunt.vendor.dao.UserRepository;
import org.bizhunt.vendor.dto.User;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.giffing.wicket.spring.boot.starter.web.servlet.websocket.WebSocketMessageBroadcaster;

@WicketHomePage
public class HomePage extends VendorBasePage {
	private static final long serialVersionUID = -3900297384685561512L;

	@SpringBean
	private WebSocketMessageBroadcaster broadcaster;

	private ListView<String> chatList;

	private ListModel<String> chatModel = new ListModel<String>(new ArrayList<String>());

	private IModel<String> latestChatMessage = Model.of("");

	private TextField<String> chatTextField;

	@SpringBean
	private UserRepository userRep;

	public HomePage() {

		queue(new Form<Void>("form"));
		chatTextField = new TextField<String>("chatInput", latestChatMessage);
		chatTextField.setOutputMarkupId(true);
		queue(chatTextField);
		queue(new AjaxButton("send") {
			private static final long serialVersionUID = 8045751270791651965L;

			@Override
			protected void onSubmit(AjaxRequestTarget target) {
				broadcaster.send(new ChatMessageEvent(latestChatMessage.getObject()));
				User user = new User("daniel", 12);
				userRep.save(user);
			}
		});

		add(new Link<Void>("mylink") {

			@Override
			public void onClick() {
				setResponsePage(SecondPage.class);
			}

		});

		queue(new DebugBar("debug"));

		final WebMarkupContainer chatContainer = new WebMarkupContainer("chatContainer");
		chatContainer.setOutputMarkupId(true);
		queue(chatContainer);

		chatList = new ListView<String>("chat", chatModel) {

			@Override
			protected void populateItem(ListItem<String> item) {
				item.add(new Label("message", item.getModelObject()));

			}
		};
		chatList.setOutputMarkupId(true);
		queue(chatList);

		add(new WebSocketBehavior() {

			@Override
			protected void onPush(WebSocketRequestHandler handler, IWebSocketPushMessage message) {
				if (message instanceof ChatMessageEvent) {
					ChatMessageEvent event = (ChatMessageEvent) message;
					if (event != null) {
						chatModel.getObject().add(event.getMessage());
						handler.add(chatContainer);
						chatTextField.setModelObject("");
						handler.add(chatTextField);
					}
				}
			}
		});

	}
}
