package Seasons;
import java.util.ArrayList;
import javax.media.opengl.GL;

/**
 * A particle system
 * @author Jacqueline Whalley
 */
public class Snow {
	
	private ArrayList<Particle> particles;

    public Snow() {
        particles = new ArrayList<Particle>();
    }

    public void addParticle(double x, double y)
    {
        particles.add(new Particle(x, y));
    }

    public void addParticle(double x, double y, double dx, double dy)
    {
        particles.add(new Particle(x, y, dx, dy));
    }

    public void animate(double time) {
        for ( Particle p : particles )
        {

           
            p.x   += p.dx * 0.09;//雪的横一速度
            p.y   += p.dy * 0.009;//纵向速度
            p.dy  -= 1.0 * 0.009;

        }

        if ( particles.size() > 0 )
        {
            Particle p = particles.get(0);
            if ( p.age > p.ageMax )
            {
                particles.remove(p);
            }
        }
    }

    public void draw(GL gl) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glLineWidth(3.5f);
        gl.glBegin(GL.GL_LINES);
            for ( Particle p : particles )
            {
               // double f = p.age / p.ageMax;
                gl.glColor3d(1,1,1);
                gl.glVertex2d(p.x, p.y);
                gl.glVertex2d(p.x, p.y+0.01);
               
            }
        gl.glEnd();
        gl.glDisable(GL.GL_BLEND);
        
 
 
    }

    private class Particle {
    	 
    	public double x,  y;
        public double dx, dy;
        public double age;
        public double ageMax;

        public Particle(double x, double y)
        {
            this(x, y, x*3, y*3);
        }

        public Particle(double x, double y, double dx, double dy)
        {
            this.x   = x;
            this.y   = y;
            this.dx  = dx;
            this.dy  = dy;
            this.age = 0.0;
            this.ageMax = 1.0 + Math.random() * 10;
        }
    }
}
