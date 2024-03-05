package com.navel.navalbattle;

import javafx.scene.paint.Color;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ship {
    private int shipID;
    private int shipSize;
    private int squareSize;
    private Rectangle rec;
    private double x;
    private double y;
    private Color color = Color.BLACK;
    private double homeX;
    private double homeY;
    private boolean isVertical = false;
    private boolean firstDrag = true;

    public boolean isVertical() {
        return isVertical;
    }

    public Ship(int shipID, int squareSize, Rectangle rec, int x, int y, int shipSize) {
        this.squareSize = squareSize;
        this.rec = rec;
        this.x = x;
        this.y = y;
        this.shipSize = shipSize;
        this.shipID = shipID;
    }

    public void setVertical(boolean vertical) {
        isVertical = vertical;
    }

    public void draw() {
        if (isVertical) {
            rec.setWidth(squareSize);
            rec.setHeight(squareSize * shipSize);
            rec.setTranslateX(x);
            rec.setTranslateY(y);
        }
        else {
            rec.setWidth(squareSize * shipSize);
            rec.setHeight(squareSize);
            rec.setTranslateX(x);
            rec.setTranslateY(y);
        }
    }
    public void draw(double drawX, double drawY) {
        if (isVertical) {
            rec.setRotate(rec.getRotate() - 90);
//            rec.setWidth(squareSize);
//            rec.setHeight(squareSize * shipSize);
//            rec.setTranslateX(drawX);
//            rec.setTranslateY(drawY);
        }
        else {
            rec.setRotate(rec.getRotate() + 90);
//            rec.setWidth(squareSize * shipSize);
//            rec.setHeight(squareSize);
//            rec.setTranslateX(drawX);
//            rec.setTranslateY(drawY);
        }
    }
    public void flipIsVertical() {
        System.out.println("FLIP");
        if (isVertical) {
            isVertical = false;
            //y -= squareSize * ((float)(shipSize) / 2) - 20;
            //draw(x, y - squareSize * ((float)(shipSize) / 2) - 20);
            draw();
        }
        else {
            isVertical = true;
            firstDrag = true;
            //y += squareSize * ((float)(shipSize) / 2) - 20;
            draw(x, y + squareSize * ((float)(shipSize) / 2) - 20);
        }
//        System.out.println(x);
//        System.out.println(y);
    }

    public int[] getUsedArea() {
        int[] area = new int[4];
        if (isVertical) {
            area[0] = (int)(x) / 40 - 1;
            area[1] = area[0] + 2;

            area[2] = (int)(y) - 1;
            area[3] = area[2] + shipSize + 1;
        }
        else {
            area[0] = (int)(x) / 40 - 1;
            area[1] = area[0] + shipSize + 1;

            area[2] = (int)(y) / 40 - 1;
            area[3] = area[2] + 2;
        }
        return area;
    }

    public int getShipSize() {
        return shipSize;
    }

    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }

    public int getSquareSize() {
        return squareSize;
    }

    public void setSquareSize(int squareSize) {
        this.squareSize = squareSize;
    }

    public Rectangle getRec() {
        return rec;
    }

    public void setRec(Rectangle rec) {
        this.rec = rec;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public double getHomeX() {
        return homeX;
    }

    public void setHomeX(double homeX) {
        this.homeX = homeX;
    }

    public double getHomeY() {
        return homeY;
    }

    public void setHomeY(double homeY) {
        this.homeY = homeY;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public int getShipID() {
        return shipID;
    }

    public void setShipID(int shipID) {
        this.shipID = shipID;
    }

    public void setY(double y) {
        this.y = y;
    }
}