abstract class Mark {

    def ENCODER_WHEEL = [ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '.', ',', '?', '!', "'", '"', ' ']

    def wheelPosition

    def encode(question) {
        def answer = ''
        question.each { character ->
            def characterIndex = ENCODER_WHEEL.indexOf(character)
            def position = (characterIndex + getWheelsMovement(characterIndex)) % ENCODER_WHEEL.size()
            answer += ENCODER_WHEEL[position]
        }
        answer
    }

    abstract getWheelsMovement(characterIndex);
}

class MarkI extends Mark {

    def getWheelsMovement(characterIndex) {
        wheelPosition
    }
}

class MarkII extends Mark {

    def wheel2Position

    def getWheelsMovement(characterIndex) {
        wheelPosition - wheel2Position * 2
    }
}

class MarkIV extends MarkII {

    def wheel3Position = 0

    def getWheelsMovement(characterIndex) {
        def encodeIndex = super.getWheelsMovement(characterIndex) + wheel3Position * 2
        wheel3Position = characterIndex
        encodeIndex
    }
}
