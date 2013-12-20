//add this script inside the source tag of gmaven plugin(refer to this project pom) to generate index.html containing
// individual link to generated spec report
package custom

import groovy.io.FileType
import groovy.xml.MarkupBuilder

def specsDirectory = new File("${project.build.directory}/next-level-spock-reports")
if(!specsDirectory.exists()){
    println("Directory ${project.build.directory}/next-level-spock-reports does not exists. Reports will not be generated")
    return
}

new File("${project.build.directory}/next-level-spock-reports/index.html").withWriter { writer ->
    new MarkupBuilder(writer).html {
        head {
            title("Results index")
        }
        body {
            ul {

                specsDirectory.eachFileRecurse (FileType.FILES) {file->
                    //escape && as &amp;&amp; when using in maven pom
                    if(file.name.toLowerCase().endsWith("html") && !file.name.toLowerCase().endsWith("index.html")){
                        li {
                            a(href: file.name, file.name.replaceAll("(\\.(\\w+)\$)",""))
                        }
                    }

                }
            }
        }
    }
}