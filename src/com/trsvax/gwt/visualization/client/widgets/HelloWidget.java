package com.trsvax.gwt.visualization.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.trsvax.gwt.visualization.client.rpc.GreetingService;
import com.trsvax.gwt.visualization.client.rpc.GreetingServiceAsync;

public class HelloWidget extends Composite implements ClickHandler {
	private Panel widget;
	private Button button;
	private TextBox nameField;
	private TextBox resultField;

	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	public HelloWidget(Dictionary widgetConfig) {
		((ServiceDefTarget) greetingService).setServiceEntryPoint(widgetConfig
				.get("completeID").replaceAll(":", "."));

		widget = new VerticalPanel();
		widget.add(nameField = new TextBox());
		widget.add(button = new Button("send"));
		widget.add(resultField = new TextBox());

		button.addClickHandler(this);

		initWidget(widget);

	}

	@Override
	public void onClick(ClickEvent event) {
		sendNameToServer();
	}

	private void sendNameToServer() {
		// First, we validate the input.

		String textToServer = nameField.getText();

		// Then, we send the input to the server.

		greetingService.greetServer(nameField.getValue(),
				new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						resultField.setValue(caught.getMessage());

					}

					public void onSuccess(String result) {
						resultField.setValue(result);
					}
				});
	}

}
