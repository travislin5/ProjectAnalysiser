package com.example.ProjectAnalysiser.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateFile {

	public static void main(String[] args) {
		String projeactPath = "/Users/travislin/Documents/GitHub/accounting";
		String pathsFileDir = "/Users/travislin/Downloads/zzzzzzzzzzz";

		createJavaPathFile(projeactPath, pathsFileDir);

	}

	// 產生專案java檔案路徑清單、className清單
	public static void createJavaPathFile(String projectPath, String dataDir) {

		// 取得專案所有檔案路徑
		List<String> fileList = getFileList(projectPath);

		// 過濾出是java檔案的路徑
		List<String> javaList = javaFileFilter(fileList);

		// 把清單存到文件
		createFile(javaList, dataDir + "/AllJavaPath.txt");

		// 存className清單
		createClassNameList(javaList, dataDir + "/AllClassName.txt");

	}

	// 取得指定檔案內容陣列
	public static List<String> getFileData(String directoryPath) {
		String filePath = directoryPath;
		List<String> lines = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lines;
	}

	// 取得專案路徑清單
	public static List<String> getFileList(String projectPath) {
		// 初始化檔案路經清單
		List<String> filePaths = new ArrayList<>();

		// 把專案下檔案路徑放入清單
		listFiles(projectPath, filePaths);

		return filePaths;
	}

	// 創造關聯資料
	public static void createContainFile(List<String> containList, String fileName, String fileDir) {

		checkAndCreateDir(fileDir);

		createFile(containList, fileDir + "/" + fileName);
	}

	//取得最後一個斜線後的所有字串的陣列
	public static List<String> getDataFileNameList(List<String> allDirStrings) {

		List<String> afterCut = new ArrayList<>();

		for (String string : allDirStrings) {

			String cut = GetBetween.getAfterLastSlash(string);

			if (!cut.isBlank()) {
				afterCut.add(cut);
			}
		}

		return afterCut;
	}


	// ClassName清單
	private static void createClassNameList(List<String> pathList, String putFilePath) {

		List<String> classNameList = cutNoNeed(pathList);

		// 把清單存到文件
		createFile(classNameList, putFilePath);

	}

	// 遍歷整個專案，把路徑放入陣列
	private static void listFiles(String folderPath, List<String> filePaths) {
		File folder = new File(folderPath);
		File[] files = folder.listFiles();

		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					// 如果是資料夾，遞迴呼叫 listFiles
					listFiles(file.getAbsolutePath(), filePaths);
				} else {
					// 如果是檔案，將檔案路徑加入 List
					filePaths.add(file.getAbsolutePath());
				}
			}
		}
	}

	private static List<String> javaFileFilter(List<String> fileList) {
		List<String> javaFileList = new ArrayList<>();

		for (String string : fileList) {
			if (IsContain.isJava(string)) {
				javaFileList.add(string);
			}
		}
		return javaFileList;
	}

	private static void createFile(List<String> lines, String filePath) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (String line : lines) {
				writer.write(line);
				writer.newLine(); // 插入新行
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static List<String> cutNoNeed(List<String> allDirStrings) {

		List<String> afterCut = new ArrayList<>();

		for (String string : allDirStrings) {

			String cut = GetBetween.getWordBetween(string, "/", ".java");

			if (!cut.isBlank()) {
				afterCut.add(cut);
			}
		}

		return afterCut;
	}

	private static void checkAndCreateDir(String fileDir) {
		File folder = new File(fileDir);

		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

}
