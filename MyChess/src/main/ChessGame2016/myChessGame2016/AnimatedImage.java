package main.ChessGame2016.myChessGame2016;

import javafx.scene.image.Image;
// TEST ONLY
public class AnimatedImage
{
    public Image[] frames;
    public double duration;
     
    public Image getFrame(double time)
    {
        int index = (int)((time % (frames.length * duration)) / duration);
        return frames[index];
    }
}