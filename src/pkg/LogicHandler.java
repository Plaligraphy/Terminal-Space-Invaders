package pkg;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class LogicHandler extends Draw{
    boolean running = false;
    int pointer=0;
    Scanner in = new Scanner(System.in);
    public void startGame() {
        setArrayContent(0,4,"1");
        System.out.println("Welcome to Terminal Invaders!");
        System.out.println("---    Debug      ---");
        System.out.println("---    Start      ---");
        System.out.println("---    Exit       ---");
        String firstOptSelect = in.nextLine();
        cls();
        if(firstOptSelect.equalsIgnoreCase("debug")) {
            debug();
        }else if(firstOptSelect.equalsIgnoreCase("start")) {
            running = true;
            update();
            gameLoop();
        }else if(firstOptSelect.equalsIgnoreCase("exit")) {

        }else{
            System.out.println("Invalid input!");
            startGame();
        }
    }
    private void endGame() {
        System.out.println("Game Over!");
        System.exit(0);
    }
    private void gameLoop() {
        if(running) {
            //update();
            System.out.println("Left || Right");
            String opt = in.nextLine();
            if(opt.equalsIgnoreCase("left")) {
                pointer--;
                setArrayZero();
                enemy();
                setArrayContent(pointer,4,"1");
                update();
            }else if(opt.equalsIgnoreCase("right")) {
                pointer++;
                setArrayZero();
                enemy();
                setArrayContent(pointer,4,"1");
                update();
            }else if(opt.equalsIgnoreCase("d")) {
                debug();
            }else if(opt.equalsIgnoreCase("shoot")){
                setArrayZero();
                enemy();
                setArrayContent(pointer,4,"1");
                shoot();
                update();
            }
            if(pointer < 0) {
                running = false;        //Collision with left wall
            }if (pointer > 4){
                running = false;        //Collision with right wall
            }

            gameLoop();
        }if(!running) {
            endGame();
        }
    }private void debug() {
        System.out.println("---Debug Screen---");
        System.out.println("Pointer: " + pointer);
        System.out.println("Running status: " + running);
    }
    private void enemy() {
        int min=0;
        int max=4;
        int maxEd = 3;
        int randomX= ThreadLocalRandom.current().nextInt(min, max + 1);
        int randomY = ThreadLocalRandom.current().nextInt(min, maxEd + 1);
        setArrayContent(randomX, randomY, "2");
        if(randomX > 0) {
            randomX--;
        }if(randomY > 0) {
            randomY--;
        }
        setArrayContent(randomX,randomY,"0");
        randomX++;
        randomY++;
    }
    private void shoot() {
        int pointeradd = 3;
        int trajectory = pointer;
        setArrayContent(trajectory,pointeradd,"*");
        pointeradd++;
    }
}
