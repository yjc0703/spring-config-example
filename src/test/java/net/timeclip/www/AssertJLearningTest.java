package net.timeclip.www;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class AssertJLearningTest {
    
    @Test
    public void stringTest() {
        String string = "hello, world. my nickname is timeclip. nice to meet you.";
        
        assertThat(string)
            .isNotEmpty()
            .isInstanceOf(String.class)
            .isNotEqualTo("superman")
            .isNotIn("date")
            .isNotInstanceOf(Integer.class)
            .isNotNull()
            .containsSequence("time")
            .containsOnlyOnce(",")
            .doesNotContain("shit")
            .doesNotStartWith("world")
            .hasLineCount(1)
            .hasSameClassAs(new String("test"))
            .startsWith("hello");
    }
    
    @Test
    public void listTest() {

        List<String> list = Arrays.asList("장동건", "정우성", "원빈", "주원", "강동원", "조인성");
        
        assertThat(list)
            .doesNotContain("윤재철")
            .doesNotContainNull()
            .hasSize(6)
            .hasOnlyElementsOfType(String.class);
    }

}
