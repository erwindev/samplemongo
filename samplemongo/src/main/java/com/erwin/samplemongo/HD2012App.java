package com.erwin.samplemongo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.erwin.samplemongo.model.Address;
import com.erwin.samplemongo.model.School;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class HD2012App {

	public static void main(String args[]){
		ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfigSchoolFile2012.xml");
		MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");		
		
		DBCollection coll_hd2012 = mongoOperation.getCollection("hd2012");		
		DBCursor curs = coll_hd2012.find();
		
		Iterator<DBObject> fields = curs.iterator();
		
		while (fields.hasNext()){
			DBObject dbObject = fields.next();
			Iterator <String> keys = dbObject.keySet().iterator();
			School school = new School();
			Address mainAddress = new Address();
			school.setMainAddress(mainAddress);
			while (keys.hasNext()){
				String column = keys.next();
				//System.out.println(column + " = " + dbObject.get(column));
				
				if (column.equals("INSTNM")){
					school.setName((String) dbObject.get(column));
				}
				if (column.equals("UNITID")){
					school.setUnitid((String) dbObject.get(column));
				}				
				if (column.equals("ADDR")){
					mainAddress.setAddress1((String) dbObject.get(column));
				}						
				if (column.equals("CITY")){
					mainAddress.setCity((String) dbObject.get(column));
				}			
				if (column.equals("STABBR")){
					mainAddress.setState((String) dbObject.get(column));
				}	
				if (column.equals("ZIP")){
					mainAddress.setZipCode((String) dbObject.get(column));
				}					
			}
			mongoOperation.save(school);
			//System.out.println(school);
		}
		List<School> listUser = mongoOperation.findAll(School.class);
		Iterator<School> schoolIter = listUser.iterator();
		while (schoolIter.hasNext()){
			System.out.println(schoolIter.next());
		}

	}
}
