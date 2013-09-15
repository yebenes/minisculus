abstract class Mark {

    def ENCODER_WHEEL = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '.', ',', '?', '!', "'", '"', ' ']

    def wheelPosition

    def encode(question) {
        def answer = ''
        question.each { character -> answer += ENCODER_WHEEL[getPositionForEncode(character)] }
        answer
    }

    def getPositionForEncode(character) {
        def characterIndex = ENCODER_WHEEL.indexOf character
        def encodePosition = (characterIndex + getWheelsMovement(characterIndex)) % ENCODER_WHEEL.size()
        updateThirdWheelPosition(characterIndex)
        encodePosition
    }

    def decode(question) {
        def answer = ''
        question.each { character -> answer += ENCODER_WHEEL[getPositionForDecode(character)] }
        answer
    }

    def getPositionForDecode(character) {
        def characterIndex = ENCODER_WHEEL.indexOf character
        def decodePosition = (characterIndex - getWheelsMovement(characterIndex)) % ENCODER_WHEEL.size()
        updateThirdWheelPosition(decodePosition)
        decodePosition
    }

    abstract getWheelsMovement(characterIndex);

    def updateThirdWheelPosition(index) {}
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
        super.getWheelsMovement(characterIndex) + wheel3Position * 2
    }

    def updateThirdWheelPosition(index) {
        wheel3Position = index
    }
}

class MarkIVCracker {

    def code, words

    def crack() {
        def wheelsConfigurations = []
        for (wheelPosition in 0..9) {
            for (wheel2Position in 0..9) {
                def message = new MarkIV(wheelPosition: wheelPosition, wheel2Position: wheel2Position).decode code
                if (words.every { word -> message.contains word }) {
                    wheelsConfigurations += [wheelPosition: wheelPosition, wheel2Position: wheel2Position, message: message]
                }
            }
        }
        wheelsConfigurations
    }
}