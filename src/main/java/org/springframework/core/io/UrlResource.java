package org.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * <big>Url资源</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/14 上午9:13
 */
public class UrlResource implements Resource{
    private final URL url;
    public UrlResource(URL url) {
        this.url = url;
    }
    @Override
    public InputStream getInputStream() throws Exception {
        // 打开URL连接
        URLConnection urlConnection = this.url.openConnection();
        // 获取输入流
        try {
            return urlConnection.getInputStream();
        }catch (IOException e) {
            throw e;
        }
    }
}
