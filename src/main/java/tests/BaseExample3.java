package tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.BaseComponent3;
import utils.DataBuilder;

public class BaseExample3 extends BaseComponent3 {

	String id;
	
	@Test(priority =1)
	public void createTodo() {
		
		System.out.println("----------POST-----------------");
		Response resp = doRequest("post", "", DataBuilder.buildTodo().toJSONString());
		id = resp.jsonPath().getString("id");
		System.out.println(resp.asString());
		
	}
	
	@Test(priority = 2)
	public void readTodo() {
		System.out.println("----------GET-----------------");
		Response resp = doRequest("get", id, "");
		System.out.println(resp.asString());
	}
	
	@Test(priority = 3)
	public void updateTodo() {
		System.out.println("----------PUT-----------------");
		Response resp = doRequest("put", id, DataBuilder.buildTodo().toJSONString());
		System.out.println(resp.asString());
	}
	
	
	@Test(priority = 4)
	public void deleteTodo() {
		System.out.println("----------DELETE-----------------");
		Response resp = doRequest("delete", id, "");
		System.out.println(resp.asString());
	}
	
}
