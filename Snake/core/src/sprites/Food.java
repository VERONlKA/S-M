package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Food {
    private int x;
    private int y;
    private Texture one;
    private Texture two;
    private Texture three;
    private Texture four;
    private Texture five;
    private Texture six;
    private Texture seven;
    private Texture eight;
    private Texture nine;
    private Texture ten;
    private Texture twelve;
    private Texture fourteen;
    private Texture fifteen;
    private Texture sixteen;
    private Texture eighteen;
    private Texture twenty;
    private Texture twentyOne;
    private Texture twentyFour;
    private Texture twentyFive;
    private Texture twentySeven;
    private Texture twentyEight;
    private Texture thirty;
    private Texture thirtyTwo;
    private Texture thirtyFour;
    private Texture thirtySix;
    private Texture thirtyFive;
    private Texture fourty;
    private Texture fourtyTwo;
    private Texture fourtyFive;
    private Texture fourtyEight;
    private Texture fourtyNine;
    private Texture fifty;
    private Texture fiftyFour;
    private Texture fiftySix;
    private Texture sixty;
    private Texture sixtyFour;
    private Texture sixtyThree;
    private Texture seventy;
    private Texture seventyTwo;
    private Texture eighty;
    private Texture eightyOne;
    private Texture ninty;



    public Food(int boardSize){
        randomisePos(boardSize);
        one = new Texture("one.png");
        two = new Texture("two.png");
        three = new Texture("three.png");
        four = new Texture("four.png");
        five = new Texture("five.png");
        six = new Texture("six.png");
        seven = new Texture("seven.png");
        eight = new Texture("eight.png");
        nine = new Texture("nine.png");
        ten = new Texture("ten.png");
        twelve = new Texture("twelve.png");
        fourteen = new Texture("fourteen.png");
        fifteen = new Texture("fifteen.png");
        sixteen = new Texture("sixteen.png");
        eighteen = new Texture("eighteen.png");
        twenty = new Texture("twenty.png");
        twentyOne = new Texture("twentyone.png");
        twentyFour = new Texture("twentyfour.png");
        twentyFive = new Texture("twentyfive.png");
        twentySeven = new Texture("twentyseven.png");
        twentyEight = new Texture("twentyeight.png");
        thirty = new Texture("thirty.png");
        thirtyTwo = new Texture("thirtytwo.png");
        thirtyFour = new Texture("thirtyfour.png");
        thirtySix = new Texture("thirtysix.png");
        thirtyFive = new Texture("thirtyfive.png");
        fourty = new Texture("fourty.png");
        fourtyTwo = new Texture("fourtytwo.png");
        fourtyFive = new Texture("fourtyfive.png");
        fourtyEight = new Texture("fourtyeight.png");
        fourtyNine = new Texture("fourtynine.png");
        fifty = new Texture("fifty.png");
        fiftyFour = new Texture("fiftyfour.png");
        fiftySix = new Texture("fiftysix.png");
        sixty = new Texture("sixty.png");
        sixtyThree = new Texture("sixtythree.png");
        sixtyFour = new Texture("sixtyfour.png");
        seventy = new Texture("seventy.png");
        seventyTwo = new Texture("seventytwo.png");
        eighty = new Texture("eighty.png");
        eightyOne = new Texture("eightyone.png");
        ninty = new Texture("ninty.png");

    }
    public void randomisePos(int boardSize){
        x = MathUtils.random(boardSize-1);
        y = MathUtils.random(boardSize-1);
    }

    public Texture getFour() {
        return four;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
