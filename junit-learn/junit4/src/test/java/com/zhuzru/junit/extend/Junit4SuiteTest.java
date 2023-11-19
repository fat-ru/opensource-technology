package com.zhuzru.junit.extend;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 功能描述：
 *
 * @Date 2023/11/19 20:56
 * @Created by zhuzru
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(Junit4StandardTest.class)
public class Junit4SuiteTest {
    // 执行顺序有问题！
    // setUp -> test -> tearDown -> destroy -> init
}
