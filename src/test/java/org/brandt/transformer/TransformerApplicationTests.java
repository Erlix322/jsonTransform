package org.brandt.transformer;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.brandt.transformer.pojo.Another;
import org.junit.Test;


public class TransformerApplicationTests {

	public String json = "{\n" + 
			"	\"parent\": {\n" + 
			"		\"id\": \"1\",\n" + 
			"		\"name\": \"parent\",\n" + 
			"		\"children\": [{\n" + 
			"			\"id\": \"1\",\n" + 
			"			\"name\": \"child1\"\n" + 
			"		}, {\n" + 
			"			\"id\": \"2\",\n" + 
			"			\"name\": \"child2\"\n" + 
			"		}],\n" + 
			"		\"another\": [{\n" + 
			"			\"of\": \"one\"\n" + 
			"		}]\n" + 
			"	}\n" +
			"}";
	
	@Test
	public void ListElementShouldBeReturnedAsList() {
		Query q = new Query(json);		
		List<Another> p =  (List<Another>) q.getObject("$.parent.another", Another.class);
		assertEquals(1, p.size());
	}
	
	@Test
	public void BasicValueShouldBeReturned() {
		Query q = new Query(json);
		assertEquals("parent",q.getObject("$.parent.name", String.class));
	}

}
