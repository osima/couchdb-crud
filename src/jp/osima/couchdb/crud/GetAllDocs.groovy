package jp.osima.couchdb.crud

import net.sf.json.*

import org.apache.commons.httpclient.*
import org.apache.commons.httpclient.methods.*


class GetAllDocs extends DbBase {

	JSONObject process(){

		def myurl = new URL("${baseUrl}/_all_docs")

		def hc = new HttpClient()
		def method = new GetMethod( myurl.toString() )
		hc.executeMethod( method )

		def reader = new InputStreamReader( method.getResponseBodyAsStream(), encoding )
		def r = reader.text
		reader.close()

		method.releaseConnection()

		JSONObject.fromObject( r )
	}
}
