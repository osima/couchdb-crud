package org.notehub.couchdb.crud

import net.sf.json.*

import org.apache.commons.httpclient.*
import org.apache.commons.httpclient.methods.*


class DeleteDb extends Base {

	JSONObject process(){

		def myurl = new URL(baseUrl)
		
		def hc = new HttpClient()
		def method = new DeleteMethod( myurl.toString() )
		hc.executeMethod( method )

		def r = method.getResponseBodyAsString()
		
		method.releaseConnection()

		JSONObject.fromObject( r )
	}
}

