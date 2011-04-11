package org.notehub.couchdb.crud

import net.sf.json.*

import org.apache.commons.httpclient.*
import org.apache.commons.httpclient.methods.*


class GetAllDocs extends Base {

	JSONObject process(){

		def myurl = new URL("${baseUrl}/_all_docs")

		def hc = new HttpClient()
		def method = new GetMethod( myurl.toString() )
		hc.executeMethod( method )

		def reader = new InputStreamReader( method.getResponseBodyAsStream(), encoding )
		def r = reader.text
		reader.close()

		//def r = method.getResponseBodyAsString()
		
		method.releaseConnection()

		JSONObject.fromObject( r )
	}
}
