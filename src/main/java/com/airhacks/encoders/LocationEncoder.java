package com.airhacks.encoders;

import java.io.IOException;
import java.io.Writer;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.airhacks.model.Location;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class LocationEncoder implements Encoder.TextStream<JsonObject> {

	private static Gson gson = new Gson();

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void encode(JsonObject object, Writer writer) throws EncodeException, IOException {
		
		System.out.println(object.toString());
		
	}

}
