package com.zhuzru.junit;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * 功能描述：通过TestSuite执行测试用例
 *
 * @Date 2023/11/19 15:27
 * @Created by zhuzru
 */
public class ExecuteTestByTestSuite {
    public static Test suite(){
        TestSuite testSuite = new TestSuite("execute test!");
        testSuite.addTestSuite(ExecuteTestByTestCase.class);
        return testSuite;
    }
}
