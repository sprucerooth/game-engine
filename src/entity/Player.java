package entity;

import entity.collidable.Collidable;
import input.KeyListenerImpl;

import java.awt.*;

public class Player extends Being {

    private final KeyListenerImpl keyInput;
    private final double jumpVelocity = -25;
    private final double gravity = 1.5;
    private final double runSpeed = 4;
    private double xMove, yMove;

    private boolean isGrounded, isJumping, isHittingHead = false;
    private double inAirTick = 0;

    public Player(KeyListenerImpl keyInput) {
        super(0, 0, 50, 50, true, null);
        this.keyInput = keyInput;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect((int) x, (int) y, width, height);
        g.setColor(Color.white);
        g.drawString("Pos x: " + x, 50, 50);
        g.drawString("Pos y: " + y, 50, 70);
        g.drawString("Airtick: " + inAirTick, 150, 50);
    }


    @Override
    public void update() {

        checkStatus();
        checkInput();
        if (isJumping) yMove = jumpVelocity;
        gravity();
        checkCollision();

        move(((int) xMove), ((int) yMove));
        xMove = 0;
        yMove = 0;

    }

    private void checkStatus() {
        isGrounded = Collidable.possibleDistanceDown(this, 1, 0) == 0;
        isHittingHead = Collidable.possibleDistanceUp(this, -1) == 0;

        if (isGrounded || isHittingHead) {
            isJumping = false;
            inAirTick = 0;
        }
    }

    private void gravity() {
        if (!isGrounded) {
            inAirTick++;
            yMove += gForce();
        }
    }

    private void checkInput() {
        if (keyInput.up && isGrounded) {
            isJumping = true;
            isGrounded = false;
        }
        if (keyInput.left) {
            xMove = -runSpeed;
        } else if (keyInput.right) {
            xMove = runSpeed;
        }
        if (keyInput.space) {
            reset();
        }
    }

    private void checkCollision() {
        if (yMove > 0) {
            yMove = Collidable.possibleDistanceDown(this, yMove, 0);
        } else if (yMove < 0) {
            yMove = Collidable.possibleDistanceUp(this, yMove);
        }

        boolean inPositiveSlope = Collidable.possibleDistanceRight(this, 1, 0) == 0 && Collidable.possibleDistanceRight(this, 1, -1) > 0;
        boolean inNegativeSlope = Collidable.possibleDistanceLeft(this, -1, 0) == 0 && Collidable.possibleDistanceLeft(this, -1, -1) < 0;

        // Move right
        if (xMove > 0) {
            if (inPositiveSlope) {
                if (!isJumping) {
                    yMove = -3;
                }
                xMove = Collidable.possibleDistanceRight(this, 10, yMove);//TODO: desired distance not relevant. should be as high as possible. new method ?
            } else if (inNegativeSlope) {
                // Causes instant fall as seen in bugs/1
                //yMove = Collidable.possibleDistanceDown(this, 100, xMove);//TODO: desired distance not relevant. should be as high as possible. new method ?
            } else {
                xMove = Collidable.possibleDistanceRight(this, xMove, yMove);
            }

        } else if (xMove < 0) {
            if (inNegativeSlope) {
                if (!isJumping) {
                    yMove = -3;
                }
            }
            xMove = Collidable.possibleDistanceLeft(this, xMove, yMove);//TODO: desired distance not relevant. should be as high as possible. new method ?
        }
    }

    public void reset() {
        isJumping = false;
        isHittingHead = false;
        inAirTick = 0;
        x = 10;
        y = 10;
        xMove = yMove = 0;
    }

    private double gForce() {
        return gravity * inAirTick;
    }

}