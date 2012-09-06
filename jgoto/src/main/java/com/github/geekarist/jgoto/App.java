package com.github.geekarist.jgoto;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class App {
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
		String url = String
				.format("http://www.ratp.fr/itineraires/fr/ratp/resultat-detaille/start/%s/end/%s/route_type/plus_rapide",
						URLEncoder.encode(from), URLEncoder.encode(to));
		Document doc = Jsoup.connect(url).data(postData)
				.post();
		Elements select = doc.select("dt:contains(Durée totale) + dd");
		duration = select.html();
	}
}
