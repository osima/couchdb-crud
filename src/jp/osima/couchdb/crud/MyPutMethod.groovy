package jp.osima.couchdb.crud

import org.apache.commons.httpclient.methods.PutMethod

class MyPutMethod extends PutMethod {

	private String encoding
	def MyPutMethod(String uri,String encoding){
		super(uri)
		this.encoding=encoding
	}
	String getRequestCharSet() { encoding } //'UTF-8' }
}
