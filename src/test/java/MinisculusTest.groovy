public class MinisculusTest extends GroovyTestCase {

    def FIRST_REFERENCE_URL = '/questions/14f7ca5f6ff1a5afb9032aa5e533ad95.html'
    def SECOND_REFERENCE_URL = '/questions/2077f244def8a70e5ea758bd8352fcd8.html'
    def THIRD_REFERENCE_URL = '/questions/36d80eb0c50b49a509b49f2424e8c805.html'
    def FOURTH_REFERENCE_URL = '/questions/4baecf8ca3f98dc13eeecbac263cd3ed.html'
    def FIFTH_REFERENCE_URL = '/finish/50763edaa9d9bd2a9516280e9044d885.html'

    def FIRST_QUESTION_LOCATION = '/14f7ca5f6ff1a5afb9032aa5e533ad95'
    def SECOND_QUESTION_LOCATION = '/2077f244def8a70e5ea758bd8352fcd8'
    def THIRD_QUESTION_LOCATION = '/36d80eb0c50b49a509b49f2424e8c805'
    def FOURTH_QUESTION_LOCATION = '/4baecf8ca3f98dc13eeecbac263cd3ed'

    def FIRST_QUESTION = 'Strong NE Winds!'
    def SECOND_QUESTION = 'The Desert Fox will move 30 tanks to Calais at dawn'
    def THIRD_QUESTION = 'The white cliffs of Alghero are visible at night'
    def FOURTH_QUESTION = 'WZyDsL3u\'0TfxP06RtSSF \'DbzhdyFIAu2 zF f5KE"SOQTNA8A"NCKPOKG5D9GSQE\'M86IGFMKE6\'K4pEVPK!bv83I'

    def FINAL_QUESTION_CODE = 'QT4e8MJYVhkls.27BL9,.MSqYSi\'IUpAJKWg9Ul9p4o8oUoGy\'ITd4d0AJVsLQp4kKJB2rz4dxfahwUa"' +
            'Wa.MS!k4hs2yY3k8ymnla.MOTxJ6wBM7sC0srXmyAAMl9t"Wk4hs2yYTtH0vwUZp4a"WhB2u,o6.!8Zt"Wf,,eh5tk8WXv9UoM99w2Vr4!' +
            '.xqA,5MSpWl9p4kJ2oUg\'6evkEiQhC\'d5d4k0qA\'24nEqhtAQmy37il9p4o8vdoVr!xWSkEDn?,iZpw24kF"fhGJZMI8nkI'

    def minisculus = new Minisculus()

    void 'test 01: Request first question'() {
        def response = minisculus.requestQuestion FIRST_QUESTION_LOCATION
        checkResponse response, FIRST_REFERENCE_URL, FIRST_QUESTION
    }

    void 'test 02: Answer first question'() {
        def answer = new MarkI(wheelPosition: 6).encode FIRST_QUESTION
        def response = minisculus.answerQuestion FIRST_QUESTION_LOCATION, answer
        checkResponse response, SECOND_REFERENCE_URL, SECOND_QUESTION
    }

    void 'test 03: Request second question'() {
        def response = minisculus.requestQuestion SECOND_QUESTION_LOCATION
        checkResponse response, SECOND_REFERENCE_URL, SECOND_QUESTION
    }

    void 'test 04: Answer second question'() {
        def answer = new MarkII(wheelPosition: 9, wheel2Position: 3).encode SECOND_QUESTION
        def response = minisculus.answerQuestion SECOND_QUESTION_LOCATION, answer
        checkResponse response, THIRD_REFERENCE_URL, THIRD_QUESTION
    }

    void 'test 05: Request third question'() {
        def response = minisculus.requestQuestion THIRD_QUESTION_LOCATION
        checkResponse response, THIRD_REFERENCE_URL, THIRD_QUESTION
    }

    void 'test 06: Answer third question'() {
        def answer = new MarkIV(wheelPosition: 4, wheel2Position: 7).encode THIRD_QUESTION
        def response = minisculus.answerQuestion THIRD_QUESTION_LOCATION, answer
        checkResponse response, FOURTH_REFERENCE_URL, FOURTH_QUESTION
    }

    void 'test 07: Request fourth question'() {
        def response = minisculus.requestQuestion FOURTH_QUESTION_LOCATION
        checkResponse response, FOURTH_REFERENCE_URL, FOURTH_QUESTION
    }

    void 'test 08: Answer fourth question'() {
        def answer = new MarkIV(wheelPosition: 7, wheel2Position: 2).decode FOURTH_QUESTION
        def response = minisculus.answerQuestion FOURTH_QUESTION_LOCATION, answer
        checkResponse response, FIFTH_REFERENCE_URL, null
    }

    def checkResponse(response, referenceUrl, question) {
        assert 200 == response.status
        assert referenceUrl == response.referenceUrl
        assert question == response.question
    }
}
