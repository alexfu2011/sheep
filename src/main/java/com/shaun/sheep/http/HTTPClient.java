package com.shaun.sheep.http;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class HTTPClient {

	public static String doPost(String url, Map<String, ?> parameters) {
		String result = "";
		URLConnection connection;
		
		try {
			connection = new URL(url).openConnection();
			connection.setDoOutput(true);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return result;
		}
		
		try (
			PrintWriter out = new PrintWriter(connection.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(
				connection.getInputStream(), "UTF-8"));
		) {
			List<String> list = new ArrayList<String>();
			for (Map.Entry<String, ?> parameter : parameters.entrySet()) {
				final String encodedKey = URLEncoder.encode(
					parameter.getKey(), "UTF-8");
				final String encodedValue = URLEncoder.encode(
					parameter.getValue().toString(), "UTF-8");
				list.add(encodedKey + "=" +  encodedValue);
			}
			
			out.print(String.join("&", list));
			
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
