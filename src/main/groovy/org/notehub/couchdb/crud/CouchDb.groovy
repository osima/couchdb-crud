package org.notehub.couchdb.crud

import net.sf.json.*


class CouchDb {

	String hostname
	Integer port
	String dbname

	String getHostname(){
		if(hostname==null) hostname='localhost'
		hostname
	}
	Integer getPort(){
		if(port==null) port = 5984
		port
	}

	boolean exists(String dbname){ getAllDbs().contains(dbname) }

	JSONArray getAllDbs(){
		new GetAllDbs(
			hostname:hostname,
			port:port).process()
	}

	JSONObject getAllDocs(){
		new GetAllDocs(
			hostname:hostname,
			port:port,
			dbname:dbname ).process()
	}

	//
	// manipulation database
	//
	JSONObject createDatabase(){
		new CreateDb(
			hostname:hostname,
			port:port,
			dbname:dbname ).process()
	}
	JSONObject deleteDatabase(){
		new DeleteDb(
			hostname:hostname,
			port:port,
			dbname:dbname ).process()
	}



	//
	// manipulation document
	//
	JSONObject createDocument(String id, JSONObject json){
		new Create( 
			hostname:hostname,
			port:port,
			dbname:dbname,
			documentId:id,
			json:json ).process()
	}
	JSONObject readDocument(String id ){
		new Read(
			hostname:hostname,
			port:port,
			dbname:dbname,
			documentId:id ).process()
	}

	private String getRevision(String id){ readDocument(id).get('_rev') }

	JSONObject updateDocument(String id, JSONObject json){
		new Update(
			hostname:hostname,
			port:port,
			dbname:dbname,
			documentId:id,
			json:json,
			revision:getRevision(id) ).process()
	}
	JSONObject deleteDocument(String id){
		new Delete(
			hostname:hostname,
			port:port,
			dbname:dbname,
			documentId:id,
			revision:getRevision(id) ).process()
	}
}
