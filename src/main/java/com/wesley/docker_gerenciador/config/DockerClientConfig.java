package com.wesley.docker_gerenciador.config;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class DockerClientConfig {
    @Value("${docker.socket.path}")
    private String dockerSocketPath;

    @Bean
    @Lazy(value = false)
    public DockerClient buildDockerClient() {
        /*
        * Aqui você pode configurar da maneira que deseja. No meu caso eu preferi deixar ele utilizando
        * a conexão tcp://localhost:2375 por conta que não quero que venha com verificação com TLS
        * */
        DefaultDockerClientConfig.Builder dockerClientConfigBuilder = DefaultDockerClientConfig
                .createDefaultConfigBuilder()
                .withDockerHost(dockerSocketPath)
                .withDockerTlsVerify(false);


        if (this.dockerSocketPath != null && this.dockerSocketPath.startsWith("tcp://")) {
            dockerClientConfigBuilder.withDockerHost(dockerSocketPath)
                    .withDockerTlsVerify(false);
        }

        DefaultDockerClientConfig defaultDockerClientConfig = dockerClientConfigBuilder.build();

        ApacheDockerHttpClient dockerHttpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(defaultDockerClientConfig.getDockerHost()).build();


        return DockerClientBuilder.getInstance(defaultDockerClientConfig)
                .withDockerHttpClient(dockerHttpClient)
                .build();
    }
}
