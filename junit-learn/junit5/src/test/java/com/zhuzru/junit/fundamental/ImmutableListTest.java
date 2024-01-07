package com.zhuzru.junit.fundamental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 功能描述：
 *
 * @Date 2024/1/7 22:19
 * @Created by zhuzru
 */
@DisplayName("<The unit test for unmodified List features>")
class ImmutableListTest {
    List<String> list = Collections.unmodifiableList(new ArrayList<>(Arrays.asList("JAVA", "C++", "Python")));

    @DisplayName("[the list size should be three]")
    @Test
    void listSizeShouldEqualsThree() {
        // give
        // when
        int size = list.size();
        // then
        Assertions.assertEquals(3, size);
    }

    @DisplayName("[the list should contains 'JAVA']")
    @Test
    void listShouldContainsElement() {
        // given
        final String element = "JAVA";
        // when
        boolean exist = list.contains(element);
        // then
        Assertions.assertTrue(exist);
    }

    @DisplayName("[the immutable list only support read operation]")
    @Test
    void immutableListCouldNotUpdate() {
        // given
        int index = 0;
        String expected = "JAVA";
        // when
        Executable executable = () -> {
            String removedElement = list.remove(index);
            Assertions.assertEquals(expected, removedElement);
        };
        // then
        Assertions.assertThrows(UnsupportedOperationException.class, executable);
    }
}
