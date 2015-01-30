package GUI;

import sun.audio.*;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Contain methods that play sound in GUI
 *
 * @author DucAnh
 */
public class Sound {
	private ContinuousAudioDataStream music;
	private AudioData button1;
	private AudioData button2;
	private boolean musicOn = true;
	private boolean soundOn = false;

	/**
	 * Constructor
	 */
	public Sound() {
		try {
			AudioData musicData = audioData("resource/sound/music1.wav");
			//AudioData musicData = audioData("resource/sound/music_special.mp3");
			music = new ContinuousAudioDataStream(musicData);
			button1 = audioData("resource/sound/button1.wav");
			button2 = audioData("resource/sound/button2.wav");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isSoundOn() {
		return soundOn;
	}

	public boolean isMusicOn() {
		return musicOn;
	}

	public void toggleMusic() {
		musicOn = !musicOn;
		if (musicOn)
			AudioPlayer.player.start(music);
		else
			AudioPlayer.player.stop(music);
	}

	public void musicStop() {
		AudioPlayer.player.stop(music);
	}

	public void toggleSound() {
		soundOn = !soundOn;
	}

	public void playButton1() {
		if (soundOn) {
			AudioDataStream audio = new AudioDataStream(button1);
			AudioPlayer.player.start(audio);
		}
	}

	public void playButton2() {
		if (soundOn) {
			AudioDataStream audio = new AudioDataStream(button2);
			AudioPlayer.player.start(audio);
		}
	}

	private AudioData audioData(String url) throws Exception {
		// open the sound file as a Java input stream
		InputStream in = new FileInputStream(url);
		AudioStream audioStream = new AudioStream(in);
		AudioData audioData = audioStream.getData();
		audioStream.close();

		return audioData;
	}
}