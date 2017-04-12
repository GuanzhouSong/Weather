package Seasons;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;





import com.sun.opengl.util.Animator;
//import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.j2d.TextRenderer;

import java.util.Random;

public class Season implements GLEventListener, MouseListener, MouseMotionListener {
	
	public double prevTick;
	public double thisTick;
	float positionX1 = -0.2f;
    float positionX2 = 0f;
    float positionX3 = -0.4f;
    float positionX4 = 0f;
    float positionX5 = -0.20f;
    float positionX6= -0.22f;
    float positionX7= 0.64f;
    float positionY1 = 0f;
    boolean index=true;
    TextRenderer renderer ;
    float x1 = new Random().nextFloat()*(0.2f)-0.9f;
	float y1 = new Random().nextFloat()*(0.2f)-1f;
	float x2 = new Random().nextFloat()*(0.3f)-0.7f;
	float y2 = new Random().nextFloat()*(0.3f)-0.9f;
	float x3 = new Random().nextFloat()*(0.2f)-0.9f;
	float y3 = new Random().nextFloat()*(0.2f)-1f;
	float x4 = new Random().nextFloat()*(0.3f)-0.7f;
	float y4 = new Random().nextFloat()*(0.3f)-0.9f;
	
    float speed = 0.002f;
    float speed1 = 0.0008f;
    float speed2 = 0.0008f;
    float speed3 = 0.0005f;
    private Snow Snow;
    private Rain Rain;
    
//    private int font = GLUT.BITMAP_HELVETICA_18;
//	private GL gl;
//	private GLUT glut;
    
	public void init(GLAutoDrawable drawable) {
		renderer = new TextRenderer(new Font("SanSerif", Font.BOLD, 36));

		
		GL gl = drawable.getGL();

        gl.setSwapInterval(1);
   
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH);
        Snow = new Snow();
        Rain=new Rain();
		prevTick = 0;
             
        
	}
	
	public void display(GLAutoDrawable drawable) {
		
		GL gl = drawable.getGL();
		
		
        gl.glShadeModel(GL.GL_SMOOTH);	
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
       

        if(index==true){
	        mountain drawmountain = new mountain();
	        drawmountain.drawmountain(drawable);

	        
	        sun drawsun = new sun();
	        drawsun.drawsun(gl);
        
	        tree1 a1 = new tree1();
			for(int i = 1; i < 4; i++)
			{
				a1.drawtree(x1 + i * 0.4f, y1 + i * 0.3f, gl);
			}

			tree2 a2 = new tree2();
			for(int i = 1; i < 4; i++)
			{
				a2.drawtree(x2 + i * 0.4f, y2 + i * 0.1f, gl);
			}
			
			
			house drawhouse = new house();
			drawhouse.drawhouse(gl);
			
			button buttonedge1 = new button();
			buttonedge1.drawedge1(drawable);
			
			button buttonedge4 = new button();
			buttonedge4.drawedge4(drawable);
			
			
			
			thisTick = System.currentTimeMillis() / 1000.0;
	        double tick = thisTick - prevTick;
	        double time = tick - prevTick;
	        
	        if (prevTick > 0) {
				
				Rain.animate(time);
			}
    	    Rain.draw(gl);
    	    createParticleExplosion1();
    	   
	        
	        prevTick = thisTick;
	        positionX4 += speed1 * tick * 100;
	        positionY1 += speed2 * tick * 90;
	        
	        if(positionY1 >= 1f){	            
	        	positionX4 = 0f;
	        	positionY1 = 0f;	
	        }
	        if(positionX4 >= 0.4){
	        	speed1 = -speed1;
	        }
	        if(positionX4 < 0){
	        	speed1 = -speed1;
	        }
	            

		    balloon balloon1 = new balloon();
		    balloon1.drawballoon(gl);
			
			Cloud cloud = new Cloud();
			cloud.drawcloud(gl, positionX1, 0);
	      
		      positionX1 += speed;
		      positionX2 += speed;
		      positionX3 += speed;
		    if(positionX1 >=1.3f)
		      {
		    	positionX1 = -1f;
		    	positionX3 += speed;
		      }
		    
		   
		    
		    renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
    	    renderer.setColor(1f, 0f, 0f, 0.8f);
    	    renderer.draw("Spring", 5, 5);
    	    renderer.setColor(1f, 0.5f, 0f, 0.8f);
    	    renderer.draw("              Winter", 5, 5);
    	    renderer.endRendering();
    	    
    	    
    	    
            
        }
            else
            	
        {
	        skyw drawskyw = new skyw();
	        drawskyw.drawskyw(drawable);
	
	        mountainw drawmountainw = new mountainw();
	        drawmountainw.drawmountainw(drawable);
      
	        sunw drawsunw = new sunw();
	        drawsunw.drawsunw(gl);
        
	        tree3 a3 = new tree3();
			for(int i = 1; i < 3; i++)
			{
				a3.drawtree(x3 + i * 0.5f, y3 + i * 0.3f, gl);
			}

			tree4 a4 = new tree4();
			for(int i = 1; i < 4; i++)
			{
				a4.drawtree(x4 + i * 0.4f, y4 + i * 0.1f, gl);
			}
			
			
			housew drawhousew = new housew();
			drawhousew.drawhousew(gl);
		    
			button buttonedge3 = new button();
			buttonedge3.drawedge3(drawable);
			
			button buttonedge2 = new button();
			buttonedge2.drawedge2(drawable);
			
			snowman drawsnowman = new snowman();
			drawsnowman.drawsnowman(gl);
			
			thisTick = System.currentTimeMillis() / 1000.0;
	        double tick3 = thisTick - prevTick;
	        prevTick = thisTick;
	        double time = tick3 - prevTick;
	        positionX5 += speed * tick3 * 100;
	        positionX6 += speed * tick3 * 100;
	        if(positionX5 >=1.0f){	            
	        	positionX5 = -0.20f;
	        	positionX6 = -0.22f;
	        }
	        bird b1 = new bird();
	        b1.drawbird(gl);
			

	        positionX7 += speed3;
	        
	        if(positionX7 >=0.68f){	            
	        	speed3 = -speed3; 
	        }
	        if(positionX7 <=0.64f){	            
	        	speed3 = -speed3; 
	        }
			eye eye1 = new eye();
			eye1.draweye(gl);
			
			renderer.beginRendering(drawable.getWidth(), drawable.getHeight());
    	    renderer.setColor(1f, 0f, 0f, 0.8f);
    	    renderer.draw("Spring", 5, 5);
    	    renderer.setColor(1f, 0.5f, 0f, 0.8f);
    	    renderer.draw("              Winter", 5, 5);
    	    
    	    renderer.endRendering(); 
    	    if (prevTick > 0) {
				
				Snow.animate(time);
			}
    	    Snow.draw(gl);
    	    createParticleExplosion();
		    
    	   
		 
           }
        
		   gl.glFlush();
		   
		   
	}
	
	class mountain{
		void drawmountain(GLAutoDrawable drawable){
			
			GL gl = drawable.getGL();
			gl.glClearColor(0.52f, 0.80f, 0.92f,0.00f);
			
			gl.glBegin(GL.GL_POLYGON);
		    gl.glColor3d(0,1,0.4); // ground brown
		    gl.glVertex2f(-1.0f, -1.0f);
		    gl.glVertex2f(-1.0f, -0.4f);	
			gl.glVertex2f(-0.8f, -0.3f);
			gl.glVertex2f(-0.7f, -0.3f);
			gl.glVertex2f(-0.5f, -0.35f);
			gl.glVertex2f(-0.2f, -0.25f);
			gl.glVertex2f(-0.1f, -0.18f);
			gl.glVertex2f(0.1f, 0.09f);
			gl.glVertex2f(0.3f, 0.24f);
			gl.glVertex2f(0.51f, 0.34f);
			gl.glVertex2f(0.82f, 0.56f);
			gl.glVertex2f(0.95f, 0.60f);
			gl.glVertex2f(1.0f, 0.63f); 
			gl.glColor3d(1.0,1.0,1.0); // white
			gl.glVertex2f(1.0f, -1.0f);
			
			gl.glEnd();
			
			gl.glColor3d(0,1,1);
		    gl.glVertex2f(-1.0f, 1.0f);
			
		}
	}
	
	class balloon{
		void drawballoon(GL gl){
                
			  
			    
			     gl.glBegin(GL.GL_TRIANGLE_FAN);
			     gl.glColor3d(0.5,0,1);
			     gl.glVertex2d(positionX4, positionY1);
			     for(int deg=0;deg<=360;deg++){
			    	 double rad=Math.toRadians(deg);
			    	 double x=positionX4+0.1*Math.cos(rad);
			    	 double y=positionY1+0.05+0.1*Math.sin(rad);
			    	 gl.glVertex2d(x,y);
			     }
			        gl.glEnd();
			        
			        
			     gl.glBegin(GL.GL_TRIANGLES);
			     gl.glColor3d(0.5, 0, 1);
			     gl.glVertex2d(positionX4, positionY1-0.04);
			     gl.glVertex2d(positionX4-0.015, positionY1-0.07);
			     gl.glVertex2d(positionX4+0.015, positionY1-0.07);
			     gl.glEnd(); 
			       
			       
			       
			       
			       gl.glLineWidth(1f);
			       gl.glBegin(GL.GL_LINE_STRIP);
			       gl.glColor3d(0, 0, 0);
			       for (int deg=135 ; deg<=225 ; deg++ ) {
			       double rad = Math.toRadians(deg);
			       double x1 = positionX4 +0.02 + 0.03 * Math.cos(rad);
			       double y1 = positionY1 -0.09 + 0.03 * Math.sin(rad);
			       gl.glVertex2d(x1, y1);
			       }
			       gl.glEnd();  
			       gl.glBegin(GL.GL_LINE_STRIP);
			       for (int deg=0 ; deg<=45 ; deg++ ) {
			       double rad = Math.toRadians(deg);
			       double x2 = positionX4 - 0.048+ 0.06 * Math.cos(rad);
			       double y2 = positionY1 - 0.15 + 0.06 * Math.sin(rad);
			       gl.glVertex2d(x2, y2);
			       }
			       gl.glEnd();
			       gl.glBegin(GL.GL_LINE_STRIP);
			       for (int deg=315 ; deg<=360 ; deg++ ) {
				   double rad = Math.toRadians(deg);
				   double x3 = positionX4 - 0.047 + 0.06 * Math.cos(rad);
				   double y3 = positionY1 - 0.15 + 0.06 * Math.sin(rad);
				   gl.glVertex2d(x3, y3);
				   }
			       gl.glEnd();
		}
	}
	
    class sun{
	    Random r = new Random();
	    void drawsun(GL gl){ 
	    	 for(int angle = 0; angle < 360; angle+=15){
	    	 double xPos=r.nextFloat()*0.32-0.86;
		     double yPos=Math.sqrt(0.0256-(xPos+0.7f)*(xPos+0.7f));   
		        
		         gl.glEnable(GL.GL_BLEND); 
			     gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
			     gl.glLineWidth(0.6f);
			     gl.glBegin(GL.GL_LINES);
			     
			     gl.glColor3d(1, 1, 0);
			     gl.glVertex2d(-0.7, 0.7);
			     gl.glColor3d(1, 0.549, 0);
			     gl.glVertex2d(xPos,yPos+0.7);
			     gl.glColor3d(1, 1, 0); 
			     gl.glVertex2d(-0.7, 0.7); 
			     gl.glColor3d(1, 0.549, 0);
			     gl.glVertex2d(xPos,-yPos+0.7);
			        
			     gl.glEnd();}

			 
		     double xOrig=-0.7;
			 double yOrig=0.7;   
			 gl.glBegin(GL.GL_TRIANGLE_FAN);
			 gl.glColor3d(0.9, 0.9, 0.1);
			 gl.glVertex2d(xOrig, yOrig);		
			 for(int deg=0;deg<=360;deg++){
				 double rads=Math.toRadians(deg);
				 double x1=xOrig+0.14*Math.cos(rads);
				 double y1=yOrig+0.14*Math.sin(rads);
				 gl.glColor3d(0.9, 0.3, 0.1);
				 gl.glVertex2d(x1, y1);
			 }
			 gl.glEnd();		 

	}
	
}
    
    class tree1{
		void drawtree(float x1, float y1, GL gl){
			gl.glBegin(GL.GL_QUADS);
			gl.glColor3f(0.1f, 0.1f, 0.1f);  
			    gl.glVertex2f(x1, y1);
			    gl.glVertex2f(x1+0.05f, y1);
			    gl.glVertex2f(x1+0.05f, y1+0.15f);
			    gl.glVertex2f(x1, y1+0.15f);
			    gl.glEnd();
			  
			gl.glBegin(GL.GL_TRIANGLES);
			gl.glColor3f(0.0f, 0.6f, 0.0f); 
			     gl.glVertex2f(x1-0.15f, y1+0.15f);   
			     gl.glVertex2f(x1+0.2f, y1+0.15f); 	    
			     gl.glVertex2f(x1+0.025f, y1+0.3f);	     
			     gl.glVertex2f(x1-0.1f, y1+0.23f);   	     
			     gl.glVertex2f(x1+0.15f, y1+0.23f); 	    
			     gl.glVertex2f(x1+0.025f, y1+0.35f);
			     gl.glVertex2f(x1-0.05f, y1+0.31f);   	     
			     gl.glVertex2f(x1+0.1f, y1+0.31f); 	    
			     gl.glVertex2f(x1+0.025f, y1+0.4f);
			     
			     gl.glEnd();
		}
		
		}
	
    class tree2{
			void drawtree(float x2, float y2, GL gl){
				gl.glBegin(GL.GL_QUADS);
				gl.glColor3f(0.1f, 0.1f, 0.1f);  
				    gl.glVertex2f(x2, y2);
				    gl.glVertex2f(x2+0.03f, y2);
				    gl.glVertex2f(x2+0.03f, y2+0.1f);
				    gl.glVertex2f(x2, y2+0.1f);
				    gl.glEnd();
				  
				gl.glBegin(GL.GL_TRIANGLES);
				gl.glColor3f(0.0f, 0.8f, 0.0f); 
				     gl.glVertex2f(x2-0.09f, y2+0.1f);   
				     gl.glVertex2f(x2+0.12f, y2+0.1f); 	    
				     gl.glVertex2f(x2+0.015f, y2+0.22f);	     
				     gl.glVertex2f(x2-0.06f, y2+0.19f);   	     
				     gl.glVertex2f(x2+0.09f, y2+0.19f); 	    
				     gl.glVertex2f(x2+0.015f, y2+0.31f);
				     gl.glVertex2f(x2-0.02f, y2+0.28f);   	     
				     gl.glVertex2f(x2+0.05f, y2+0.28f); 	    
				     gl.glVertex2f(x2+0.015f, y2+0.37f);
				     
				     gl.glEnd();
			}
		
		
	}
	
    class house{
		 void drawhouse(GL gl) {
			
			 gl.glBegin(GL.GL_QUADS);
				
				gl.glColor3d(0.5f,0.5f,0.5f);
				gl.glVertex2f(0.80f,0.48f);
				gl.glVertex2f(0.95f,0.48f);
				gl.glVertex2f(0.95f,0.59f);
				gl.glVertex2f(0.80f,0.59f);
				
				gl.glEnd();
				
				gl.glBegin(GL.GL_TRIANGLES);
				
				gl.glColor3f(1f,0f,0f);
				gl.glVertex2f(0.80f,0.59f);
				gl.glVertex2f(0.875f,0.68f);
				gl.glVertex2f(0.95f,0.59f);
				
				gl.glEnd();
			
		
		}
		
	}
	
    class skyw{
		void drawskyw(GLAutoDrawable drawable){
			GL gl = drawable.getGL();
			
			gl.glBegin(GL.GL_POLYGON);
		    gl.glColor3d(0.51f, 0.43f, 1.0f); 
		    gl.glVertex2f(-1.0f, 1.0f);
		    gl.glVertex2f(-1.0f, -0.4f);	
			gl.glVertex2f(-0.8f, -0.3f);
			gl.glVertex2f(-0.7f, -0.3f);
			gl.glVertex2f(-0.5f, -0.35f);
			gl.glVertex2f(-0.2f, -0.25f);
			gl.glVertex2f(-0.1f, -0.18f);
			gl.glVertex2f(0.1f, 0.09f);
			gl.glVertex2f(0.3f, 0.24f);
			gl.glVertex2f(0.51f, 0.34f);
			gl.glVertex2f(0.82f, 0.56f);
			gl.glVertex2f(0.95f, 0.60f);
			gl.glVertex2f(1.0f, 0.63f); 
			gl.glVertex2f(1.0f, 1.0f);
			gl.glEnd();
		
		}
		
	}
	
    class mountainw{
		void drawmountainw(GLAutoDrawable drawable){
			
			GL gl = drawable.getGL();
		
			gl.glBegin(GL.GL_POLYGON);
		    gl.glColor3d(1,1,1); 
		    gl.glVertex2f(-1.0f, -1.0f);
		    gl.glVertex2f(-1.0f, -0.4f);	
			gl.glVertex2f(-0.8f, -0.3f);
			gl.glVertex2f(-0.7f, -0.3f);
			gl.glVertex2f(-0.5f, -0.35f);
			gl.glVertex2f(-0.2f, -0.25f);
			gl.glVertex2f(-0.1f, -0.18f);
			gl.glVertex2f(0.1f, 0.09f);
			gl.glVertex2f(0.3f, 0.24f);
			gl.glVertex2f(0.51f, 0.34f);
			gl.glVertex2f(0.82f, 0.56f);
			gl.glVertex2f(0.95f, 0.60f);
			gl.glVertex2f(1.0f, 0.63f); 
			gl.glColor3d(0.75,0.75,0.75); 
			gl.glVertex2f(1.0f, -1.0f);
			
			gl.glEnd();
			
			gl.glColor3d(0,1,1);
		    gl.glVertex2f(-1.0f, 1.0f);
			
		}
	}
	
    class sunw{
	    Random r = new Random();
	    void drawsunw(GL gl){ 
	    	 for(int angle = 0; angle < 360; angle+=15){
	    	 double xPos=r.nextFloat()*0.32-0.86;
		     double yPos=Math.sqrt(0.018-(xPos+0.7)*(xPos+0.7));   
		        
		         gl.glEnable(GL.GL_BLEND); 
			     gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
			     gl.glLineWidth(0.6f);
			     gl.glBegin(GL.GL_LINES);
			  
			     gl.glColor3d(1, 1, 0);
			     gl.glVertex2d(-0.7, 0.7);
			     gl.glColor3d(1, 1, 0);
			     gl.glVertex2d(xPos,yPos+0.7F);
			     gl.glColor3d(1, 1, 0); 
			     gl.glVertex2d(-0.7, 0.7); 
			     gl.glColor3d(1, 1, 0);
			     gl.glVertex2d(xPos,-yPos+0.7F);
			        
			        gl.glEnd();}
				
			 
			 
			 
		     double xOrig=-0.7;
			 double yOrig=0.7;   
			 gl.glBegin(GL.GL_TRIANGLE_FAN);
			 gl.glColor3d(0.9, 0.9, 0.1);
			 gl.glVertex2d(xOrig, yOrig);		
			 for(int deg=0;deg<=360;deg++){
				 double rads=Math.toRadians(deg);
				 double x1=xOrig+0.12*Math.cos(rads);
				 double y1=yOrig+0.12*Math.sin(rads);
				 gl.glColor3d(0.9, 0.3, 0.1);
				 gl.glVertex2d(x1, y1);
			 }
			 gl.glEnd();		 

	}
	
}
    
    private void createParticleExplosion() {
		// get mouse coordinates
	
		// calculate GL coordinates
		double px =  Math.random() *2- 1;//x出现的位置区域
		double py = 1.05;
		for (int i = 0; i < 20; i++) {//雪的数量
			double pdx = Math.random() - 0.1;//这俩参数可改
			double pdy = Math.random() - 0.01;
			Snow.addParticle(px, py, pdx, pdy);
		}
	}
    
    private void createParticleExplosion1() {
  		// get mouse coordinates
    	positionX1 += speed;
    	if(positionX1 >=0.9f)
	      {
	    	positionX1 = -0.85f;
	      }
  		// calculate GL coordinates
  		double px =  positionX1 - 0.20;
  		double py = 0.85;
  		for (int i = 0; i < 5; i++) {
  			double pdx = Math.random()*15- 1;
  			double pdy = Math.random()*0.1 -1;
  			Rain.addParticle(px, py, pdx, pdy);
  		}
  	}

    
    class tree3{
		void drawtree(float x1, float y1, GL gl){
			gl.glBegin(GL.GL_QUADS);
			gl.glColor3f(0.1f, 0.1f, 0.1f);  
			    gl.glVertex2f(x1, y1);
			    gl.glVertex2f(x1+0.05f, y1);
			    gl.glVertex2f(x1+0.05f, y1+0.15f);
			    gl.glVertex2f(x1, y1+0.15f);
			    gl.glEnd();
			  
			gl.glBegin(GL.GL_TRIANGLES);
			gl.glColor3f(0.0f, 0.5f, 0.0f); 
			     gl.glVertex2f(x1-0.15f, y1+0.15f);   
			     gl.glVertex2f(x1+0.2f, y1+0.15f); 	    
			     gl.glVertex2f(x1+0.025f, y1+0.3f);	     
			     gl.glVertex2f(x1-0.1f, y1+0.23f);   	     
			     gl.glVertex2f(x1+0.15f, y1+0.23f); 	    
			     gl.glVertex2f(x1+0.025f, y1+0.35f);
			     gl.glVertex2f(x1-0.05f, y1+0.31f);   	     
			     gl.glVertex2f(x1+0.1f, y1+0.31f); 
			     gl.glColor3f(1.0f, 1.0f, 1.0f);
			     gl.glVertex2f(x1+0.025f, y1+0.4f);
			     
			     gl.glEnd();
		}
		
		}
	
    class tree4{
			void drawtree(float x2, float y2, GL gl){
				gl.glBegin(GL.GL_QUADS);
				gl.glColor3f(0.1f, 0.1f, 0.1f);  
				    gl.glVertex2f(x2, y2);
				    gl.glVertex2f(x2+0.03f, y2);
				    gl.glVertex2f(x2+0.03f, y2+0.1f);
				    gl.glVertex2f(x2, y2+0.1f);
				    gl.glEnd();
				  
				gl.glBegin(GL.GL_TRIANGLES);
				gl.glColor3f(0.0f, 0.4f, 0.0f); 
				     gl.glVertex2f(x2-0.09f, y2+0.1f);   
				     gl.glVertex2f(x2+0.12f, y2+0.1f); 	    
				     gl.glVertex2f(x2+0.015f, y2+0.22f);	     
				     gl.glVertex2f(x2-0.06f, y2+0.19f);   	     
				     gl.glVertex2f(x2+0.09f, y2+0.19f); 	    
				     gl.glVertex2f(x2+0.015f, y2+0.31f);
				     gl.glVertex2f(x2-0.02f, y2+0.28f);   	     
				     gl.glVertex2f(x2+0.05f, y2+0.28f); 
				     gl.glColor3f(1.0f, 1.0f, 1.0f);
				     gl.glVertex2f(x2+0.015f, y2+0.37f);
				     
				     gl.glEnd();
			}
		
		
	}
	
    class housew{
		 void drawhousew(GL gl) {
			
			 gl.glBegin(GL.GL_QUADS);
				
				gl.glColor3d(0.5f,0.5f,0.5f);
				gl.glVertex2f(0.80f,0.48f);
				gl.glVertex2f(0.95f,0.48f);
				gl.glVertex2f(0.95f,0.59f);
				gl.glVertex2f(0.80f,0.59f);
				
				gl.glEnd();
				
				gl.glBegin(GL.GL_TRIANGLES);
				
				gl.glColor3f(1f,0f,0f);
				gl.glVertex2f(0.80f,0.59f);
				gl.glVertex2f(0.95f,0.59f);
				gl.glColor3f(1.0f, 1.0f, 1.0f);
				gl.glVertex2f(0.875f,0.68f);
				gl.glEnd();
			
		
		}
		
	}

	class button{
		void drawedge1(GLAutoDrawable drawable){
			
			GL gl = drawable.getGL();
			
			gl.glBegin(GL.GL_QUADS);
			
			gl.glColor3d(0.4,0.4,0.4);
			gl.glVertex2f(-0.99f,-0.999f);
			gl.glVertex2f(-0.65f,-0.999f);
			gl.glVertex2f(-0.65f,-0.9f);
			gl.glVertex2f(-0.99f,-0.9f);
			
			gl.glEnd();
		    
			gl.glFlush();
			
		}
        void drawedge2(GLAutoDrawable drawable){
			
			GL gl = drawable.getGL();
			
			gl.glBegin(GL.GL_QUADS);
			
			gl.glColor3d(0.4,0.4,0.4);
			gl.glVertex2f(-0.60f,-0.999f);
			gl.glVertex2f(-0.26f,-0.999f);
			gl.glVertex2f(-0.26f,-0.9f);
			gl.glVertex2f(-0.60f,-0.9f);
			
			gl.glEnd();
		    
			gl.glFlush();
			
		}
        void drawedge3(GLAutoDrawable drawable){
			
			GL gl = drawable.getGL();
			
			gl.glBegin(GL.GL_QUADS);
			
			gl.glColor3d(0.5,0,1);
			gl.glVertex2f(-0.99f,-0.999f);
			gl.glVertex2f(-0.65f,-0.999f);
			gl.glVertex2f(-0.65f,-0.9f);
			gl.glVertex2f(-0.99f,-0.9f);
			
			gl.glEnd();
		    
			gl.glFlush();
			
		}
        void drawedge4(GLAutoDrawable drawable){
			
			GL gl = drawable.getGL();
			
			gl.glBegin(GL.GL_QUADS);
			
			gl.glColor3d(0.5,0,1);
			gl.glVertex2f(-0.60f,-0.999f);
			gl.glVertex2f(-0.26f,-0.999f);
			gl.glVertex2f(-0.26f,-0.9f);
			gl.glVertex2f(-0.60f,-0.9f);
			
			gl.glEnd();
		    
			gl.glFlush();
			
		}
	}
    
	class snowman{
		void drawsnowman(GL gl){
			gl.glColor3f(1.0f, 1.0f, 1.0f);  

	        double xOrig1 = 0.7;
	        double yOrig1 = -0.6;
	        
	        gl.glBegin(GL.GL_TRIANGLE_FAN);
	        gl.glVertex2d(xOrig1, yOrig1);
	        for (int deg = 0; deg <= 360; deg++) {  
	            double rad = Math.toRadians(deg);
	            double x = xOrig1 + 0.1 * Math.cos(rad);
	            double y = yOrig1 + 0.1 * Math.sin(rad);
	            gl.glVertex2d(x, y);
	        }
	        gl.glEnd();

	        gl.glColor3f(1.0f, 1.0f, 1.0f);  

	        double xOrig2 = 0.7;
	        double yOrig2 = -0.78;
	        
	        gl.glBegin(GL.GL_TRIANGLE_FAN);
	        gl.glVertex2d(xOrig2, yOrig2);
	        for (int deg = 0; deg <= 360; deg++) {  
	            double rad = Math.toRadians(deg);
	            double x = xOrig2 + 0.14 * Math.cos(rad);
	            double y = yOrig2 + 0.14 * Math.sin(rad);
	            gl.glVertex2d(x, y);
	        }
	        gl.glEnd();

	        gl.glBegin(GL.GL_TRIANGLES);
			gl.glColor3f(1.0f, 0.0f, 0.0f); 
			     gl.glVertex2f(0.7f, -0.59f);   
			     gl.glVertex2f(0.68f, -0.61f); 	    
			     gl.glVertex2f(0.74f, -0.62f);	     			   
			gl.glEnd();
			
			
			double xOrig3 = 0.7;
		    double yOrig3 = -0.63;
			gl.glBegin(GL.GL_TRIANGLE_FAN);
			gl.glColor3f(0.0f, 0.0f, 0.0f); 
	        gl.glVertex2d(xOrig3, yOrig3);
	        for (int deg = 180; deg <= 360; deg++) {  
	            double rad = Math.toRadians(deg);
	            double x = xOrig3 + 0.03 * Math.cos(rad);
	            double y = yOrig3 + 0.03 * Math.sin(rad);
	            gl.glVertex2d(x, y);
	        }
	        gl.glEnd();
	        
	        gl.glColor3d(0,0,0);
	        
			gl.glBegin(GL.GL_LINES);
				gl.glVertex2f(0.8f, -0.73f);
				gl.glVertex2f(0.85f, -0.6f);
			gl.glEnd();
			
			gl.glColor3d(0,0,0);
			gl.glBegin(GL.GL_LINES);
				gl.glVertex2f(0.6f, -0.73f);
				gl.glVertex2f(0.55f, -0.6f);
			gl.glEnd();
			
	        gl.glFlush();
		}
	}
	
	class eye{
		void draweye(GL gl){
			gl.glColor3f(0f, 0f, 0f);    	         
		    gl.glPointSize(8f); 	    
		    gl.glBegin(GL.GL_POINTS);
		    gl.glVertex2f(positionX7, -0.57f);   
		    gl.glEnd();
			
			gl.glColor3f(0f, 0f, 0f);            
	        gl.glPointSize(8f); 	    
	        gl.glBegin(GL.GL_POINTS);
	        gl.glVertex2f(positionX7+0.08f, -0.57f);  
	        gl.glEnd();
		}
	}
	
	class bird{
    	void drawbird(GL gl){
    		gl.glBegin(GL.GL_TRIANGLES);
	        gl.glColor3f(0.5f, 0.5f, 0.5f);   
	        gl.glVertex2d(positionX6,0.1);
	        gl.glColor3f(0.75f, 0.75f, 0.75f);
	        gl.glVertex2d(positionX6-0.08,0.16);
	        gl.glVertex2d(positionX6-0.08,0.04);
	        gl.glEnd();
	        gl.glBegin(GL.GL_POLYGON);
	        gl.glColor3f(0.6f, 0.6f, 0.6f); 
	        for (int deg = 0; deg <= 360; deg++) {          
	        	double rad = Math.toRadians(deg);
	            double x1 = positionX5 + 0.04 * Math.cos(rad);
	            double y1 = 0.1 + 0.04 * Math.sin(rad);
	            gl.glVertex2d(x1, y1);
	        }
	        gl.glEnd();
	        
	        gl.glBegin(GL.GL_TRIANGLES);
	        gl.glColor3f(0f, 0f, 0f); 
	        gl.glVertex2d(positionX5+0.03,0.09);
	        gl.glVertex2d(positionX5+0.02,0.08);
	        gl.glVertex2d(positionX5+0.06,0.06);
	        gl.glEnd();
	        
	        gl.glBegin(GL.GL_TRIANGLES);
	        gl.glColor3f(0.5f, 0.5f, 0.5f); 
	        gl.glVertex2d(positionX5-0.065,0.13);
	        gl.glVertex2d(positionX5-0.045,0.115);
	        gl.glVertex2d(positionX5-0.04,0.16);
	        gl.glEnd();
	        
	        gl.glBegin(GL.GL_TRIANGLES);
	        gl.glColor3f(0.5f, 0.5f, 0.5f); 
	        gl.glVertex2d(positionX5-0.065,0.07);
	        gl.glVertex2d(positionX5-0.045,0.085);
	        gl.glVertex2d(positionX5-0.04,0.04);
	        gl.glEnd();
	        
	        gl.glPointSize(4f); 
	        gl.glColor3f(0.0f,0.0f,0.0f);
	        gl.glBegin(GL.GL_POINTS);
	        gl.glVertex2d(positionX5, 0.1f);   
	        gl.glEnd();
	        
	        gl.glColor3d(0,0,0);
			gl.glBegin(GL.GL_LINES);
		    gl.glVertex2d(positionX6-0.08, 0.11);
			gl.glVertex2d(positionX6-0.12, 0.13);
			gl.glVertex2d(positionX6-0.08, 0.09);
			gl.glVertex2d(positionX6-0.12, 0.07);
			gl.glEnd();
    	}
    }
    
	
	
	public static void main(String[] args) {
	
		Frame frame = new Frame("Leon Yu");
		GLCanvas canvas = new GLCanvas();
		Season s=new Season();
		canvas.addGLEventListener(new Season());
		canvas.addGLEventListener(s);
		canvas.addMouseListener(s);
		canvas.addMouseMotionListener(s);
		frame.add(canvas);
		frame.setSize(720,720);
		final Animator animator = new Animator(canvas);
		
		
        frame.addWindowListener(new WindowAdapter() {
            
            public void windowClosing(WindowEvent e) {
               
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	    animator.start();
	}
	
	
	public void displayChanged(GLAutoDrawable drawable, boolean arg1, boolean arg2) {}

	public void reshape(GLAutoDrawable drawable, int arg1, int arg2, int arg3, int arg4) {
//		this.windowWidth = width;
//		this.windowHeight = height;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX()>=0&&e.getX()<=250&&e.getY()>=650&&e.getY()<=673){
			index=!index;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
