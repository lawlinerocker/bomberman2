
 package bomberman.sfx;
import java.io.File;
import javax.sound.sampled.*;
import java.util.ArrayList;
public class AudioPlayer 
{
	private int bgMusic;
	private ArrayList<String> musicFiles;
	Clip clip;
	long currentFrame;
	public  AudioPlayer(String...files)
	{
		musicFiles=new ArrayList<String>();
		for(String file:files)
			musicFiles.add("./resorce/sfx/"+file+".wav");
	}
	public void playSound(String fileName)
	{
		try
		{
			File soundFile=new File(fileName);
			AudioInputStream ais=AudioSystem.getAudioInputStream(soundFile);
			AudioFormat format=ais.getFormat();
			DataLine.Info info=new DataLine.Info(Clip.class, format);
			Clip clip=(Clip) AudioSystem.getLine(info);
			clip.open(ais);
			FloatControl gainControl=(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-10);
			clip.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void run()
	{
		playSound(musicFiles.get(bgMusic));
	}
	
	public void stop()
	{
	
		if(clip==null)
			return;
		stop();
		clip.stop();
		clip.close();
	}
	
	
	
}
