package oclu.ludumdare.elements;

import org.newdawn.slick.*;

public class Bullet {

    SpriteSheet sheet;
    Image bullet;

    float posX;
    float posY;
    float speed;

    double angle;

    public Asteroid target;

    public Bullet(SpriteSheet sheet, float posX, float posY, Asteroid target) {

        this.sheet = sheet;

        bullet = sheet.getSubImage(19, 99, 10, 10);

        this.posX = posX;
        this.posY = posY;

        this.target = target;

    }

    public void move(int delta) {

        speed = delta * 0.5f;

        float targetX = (float)target.xPos;
        float targetY = target.yPos;

            if (targetX - posX == 0) {
                angle = Math.atan((targetY-posY)/0.001);
            }else {
                angle = Math.atan((targetY-posY) / (targetX-posX));
            }
            angle *= 180 / Math.PI;
            angle += 90;
            if (targetX-posX < 0) {
                angle += 180;
            }


        posX += Math.cos(angle) * speed;
        posY += Math.sin(angle) * speed;

    }

    public void draw() {
        bullet.draw(posX, posY);
    }

    public boolean hitDetection() {

        if (posX >= target.xPos && posX <= target.xPos + 32 && posY >= target.yPos && posY <= target.yPos + 32 && target.isDestroyed == false) {
            return true;
        }else {
            return false;
        }

    }

}
