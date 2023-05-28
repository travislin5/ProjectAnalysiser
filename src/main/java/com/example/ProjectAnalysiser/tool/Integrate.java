package com.example.ProjectAnalysiser.tool;

import java.util.List;

public class Integrate {

	public static void main(String[] args) {
		String projectPath = "/Users/travislin/Documents/GitHub/accounting";
		String dataDir = "/Users/travislin/Downloads/zzzzzzzzzzz";

		scanProject(projectPath, dataDir);

	}

	public static void scanProject(String projectPath, String dataDir) {
		CreateFile.createJavaPathFile(projectPath, dataDir);

		createAllContainFile(dataDir);

	}

	private static void createAllContainFile(String dataDir) {

		// 把資料準備好

		List<String> fileList = CreateFile.getFileData(dataDir + "/AllJavaPath.txt");

		List<String> classNameList = ClassNameFile.getClassNameList(dataDir + "/AllClassName.txt");

		// 使用做好的函數

		IsContain.createAllContainFile(fileList, classNameList, dataDir + "/data");

	}

}
