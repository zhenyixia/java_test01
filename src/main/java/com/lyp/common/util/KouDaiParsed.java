package com.lyp.common.util;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * 解析口袋写作 从口袋写作中导出的一本书的txt，包含所有文章。需要将所有文章分割成单独的txt 整体txt格式如下： |文章1标题 文章1内容 。。。
 * |文章2标题 文章2内容 。。。 <p> 有分卷的整体txtx格式如下： 分卷名1|文章1标题 文章1内容 。。。 分卷名1|文章2标题 文章2内容
 * 。。。 分卷名2|文章1标题 文章1内容 。。。 分卷名2|文章2标题 文章2内容 。。。
 */
public class KouDaiParsed {

  /**
   * 解析方法
   */
  public static void parse(String filepath) {
    //1，根据文件路径，一行行读取文件内容

    //2，如果某一行，是以|开头，或者|在前5个字之内的则为文章标题，|之前的为分卷名，|之后的为文章名

    //3，将读取到的“分卷名+文章名”重命名为新的文章名：分卷名-文章名，如果没有分卷名，则直接文章名，将文章名保存为文件名

    //4，循环读取事个文件，遇到包含文章标题的一行，则将该行抽取出标题，并将上一个文件保存

    File file = new File(filepath);
    String line = null;
    try (
        FileReader reader = new FileReader(filepath);
        BufferedReader br = new BufferedReader(reader)
    ) {

      String title = null;
      File tempFile = null;
      String tempPath = null;
      BufferedWriter writer = null;
      String parentPath = file.getParent();

      while ((line = br.readLine()) != null) {
        String newLine = StringFormat.normalize(line);
        if (StringUtils.isBlank(newLine)) {
          continue;
        }

        newLine = newLine.replaceAll("\\s", "");
        if (newLine.contains("|")) {
          newLine = getTitleFromLine(newLine);
          title = newLine;
          System.out.println(title);
        }

        //第一篇文章
        if (tempFile == null && title != null) {
          tempPath = parentPath + "\\" + title + ".txt";
          tempFile = new File(tempPath);
          tempFile.createNewFile();
          title = null;
          writer = new BufferedWriter(new FileWriter(tempPath, true));
        } else if (tempFile != null && title != null) {
          writer.close();
          tempPath = parentPath + "\\" + title + ".txt";
          tempFile = new File(tempPath);
          tempFile.createNewFile();
          title = null;
          writer = new BufferedWriter(new FileWriter(tempPath, true));
        }

        if (tempFile != null) {

          writer.write(newLine + "\r\n");
        }
      }

      if (writer != null) {
        writer.close();
      }
    } catch (IOException e) {
      System.out.println("异常行：" + line);
      e.printStackTrace();
    }
  }

  private static String getTitleFromLine(String line) {
    if (StringUtils.isBlank(line)) {
      return null;
    }

    String title = "";
    if (line.startsWith("|")) {
      title = StringUtils.stripStart(line, "\\|");

    } else if (line.indexOf("|") < 5) {
      title = String
          .format("%s-%s", line.split("\\|")[0], line.split("\\|")[1]);
    }

    title = WindowsNameFormatUtils.en2Zh(title);

    return title;

  }

  public static void main(String[] args) {
    String filePath = "C:\\Users\\Administrator\\Desktop\\0531-文件处理\\文章收集.txt";
    parse(filePath);
  }


}
