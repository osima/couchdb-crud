
import groovy.util.GroovyTestCase

class MyTest extends GroovyTestCase {
    void testString(){
        String a = 'hello'
        String b = 'hello'
        assertEquals('message',a,b)
    }
}

