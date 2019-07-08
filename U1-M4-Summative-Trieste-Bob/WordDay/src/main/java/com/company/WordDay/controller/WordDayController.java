//my WordDayControllerVersion3

package com.company.WordDay.controller;
import java.util.*;
import com.company.WordDay.model.Quote;
import com.company.WordDay.model.Word;
import com.company.WordDay.model.Magic;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class WordDayController {

    private Magic magic;
    private Magic question;

    public WordDayController() {
        List<Quote> List = new ArrayList<>();
        List<Word> words = new ArrayList<>();
        List<Magic> answers8Ball = new ArrayList<>();
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote randomQuote() {

        //declaring 10 new empty quotes
        //(Not instantiation which occurs when we give it a name & PARAMS//

        Quote quote0 = new Quote();
        Quote quote1 = new Quote();
        Quote quote2 = new Quote();
        Quote quote3 = new Quote();
        Quote quote4 = new Quote();
        Quote quote5 = new Quote();
        Quote quote6 = new Quote();
        Quote quote7 = new Quote();
        Quote quote8 = new Quote();
        Quote quote9 = new Quote();

        quote0.setQuote("“The most painful thing is losing yourself in the process of loving someone too much, and forgetting that you are special too.” ― Ernest Hemingway");
        quote2.setQuote("A society grows great when old men plant trees whose shade they know they shall never sit in. - Greek proverb");
        quote2.setQuote("Chop your own wood, and it will warm you twice.” - Henry Ford");
        quote3.setQuote("I'm not upset that you lied to me, I'm upset that from now on I can't believe you” - Friedrich Nietzsche");
        quote4.setQuote("You can never understand everything. But, you should push yourself to understand the system.");
        quote5.setQuote("When the axe came into the woods, many of the trees said,'At least the handle is one of us.' - Proverb");
        quote6.setQuote("Everyone you will ever meet knows something you don't. - Bill Nye");
        quote7.setQuote("I am patient with stupidity but not with those who are proud of it. - Edith Sitwell");
        quote8.setQuote("Don't let school interfere with your education - Mark Twain");
        quote9.setQuote("Struggle ends where gratitude begins.  - Tim Ferris");

        List<Quote> List = new ArrayList<>();

        List.add(quote1);
        List.add(quote2);
        List.add(quote3);
        List.add(quote4);
        List.add(quote5);
        List.add(quote6);
        List.add(quote7);
        List.add(quote8);
        List.add(quote9);

        Random random = new Random();
        Quote quoteR = List.get(random.nextInt(10));

        return quoteR;
    }


    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Word randomWord() {


        Word word0 = new Word();
        Word word1 = new Word();
        Word word2 = new Word();
        Word word3 = new Word();
        Word word4 = new Word();
        Word word5 = new Word();
        Word word6 = new Word();
        Word word7 = new Word();
        Word word8 = new Word();
        Word word9 = new Word();


        word0.setWord("zephyr: a slight wind.");
        word1.setWord("acumen: shrewdness shown by keen insight.");
        word2.setWord("ebullient: joyously unrestrained");
        word3.setWord("garrulous: full of trivial conversation.");
        word4.setWord("heterogenous: consisting of elements that are not of the same kind.");
        word5.setWord("iconoclast: someone who attacks cherished ideas or institutions.");
        word6.setWord("idiosyncratic: peculiar to the individual");
        word7.setWord("laconic: brief and to the point.");
        word8.setWord("modicum: a small or moderate or token amount.");
        word9.setWord("quixotic: not sensible about practical matters.");


        List<Word> words = new ArrayList<>();

        words.add(word0);
        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);
        words.add(word5);
        words.add(word6);
        words.add(word7);
        words.add(word8);
        words.add(word9);

        Random random2 = new Random();
        Word wordR = words.get(random2.nextInt(10));

        return wordR;

    }



    @RequestMapping(value = "/magic{question}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Magic setQuestion() {


        Magic answer0 = new Magic(magic, question);
        Magic answer1 = new Magic(magic, question);
        Magic answer2 = new Magic(magic, question);
        Magic answer3 = new Magic(magic, question);
        Magic answer4 = new Magic(magic, question);
        Magic answer5 = new Magic(magic, question);


        List<Magic> answers8Ball = new ArrayList<>();

        answer0.setAnswer("When hell freezes over...");
        answer1.setAnswer("You are destined to fail horribly.");
        answer2.setAnswer("Yes, but then gain, maybe no way...?");
        answer3.setAnswer("I haven't had coffee yet so no clue.");
        answer4.setAnswer("You are way over your head.");
        answer5.setAnswer("Personally, I give you one chance in three...");

        Random randomEightBall = new Random();

        answers8Ball.add(answer0);
        answers8Ball.add(answer1);
        answers8Ball.add(answer2);
        answers8Ball.add(answer3);
        answers8Ball.add(answer4);
        answers8Ball.add(answer5);
        answers8Ball.add(answer5);


        Magic answer = answers8Ball.get(randomEightBall.nextInt(6));
        return answer;

    }
}
