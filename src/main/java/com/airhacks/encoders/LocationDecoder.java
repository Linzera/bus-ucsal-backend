package com.airhacks.encoders;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.airhacks.model.Location;
import com.google.gson.Gson;

public class LocationDecoder implements Decoder.Text<Location> {

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
	public Location decode(String s) throws DecodeException {
		return gson.fromJson(s, Location.class);
	}

	@Override
	public boolean willDecode(String s) {
		// TODO Auto-generated method stub
		return false;
	}

}
