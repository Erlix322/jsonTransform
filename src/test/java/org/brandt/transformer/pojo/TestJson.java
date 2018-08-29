package org.brandt.transformer.pojo;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJson {

	@Test
	public void test() throws JsonProcessingException {
		Child c1 = new Child();
		c1.id = "1";
		c1.name = "child1";
		Child c2 = new Child();
		c2.id = "2";
		c2.name = "child2";
		Parent p = new Parent();
		p.children = new Child[] {c1,c2};
		p.id = "1";
		p.name = "parent";
		
		ObjectMapper m = new ObjectMapper();
		System.out.println(m.writeValueAsString(p));
	}

}
