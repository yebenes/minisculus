import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.PUT
import static groovyx.net.http.ContentType.JSON

class Minisculus {

    def http = new HTTPBuilder('http://minisculuschallenge.com')

    def requestQuestion(path) {
        http.get(path: path) {
            response, json ->
                [status: response.status, question: json['question'], referenceUrl: json['reference-url']]
        }
    }

    def answerQuestion(path, answer) {
        http.request(PUT, JSON) { request ->
            uri.path = path
            body = ['answer' : answer]

            response.success = { response, json ->
                [status: response.status, question: json['question'], referenceUrl: json['reference-url'], code: json['code']]
            }
        }
    }
}
