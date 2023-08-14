import hype.*;
import hype.extended.behavior.*;
import hype.extended.colorist.*;
import hype.extended.layout.*;
import hype.interfaces.*;
import processing.pdf.*;
boolean record = false;

HDrawablePool pool, pool2, pool3, pool4;
HColorPool colors, colors2, colors3;
long seed;
color bckCO = color(#264653);
color bckCO2 = color(155,0);
color bckCO3 = color(#264653);

void setup() {
	size(1000, 600);
	H.init(this).background(bckCO);
	smooth();
	seed = (long)random(100000);
	randomSeed(seed);
	println("Seed:" + seed);


	colors3 = new HColorPool()
		.add(#264653)
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
						.fill(#222222)
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

void draw() {
	PGraphics tmp = null;

	if (record) {
		tmp = beginRecord(PDF, "/render/fa01_pt_"+seed+".pdf");
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

void mousePressed() {
    record = true;
}

	
