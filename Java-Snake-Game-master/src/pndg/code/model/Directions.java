package pndg.code.model;

public class Directions {

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;


    public Directions(){
        leftDirection = false;
        rightDirection =true;
        upDirection = false;
        downDirection =false;
    }

    public boolean isLeftDirection() {
        return leftDirection;
    }

    public void setLeftDirection( boolean leftDirection ) {
        this.leftDirection = leftDirection;
    }

    public boolean isRightDirection() {
        return rightDirection;
    }

    public void setRightDirection( boolean rightDirection ) {
        this.rightDirection = rightDirection;
    }

    public boolean isUpDirection() {
        return upDirection;
    }

    public void setUpDirection( boolean upDirection ) {
        this.upDirection = upDirection;
    }

    public boolean isDownDirection() {
        return downDirection;
    }

    public void setDownDirection( boolean downDirection ) {
        this.downDirection = downDirection;
    }
}
