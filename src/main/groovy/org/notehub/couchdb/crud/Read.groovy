package org.notehub.couchdb.crud

import net.sf.json.*

//import org.apache.commons.httpclient.*
//import org.apache.commons.httpclient.methods.*

class Read extends DocBase {

	JSONObject process(){

		def reader = new URL("${baseUrl}/${documentId}").newReader(encoding)
		def r = reader.text
		reader.close()

		JSONObject.fromObject( r )
	}
}

