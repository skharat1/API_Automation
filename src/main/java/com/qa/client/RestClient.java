package com.qa.client;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	// 1 GET method
	public void get(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();// to create one client connection
		HttpGet httpGet = new HttpGet(url); // https get request created by me
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet); // send/hit the get URL
		
		//1. Status Code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Response Status code--->" + statusCode);

		// to get all response as string use entity utils method
		// UTF -8 standard means if any special char available pls correct it and give
		// me string
		
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		//2. Get JSON	
		// We got the string now give me the json
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response Json from API--->" + responseJson);

		//3.Get all Headers
		// get the headers
		Header[] headerArray = closeableHttpResponse.getAllHeaders();

		// to convert this header array to key value pair convert it to hashmap

		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.err.println("Headers Array--->" + allHeaders);
		
	}
}
