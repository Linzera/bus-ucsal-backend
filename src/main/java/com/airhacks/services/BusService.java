package com.airhacks.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.airhacks.enums.RoteiroEnum;
import com.airhacks.model.Bus;
import com.airhacks.model.BusInfo;
import com.airhacks.model.Location;

@Path("/bus")
public class BusService {

	private static List<BusInfo> lista = new ArrayList<BusInfo>();
	public static Bus onibus = new Bus(new Location(-12.946036, -38.413762), "Italo", 0);

	static {
		lista.add(new BusInfo("6:30", RoteiroEnum.ROTEIRO));
		lista.add(new BusInfo("7:30", RoteiroEnum.ROTEIRO2));
		lista.add(new BusInfo("8:30", RoteiroEnum.ROTEIRO3));
		lista.add(new BusInfo("9:30", RoteiroEnum.ROTEIRO4));
		lista.add(new BusInfo("10:30", RoteiroEnum.ROTEIRO4));
		lista.add(new BusInfo("11:30", RoteiroEnum.ROTEIRO4));
		lista.add(new BusInfo("12:30", RoteiroEnum.ROTEIRO4));
		lista.add(new BusInfo("13:30", RoteiroEnum.ROTEIRO4));
		lista.add(new BusInfo("14:30", RoteiroEnum.ROTEIRO4));
		lista.add(new BusInfo("15:30", RoteiroEnum.ROTEIRO4));
		lista.add(new BusInfo("16:30", RoteiroEnum.ROTEIRO4));
		lista.add(new BusInfo("17:30", RoteiroEnum.ROTEIRO4));
		lista.add(new BusInfo("18:30", RoteiroEnum.ROTEIRO2));

	}

	@GET
	@Path("/passageiros")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getPassageirosAtual() {

		JSONObject qntPassageirosJson = new JSONObject();

		try {
			qntPassageirosJson.put("qntPassageiros", onibus.getQntPassageiros());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return Response.ok() // 200
				.entity(qntPassageirosJson).build();
	}

	@GET
	@Path("/localizacao")
	@Produces({ MediaType.APPLICATION_JSON })
	public JSONObject getLocalizacaoBus() {

		JSONObject localizacaoJson = new JSONObject();

		try {
			localizacaoJson.put("latitude", onibus.getLocalizacao().getLatitude());
			localizacaoJson.put("longitude", onibus.getLocalizacao().getLongitude());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return localizacaoJson;
	}

	@GET
	@Path("/businfo")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getRoteiroHoraio() {

		JSONArray jsonArray = new JSONArray();

		for (BusInfo busInfo : lista) {

			JSONObject busInfoJson = new JSONObject();

			try {
				busInfoJson.put("horario", busInfo.getHorario());
				busInfoJson.put("roteiro", busInfo.getRoteiro().toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}

			jsonArray.put(busInfoJson);
		}

		return Response.ok() // 200
				.entity(jsonArray).build();

	}

	@POST
	@Path("/localizacao")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public JSONObject updateLocalization(Location location) {

		BusService.onibus.setLocalizacao(location);

		JSONObject newLocation = new JSONObject();
		try {
			newLocation.put("latitude", BusService.onibus.getLocalizacao().getLatitude());
			newLocation.put("longitude", BusService.onibus.getLocalizacao().getLongitude());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return newLocation;
	}

}
