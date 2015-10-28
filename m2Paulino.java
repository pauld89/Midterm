float dogX, dogY, dogDX, dogDY;
float aceX, aceY, aceDX, aceDY;
float pigX, pigY, pigDX, pigDY;
float top, bottom, left, right, middle;
boolean wall = true;
boolean mouse= false;

int counter = 0;


// SETUP WINDOW SIZE
void setup(){
  size(640, 480);
  reset();
  
}
// POSITIONS AND SPEED
void reset(){
  top= height-305;              
  bottom= height-75;
  left= width/2-260;
  right=width/2+260;
  middle= left + (right-left)/2;
  //POSITIONS
  dogX= random(middle, right);      dogY=random(top, bottom);
  aceX= random(middle, right);      aceY=random(top, bottom);
  pigX= random(middle, right);      pigY=random(top, bottom);
  //SPEED
  dogDX= random(-7,7);                    dogDY= random(-7,7);
  aceDX= random(-7,7);                    aceDY= random(-7,7);
  pigDX= random(-7,7);                    pigDY= random(-7,7);
  
}
  
  void draw(){
   background(#21FAEA); 
   table();
   ball();
   action();
   middleWall();

  }
  
  //TABLE
  void table(){
    rectMode(CENTER);  
    fill(#432805);
    rect(width/2, height/2 + 50, 600, 300);     
    fill(100, 200, 100);
    rect(width/2, height/2 + 50, 550, 250);     
    strokeWeight(20);                          
    stroke(130, 0, 65);                       
  }
    

  // BALLS
void ball(){
    strokeWeight(0);
    fill(255, 0, 0);
    ellipse(dogX, dogY, 30, 30);     //BALL
    fill(0, 0, 240);
    ellipse(aceX, aceY, 30, 30);     // BALL
    fill(255, 205, 0);
    ellipse(pigX, pigY, 30, 30);     //BALL
    
  }
  // BOUNCEING BALLS
  void action(){  
  
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
  
       //WALL
void middleWall(){
    if(wall){   
      float middle = ( left + right ) / 2;
      strokeWeight(1);                          
      stroke(0);      
      line(middle, top, middle, bottom);
    
    
    //bouncing off the wall
    
    dogX += dogDX;
  if(dogX > right || dogX < middle) dogDX *= -1;
 
  dogY += dogDY;
  if(dogY < top   || dogY > bottom) dogDY *= -1;
    }
    

}

void keyPressed(){  
  if ( key == 'w') {
    counter = counter + 1;
    if(counter % 2 > 0){
      wall = true;
    }
    else{
      wall = false;
    }
  }
}
    
