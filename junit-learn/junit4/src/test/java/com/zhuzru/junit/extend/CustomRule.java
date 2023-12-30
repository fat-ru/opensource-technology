package com.zhuzru.junit.extend;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * 功能描述：
 *
 * @Date 2023/11/1 23:53
 * @Created by zhuzru
 */
public class CustomRule implements TestRule {
    // TODO: 自定义Rule
    @Override
    public Statement apply(Statement statement, Description description) {
        return null;
    }
}
