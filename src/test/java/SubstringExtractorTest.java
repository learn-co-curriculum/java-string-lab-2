import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubstringExtractorTest {

    @Test
    public void test0() {
        assertEquals("", SubstringExtractor.extractH1Content("<body><p>Hello World</p></body>"));
    }

    @Test
    public void test1() {
        assertEquals("", SubstringExtractor.extractH1Content("<body><h1>Greetings!</body>"));
    }

    @Test
    public void test2() {
        assertEquals("Hello World", SubstringExtractor.extractH1Content("<body><h1>Hello World</h1></body>"));
    }

    @Test
    public void test3() {
        assertEquals("Howdy", SubstringExtractor.extractH1Content("<body></h1><h1>Howdy</h1></body>"));
    }

    @Test
    public void test4() {
        assertEquals("Greetings!", SubstringExtractor.extractH1Content("<body><H1>Greetings!</H1></body>"));
    }

}