package com.example.ProjectAnalysiser.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainTree {

	public static void main(String[] args) {

		List<String> roots = getRootList("/Users/travislin/Downloads/zzzzzzzzzzz/data");

		System.out.println(roots.size() + ":");

		for (String string : roots) {
			System.out.println(string);
		}
		System.out.println("下面是另外: ");
		findDataByName("CRUDOrderDetailsController");

		if (dataFileExists("aaa")) {
			System.out.println("有");
		} else {

			System.out.println("沒有");
		}

	}

	public static List<String> getRootList(String dataPath) {
		// 取得data資料夾所有檔案路徑
		List<String> filePathList = CreateFile.getFileList(dataPath);

		// 取得所有有關聯檔案的className
		List<String> classNameList = CreateFile.getDataFileNameList(filePathList);

		Set<String> inOtherList = new HashSet<>();

		for (String className : classNameList) {

			for (String path : filePathList) {

				if (isInOther(path, className)) {
					inOtherList.add(className);
					break;
				}
			}

		}
		List<String> diffElements = ListTool.listAndSetDiff(classNameList, inOtherList);

		return diffElements;

	}

	private static boolean isInOther(String path, String className) {

		boolean result = false;

		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = reader.readLine()) != null) {

				if (line.equals(className)) {
					result = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static List<String> findDataByName(String dataName) {
		List<String> data = new ArrayList<>();
		if (dataFileExists(dataName)) {
			data = CreateFile.getFileData("/Users/travislin/Downloads/zzzzzzzzzzz/data/" + dataName);
		} else {
			System.out.println("無此檔案");
		}

		return data;
	}

	public static boolean dataFileExists(String dataName) {
		boolean result = false;

		String filePath = "/Users/travislin/Downloads/zzzzzzzzzzz/data/" + dataName;

		File file = new File(filePath);

		if (file.exists()) {
			result = true;
		}

		return result;
	}

}
