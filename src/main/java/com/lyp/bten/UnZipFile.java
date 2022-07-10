package com.lyp.bten;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.commons.io.FileUtils;

public class UnZipFile{

  static ExecutorService threadPool = new ThreadPoolExecutor(5, 10, 10, MILLISECONDS, new LinkedBlockingQueue<Runnable>());

  static List<String> sss = Arrays.asList("lib", "org", "com", "META-INF", "log", "java");

  public static void main(String[] args) throws IOException, InterruptedException{
    String srcBasePath = "E:\\recovery\\filter_zip2";
    File file = new File(srcBasePath);
    String[] list = file.list();
    if(list == null || list.length == 0){
      return;
    }

    for(String tempFileName : list){
      if(!tempFileName.endsWith(".zip")){
        continue;
      }

      String filePath = srcBasePath + File.separator + tempFileName;
      File srcFile = new File(filePath);
      long fileSize = (int)srcFile.length() / 1024;
      System.out.printf("%s\t %dk\r\n", srcFile.getName(), fileSize);
      if(fileSize < 500){
        continue;
      }

      String unzipDir = tempFileName.split("\\.")[0];
      String dirPath = srcBasePath + File.separator + unzipDir;
      File srcParentDirFile = new File(dirPath);
      if(!srcParentDirFile.exists()){
        srcParentDirFile.mkdir();
      }
      threadPool.execute(() -> unzipAndProcess(srcFile, srcParentDirFile));
    }
    // String filePath = path + File.separator + "丢失文件名的文件 (7).zip";

  }

  private static void unzipAndProcess(File srcFile, File srcParentDirFile){
    String rarPath = "E:\\softwareinstalled\\WinRAR\\WinRAR.exe";
    String cmd = rarPath + " X -o " + "\"" + srcFile.getPath() + "\" " + "\"" + srcParentDirFile.getPath() + "\"";
    try{
      Process proc = Runtime.getRuntime().exec(cmd);
      if(proc.waitFor(5, SECONDS)){
        System.out.println("it successfully.");
      }
    }catch(IOException | InterruptedException e){
      e.printStackTrace();
    }

    String[] unzipedFileList = srcParentDirFile.list();
    if(unzipedFileList == null || unzipedFileList.length == 0){
      System.out.println("it failed.");
    }

    String dstBaseDir = "E:\\recovery\\filter_zip3";
    try{
      for(String unzippedFileName : unzipedFileList){
        boolean flag = false;
        for(String sss1 : sss){
          if(unzippedFileName.contains(sss1)){
            flag = true;
            break;
          }
        }

        if(flag){
          System.out.println("包含com或lib，无用: " + srcFile.getPath());
          dstBaseDir = "E:\\recovery\\filter_zip3";
          FileUtils.deleteDirectory(srcParentDirFile);
          break;
        }else{
          dstBaseDir = "E:\\recovery\\filter_zip";
        }
      }

      String dstFile = dstBaseDir + File.separator + srcFile.getName();
      Files.move(Paths.get(srcFile.getPath()), Paths.get(dstFile), StandardCopyOption.REPLACE_EXISTING);

      // 防止弹出 解压出错告警弹框
      // String cmd2 = "taskkill /f /im WinRAR.exe";
      // proc = Runtime.getRuntime().exec(cmd2);
      // proc.waitFor(10, MILLISECONDS);
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}