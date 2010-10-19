package com.trsvax.gwt.visualization.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.visualizations.AnnotatedTimeLine;
import com.google.gwt.visualization.client.visualizations.PieChart;
import com.trsvax.gwt.visualization.client.widgets.AnnotatedTimeLineWidget;
import com.trsvax.gwt.visualization.client.widgets.HelloWidget;
import com.trsvax.gwt.visualization.client.widgets.PieChartWidget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTVisualization implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		Runnable onLoadCallback = new Runnable() {
			public void run() {

				Dictionary config = Dictionary.getDictionary("trsvax");
				String[] ids = config.get("componentIDs").split(",");

				for (String id : ids) {
					Panel panel = RootPanel.get(id);
					// Composite widget = injector.getPieChartWidget();
					Composite widget = null;
					Dictionary widgetConfig = Dictionary.getDictionary(id);
					String type = widgetConfig.get("type");
					if (type.equals("PieChartWidget"))
						widget = new PieChartWidget(widgetConfig);
					if (type.equals("AnnotatedTimeLineWidget"))
						widget = new AnnotatedTimeLineWidget(widgetConfig);
					if (type.equals("HelloWidget"))
						widget = new HelloWidget(widgetConfig);

					if (widget != null)
						panel.add(widget);
				}

				// Create a pie chart visualization.

			}
		};

		// Load the visualization api, passing the onLoadCallback to be called
		// when loading is done.
		VisualizationUtils.loadVisualizationApi(onLoadCallback,
				PieChart.PACKAGE, AnnotatedTimeLine.PACKAGE);
	}
}
