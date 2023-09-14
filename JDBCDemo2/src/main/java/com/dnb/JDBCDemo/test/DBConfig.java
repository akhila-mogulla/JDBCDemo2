package com.dnb.JDBCDemo.test;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dnb.JDBCDemo.utils.DataSourceBean;

@Configuration
public class DBConfig {
	
	@Bean //it makes us to create only one object though it was called many times(first time object is created and in later cases it returns the created object).
	public DataSourceBean dataSourceBean() {
		return new DataSourceBean();
		
	}
	
	@Bean
	public String[] arrayDemo() {
		
		return new String[] {"a","b","c"};
	}
	
	//we can use HahMap, HashSet, TreeSet, custom object just like above

}
