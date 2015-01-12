package com.unsa.pmf.ws.rest.client;

import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class Client {
	public static void main(String[] args) {
		try {
			try {
				URL url = new URL(
						"http://192.168.0.102:8080/restws/cache/1/getName");
				URLConnection connection = url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                //out.write(jsonObject.toString());
                out.close();

			} catch (Exception e) {
				System.out.println("\nError while calling REST Service");
				System.out.println(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
