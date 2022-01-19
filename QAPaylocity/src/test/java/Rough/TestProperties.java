/*package Testcases;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.host.Document;
import com.gargoylesoftware.htmlunit.javascript.host.NodeList;

public class UrlCheckTest {

	// This is request which we are sending to server 
	String restURL_XML = "https://192.168.110.210/pme";
	 
	// sending request and we are passing parameter in url itself
	String restURL_JSON = "https://192.168.110.214/pme";
	 
	try {
	 
	testStatusCode(restURL_XML);
	testStatusCode(restURL_JSON);
	testMimeType(restURL_XML,"application/xml");
	testMimeType(restURL_JSON,"application/json");
	testContent(restURL_XML,"lastName","Smith");
	testContentJSON(restURL_JSON,"name","Amsterdam");
	 
	} catch (ClientProtocolException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (SAXException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (ParserConfigurationException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	 
	public static void testStatusCode(String restURL) throws ClientProtocolException, IOException {
	 
	HttpUriRequest request = new HttpGet(restURL);
	HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
	 
	Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_OK);
	}
	 
	public static void testMimeType(String restURL, String expectedMimeType) throws ClientProtocolException, IOException {
	 
	HttpUriRequest request = new HttpGet(restURL);
	HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
	 
	Assert.assertEquals(expectedMimeType,ContentType.getOrDefault(httpResponse.getEntity()).getMimeType());
	}
	 
	public static void testContent(String restURL, String element, String expectedValue) throws ClientProtocolException, IOException, SAXException, ParserConfigurationException {
	 
	 
	Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(restURL);
	NodeList nodelist = doc.getElementsByTagName(element);
	 
	Assert.assertEquals(expectedValue,nodelist.item(0).getTextContent()); 
	}
	 
	public static void testContentJSON(String restURL, String element, String expectedValue) throws ClientProtocolException, IOException, SAXException, ParserConfigurationException, JSONException {
	 
	HttpUriRequest request = new HttpGet(restURL);
	HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
	 
	// Convert the response to a String format
	String result = EntityUtils.toString(httpResponse.getEntity());
	 
	// Convert the result as a String to a JSON object
	JSONObject jo = new JSONObject(result);
	 
	Assert.assertEquals(expectedValue, jo.getString(element));
	 
	}
	 
	}
*/