class MarkTest extends GroovyTestCase {

    void 'test 01: Encode with MarkI letter a with wheel position 5'() {
        def answer = new MarkI(wheelPosition: 5).encode('a')
        assert 'f' == answer
    }

    void 'test 02: Encode with MarkI letter c with wheel position 5'() {
        def answer = new MarkI(wheelPosition: 5).encode('c')
        assert 'h' == answer
    }
}
