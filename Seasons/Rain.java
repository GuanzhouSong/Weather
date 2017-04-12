package Seasons;
import java.util.ArrayList;
import javax.media.opengl.GL;


public class Rain {
	
	private ArrayList<Particle> particles;

    public Rain() {
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

            p.age += 0.009;
            p.x   += p.dx * 0.001;
            p.y   += p.dy * 0.009;
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
        gl.glLineWidth(2f);
        gl.glBegin(GL.GL_LINES);
            for ( Particle p : particles )
            {
              
            	gl.glColor3d(0,0.5,1);
                gl.glVertex2d(p.x, p.y);
                gl.glColor3d(0.75,0.75,0.75);
                gl.glVertex2d(p.x, p.y+0.03);
               
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
