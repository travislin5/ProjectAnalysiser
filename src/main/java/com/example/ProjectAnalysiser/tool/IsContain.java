package com.example.ProjectAnalysiser.tool;

import java.util.ArrayList;
import java.util.List;

public class IsContain {

	public static void main(String[] args) {

		String projeactPath = "/Users/travislin/Documents/GitHub/accounting";
		String pathsFileDir = "/Users/travislin/Downloads/zzzzzzzzzzz/AllJavaPath.txt";
		String classNameFileDir = "/Users/travislin/Downloads/zzzzzzzzzzz/AllClassName.txt";
		String dataDir = "/Users/travislin/Downloads/zzzzzzzzzzz/data";

		List<String> fileList = CreateFile.getFileData(pathsFileDir);

		List<String> classNameList = ClassNameFile
				.getClassNameList("/Users/travislin/Downloads/zzzzzzzzzzz/AllClassName.txt");

//		setEachContainList(fileList.get(45), classNameList, "/Users/travislin/Downloads/zzzzzzzzzzz/data");

		createAllContainFile(fileList, classNameList, dataDir);

	}

	public static boolean isJava(String path) {

		boolean contains = path.contains(".java");

		return contains;

	}

	public static boolean isContainThisClass(String path, String className) {

		boolean contains = path.contains(className);

		return contains;

	}

	public static void createAllContainFile(List<String> pathList, List<String> classNameList, String dataDir) {

		for (String string : pathList) {

			setEachContainList(string, classNameList, dataDir);
		}

	}

	public static void setEachContainList(String path, List<String> classNameList, String dataDir) {
		List<String> containList = new ArrayList<>();

		// 取得檔案字串
		String fileString = GetFlieString.getFileString(path);

		// 印出路徑className
		String thisClassName = GetBetween.getWordBetween(path, "/", ".java");
		
		// 拿className清單做比對

		for (String string : classNameList) {
			// 判斷有沒有包含
			boolean contains = StringTool.preAndNextNotEng(fileString, string);

			if (contains && !thisClassName.equals(string)) {
				containList.add(string);
			}

		}

		if (containList.size() != 0) {
			CreateFile.createContainFile(containList, thisClassName, dataDir);
		}

	}

}
