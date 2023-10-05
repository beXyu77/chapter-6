package se233.snakegame.model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import se233.snakegame.view.Platform;

import java.util.Random;

public class Food {
    Logger logger = LogManager.getLogger(Food.class);
    private Point2D position;
    private Color color;

    private Random rn;
    public Food(Point2D position) {
        this.rn = new Random();
        this.position = position;

    }
    public Food(Color color){
        this.rn = new Random();
        respawn();
        this.color= color;
    }

    public void respawn() {
        Point2D prev_position = this.position;
        do{
            this.position =new Point2D(rn.nextInt(Platform.WIDTH),rn.nextInt(Platform.HEIGHT));

        }while(prev_position == this.position);
        logger.info("food: x:{} y:{}",this.position.getX(), this.position.getY());
    }

    public Point2D getPosition() {
        return position;
    }

    public boolean isGreen() {
        if(this.color == Color.GREEN){return true;}

        return false;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
/*
import javafx.geometry.Point2D;
import se233.chapter5_tdd.view.Platform;

import java.util.Random;

public class Food {
    private Point2D position;
    private Random rn;
    public Food(Point2D position) {
        this.rn = new Random();
        this.position = position;
    }
    public Food() {
        this.rn = new Random();
        respawn();
    }
    public void respawn() {
        Point2D prev_position = this.position;
        do {
            this.position = new Point2D(rn.nextInt(Platform.WIDTH), rn.nextInt(Platform.HEIGHT));
        } while(prev_position == this.position);
    }
    public Point2D getPosition() { return position; }

    public boolean isGreen() {
    }
}
*/