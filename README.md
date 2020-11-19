## HTTP

java.net类库的简单封装。

### HTTPClient

HTTPClient 用以网络上提交数据，例如，微信小程序登录：

	Map<String, String> parameters = new HashMap<String, String>();
	parameters.put("appid", wxspAppid);
	parameters.put("secret", wxspSecret);
	parameters.put("grant_type", grant_type);
	parameters.put("code", code);
	String str = HTTPClient.doPost("https://api.weixin.qq.com/sns/jscode2session", parameters);

## JSON

实现了一个对javax.json类库的简单封装：

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
	        assertEquals(null, json.getInteger("age"));
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



## mvn 如何执行主程序？

执行主程序：

	mvn -q clean compile exec:java -Dexec:java -Dexec.mainClass="com.builder.durid.App"

执行带参数的主程序：

	mvn -q clean compile exec:java -Dexec:java -Dexec.mainClass="com.builder.durid.App" -Dexec.args="myArg1 myArg2"
