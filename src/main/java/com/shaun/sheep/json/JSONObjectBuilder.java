package com.shaun.sheep.json;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

public class JSONObjectBuilder {
	
	public JSONObjectBuilder() {
		jsonObjectBuilder = Json.createObjectBuilder();
	}
	
	private JsonObjectBuilder jsonObjectBuilder;
	
	public JSONObjectBuilder add(String name, boolean value) {
		jsonObjectBuilder.add(name, value);
		return this;
	}
	
	public JSONObjectBuilder add(String name, double value) {
		jsonObjectBuilder.add(name, value);
		return this;
	}
	
	public JSONObjectBuilder add(String name, int value) {
		jsonObjectBuilder.add(name, value);
		return this;
	}
	
	public JSONObjectBuilder add(String name, long value) {
		jsonObjectBuilder.add(name, value);
		return this;
	}
	
	public JSONObjectBuilder add(String name, String value) {
		jsonObjectBuilder.add(name, value);
		return this;
	}
	
	public JSONObjectBuilder addNull(String name) {
		jsonObjectBuilder.addNull(name);
		return this;
	}
	
	public JSONObject build() {
		return new JSONObject(jsonObjectBuilder.build());
	}

}
