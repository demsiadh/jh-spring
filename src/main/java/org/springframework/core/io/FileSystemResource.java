package org.springframework.core.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * <big>系统文件资源</big>
 * <p></p>
 *
 * @author 13684
 * @data 2024/6/14 上午9:17
 */
public class FileSystemResource implements Resource{
    private final String path;
    public FileSystemResource(String path) {
        this.path = path;
    }
    @Override
    public InputStream getInputStream() throws Exception {
        // 读取文件
        File file = new File(path);
        try {
            // 获取文件输入流
            return Files.newInputStream(file.toPath());
        } catch (IOException e) {
            throw new FileNotFoundException("File not found: " + path);
        }
    }
}
