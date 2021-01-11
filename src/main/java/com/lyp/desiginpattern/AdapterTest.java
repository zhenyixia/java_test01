package com.lyp.desiginpattern;

public class AdapterTest {
  public static void main(String[] args) {
    MediaPlayerInter mediaPlayer = new MediaPlayerImpl();
    mediaPlayer.play("mp3", "向天再借五百年");
    mediaPlayer.play("mp4", "我不是药神");
    mediaPlayer.play("flv", "摔跤吧！爸爸");
  }
}

interface MediaPlayerInter {
  void play(String fileType, String fileName);
}

class MediaAdapterClass implements MediaPlayerInter {
  AdvancedMediaPlayerInter advancedMediaPlayer;

  public MediaAdapterClass() {
    this.advancedMediaPlayer = new AdvancedMediaPlayerImpl();
  }

  @Override
  public void play(String fileType, String fileName) {
    if ("mp4".equalsIgnoreCase(fileType)) {
      advancedMediaPlayer.playMp4(fileName);
    } else if ("flv".equalsIgnoreCase(fileType)) {
      advancedMediaPlayer.playFlv(fileName);
    }
  }
}

class MediaPlayerImpl implements MediaPlayerInter {
  MediaAdapterClass mediaAdapterClass;

  @Override
  public void play(String fileType, String fileName) {
    if ("mp3".equalsIgnoreCase(fileType)) {
      System.out.printf("正在播放Mp3文件：%s.%s", fileName, System.lineSeparator());
      return;
    }
    mediaAdapterClass = new MediaAdapterClass();
    mediaAdapterClass.play(fileType, fileName);
  }
}

interface AdvancedMediaPlayerInter {
  void playMp4(String fileName);

  void playFlv(String fileName);
}

class AdvancedMediaPlayerImpl implements AdvancedMediaPlayerInter {

  @Override
  public void playMp4(String fileName) {
    System.out.printf("正在播放mp4文件：%s.%s", fileName, System.lineSeparator());
  }

  @Override
  public void playFlv(String fileName) {
    System.out.printf("正在播放flv文件：%s.%s", fileName, System.lineSeparator());
  }
}





