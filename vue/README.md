
## 一、基础知识

### 1.1 DOM

- 定义  

DOM（Document Object Model）：文档对象模型  
DOM是一种抽象结构，浏览器把HTML转成的可被JavaScript操作的“对象树”

开发者工具（F12）中的“元素”面板，本质就是实时DOM的可视化呈现。

- dom基本操作

**获取元素**

```javascript
const title = document.getElementById("myTitle");
const items = document.querySelectorAll(".item");
```

**修改内容**

```javascript
title.textContent = "新的标题";
```

**修改样式**

```javascript
title.style.color = "red";
```

**添加元素**

```javascript
const div = document.createElement("div");
div.textContent = "Hello";
document.body.appendChild(div);
```

**删除元素**

```javascript
title.remove();
```

### Pinia  

Pinia是Vue3官方推荐的状态管理库（Vuex的升级版）  
类似后端的全局状态/缓存上下文

### TypeScript & JavaScript

|特性|JavaScript|TypeScript|
|---|---|---|
|类型|动态类型|静态类型（可选类型注解）|
|编译|不需要编译，浏览器直接执行|需要编译为JS后才能执行|
|ES支持|取决于浏览器|TS可以提前使用最新ES特性，通过编译兼容旧浏览器|
|错误检查|运行时报错|编译阶段报错|

TypeScript是JavaScript的超集，在JS的基础上增加类型系统和编译时检查。  
JS写的代码基本能直接在TS中运行。

## 二、Vue3核心原理  

### 2.1 响应式（Reactivity）  

Vue监听数据变化，UI自动更新。


### 2.2 虚拟DOM（Virtual DOM）  

Vue不直接操作DOM，而是维护一套内存中的虚拟树结构，实现更快的Diff更新。

### 2.3组件化（Component）  

Vue由组件组成，每个组件包括：  
- 模版（HTML）  
- 状态（JS）  
- 样式（CSS）  




## 前端构建工具  

Vue的前端构建工具一般有：Vue CLI、IDEA Node.js Vue模版、Vite  
此三种构建工具的差异如下：  

|工具|启动速度|Vue3支持|默认构建方案|是否官方支持|
|---|---|---|---|---|
|Vue CLI|慢|支持，体验一般|Webpack|否|
|IDEA Node.js Vue模版|慢|可能不完整|Webpack|否|
|Vite|极快|完整支持Vue3|EsBuild+Rollup|是|

## Vue工程搭建  

### 安装Node.js  

Node.js：JavaScript后端运行环境（浏览器运行Vue不需要Node）  
Npm：Node.js的包管理器  
安装Node时会自动安装npm，安装后检查版本  

```shell script
node -v
npm -v
```

### 运行脚手架  

启动官方的脚手架工具create-vue，并根据引导选择一系列参数。

```shell script
npm create vue@latest
```

- **【问题1】**：脚手架工具创建报错

![](images\脚手架工具创建失败.jpg)

**问题定位**

node.js版本低于v16，不支持parseArgs。

**解决方法**

升级node.js到v18

### 安装依赖

```shell script
cd vue/vue3/vue-test

npm install
```

### 启动开发服务器

使用Vite启动开发服务器
```shell script
npm run dev
```

服务启动后，访问`http://localhost:5173/`即可看到Vite默认页面。  


### 工程目录解析  

- .vscode/  

VS Code工作区设置，通常用来保存团队开发的编辑器规范

- node_modules  

npm安装的依赖包目录，通过package.json管理，该目录一般很大，不纳入版本控制，通过.gitignore文件排除。

- package.json

定义项目元信息、依赖、脚本，运行`npm run dev`命令即是执行脚本中对应的命令。

```javascript
{
  <!-- 项目信息 -->
  "name": "vue-test",
  "version": "0.0.0",
  "private": true,
  <!-- 项目信息 -->
  // 默认使用ES Build作为打包器和构建工具
  "type": "module",
  // Node.js版本约束
  "engines": {
    "node": "^20.19.0 || >=22.12.0"
  },
  // npm run命令组合
  "scripts": {
    // 启动开发服务器、热更新
    "dev": "vite",
    // 构建：并行执行、ts类型检查、真正打包
    "build": "run-p type-check \"build-only {@}\" --",
    // 启动本地服务器查询构建产物的效果
    "preview": "vite preview",
    // 单元测试
    "test:unit": "vitest",
    // 端到端测试
    "test:e2e": "playwright test",
    "build-only": "vite build",
    "type-check": "vue-tsc --build",
    // 代码质量
    "lint": "eslint . --fix --cache",
    "format": "prettier --write --experimental-cli src/"
  },
  // 运行时依赖，打包后进入浏览器的代码
  "dependencies": {
    "pinia": "^3.0.4",
    "vue": "^3.5.25",
    "vue-router": "^4.6.3"
  },
  // 开发期工具
  "devDependencies": {
    "@playwright/test": "^1.57.0",
    "@tsconfig/node24": "^24.0.3",
    "@types/jsdom": "^27.0.0",
    "@types/node": "^24.10.1",
    "@vitejs/plugin-vue": "^6.0.2",
    "@vitejs/plugin-vue-jsx": "^5.1.2",
    "@vitest/eslint-plugin": "^1.5.0",
    "@vue/eslint-config-prettier": "^10.2.0",
    "@vue/eslint-config-typescript": "^14.6.0",
    "@vue/test-utils": "^2.4.6",
    "@vue/tsconfig": "^0.8.1",
    "eslint": "^9.39.1",
    "eslint-plugin-playwright": "^2.3.0",
    "eslint-plugin-vue": "~10.5.1",
    "jiti": "^2.6.1",
    "jsdom": "^27.2.0",
    "npm-run-all2": "^8.0.4",
    "prettier": "3.6.2",
    "typescript": "~5.9.0",
    "vite": "^7.2.4",
    "vite-plugin-vue-devtools": "^8.0.5",
    "vitest": "^4.0.14",
    "vue-tsc": "^3.1.5"
  }
}
```

- package-lock.json

锁文件，锁定依赖树的精确版本，保证可复现安装，提交到版本库。

- editorconfig

编辑器统一格式化约定

- vite.config.ts

Vite的构建与开发服务器配置（端口、proxy、别名、插件），可自定义dev server或修改构建行为

- vitest.config.ts

Vitest（单元测试）配置，设置测试环境、coverage、alias等

- tsconfig.json

基础/共享配置  

- tsconfig.app.json

用于应用源码的特定配置（编译范围、路径别名）

- tsconfig.node.json

Node环境下脚本/构建工具使用（例如vite插件、构建脚本）  

- tsconfig.vitest.json

单元测试（vitest）特有的tsconfig，设置测试文件类型、globals等

- eslint.config.ts

ESLint配置文件（规则、插件、解析器），用于代码质量检查、风格统一，可与Prettier联动。

- .prettierrc.json

Prettier的格式化配置（缩进、行宽等）

- playwright.config.js

Playwright的端到端测试配置（浏览器、测试目录、timeout等）。
如果项目集成e2e，在playwright.config.js中进行配置并在package.json中添加e2e脚本。

- index.html

Vite的HTML入口文件，可以直接在文件中插入meta、外部脚本、站位`div#app`。
Vite会在dev时注入资源并替换环境变量`import.meta.env`

```html
<!-- 告诉浏览器使用HTML5标准模式解析页面 -->  
<!DOCTYPE html>
<!-- 声明HTML文档的语言，默认为空 -->
<html lang="">
  <!-- 页面配置信息 -->
  <head>
    <!-- 采用UTF-8编码方式，预防中文乱码 -->
    <meta charset="UTF-8">
    <!-- 设置浏览器标签页的图标 -->
    <link rel="icon" href="/favicon.ico">
    <!-- 移动端适配（响应式布局），页面在不同屏幕上缩放合理 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 浏览器标签页的标题 -->
    <title>Vite App</title>
  </head>
  <!-- 浏览器显示内容的区域 -->
  <body>
    <!-- Vue应用的挂载点 -->
    <div id="app"></div>
    <!-- 让浏览器直接加载ES Module -->
    <!-- 加载Vue应用入口文件main.ts -->
    <script type="module" src="/src/main.ts"></script>
  </body>
</html>
```

- e2e目录

端到端测试目录（Playwright/Cypress），通常包含测试脚本、配置与fixtures

- public目录

放置静态资源，不会被Vite打包器处理为模块，直接将静态资源文件复制到最终的dist根目录
> favicon.ico
> robots.txt
> 静态图像或第三方静态文件

引用方式永昌用绝对路径`/favicon.ico`，或在HTML中直接使用，对需要被Vite打包的资源应放在`src/assets`中

- src目录

应用源码目录，通常包含应用逻辑、组件、样式、路由、状态

**main.ts**  
应用入口脚本，负责创建Vue app、挂载插件（Router、Pinia、i18n等）  
启动命令`npm run dev`会加载并调用此入口脚本

```javascript
// 从Vue框架导入createApp工厂函数  
// 在Vue3中，应用要通过createApp创建一个应用实例，作为整个前端应用的“容器”、“启动器”。  
import { createApp } from 'vue'
// 引入Pinia的创建方法
import { createPinia } from 'pinia'
// 引入根组件（类似前端根页面）
import App from './App.vue'
// 导入Vue Router实例，整个应用支持页面切换
import router from './router'
// 创建Vue应用实例，并把根组件注册进去
const app = createApp(App)
// 在应用实例中注册Pinia状态管理
app.use(createPinia())
// 在应用实例中注册Vue Router
app.use(router)
// 应用实例挂载到HTML页面中的DOM节点
app.mount('#app')
```


**App.vue**  
根组件，通常包含`<router-view/>`或全局布局，是应用的顶层UI组件。  
整个应用的根节点。  
所有路由页面、组件都嵌套在App.vue下面。  
类似SpringBoot项目中的主Controller或根页面入口。

App.vue是一个单文件组件。  
> Vue组件一般由三部分组成
> 逻辑区域 : <script>
> HTML视图区域：<template>
> 样式区域：<style>


```html
<!-- 使用TypeScript -->
<script setup lang="ts"></script>

<template>
  <h1>You did it!</h1>
  <p>
    <!-- 在文本中添加超链接 -->
    Visit <a href="https://vuejs.org/" target="_blank" rel="noopener">vuejs.org</a> to read the
    documentation
  </p>
</template>
<!-- scoped：样式只对当前组件生肖 -->
<style scoped></style>
```

**router/index.ts**  
Vue Router的配置文件，定义路由表、history模式、路由守卫（导航钩子）等
实现跳转、鉴权、重定向

```javascript
// 从Vue Router官方路由库中导入核心API
// createRouter：创建路由实例，管理URL映射规则，初始化前端路由调度器
// createWebHistory：定义路由模式，即URL的显示方式、支持前进、后退按钮
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  // meta.env.BASE_URL：Vite环境变量，表示应用的基础访问路径
  history: createWebHistory(import.meta.env.BASE_URL),
  // 路由表：URL->组件映射 
  routes: [],
})

// 导出路由实例，供main.ts使用
export default router
```


**stores/counter.ts**  
Pinia/Vuex状态管理目录。
counter.ts通常是示例store（计数器），其中定义state、actions、getters。
Pinia的createPinia()在main.ts中挂载。

```javascript
// ref：定义响应式状态
// computed：定义派生状态（自动计算）
import { ref, computed } from 'vue'
// Pinia提供的定义Store的工厂方法
import { defineStore } from 'pinia'

export const useCounterStore = defineStore('counter', () => {
  // 定义响应式状态，修改count.value，所有使用他的组件自动更新
  const count = ref(0)
  // 定义派生状态，count变化，doubleCount自动重新计算
  const doubleCount = computed(() => count.value * 2)
  // 定义修改状态的方法
  function increment() {
    count.value++
  }

  return { count, doubleCount, increment }
})
```

**_tests_/App.spec.ts**  
单元测试文件，测试组件渲染、方法、行为、store等
由Vitest执行，通常放在靠近被测模块的位置