package com.eccl.cloud.common.web;

import com.eccl.cloud.common.domain.FileInfo;

/*********
 * 文件信息返回信息
 * @author luwenhe
 *
 */
public class FileInfoRM {
	
	
	
	public FileInfoRM(FileInfo fileInfo) {
		super();
		this.fileInfo = fileInfo;
	}
	
	/*********
	 * 是否成功
	 */
	private boolean success = true;
	
	/********
	 * 文件信息
	 */
	private FileInfo fileInfo;
	
	
	public boolean isSuccess() {
		return success;
	}
	public FileInfo getFileInfo() {
		return fileInfo;
	}
	
	
}
