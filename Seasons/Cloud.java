package Seasons;

import javax.media.opengl.GL;



public class Cloud extends Season {
    
    void drawcloud(GL gl,double x1,double y1){
		gl.glColor3f(1, 1, 1);
		
		double yOrig1 = 0.8;
        gl.glBegin(GL.GL_POLYGON);
       
        for (int deg = 0; deg <= 360; deg++) {          
        	double rad = Math.toRadians(deg);
            double x = positionX1 + x1 + 0.30 * Math.cos(rad);
            double y = yOrig1 + 0.15 * Math.sin(rad);
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
        
    
       double yOrig2 = 0.78;
       gl.glBegin(GL.GL_POLYGON);
       
       for (int deg2 = 0; deg2 <= 360; deg2++) {
            double rad = Math.toRadians(deg2);
            double x = positionX2 + x1 + 0.25 * Math.cos(rad);
            double y = yOrig2 + 0.1 * Math.sin(rad);
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
        

        double yOrig3 = 0.82;
        gl.glBegin(GL.GL_POLYGON);
        
        for (int deg3 = 0; deg3 <= 360; deg3++) {  	
            double rad = Math.toRadians(deg3);
            double x = positionX3 + x1 + 0.30 * Math.cos(rad);
            double y = yOrig3 + 0.1 * Math.sin(rad);
            gl.glVertex2d(x, y);
            
        }
        gl.glEnd();
    }

}

    
    


