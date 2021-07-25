package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;

public class GetTestAPI extends TestBase {
	TestBase testBase;
	String serviceUrl;
	String apiURL;
	String url;
	RestClient  client;

	@BeforeMethod
	public void setUp() {
		//testBase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		apiURL = prop.getProperty("serviceURL");
		// to get this url https://reqres.in/api/users
		url = serviceUrl + apiURL;
	}

	@Test
	public void getAPITest() throws ClientProtocolException, IOException {
		client = new RestClient();
		client.get(url);
	}

}
