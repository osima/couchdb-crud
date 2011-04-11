
# couchdb-crud 

This is a Simple CRUD library for CouchDB in groovy.


## code example

You can manipulate database like this ...


    import net.sf.json.JSONObject

    db = new CouchDb( dbname:'testdb' )

    // 1)
    db.createDatabase()

    // 2)
    docId = '1'
    json = JSONObject.fromObject('{"title":"Hello CouchDb!"}')
    db.createDocument(docId,json)

    assertTrue( db.readDocument(docId).get('title') == 'Hello CouchDb!' )

    // 3)
    json = JSONObject.fromObject('{"title":"Hello again CouchDb!"}')
    db.updateDocument(docId,json)

    assertTrue( db.readDocument(docId).get('title') == 'Hello again CouchDb!' )

    // 4)
    db.deleteDocument(docId)

    // 5)
    db.deleteDatabase()



