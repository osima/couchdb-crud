package jp.osima.couchdb.crud

import net.sf.json.*

import org.apache.commons.httpclient.*
import org.apache.commons.httpclient.methods.*


class CreateDb extends DbBase {

	JSONObject process(){

		def myurl = new URL(baseUrl)

		def hc = new HttpClient()
		def method = new MyPutMethod( myurl.toString(), encoding )
		hc.executeMethod( method )

		def r = method.getResponseBodyAsString()
		
		method.releaseConnection()

		JSONObject.fromObject( r )
	}
}
