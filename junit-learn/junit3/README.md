## Junit3概述

#### 1、开发背景
   - junit3是基于java1.1及之后的版本开发的；
   - 未采用annotation发起测试，因为annotation在jdk5中才出现；
   - junit是从1995年开始开发，jdk是从1996年开始开发，所以junit最早开发时可能是和jdk同步开发，或者基于jdk内部版本进行开发。
   
#### 2、发起测试方法
   - 继承TestCse类
   - 定义TestSuite，定义suite方法
   
#### 3、测试用例注意事项
   - 测试方法必须以test开头
   - 可重写setUp方法和tearDown方法