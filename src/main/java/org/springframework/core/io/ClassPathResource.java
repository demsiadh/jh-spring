package org.springframework.core.io;

import org.springframework.beans.BeansException;

import java.io.InputStream;

/**
 * <big>类路径资源</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/14 上午9:05
 */
public class ClassPathResource implements Resource{
    // 类路径
    private final String path;

    public ClassPathResource(String path) {
        this.path = path;
    }
    @Override
    public InputStream getInputStream() throws Exception {
        // 获取类路径下的资源
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(this.path);
        if (inputStream == null) {
            throw new BeansException("Could not open InputStream for path: " + this.path);
        }
        return inputStream;
    }
}
