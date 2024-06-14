package org.springframework.core.io;

import java.io.InputStream;

/**
 * <big>资源的抽象和访问接口</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/13 下午8:52
 */
public interface Resource {
    InputStream getInputStream() throws Exception;
}
