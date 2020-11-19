package com.shaun.sheep;

import static org.junit.Assert.assertEquals;

import java.io.FileWriter;

import org.junit.Test;

import com.shaun.sheep.json.JSON;
import com.shaun.sheep.json.JSONObject;
import com.shaun.sheep.json.JSONWriter;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * 读取 JSON 字符串
     */
    @Test
    public void testReadFromString()
    {
        String people = "{\"name\":\"John\"}";
        JSONObject json = JSON.FromString(people);
        assertEquals("John", json.getString("name"));
        assertEquals(0, json.getInt("age"));
    }

    /**
     * 创建 JSON 对象，保存到文件
     */
    @Test
    public void testWriter()
    {
        try (
    		FileWriter writer = new FileWriter("C:\\json.txt");
            JSONWriter jsonWriter = JSON.createWriter(writer);
        )
        {
        	JSONObject json = JSON.createObjectBuilder()
	        	     .add("firstName", "John")
	        	     .add("lastName", "Smith")
	        	     .add("age", 25)
	        	     .build();
	        assertEquals("John", json.getString("firstName"));
	        jsonWriter.writeObject(json);
        } catch(Exception e) {}
    }

    /**
     * 读取 JSON 文件
     */
    @Test
    public void testReadFromFile()
    {
    	JSONObject json = JSON.FromFile("C:\\json.txt");
        assertEquals("John", json.getString("firstName"));
    }

}
