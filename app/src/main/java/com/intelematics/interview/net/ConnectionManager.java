package com.intelematics.interview.net;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.util.JsonReader;

public class ConnectionManager {
	private HttpURLConnection httpConnection = null;
	private URL url = null;
	private InputStream is = null;
	private JsonReader jsonReader = null;
	

	public ConnectionManager(String requestURL){
		try {
			url = new URL(requestURL);
			
		} catch (MalformedURLException e) {
		}
	}

	public JsonReader requestJson(){
		try {
			jsonReader = new JsonReader(new InputStreamReader(request(), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
		}
		
		return jsonReader;
	}
	
	public InputStream request(){

	    try {
	        httpConnection = (HttpURLConnection) url.openConnection();

	        int responseCode = httpConnection.getResponseCode();
	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            is = httpConnection.getInputStream();
	            
	        }
	        
	    } catch (Exception ex) {
	    }
	    
	    return is;
	}
	
	public void closeConnection(){
	    try{
	    	if(is != null){
	    		is.close();
	    	}
	    	if(httpConnection != null){
	    		httpConnection.disconnect();
	    	}
		} catch(Exception e){
		}
	}
}
