# orange-system-storage-local-biz-starter

> `orange-system-storage-local-biz-starter`项目基于`Spring Boot`框架，旨在提供一个高效且简化的文件上传解决方案，支持将文件安全地存储到本地服务器。
> 该项目不仅简化了开发者的集成工作，还通过优化性能和增强安全性，确保文件上传过程既快速又可靠。同时，它还提供了灵活的配置选项，以满足不同应用场景下的需求，
> 例如文件大小限制、存储路径自定义等，从而成为构建企业级应用的理想选择。

## 自定义配置

| 属性                                      | 描述       | 必填 | 默认值              |
|-----------------------------------------|----------|----|------------------|
| orange.system.storage.local.enabled     | 是否启用     | 是  | true             |
| orange.system.storage.local.basePath    | 基础存储路径   | 是  | D://temp         |
| orange.system.storage.local.servicePath | 项目服务路径地址 | 是  | http://tiny.hengzq.cn/rest-api |

## 案例

```yaml
orange:
  system:
    storage:
      local:
        true: true
        basePath: d://temp
        service-path: http://tiny.hengzq.cn/rest-api
```

# orange-system-storage-aliyun-biz-starter

> `orange-system-storage-aliyun-biz-starter`项目基于`Spring Boot`框架，旨在为开发者提供一个简洁高效的文件上传解决方案，
> 直接将文件存储至阿里云的对象存储服务（OSS）。该框架不仅简化了与阿里云 OSS 的集成流程，还通过内置的安全机制和性能优化，确保文件上传的高效性和数据的安全性。
> 此外，它支持多种配置选项，如自定义存储桶、访问控制策略等，使开发者能够轻松应对复杂多变的应用场景，是构建现代云端应用的理想工具。

## 自定义配置

| 属性                                       | 描述       | 必填 | 默认值                            |
|------------------------------------------|----------|----|--------------------------------|
| orange.system.storage.aliyun.enabled     | 是否启用     | 是  | false                          |
| orange.system.storage.aliyun.basePath    | 基础存储路径   | 是  | D://temp                       |
| orange.system.storage.aliyun.servicePath | 项目服务路径地址 | 是  | http://tiny.hengzq.cn/rest-api |

## 案例

```yaml
orange:
  system:
    storage:
      aliyun:
        enabled: false
        basePath: d://temp
        service-path: http://tiny.hengzq.cn/rest-api
```