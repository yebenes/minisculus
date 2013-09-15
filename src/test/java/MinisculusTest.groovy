public class MinisculusTest extends GroovyTestCase {

    def FIRST_REFERENCE_URL = '/questions/14f7ca5f6ff1a5afb9032aa5e533ad95.html'
    def SECOND_REFERENCE_URL = '/questions/2077f244def8a70e5ea758bd8352fcd8.html'
    def THIRD_REFERENCE_URL = ''
    def FOURTH_REFERENCE_URL = ''
    def FIFTH_REFERENCE_URL = ''

    def FIRST_QUESTION_LOCATION = '/14f7ca5f6ff1a5afb9032aa5e533ad95'
    def SECOND_QUESTION_LOCATION = '/2077f244def8a70e5ea758bd8352fcd8'
    def THIRD_QUESTION_LOCATION = ''
    def FOURTH_QUESTION_LOCATION = ''
    def FIFTH_QUESTION_LOCATION = ''

    def FIRST_QUESTION = 'Strong NE Winds!'
    def SECOND_QUESTION = 'The Desert Fox will move 30 tanks to Calais at dawn'
    def THIRD_QUESTION = ''
    def FOURTH_QUESTION = ''
    def FIFTH_QUESTION = ''


    Minisculus minisculus = new Minisculus()

    void 'test 01: Request first question'() {
        def response = minisculus.requestQuestion FIRST_QUESTION_LOCATION
        checkResponse response, FIRST_REFERENCE_URL, FIRST_QUESTION
    }

    void 'test 02: Answer first question'() {
        def answer = new MarkI(wheelPosition: 6).encode(FIRST_QUESTION)
        def response = minisculus.answerQuestion(FIRST_QUESTION_LOCATION, answer)
        checkResponse response, SECOND_REFERENCE_URL, SECOND_QUESTION
    }

    void 'test 03: Request second question'() {
        def response = minisculus.requestQuestion SECOND_QUESTION_LOCATION
        checkResponse response, SECOND_REFERENCE_URL, SECOND_QUESTION
    }

    def checkResponse(response, referenceUrl, question) {
        assert 200 == response.status
        assert referenceUrl == response.referenceUrl
        assert question == response.question
    }
}
