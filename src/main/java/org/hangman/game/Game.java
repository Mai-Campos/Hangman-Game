package org.hangman.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        String secretWord = getSecretWord();
        char[] wordLetters = secretWord.toCharArray();
        char[] scriptsWord = parseWordToScripts(secretWord);
        boolean endedGame = false;
        boolean correctLetter;
        List failedLetter = new ArrayList<Character>();
        Scanner in = new Scanner(System.in);
        int attemps = 9;

        do{
            System.out.println("Introduce una letra");
            char letter = in.next().charAt(0);
            correctLetter = false;

        for(int i = 0; i<wordLetters.length; i++){
            if(wordLetters[i] == letter){
                scriptsWord[i] = letter;
                correctLetter = true;
            }

        }

        if(correctLetter == false){
            System.out.println("Letra no acertada");
            attemps--;
            failedLetter.add(letter);
        }else{
            endedGame = !scriptsExist(scriptsWord);
            if(endedGame){
                System.out.println("Has ganado en " + attemps + " intentos");
                System.out.println(secretWord);
                return;
            }
        }

            System.out.print("Letras falladas:");
            System.out.println(failedLetter);
            System.out.print("Intentos :");
            System.out.println(attemps);
            System.out.println(scriptsWord);

            if(attemps == 0){
                endedGame = true;
                System.out.println("Has perdido el juego");
                System.out.println("La palabra es " + secretWord);
            }
        }while(!endedGame);
    }

    static String getSecretWord(){

        String[] words = {"ropa","manzana","universidad","cucaracha","candelabro","malabares","interestelar",
                "linaje","hostal","licuadora","esmeralda","cristalera","magdalena","empresarial","historiador"};
        Random r = new Random();
        int randomNumber = r.nextInt(words.length);
        String secretWord = words[randomNumber];

        return secretWord;
    }

    static char[] parseWordToScripts(String secretWord){

        char[] scriptWord = new char[secretWord.length()];

        for(int i = 0; i < scriptWord.length; i++){
            scriptWord[i] = '_';
        }

        return scriptWord;
    }

    static boolean scriptsExist(char[] arrayLetras){
        for(char l : arrayLetras){
            if(l == '_'){
                return true;
            }
        }
        return false;
    }
}