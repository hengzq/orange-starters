## orange-starter-security

> orange-starter-security 项目是一个基于 Spring Boot Starter Security 构建的安全认证解决方案，它旨在简化安全功能的集成过程。
> 通过提供一套预配置的安全机制，该项目使得开发者能够快速地为他们的应用程序添加用户认证、授权以及常见的安全防护措施，从而有效保护应用免受未授权访问和其他潜在的安全威胁。
> 此外，orange-starter-security 还可能包含了自定义的安全配置选项，以满足特定项目的个性化需求，让开发人员能够在保持高效开发速度的同时，确保应用的安全性达到高标准。

## 自定义配置

| 属性                             | 描述    | 默认值       |
|--------------------------------|-------|-----------|
| orange.security.white-list-url | 白名单列表 | List.of() |

### 案例

```yaml
orange:
  security:
    white-list-url: # 白名单
      - /orange-system/v1.0/auth/password-encrypt
```


