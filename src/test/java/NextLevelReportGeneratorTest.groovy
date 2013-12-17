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
}

