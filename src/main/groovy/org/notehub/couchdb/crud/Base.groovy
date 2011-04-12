package org.notehub.couchdb.crud


class Base {

	String hostname
	Integer port

	String encoding
	String getEncoding(){
		if(encoding==null) encoding='UTF-8'
		return encoding
	}

	String getHostname(){
		if(hostname==null) hostname='localhost'
		hostname
	}
	Integer getPort(){
		if(port==null) port = 5984
		port
	}

	String getBaseUrl(){ "http://${getHostname()}:${getPort()}" }
}
