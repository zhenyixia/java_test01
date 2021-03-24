package com.lyp.desiginpattern;

/**
 * 适配器设计模式 意图：将一个类的接口转换成客户希望的另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 * 主要解决：主要解决在软件系统中，常常要将一些"现存的对象"放到新的环境中，而新环境要求的接口是现对象不能满足的。
 * 优点：
 * 1、可以让任何两个没有关联的类一起运行。 2、提高了类的复用。 3、增加了类的透明度。 4、灵活性好。
 * 缺点：
 * 1、过多地使用适配器，会让系统非常零乱，不易整体进行把握。比如，明明看到调用的是 A 接口， 其实内部被适配成了 B
 * 接口的实现，一个系统如果太多出现这种情况，无异于一场灾难。
 */
public class AdapterDP {

  public static void main(String[] args) {
    AudioPlayer audioPlayer = new AudioPlayer();

    audioPlayer.play("mp3", "beyond the horizon.mp3");
    audioPlayer.play("mp4", "alone.mp4");
    audioPlayer.play("vlc", "far far away.vlc");
    audioPlayer.play("avi", "mind me.avi");
  }
}

interface MediaPlayer {
  void play(String audioType, String fileName);
}

interface AdvancedMediaPlayer {
  void playVlc(String fileName);

  void playMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer {
  @Override
  public void playVlc(String fileName) {
    System.out.println("Playing vlc file. Name: " + fileName);
  }

  @Override
  public void playMp4(String fileName) {
    //什么也不做
  }
}

class Mp4Player implements AdvancedMediaPlayer {

  @Override
  public void playVlc(String fileName) {
    //什么也不做
  }

  @Override
  public void playMp4(String fileName) {
    System.out.println("Playing mp4 file. Name: " + fileName);
  }
}

class MediaAdapter implements MediaPlayer {

  private AdvancedMediaPlayer advancedMusicPlayer;

  MediaAdapter(String audioType) {
    if (audioType.equalsIgnoreCase("vlc")) {
      advancedMusicPlayer = new VlcPlayer();
    } else if (audioType.equalsIgnoreCase("mp4")) {
      advancedMusicPlayer = new Mp4Player();
    }
  }

  @Override
  public void play(String audioType, String fileName) {
    if (audioType.equalsIgnoreCase("vlc")) {
      advancedMusicPlayer.playVlc(fileName);
    } else if (audioType.equalsIgnoreCase("mp4")) {
      advancedMusicPlayer.playMp4(fileName);
    }
  }
}

class AudioPlayer implements MediaPlayer {
  private MediaAdapter mediaAdapter;

  @Override
  public void play(String audioType, String fileName) {

    //播放 mp3 音乐文件的内置支持
    if (audioType.equalsIgnoreCase("mp3")) {
      System.out.println("Playing mp3 file. Name: " + fileName);
    }
    //mediaAdapter 提供了播放其他文件格式的支持
    else if (audioType.equalsIgnoreCase("vlc")
        || audioType.equalsIgnoreCase("mp4")) {
      mediaAdapter = new MediaAdapter(audioType);
      mediaAdapter.play(audioType, fileName);
    } else {
      System.out.println("Invalid media. " + audioType + " format not supported");
    }
  }
}
