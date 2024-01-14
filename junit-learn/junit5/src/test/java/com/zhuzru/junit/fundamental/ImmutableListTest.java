package com.zhuzru.junit.fundamental;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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
        // 测试是否抛出异常
        Assertions.assertThrows(UnsupportedOperationException.class, executable);
    }

    //    @Disabled("disabled due to one of assertion failure")
    @DisplayName("[the immutable list only support read operation]")
    @Test
    void immutableListCouldBeReadButUpdate() {
        // 测试多个断言中是否抛出异常
        Assertions.assertAll("assert read and update mixed", Stream.of(
                () -> Assertions.assertEquals("JAVA", list.remove(0)),
                () -> Assertions.assertEquals("C++", list.remove(1)),
                () -> Assertions.assertEquals("Python", list.get(2))
        ));
    }

    // 通过@RepeatedTest注解，测试重复执行
    @RepeatedTest(3)
    void repeatTest() {
        System.out.println("execute test");
        Assertions.assertTrue(list.contains("JAVA"));
    }

    // 结合@RepeatedTest和RepetitionInfo，根据index设置期望值，测试重复执行时取不同的期望值
    @RepeatedTest(3)
    void repeatTestWithIndex(RepetitionInfo repetitionInfo) {
        // given
        String element = "";
        switch (repetitionInfo.getCurrentRepetition()) {
            case 1:
                element = "JAVA";
                break;
            case 2:
                element = "C++";
                break;
            case 3:
                element = "Python";
                break;
            default:
                element = "N/A";
                break;
        }
        // when
        String actual = list.get(repetitionInfo.getCurrentRepetition() - 1);
        // then
        Assertions.assertEquals(element, actual);
    }

    // @DisplayName设置测试时的名称
    // 结合@RepeatedTest和RepetitionInfo，根据index设置期望值，测试重复执行时取不同的期望值
    @DisplayName("repeat assert immutable list element ==>")
    @RepeatedTest(value = 3, name = "{displayName}: {currentRepetition}/{totalRepetitions}")
    void repeatTestWithIndexAndDetailsInformation(RepetitionInfo repetitionInfo) {
        // given
        String element = "";
        switch (repetitionInfo.getCurrentRepetition()) {
            case 1:
                element = "JAVA";
                break;
            case 2:
                element = "C++";
                break;
            case 3:
                element = "Python";
                break;
            default:
                element = "N/A";
                break;
        }
        // when
        String actual = list.get(repetitionInfo.getCurrentRepetition() - 1);
        // then
        Assertions.assertEquals(element, actual);
    }

    // @DisplayName设置测试时的名称
    // 结合@RepeatedTest和RepetitionInfo，根据index设置期望值，测试重复执行时取不同的期望值
    @DisplayName("repeat assert immutable list element")
    @RepeatedTest(value = 3, name = RepeatedTest.LONG_DISPLAY_NAME)
    void repeatTestWithLongDisplayName(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        Assertions.assertEquals(String.format("repeat assert immutable list element :: repetition %d of %d",
                repetitionInfo.getCurrentRepetition(), repetitionInfo.getTotalRepetitions()), testInfo.getDisplayName());
    }
}
