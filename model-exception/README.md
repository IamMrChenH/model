[TOC]

# 统一异常信息——模块

拦截全局异常，并指定格式输出.

| 名称                  | 状态码  | 备注      |
| ------------------- | ---- | ------- |
| Throwable           | 500  | 内部异常    |
| BaseException       |      | 基础异常类   |
| BadRequestException | 400  | 请求数据错误  |
| NotFoundException   | 404  | 请求资源不存在 |

> 示例: {"time":1571753104371,"code":"error"}

PS: **resources/META-INF/spring.factories** 文件是必须存在的，
否则无法通过SpringBooot加载模块的时候载入服务中.

例:
spring.factories
> org.springframework.boot.autoconfigure.EnableAutoConfiguration=\ExceptionConfiguration

以下为上述加载类
```java
@ComponentScan
@Configuration
public class ExceptionConfiguration {
}
```