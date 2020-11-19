package com.shaun.sheep.json;

import javax.json.Json;
import javax.json.JsonObject;

public class JSONObject {
	
	public JSONObject(JsonObject jsonObject) {
		setJsonObject(jsonObject);
	}
	
	private JsonObject jsonObject;
	
	/*
	 * build an empty JSONObject.
	 */
	public JSONObject() {
		this.jsonObject =  Json.createObjectBuilder().build();
	}
	
	public String getString(String key) {
		String value;
		try {
			value = jsonObject.getString(key);
		} catch (NullPointerException e) {
			value = "";
		}
		return value;
	}
	
	public int getInt(String key) {
		int value;
		try {
			value = jsonObject.getInt(key);
		} catch (NullPointerException e) {
			value = 0;
		}
		return value;
	}
	
	public Boolean getBoolean(String key) {
		Boolean value;
		try {
			value = jsonObject.getBoolean(key);
		} catch (NullPointerException e) {
			value = false;
		}
		return value;
	}
	
	public Boolean isNull(String key) {
		Boolean value;
		try {
			value = jsonObject.isNull(key);
		} catch (NullPointerException e) {
			value = false;
		}
		return value;
	}

	protected JsonObject getJsonObject() {
		return jsonObject;
	}

	protected void setJsonObject(JsonObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	@Override
	public String toString() {
		return "JSONObject [jsonObject=" + jsonObject + "]";
	}

}
