package com.example.ProjectAnalysiser.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindFiles {

	public static void main(String[] args) {

//		List<String> filePaths = getFileList("/Users/travislin/Documents/GitHub/accounting");

//		for (String filePath : filePaths) {
//			System.out.println(filePath);
//
////			if (IsContain.isJava(filePath)) {
////
////				// 取得檔案路徑字串
////				String fileString = GetFlieString.getFileString(filePath);
////				// 判斷是不是包含某個ClassName
////				boolean aa = IsContain.isContainThisClass(fileString, "ProductDao");
////
////				System.out.println(aa);
////			}
//		}
		
		createJataFilePath();
	}

	public static List<String> getFileList(String folderPath) {
		List<String> filePaths = new ArrayList<>();

		listFiles(folderPath, filePaths);

		return filePaths;
	}

	public static void listFiles(String folderPath, List<String> filePaths) {
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
	
	public static void createJataFilePath() {
		List<String> filePaths = getFileList("/Users/travislin/Documents/GitHub/accounting");
		
		CreateFiles.createFile(filePaths, "/Users/travislin/Downloads/zzzzzzzzzzz/AllFilePath.txt");

	}

}
