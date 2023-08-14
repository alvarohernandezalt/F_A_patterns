import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import hype.*; 
import hype.extended.behavior.*; 
import hype.extended.colorist.*; 
import hype.extended.layout.*; 
import hype.interfaces.*; 
import processing.pdf.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class MMrs05 extends PApplet {







boolean record = false;

HDrawablePool pool, pool2, pool3, pool4;
HColorPool colors, colors2, colors3;
long seed;
int bckCO = color(71,185,114);
int bckCO2 = color(255,0);
int bckCO3 = color(255,255,255);

public void setup() {
	
	H.init(this).background(bckCO);
	
	seed = (long)random(100000);
	randomSeed(seed);
	println("Seed:" + seed);


	colors3 = new HColorPool()
		.add(0xff73c48f)
		.add(bckCO2,2)
		.fillOnly()
	;
	pool3 = new HDrawablePool(15);
	pool3.autoAddToStage()
		.add(new HShape("MMrs05.svg"))
		.add(new HShape("MMrs11.svg"))
		.add(new HShape("MMrs18.svg"))
		.add(new HShape("MMrs22.svg"))
		.add(new HShape("MMrs25.svg"))
		.add(new HShape("MMrs14.svg"))
		.add(new HShape("MMrs15.svg"))

		.layout(
			new HGridLayout()
			.startX(100)
			.startY(100)
			.spacing(200,200)
			.cols(5)
			.rows(3)
		)

		.onCreate(
			new HCallback() {
				public void run(Object obj) {
					HShape d = (HShape) obj;
					d
						.enableStyle(false)
						// .noStroke()
						.strokeJoin(ROUND)
						.strokeCap(ROUND)
						.strokeWeight(1)
						.stroke(bckCO3)
						.noFill()
						// .fill(#FFFFFF)
						// .scale(random(0.5,1))
						//.size(50)
						//.size(((int)random(2)*100)+100)
						.rotate((int)random(4)*90)
						// .loc( (int)random(-200,width+200), (int)random(-200,height+200) )
						.anchorAt(H.CENTER)
					;
					//d.randomColors(colors.fillOnly());
					//new HRotate(d, 0.3);
				}
			}

		)
		.requestAll()
	;
	pool4 = new HDrawablePool(240);
	pool4.autoAddToStage()
		.add(new HShape("MMrs05.svg"))
		.add(new HShape("MMrs11.svg"))
		.add(new HShape("MMrs18.svg"))
		.add(new HShape("MMrs22.svg"))
		.add(new HShape("MMrs25.svg"))
		.add(new HShape("MMrs14.svg"))
		.add(new HShape("MMrs15.svg"))

		.layout(
			new HGridLayout()
			.startX(25)
			.startY(25)
			.spacing(50,50)
			.cols(20)
			.rows(12)
		)

		.onCreate(
			new HCallback() {
				public void run(Object obj) {
					HShape d = (HShape) obj;
					d
						.enableStyle(false)
						.noStroke()
						// .noFill()
						// .strokeJoin(ROUND)
						// .strokeCap(ROUND)
						// .strokeWeight(1)
						// .stroke(#FFFFFF)
						.fill(0xff020202)
						//.scale(random(0.5,1))
						// .size(50)
						.size(((int)random(2)*50)+100)
						.rotate((int)random(4)*90)
						//.loc( (int)random(-200,width+200), (int)random(-200,height+200) )
						.anchorAt(H.CENTER)
					;
					d.randomColors(colors3.fillOnly());
					//new HRotate(d, 0.5);
				}
			}

		)
		.requestAll()
	;






	
}

public void draw() {
	PGraphics tmp = null;

	if (record) {
		tmp = beginRecord(PDF, "/render/render-######.pdf");
	}

	if (tmp == null) {
		H.drawStage();
	} else {
		PGraphics g = tmp;
		boolean uses3D = false;
		float alpha = 1;
		H.stage().paintAll(g, uses3D, alpha);
	}

	if (record) {
		endRecord();
		record = false;
	}	
	
}

public void mousePressed() {
    record = true;
}

	
  public void settings() { 	size(1000, 600); 	smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "MMrs05" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
