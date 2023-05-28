package com.example.ProjectAnalysiser.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CreateFiles {

	public static void main(String[] args) {
//		String[] lines = { "Line 1", "Line 2", "Line 9" };
		List<String> lines = new ArrayList<>();
		lines.add("這是1");
		lines.add("這是2");
		lines.add("這是3");
		createFile(lines, "/Users/travislin/Downloads/zzzzzzzzzzz/test.txt");

//		getFirstString("/Users/travislin/Downloads/zzzzzzzzzzz/test.txt");

	}

	public static void createFile(List<String> lines, String filePath) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (String line : lines) {
				writer.write(line);
				writer.newLine(); // 插入新行
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("文件已成功寫入。");
	}

	public static void getFirstString(String filePath) {

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String firstLine = reader.readLine(); // 讀取第一行文字
			System.out.println("First line: " + firstLine);
			Gson gson = new Gson();

			Map<String, List<Map<String, Integer>>> object = gson.fromJson(firstLine,
					new TypeToken<Map<String, List<Map<String, Integer>>>>() {
					}.getType());
			System.out.println(object.get("a").get(0).get("b"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
