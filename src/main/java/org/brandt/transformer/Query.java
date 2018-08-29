package org.brandt.transformer;



import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.brandt.transformer.pojo.Child;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.TypeRef;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;

public class Query {

	public final String json;
	
	Query(String json){
		init();
		this.json =json;
	}
	
	private void init() {
		Configuration.setDefaults(new Configuration.Defaults() {
		    private final JsonProvider jsonProvider = new JacksonJsonProvider();
		    private final MappingProvider mappingProvider = new JacksonMappingProvider();

		    @Override
		    public JsonProvider jsonProvider() {
		        return jsonProvider;
		    }

		    @Override
		    public MappingProvider mappingProvider() {
		        return mappingProvider;
		    }

		    @Override
		    public Set<Option> options() {
		        return EnumSet.noneOf(Option.class);
		    }
		});
		
	}

	
	
	@SuppressWarnings("unchecked")
	public <T> T getObject(String query, Class<T> clazz) {
		Object object = null;
		TypeRef<List<T>> typeRef = new TypeRef<List<T>>() {};
		Object o = JsonPath.parse(json).read(query);
		if(o instanceof ArrayList) {
			object = JsonPath.parse(json).read(query,typeRef);
		}else {
			object = JsonPath.parse(json).read(query,clazz);
		}		
		return (T) 	object;
				
	}
	
	
	
	
}
