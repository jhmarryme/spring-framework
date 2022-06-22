package com.example.demo.resource;

import org.springframework.core.io.FileSystemResource;

import java.io.*;

/**
 *
 * @author JiaHao Wang
 * @date 2022/6/20 下午12:57
 */
public class ResourceDemo {
	public static void main(String[] args) throws IOException {
		FileSystemResource fileSystemResource = new FileSystemResource(
				"/home/jhmarryme/develop/code/spring-framework/z-spring-demo/src/main/java/com/example/demo/resource/test.txt"
		);
		File file = fileSystemResource.getFile();
		System.out.println(file.length());
		OutputStream outputStream = fileSystemResource.getOutputStream();
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
		bufferedWriter.write("Hello World");
		bufferedWriter.flush();
		outputStream.close();
		bufferedWriter.close();
	}
}
