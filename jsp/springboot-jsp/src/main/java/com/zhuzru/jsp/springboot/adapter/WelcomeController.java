package com.zhuzru.jsp.springboot.adapter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * 功能描述：
 *
 * @Date 2025/12/6 11:15
 * @Created by zhuzru
 */
@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    public String handleWelcome(Model model) {
        // 1. 将数据放入Model，这些数据将在JSP页面中通过EL表达式${...} 访问
        model.addAttribute("message", "这是 Spring Boot 传递的动态数据！");
        List<String> tasks = Arrays.asList("学习 Spring Boot", "理解 JSP 原理", "开始重构项目");
        model.addAttribute("tasks", tasks);

        // 2. 返回逻辑视图名 "welcome"
        // 视图解析器会将其解析为/WEB-INF/jsp/welcome.jsp
        return "welcome";
    }
}
