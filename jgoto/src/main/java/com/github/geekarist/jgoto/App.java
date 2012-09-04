package com.github.geekarist.jgoto;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class App 
{
	private String from;
	private String to;
	private String duration;

	public App from(String string) {
		from = string;
		return this;
	}

	public App to(String string) {
		to = string;
		return this;
	}

	public String duration() throws IOException {
		computeRoute();
		return duration;
	}

	private void computeRoute() throws IOException {
		Map<String, String> postData = new HashMap<String, String>();
		postData.put("itineraire_start", from);
		postData.put("itineraire_end", to);
		Document doc = Jsoup.connect("http://www.ratp.fr/").data(postData).post();
		duration = doc.html();
	}
}
