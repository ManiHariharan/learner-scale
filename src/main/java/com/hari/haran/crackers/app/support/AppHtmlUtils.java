package com.hari.haran.crackers.app.support;

import com.hari.haran.crackers.app.cons.SettingCons;

/**
 * AppHtmlUtils is an utility class used to define HTML components
 * 
 * @author HARIHARAN MANI
 * @since 17-11-2021
 */
public class AppHtmlUtils {

	public static final String ERROR_PAGE = getHtmlPage("h2-eCommerce Error Page", getErrorPage());
	public static final String HEALTH_PAGE = getHtmlPage("h2-eCommerce", getHealthPage());
	public static final String BUILD_INFO = getHtmlPage("h2-eCommerce Features", getBuildInfo());

	/**
	 * AppHtmlUtils() is a private constructor to hide the implicit public one.
	 */
	private AppHtmlUtils() {
		throw new IllegalStateException();
	}
	
	
	private static String getHtmlPage(String headerName, String pageInfo) {
		StringBuilder htmlBuilder = new StringBuilder();
		htmlBuilder.append("<head>");
		htmlBuilder.append("<title>").append(headerName).append("</title>");
		htmlBuilder.append("</head>");
		
		htmlBuilder.append("<body>");
		htmlBuilder.append(pageInfo);
		htmlBuilder.append("</body>");
		
		return htmlBuilder.toString();
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

	private static String getBuildInfo() {
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
		
		
		indexBuilder.append("<ul>");
		indexBuilder.append("<li>").append("Crackers can be easily filtered using Category and Sub-Category");
		indexBuilder.append("<br>").append("Eg : [<b>Category</b> : SPARKLERS] [<b>Sub-Category</b> : 7 CM SPARKLERS, 10 CM SPARKLERS]").append("</li>");
		indexBuilder.append("</ul>");
		
		
		indexBuilder.append("<ul>");
		indexBuilder.append("<li>").append("Filters can be searched on selected Category separately").append("</li>");
		indexBuilder.append("<li>").append("Filters can be searched for All Categories also").append("</li>");
		indexBuilder.append("</ul>");
		
		indexBuilder.append("<ul>");
		indexBuilder.append("<li>").append("Each crackers will be displayed with Primary image in dashboard").append("</li>");
		indexBuilder.append("<li>").append("If View icon clicked, Primary and Secondary image of the crackers will be displayed along with detailed category information");
		indexBuilder.append("<br>");
		indexBuilder.append("(If required, 2 lines of individual product description can also be added in this page)");
		indexBuilder.append("</li>");
		indexBuilder.append("</ul>");
		
		
		indexBuilder.append("<ul>");
		indexBuilder.append("<li>").append("Each crackers can be added to cart separately").append("</li>");
		indexBuilder.append("<li>").append("View Cart icon will alwayz available on page top along with selected product count").append("</li>");
		indexBuilder.append("</ul>");
		
		indexBuilder.append("<ul>");
		indexBuilder.append("<li>").append("In View Cart page itself, Quantity can be increased, decreased. Product can also be deleted").append("</li>");
		indexBuilder.append("<li>").append("Cart can be reviewed once before Delivery address to be added").append("</li>");
		indexBuilder.append("<li>").append("Final Order Summary will be displayed").append("</li>");
		indexBuilder.append("</ul>");
		
		indexBuilder.append("<ul>");
		indexBuilder.append("<li>").append("Reference information can be added (optinal)").append("</li>");
		indexBuilder.append("<li>").append("Estimation PDF can be downloaded (same like old application PDF)").append("</li>");
		indexBuilder.append("<li>").append("Mail Notification will be sent (same like old application PDF)").append("</li>");
		indexBuilder.append("</ul>");
		
		indexBuilder.append("<ul>");
		indexBuilder.append("<li>").append("Selected Cart information will be stored in browser Local Storage").append("</li>");
		indexBuilder.append("<li>").append("Delivery Address will alos be stored in browser Local Storage which can be used for future orders").append("</li>");
		indexBuilder.append("</ul>");
		
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
