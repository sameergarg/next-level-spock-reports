import org.junit.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class NextLevelReportGeneratorTest extends Specification
{
    @Unroll
    def "say hello to #person"()
    {
        given: "you met #person"
        String greeting = "hello"
        and: "and #person is your friend"

        when: "#person says hi"

        then: "you say hello"
        "$greeting $person" == "hello $person"

        where: person << ["sally", "harry"]

    }

    /*@Unroll
    def "don't talk to #person"()
    {
        given: "you met #person"
        String greeting = "hello"
        and: "and #person is a stranger"

        when: "#person says hi"

        then: "remember what your mother says 'don't talk to strangers'"
        "$greeting $person" == ""

        where: person << ["sally", "harry"]

    }*/
}

