
import groovy.util.GroovyTestCase

import net.sf.json.*

import org.notehub.couchdb.crud.*


class TestCrud extends GroovyTestCase {
	
	static private String hostname = 'localhost'
	void setUp(){
		deleteAllTestDbs()
		createAllTestDbs()
	}
	private void createAllTestDbs(){ 
		(0..2).each{
			String dbname = "testdb${it}"
			new CouchDb( dbname:dbname, hostname:hostname ).createDatabase()
		}
	}
	void tearDown(){
		deleteAllTestDbs()
	}
	private void deleteAllTestDbs(){
		(0..2).each{
			String dbname = "testdb${it}"
			new CouchDb( dbname:dbname, hostname:hostname ).deleteDatabase()
		}
	}

	void testCreateDb(){
		String dbname = 'testdb0' 
		String hostname = 'localhost'

		def db = new CouchDb( dbname:dbname, hostname:hostname )
		db.createDatabase()

		db.getAllDocs()
	}

	void testDeleteDb(){
		String dbname = 'testdb1' 
		String hostname = 'localhost'

		def db = new CouchDb( dbname:dbname, hostname:hostname )
		db.createDatabase()
		db.deleteDatabase()
	}

	void testCrudDocument(){
		String dbname = 'testdb2' 
		String hostname = 'localhost' 

		//deleteDb( dbname,hostname ) 

		def db = new CouchDb( dbname:dbname, hostname:hostname )
		db.createDatabase()

		String documentId = '100'
		def json = null
		json = JSONObject.fromObject('{"title":"Hello CouchDb!"}')
		db.createDocument(documentId,json)

		assertTrue( db.readDocument(documentId).get('title') == 'Hello CouchDb!' )

		json = JSONObject.fromObject('{"title":"Hello again CouchDb!"}')
		db.updateDocument(documentId,json)

		assertTrue( db.readDocument(documentId).get('title') == 'Hello again CouchDb!' )

		db.deleteDocument(documentId)
	}


	/*
	void testString(){
		String a = 'hello'
		String b = 'hello'
        	assertEquals('message',a,b)
	}
	*/
}

