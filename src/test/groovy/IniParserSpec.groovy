import spock.lang.*;
import org.benignbala.iniparser.IniParser;

class IniParserSpec extends spock.lang.Specification {
  def ini = new IniParser("/tmp/test.ini")

  def "Check constructor loads the config"() {
    when:
    def config = ini.getConfig()
    then:
    config['top'] != null
    config['next'] != null
  }

  def "Check all sections are loaded"() {
    when:
    def config = ini.getAllSections()
    then:
    config.size() == 2
  }
}
