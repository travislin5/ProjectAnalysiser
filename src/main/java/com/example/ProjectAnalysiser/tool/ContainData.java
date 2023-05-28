package com.example.ProjectAnalysiser.tool;

import java.util.List;

public class ContainData {

	public static void main(String[] args) {

		// 設定要存在哪裏？路徑？

		// 取得路徑清單？
		List<String> filesPathList = FindFiles.getFileList("/Users/travislin/Documents/GitHub/accounting");
		// 取得className清單
		ClassNameFile.getClassNameList("/Users/travislin/Downloads/zzzzzzzzzzz/AllClassName.txt");
		//

		//

	}

}
