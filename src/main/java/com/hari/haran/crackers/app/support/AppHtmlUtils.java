package com.hari.haran.crackers.app.support;

import com.hari.haran.crackers.app.cons.SettingCons;

/**
 * AppHtmlUtils is an utility class used to define HTML components
 * 
 * @author HARIHARAN MANI
 * @since 17-11-2021
 */
public class AppHtmlUtils {

	public static final String ERROR_PAGE = getErrorPage();
	public static final String HEALTH_PAGE = getHealthPage();

	/**
	 * AppHtmlUtils() is a private constructor to hide the implicit public one.
	 */
	private AppHtmlUtils() {
		throw new IllegalStateException();
	}

	private static String getHealthPage() {
		String appVersion = String.format("%s.%s", SettingCons.APP_VERSION, SettingCons.APP_BUILD_NO);

		StringBuilder indexBuilder = new StringBuilder();

		indexBuilder.append("<div style=\"font-family: Open Sans,sans-serif;\">");

		indexBuilder.append("<h2 style=\"");
		indexBuilder.append("font-size: 36px;");
		indexBuilder.append("margin: 0;");
		indexBuilder.append("color: #055593;");
		indexBuilder.append("border-bottom: 1px solid rgba(59,65,81,.3);");
		indexBuilder.append("padding-bottom: 10px;");
		indexBuilder.append("\">");
		indexBuilder.append(SettingCons.APP_NAME);
		indexBuilder.append(getSmallText(appVersion, "super"));
		indexBuilder.append("</h2>");

		indexBuilder.append("</div>");

		return indexBuilder.toString();
	}

	private static String getSmallText(String smallText, String verticalAlign) {
		StringBuilder textBuilder = new StringBuilder();

		textBuilder.append("<small style=\"display: inline-block;");
		textBuilder.append("font-size: 15px;");
		textBuilder.append("margin-left: 10px;");
		textBuilder.append("padding: 5px 10px;");
		textBuilder.append("background: #c8da91;");
		textBuilder.append("border-radius: 57px;");
		textBuilder.append(String.format("vertical-align: %s;", verticalAlign));
		textBuilder.append("\">");

		textBuilder.append("<pre style=\"margin: 0;font-family: Titillium Web,sans-serif;color: #055593;\">");
		textBuilder.append(smallText);
		textBuilder.append("</pre>");

		textBuilder.append("</small>");
		return textBuilder.toString();
	}

	private static String getErrorPage() {
		StringBuilder errorBuilder = new StringBuilder();
		errorBuilder.append("<div style=\"margin: 20px 2px 2px 20px\">");

		errorBuilder.append("<h2 style=\"color: #CC0000;\">");
		errorBuilder.append("HTTP Error 404 - Not Found");
		errorBuilder.append("</h2>");

		errorBuilder.append("<h3>");
		errorBuilder.append("The resource you are looking has been removed / changed / temporarily unavailable.");
		errorBuilder.append("</h3>");

		errorBuilder.append("</div>");
		return errorBuilder.toString();
	}

}
