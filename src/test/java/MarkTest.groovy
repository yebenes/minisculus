class MarkTest extends GroovyTestCase {

    void 'test 01: Encode with MarkI letter a with wheel position 5'() {
        def answer = new MarkI(wheelPosition: 5).encode 'a'
        assert 'f' == answer
    }

    void 'test 02: Encode with MarkI letter c with wheel position 5'() {
        def answer = new MarkI(wheelPosition: 5).encode 'c'
        assert 'h' == answer
    }

    void 'test 03: Encode with MarkII text abc with wheels position 2 and 5'() {
        def answer = new MarkII(wheelPosition: 2, wheel2Position: 5).encode 'abc'
        assert 'STU' == answer
    }

    void 'test 04: Decode with MarkI letter f with wheel position 5'() {
        def answer = new MarkI(wheelPosition: 5).decode 'f'
        assert 'a' == answer
    }

    void 'test 05: Decode with MarkI letter h with wheel position 5'() {
        def answer = new MarkI(wheelPosition: 5).decode 'h'
        assert 'c' == answer
    }

    void 'test 06: Decode with MarkII text STU with wheels position 2 and 5'() {
        def answer = new MarkII(wheelPosition: 2, wheel2Position: 5).decode 'STU'
        assert 'abc' == answer
    }
}
