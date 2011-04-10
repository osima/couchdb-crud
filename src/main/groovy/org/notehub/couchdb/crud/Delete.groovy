package org.notehub.couchdb.crud

import net.sf.json.*

import org.apache.commons.httpclient.*
import org.apache.commons.httpclient.methods.*


class Delete extends CrudBase {

	//String documentId 

	String revision

	JSONObject process(){

		def myurl = new URL("${baseUrl}/${documentId}")
		
		def hc = new HttpClient()
		def method = new DeleteMethod( myurl.toString() )
		method.setQueryString( new NameValuePair('rev',"${revision}" ) )
		hc.executeMethod( method )

		def r = method.getResponseBodyAsString()
		
		method.releaseConnection()

		JSONObject.fromObject( r )
	}
}

