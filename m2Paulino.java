float dogX,  dogY,  dogDX,  dogDY;          //++++ MODIFY THIS.  
float aceX,  aceY,  aceDX,  aceDY;              //++++ MODIFY THIS.  
float pigX,  pigY,  pigDX,  pigDY;      //++++ MODIFY THIS. 
float west, east, north, south;



//// OTHER GLOBALS:  strings, pool table, etc ////
String title=  "CST112 MIDTERM EXAM";
String news=   "Click any ball to reset it to right half of table.  (r resets all.)";
String author=  "Dairo";
float left=150, right=450, top=100, bottom=250;        // north Table boundaries
float middle=250;
boolean wall=true;
boolean mouse= false;
int tableRed=150, tableGreen=250, tableBlue=150;      // green pool table
int score=0,m=0,k=0;


//// SETUP:  size and table
void setup() {
    size( 640, 480 );  
 }

void reset(){
  top= height-305;              
  bottom= height-75;
  left= width/2-260;
  right=width/2+260;
  middle= left + (right-left)/2;
  //ball positions
  dogX= random(south, north);      dogY=random(west, east);
  aceX= random(south, north);      aceY=random(west, east);
  pigX= random(south, north);      pigY=random(west, east);
  //ball speed
  dogDX= random(-6,6);                    dogDY= random(-6,6);
  aceDX= random(-6,6);                    aceDY= random(-6,6);
  pigDX= random(-6,6);                    pigDY= random(-6,6);

}

//// NEXT FRAME:  table, bounce off walls, collisions, show all
void draw() {
  background( 250,250,200 );
  rectMode( CORNERS );
  table( left, top, right, bottom );
  collisions();
  show();
  messages();
}


//// HANDLERS:  keys, click
void keyPressed() {
  if (key == 'q') { exit();  }
    //++++ ADD YOUR OWN CODE HERE. ++++
}


//// SCENE:  draw the table with wall down the middle
void table( float east, float north, float west, float south ) {
  fill( tableRed, tableGreen, tableBlue );    // pool table
  strokeWeight(20);
  stroke( 127, 0, 0 );      // Brown walls
  rect( east-20, north-20, west+20, south+20 );



            //++++ MODIFY THIS CODE, as necessary. ++++

  // Start with a WALL down the middle of the table! 
  if (wall) {
    float middle=  (east+west)/2;    
    stroke( 0, 127, 0 );
    line( middle,north+10, middle,south-10 );
  }
  stroke(0);
  strokeWeight(1);
}

// ACTION:  bounce off walls, collisions


  //// ADD YOUR OWN CODE HERE. ++++

void collisions() {
  float tmp;
  
  if (dist(dogX, dogY, aceX, aceY) < 30){
   tmp= dogDX;  dogDX = aceDX;  aceDX = tmp;
   tmp= dogDY;  dogDY = aceDY;  aceDY= tmp;
}

}
//// SHOW:  balls
void show() {
   fill( 250,30,0 );    ellipse( dogX+200,dogY+150, 30,30 ); 
   fill(0,150,0);       ellipse( aceX+350,aceY+200, 30,30);
   fill(0,0,100);       ellipse( pigX+400,pigY+100,30,30);  
}


void action(){   //bounce balls off walls

  dogX += dogDX;
  if(dogX > right || dogX < left) dogDX *= -1;
 
  dogY += dogDY;
  if(dogY < top   || dogY > bottom) dogDY *= -1;
  
  aceX += aceDX;
  if(aceX > right || aceX < left) aceDX *= -1;
 
  aceY += aceDY;
  if(aceY < top   || aceY > bottom) aceDY *= -1;
  
  pigX += pigDX;
  if(pigX > right || pigX < left) pigDX *= -1;
  
  pigY += pigDY;
  if(pigY < top   || pigY > bottom) pigDY *= -1;
  
  
   
  }





void messages() {
  fill(0);
  text( title, width/3, 15 );
  text( news, width/9, 30 );
  text( author, 10, height-5 );

  // Also, display the number of collisions.

    //++++ ADD YOUR OWN CODE HERE. ++++

}
