package org.notehub.couchdb.crud

import net.sf.json.*

import org.apache.commons.httpclient.*
import org.apache.commons.httpclient.methods.*


class GetAllDbs extends Base {

	JSONArray process(){

		def myurl = new URL("${baseUrl}/_all_dbs")

		def hc = new HttpClient()
		def method = new GetMethod( myurl.toString() )
		hc.executeMethod( method )

		def reader = new InputStreamReader( method.getResponseBodyAsStream(), encoding )
		def r = reader.text
		reader.close()

		method.releaseConnection()

		JSONArray.fromObject( r )
	}
}
