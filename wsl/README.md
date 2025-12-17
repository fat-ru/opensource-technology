
  * [定义](#定义)
  * [分类](#分类)
  * [WSL安装](#wsl安装)
  * [WSL1增强](#wsl1增强)


## 定义

WSL：Windows subSystem for Linux  
WSL是Windows操作系统的一个可选子系统，用于在不依赖传统虚拟机或双系统的前提下，在Windows环境中运行Linux用户空间。

> 核心目标：  
> 在Windows上原生支持Linux开发、构建和运行环境，同时保持与Windows的高度集成  

## 分类

WSL有WSL1和WSL2两个版本，WSL1提供系统调用级兼容，WSL2提供内核级一致性。

|对比维度|WSL1|WSL2|
|---|---|---|
|Linux内核|无|有（微软维护的官方Linux Kernel）|
|系统调用|兼容性实现|原生Linux syscall|
|Docker|不支持|原生支持|
|Kubernetes|不支持|支持|
|systemd|不支持|支持|
|内核模块|不支持|有限支持|

WSL1更适用于Linux学习、基础命令执行等简单操作。  
WSL2可用于后端开发、编译、容器部署等。


## WSL安装  

- 开启底座能力

命令方式：管理员打开命令提示符窗口  
```shell script
# 打开Linux子系统能力
dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart
# 打开支撑WSL2的虚拟化平台
dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart
```

图形界面设置：  
> 控制面板 -> 程序 -> 启用或关闭Windows功能

![](images\WSL开启.jpg)

- 设置WSL2为默认版本

```shell script
wsl --set-default-version 2
```

- 安装Linux发行版

```shell script
wsl --install -d Ubuntu
```

- 启动Ubuntu


- 确认WSL版本

```shell script
wsl -l -v
```

如果VERSION不是2，则需要升级版本。
```shell script
wsl --set-version Ubuntu 2
```

升级WSL版本报错：  

![](images\WSL设置版本报错.jpg)

**问题定位**

未打开虚拟化=>进入BIOS，设置虚拟化选项为Enable  
> Intel CPU的虚拟化选项：  
> Intel Virtualization Technology  
> ntel VT-x  
> VT-d  
> AMD CPU的虚拟化选项：  
> SVM Mode  
> AMD-V  

如果BIOS中没有以上虚拟化选项，则表明CPU不支持虚拟化。无法升级到WSL2。


## WSL1增强  

在不支持WSL2的情况下，WSL1+少量增强+远程/容器是一种最佳的方案

- 基础开发环境  

```shell script
# 更新软件清单
sudo apt update
# 安装开发基础工具
sudo apt install -y \
  build-essential \
  curl wget git unzip zip \
  ca-certificates \
  vim nano \
  net-tools iputils-ping \
  htop
```

- 增强Shell

将zsh设置为shell默认工具  
```shell script
# 安装zsh工具
sudo apt install -y zsh

# 安装ohmyzsh工具
sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)"
```

- systemd替代方案

WSL1没有systemd，安装tmux和supervisord，使用shell脚本托管服务。  

```shell script
sudo apt install -y supervisor tmux
```

- 服务运行解决方案  

解决不能后台服务的问题

编辑配置文件：  
```shell script
[program:myapp]
command=java -jar app.jar
autostart=true
autorestart=true
```

执行命令：  

```shell script
sudo supervisord -c /etc/supervisor/supervisord.conf
```
