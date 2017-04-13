// 5 Oct 2016
// Thomas Burless
// HW #4 - CSCI 157 6.8.3
// Program that creates face, hides it, returns its x value, and changes color

import objectdraw.*;
import java.awt.*;

public class FunnyFace {

  private static final int FACE_HEIGHT = 60,  // dimensions of the face
                             FACE_WIDTH = 60,
        
                             EYE_OFFSET = 20,   // eye location and size
                             EYE_RADIUS = 8,
        
                             MOUTH_HEIGHT = 10, // dimensions of the mouth
                             MOUTH_WIDTH = FACE_WIDTH/2;

  private FramedOval head, leftEye, rightEye, mouth;
  private Color c;
  

  public FunnyFace( double left, double top, DrawingCanvas canvas) {
        head = new FramedOval( left, top, FACE_WIDTH, FACE_HEIGHT, canvas );
        mouth = new FramedOval( left+(FACE_WIDTH-MOUTH_WIDTH)/2, 
                                top + 2*FACE_HEIGHT/3,
                                MOUTH_WIDTH, MOUTH_HEIGHT, canvas );
        leftEye = new FramedOval( left+EYE_OFFSET-EYE_RADIUS/2, top+EYE_OFFSET, 
                                  EYE_RADIUS, EYE_RADIUS, canvas );
        rightEye = new FramedOval( left+FACE_WIDTH-EYE_OFFSET-EYE_RADIUS/2, 
                                   top+EYE_OFFSET, EYE_RADIUS, EYE_RADIUS, canvas);
    }

  public void removeFromCanvas() {
    head.hide();
    mouth.hide();
    leftEye.hide();
    rightEye.hide();
  }

  public double getX() {
    return head.getX();
  }

  public void setEyeColor( Color c ) {
    rightEye.setColor( c );
    leftEye.setColor( c );
  }

  public void move(  double x, double y ) {
    head.move( x, y );
    mouth.move( x, y );
    leftEye.move( x, y );
    rightEye.move( x, y );
}

  public void moveTo( double x, double y ) {
    this.move( x - head.getX(), y - head.getY() );
}
}
    
