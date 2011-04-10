package org.notehub.couchdb.crud

import org.apache.commons.httpclient.methods.PutMethod

class MyPutMethod extends PutMethod {
	def MyPutMethod(String uri){ super(uri) }
	String getRequestCharSet() { 'UTF-8' }
}
