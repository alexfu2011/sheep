package com.shaun.sheep.json;

import java.io.Reader;
import java.io.Writer;
import java.io.StringReader;
import java.io.FileReader;

public class JSON {

	public static JSONObject FromString(String str) {
		JSONObject jsonObject;
		try (
			Reader input = new StringReader(str);
			JSONReader reader = createReader(input);
		) {
			jsonObject = reader.readObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return jsonObject;
	}
	
	public static JSONObject FromFile(String file) {
		JSONObject jsonObject;
		try (
			Reader input = new FileReader(file);
			JSONReader reader = createReader(input);
		) {
			jsonObject = reader.readObject();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return jsonObject;
	}

	public static JSONReader createReader(Reader reader) {
		return new JSONReader(reader);
	}
	
	public static JSONWriter createWriter(Writer writer) {
		return new JSONWriter(writer);
	}
	
	public static JSONObjectBuilder createObjectBuilder() {
		return new JSONObjectBuilder();
	}

}
