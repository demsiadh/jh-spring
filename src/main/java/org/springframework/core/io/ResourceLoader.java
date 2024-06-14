package org.springframework.core.io;

/**
 * <big>资源加载接口</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/13 下午8:55
 */
public interface ResourceLoader {
    Resource getResource(String location);
}
