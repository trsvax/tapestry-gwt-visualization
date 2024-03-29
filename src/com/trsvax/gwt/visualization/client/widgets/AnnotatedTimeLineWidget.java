package com.trsvax.gwt.visualization.client.widgets;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine.Options;

public class AnnotatedTimeLineWidget extends Composite {

	AnnotatedTimeLine widget;

	public AnnotatedTimeLineWidget(Dictionary widgetConfig) {
		Options options = createOptions();
		// options.set)

		widget = new AnnotatedTimeLine(createTable(), createOptions(),
				widgetConfig.get("width"), widgetConfig.get("height"));
		// widget.draw(createTable(), createOptions());

		initWidget(widget);
	}

	private Options createOptions() {
		Options options = Options.create();

		return options;
	}

	private AbstractDataTable createTable() {

		int year, month, day;

		DataTable data = DataTable.create();
		data.addColumn(ColumnType.DATE, "Date");
		data.addColumn(ColumnType.NUMBER, "Sold Pencils");
		data.addColumn(ColumnType.STRING, "title1");
		data.addColumn(ColumnType.STRING, "text1");
		data.addColumn(ColumnType.NUMBER, "Sold Pens");
		data.addColumn(ColumnType.STRING, "title2");
		data.addColumn(ColumnType.STRING, "text2");
		data.addRows(6);
		try {
			data.setValue(0, 0,
					new Date(year = 2008 - 1900, month = 1, day = 1));
			data.setValue(1, 0,
					new Date(year = 2008 - 1900, month = 1, day = 2));
			data.setValue(2, 0,
					new Date(year = 2008 - 1900, month = 1, day = 3));
			data.setValue(3, 0,
					new Date(year = 2008 - 1900, month = 1, day = 4));
			data.setValue(4, 0,
					new Date(year = 2008 - 1900, month = 1, day = 5));
			data.setValue(5, 0,
					new Date(year = 2008 - 1900, month = 1, day = 6));
		} catch (JavaScriptException ex) {
			// GWT.log("Error creating data table - Date bug on mac?", ex);
		}
		data.setValue(0, 1, 30000);
		data.setValue(0, 4, 40645);
		data.setValue(1, 1, 14045);
		data.setValue(1, 4, 20374);
		data.setValue(2, 1, 55022);
		data.setValue(2, 4, 50766);
		data.setValue(3, 1, 75284);
		data.setValue(3, 4, 14334);
		data.setValue(3, 5, "Out of Stock");
		data.setValue(3, 6, "Ran out of stock on pens at 4pm");
		data.setValue(4, 1, 41476);
		data.setValue(4, 2, "Bought 200k pens");
		data.setValue(4, 4, 66467);
		data.setValue(5, 1, 33322);
		data.setValue(5, 4, 39463);

		return data;
	}
}
