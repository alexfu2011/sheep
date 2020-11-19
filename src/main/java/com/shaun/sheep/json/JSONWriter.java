package com.shaun.sheep.json;

import java.io.Writer;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonWriter;

public class JSONWriter implements AutoCloseable {

	public JSONWriter(Writer writer) {
		this.writer = writer;
	}

	private Writer writer;
	
	public void writeObject(JSONObject jsonObject) {
		try (
			JsonWriter jsonWriter = Json.createWriter(writer);
		) {
			jsonWriter.write(jsonObject.getJsonObject());
		} catch (Exception e) {
		}
		return;
	}
	
	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
		}
	}

	protected Writer getWriter() {
		return writer;
	}

	protected void setWriter(Writer writer) {
		this.writer = writer;
	}

}
