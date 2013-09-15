class Mark {

    def ENCODER_WHEEL = [ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '.', ',', '?', '!', "'", '"', ' ']

    def encode(wheelPosition, question) {
        def answer = ''
        question.each { character ->
            def position = (ENCODER_WHEEL.indexOf(character) + wheelPosition) % ENCODER_WHEEL.size()
            answer += ENCODER_WHEEL[position]
        }
        answer
    }
}

class MarkI extends Mark {

    def wheelPosition

    def encode(question) {
        super.encode(wheelPosition, question)
    }
}
