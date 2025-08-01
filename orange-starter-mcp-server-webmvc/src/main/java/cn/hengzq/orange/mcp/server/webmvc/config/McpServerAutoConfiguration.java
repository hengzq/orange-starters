package cn.hengzq.orange.mcp.server.webmvc.config;

import cn.hengzq.orange.common.service.mcp.McpServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author hengzq
 */
@Slf4j
@AutoConfiguration
public class McpServerAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ToolCallbackProvider mcpTools(List<McpServerService> mcpServerServices) {
        log.info("init mcpTools.");
        return MethodToolCallbackProvider
                .builder()
                .toolObjects(mcpServerServices.toArray())
                .build();
    }

}