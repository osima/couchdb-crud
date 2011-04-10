package org.notehub.couchdb.crud

import net.sf.json.*

import org.apache.commons.httpclient.*
import org.apache.commons.httpclient.methods.*

class Read {

	String dbname
	String documentId

	JSONObject proc(){

		def r = null

		def myurl = new URL("http://localhost:5984/${dbname}/${documentId}")
		def reader = myurl.newReader('UTF-8')
		r = reader.text
		reader.close()

		JSONObject.fromObject( r )
	}
}

