package com.wilis.webkit3;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Date;

public class webkit3 extends Activity {
	WebView browser;
	
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		browser=(WebView)findViewById(R.id.webkit);
		browser.setWebViewClient(new Callback());
		
		loadTime();
	}
	
	void loadTime() {
		String page="<html><body><a href=\"clock\">"
						+new Date().toString()
						+"</a></body></html>";
						
						browser.loadDataWithBaseURL("x-data://base", page,
																				"text/html", "UTF-8",
																				null);
	}
	private class Callback extends WebViewClient {
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			loadTime();
			
			return(true);
		}
	}
}