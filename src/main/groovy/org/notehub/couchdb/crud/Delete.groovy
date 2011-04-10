package org.notehub.couchdb.crud

import net.sf.json.*

import org.apache.commons.httpclient.*
import org.apache.commons.httpclient.methods.*


class Delete {

	String dbname 
	String documentId 
	String revision

	JSONObject proc(){
		def r = null
		def myurl = new URL("http://localhost:5984/${dbname}/${documentId}")
		
		def hc = new HttpClient()
		def method = new DeleteMethod( myurl.toString() )
		method.setQueryString( new NameValuePair('rev',"${revision}" ) )
		hc.executeMethod( method )

		r = method.getResponseBodyAsString()
		
		method.releaseConnection()

		JSONObject.fromObject( r )
	}
}

