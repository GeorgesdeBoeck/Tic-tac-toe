import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] digits = new char[9];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = ' ';
        }


        printGameState(digits);
        updateGameState(digits);
    }

    public static void printGameState(char[] array) {
        System.out.println("---------");
        System.out.println("| " + array[0] + " " + array[1] + " " + array[2] + " |");
        System.out.println("| " + array[3] + " " + array[4] + " " + array[5] + " |");
        System.out.println("| " + array[6] + " " + array[7] + " " + array[8] + " |");
        System.out.println("---------");
    }


    public static int coordinateConverter () {
        Scanner scanner1 = new Scanner(System.in);
        int coorValue = 0;
        boolean inputValidator = false;
        int input1;
        int input2;

        while (!inputValidator) {
            System.out.println("Enter the coordinates:");
            input1 = scanner1.nextInt();
            input2 = scanner1.nextInt();

            if (input1 > 3 || input1 < 1 || input2 > 3 || input2 < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (input1 == 1) {
                if (input2 == 1) {
                    coorValue = 0;
                    inputValidator = true;
                } else if (input2 == 2) {
                    coorValue = 1;
                    inputValidator = true;
                } else {
                    coorValue = 2;
                    inputValidator = true;
                }
            } else if (input1 == 2) {
                if (input2 == 1) {
                    coorValue = 3;
                    inputValidator = true;
                } else if (input2 == 2) {
                    coorValue = 4;
                    inputValidator = true;
                } else {
                    coorValue = 5;
                    inputValidator = true;
                }
            } else if (input1 == 3) {
                if (input2 == 1) {
                    coorValue = 6;
                    inputValidator = true;
                } else if (input2 == 2) {
                    coorValue = 7;
                    inputValidator = true;
                } else {
                    coorValue = 8;
                    inputValidator = true;
                }
            }
        }
        return coorValue;
    }

    public static void updateGameState (char[] array) {
        int winnerInt = 0;
        int coordinate;
        int counter = 0;

        while (winnerInt == 0 && counter < 9) {
            coordinate = coordinateConverter();

            if (array[coordinate] == 'X' || array[coordinate] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                if (counter % 2 == 0 || counter == 0) {
                    array[coordinate] = 'X';
                    counter++;
                } else if (counter % 2 == 1 || counter == 1) {
                    array[coordinate] = 'O';
                    counter++;
                }

                printGameState(array);
                winnerInt = check3InARow(array, winnerInt);

            }

        }

        if (winnerInt == 1) {
            System.out.println("X wins");
        } else if (winnerInt == 2) {
            System.out.println("O wins");
        } else if (winnerInt == 0) {
            System.out.println("Draw");
        }
    }


    public static int check3InARow (char[] array, int winnerInt) {

        if (array[0] == 'X' && array[1] == 'X' && array[2] == 'X') {
            winnerInt = 1;
        }

        if (array[3] == 'X' && array[4] == 'X' && array[5] == 'X') {
            winnerInt = 1;
        }

        if (array[6] == 'X' && array[7] == 'X' && array[8] == 'X') {
            winnerInt = 1;
        }

        if (array[0] == 'X' && array[3] == 'X' && array[6] == 'X') {
            winnerInt = 1;
        }

        if (array[1] == 'X' && array[4] == 'X' && array[7] == 'X') {
            winnerInt = 1;
        }

        if (array[2] == 'X' && array[5] == 'X' && array[8] == 'X') {
            winnerInt = 1;
        }

        if (array[0] == 'X' && array[4] == 'X' && array[8] == 'X') {
            winnerInt = 1;
        }

        if (array[2] == 'X' && array[4] == 'X' && array[6] == 'X') {
            winnerInt = 1;
        }

        if (array[0] == 'O' && array[1] == 'O' && array[2] == 'O') {
            winnerInt = 2;
        }

        if (array[3] == 'O' && array[4] == 'O' && array[5] == 'O') {
            winnerInt = 2;
        }

        if (array[6] == 'O' && array[7] == 'O' && array[8] == 'O') {
            winnerInt = 2;
        }

        if (array[0] == 'O' && array[3] == 'O' && array[6] == 'O') {
            winnerInt = 2;
        }

        if (array[1] == 'O' && array[4] == 'O' && array[7] == 'O') {
            winnerInt = 2;
        }

        if (array[2] == 'O' && array[5] == 'O' && array[8] == 'O') {
            winnerInt = 2;
        }

        if (array[0] == 'O' && array[4] == 'O' && array[8] == 'O') {
            winnerInt = 2;
        }

        if (array[2] == 'O' && array[4] == 'O' && array[6] == 'O') {
            winnerInt = 2;
        }

        return winnerInt;
    }
}
