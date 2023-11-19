## Junit4概述

#### 1、Junit4和Junit3的主要特性区别
   ![junit4与junit3对比](src/main/resources/junit4与junit3对比.jpg)
   
#### 2、Junit4扩展特性
   - Runner管理测试生命周期
   - Rule
   
#### 3、发起Junit4测试的方法
   - @Test注解
   - @RunWith + @Suite.SuiteClasses
     - 执行顺序不符合预期
     - setUp -> test -> tearDown -> destroy -> init