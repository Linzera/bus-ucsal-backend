package com.airhacks.services;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.airhacks.encoders.LocationDecoder;
import com.airhacks.encoders.LocationEncoder;
import com.airhacks.model.Location;

@ServerEndpoint(value = "/location", decoders = LocationDecoder.class, encoders = LocationEncoder.class)
public class LocationService {

	private Session session;
	private static Set<LocationService> locationEndpoints = new CopyOnWriteArraySet<>();

	@OnOpen
	public void onOpen(Session session) throws IOException, EncodeException {

		this.session = session;
		locationEndpoints.add(this);

		Location busLocation = BusService.onibus.getLocalizacao();
		broadcast(busLocation);

	}

	@OnMessage
	public void onMessage(Session session, Location newLocation) throws IOException, EncodeException {


		BusService.onibus.setLocalizacao(newLocation);
		System.out.println(newLocation);
		broadcast(newLocation);

	}

	@OnClose
	public void onClose(Session session) throws IOException {

		locationEndpoints.remove(this);

	}

	@OnError
	public void onError(Session session, Throwable throwable) {

	}

	private void broadcast(Location localizacao) throws IOException, EncodeException {

		locationEndpoints.forEach(endpoint -> {
			synchronized (endpoint) {
				try {
					endpoint.session.getBasicRemote().sendObject(localizacao);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
