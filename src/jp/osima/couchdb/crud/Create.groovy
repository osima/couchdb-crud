package jp.osima.couchdb.crud

import net.sf.json.*

import org.apache.commons.httpclient.*
import org.apache.commons.httpclient.methods.*



class Create extends DocBase {

	JSONObject json

	JSONObject process(){

		def myurl = new URL("${baseUrl}/${documentId}")

		def hc = new HttpClient()
		def method = new MyPutMethod( myurl.toString(), encoding )
		method.setRequestBody( json.toString() )
		hc.executeMethod( method )

		def r = method.getResponseBodyAsString()
		
		method.releaseConnection()

		JSONObject.fromObject( r )
	}
}
