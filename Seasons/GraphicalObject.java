package Seasons;
import javax.media.opengl.GL;

public interface GraphicalObject {
    public void animate(double time);
    public void draw(GL gl);}
