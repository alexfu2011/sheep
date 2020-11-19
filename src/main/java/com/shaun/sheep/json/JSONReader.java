package com.shaun.sheep.json;

import java.io.IOException;
import java.io.Reader;
import javax.json.Json;
import javax.json.JsonReader;

public class JSONReader implements AutoCloseable {
	
	public JSONReader(Reader reader) {
		this.reader = reader;
	}

	private Reader reader;
	
	public JSONObject readObject() {
		JSONObject object;
		try (
			JsonReader jsonReader = Json.createReader(reader);
		) {
			object = new JSONObject(jsonReader.readObject());
		} catch (Exception e) {
			return null;
		}
		return object;
	}
	
	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
		}
	}

	protected Reader getReader() {
		return reader;
	}

	protected void setReader(Reader reader) {
		this.reader = reader;
	}

}
