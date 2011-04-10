package org.notehub.couchdb.crud


class Base {

	String dbname

	String hostname
	Integer port

	String getHostname(){
		if(hostname==null) hostname='localhost'
		hostname
	}
	Integer getPort(){
		if(port==null) port = 5984
		port
	}

	String getBaseUrl(){
		"http://${getHostname()}:${getPort()}/${dbname}"
		//"http://${hostname}:${port}/${dbname}"
	}
}
