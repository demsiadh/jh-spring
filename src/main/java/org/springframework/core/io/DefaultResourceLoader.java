package org.springframework.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * <big>默认的资源加载器实现类</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/14 上午9:03
 */
public class DefaultResourceLoader implements ResourceLoader{
    private static final String CLASSPATH_URL_PREFIX = "classpath:";
    @Override
    public Resource getResource(String location) {
        // 本地资源
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            // 切割字符串，去掉前缀
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            // 可能是URL上的资源
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                // 不是网络资源就当成本地资源
                return new FileSystemResource(location);
            }
        }
    }
}
