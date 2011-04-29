package org.notehub.couchdb.crud

import net.sf.json.*

//import org.apache.commons.httpclient.*
//import org.apache.commons.httpclient.methods.*

class Read extends DocBase {

	JSONObject process(){

		try{
			def reader = new URL("${baseUrl}/${documentId}").newReader(encoding)
			def r = reader.text
			reader.close()
	
			return JSONObject.fromObject( r )
		}
		catch(Exception ex){
			return null
		}
	}
}

