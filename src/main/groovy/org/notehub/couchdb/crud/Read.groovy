package org.notehub.couchdb.crud

import net.sf.json.*

import org.apache.commons.httpclient.*
import org.apache.commons.httpclient.methods.*

class Read extends CrudBase {

	//String documentId

	JSONObject process(){

		def reader = new URL("${baseUrl}/${documentId}").newReader('UTF-8')
		def r = reader.text
		reader.close()

		JSONObject.fromObject( r )
	}
}

