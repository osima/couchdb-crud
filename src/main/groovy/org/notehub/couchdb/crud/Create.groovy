package org.notehub.couchdb.crud

import net.sf.json.*

import org.apache.commons.httpclient.*
import org.apache.commons.httpclient.methods.*




class Create {

	String dbname
	String documentId
	JSONObject json

	JSONObject proc(){

		def r=null

		def myurl = new URL("http://localhost:5984/${dbname}/${documentId}")

		def hc = new HttpClient()
		def method = new MyPutMethod( myurl.toString() )
		method.setRequestBody( json.toString() )
		hc.executeMethod( method )
		r = method.getResponseBodyAsString()
		
		method.releaseConnection()

		JSONObject.fromObject( r )
	}
}
