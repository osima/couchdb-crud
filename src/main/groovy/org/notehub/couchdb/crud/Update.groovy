package org.notehub.couchdb.crud

import net.sf.json.*

import org.apache.commons.httpclient.*
import org.apache.commons.httpclient.methods.*

class Update extends CrudBase {

	//String documentId

	String revision
	JSONObject json

	JSONObject process(){

		def myurl = new URL("${baseUrl}/${documentId}")
		
		def hc = new HttpClient()
		def method = new MyPutMethod( myurl.toString(),encoding )

		json.put( '_rev', revision )
		method.setRequestBody( json.toString() )

		hc.executeMethod( method )
		def r = method.getResponseBodyAsString()
		
		method.releaseConnection()

		JSONObject.fromObject( r )
	}
}
