import spock.lang.*

class SimpleTest extends Specification {
    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }
}