import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter the size of the array: ");
            int input0 = input.nextInt();
            int Q7Arr[] = new int[input0];
            int in;
            do {
                System.out.println("1. Accept elements of an array");
                System.out.println("2. Display elements of an array");
                System.out.println("3. Search the element within array");
                System.out.println("4. Sort the array");
                System.out.println("5. To Stop");
                in = input.nextInt();

                if (in == 1) {
                    for (int i = 0; i < Q7Arr.length; i++) {
                        System.out.println("Enter element " + i + " : ");
                        Q7Arr[i] = input.nextInt();
                    }
                } else if (in == 2) {
                    System.out.println("the arrays are: " + Arrays.toString(Q7Arr));
                } else if (in == 3) {
                    boolean res = false;
                    System.out.println("Search for: ");
                    int search = input.nextInt();
                    for (int i : Q7Arr) {
                        if (i == search) {
                            res = true;
                            break;
                        } else {
                            res = false;
                        }
                    }
                    if (res == true) {
                        System.out.println("element found");
                    } else {
                        System.out.println("element not found");
                    }
                } else if (in == 4) {
                    Arrays.sort(Q7Arr);
                    System.out.println("Array sorted");
                } else {
                    System.out.println("please enter only from 1 to 5");
                }
            } while (in != 5);
        }catch (InputMismatchException e0){
            System.out.println(e0.getMessage());
        }catch (ArrayIndexOutOfBoundsException e1){
            System.out.println(e1.getMessage());
        }
        catch (IndexOutOfBoundsException e2){
            System.out.println(e2.getMessage());
        }catch (Exception e3){
            System.out.println(e3.getMessage());
        }
        //End of Q7


        boolean gameStatus = true;
        boolean turn = true;
        String [][] arr = new String[3][3];
        System.out.println("where do you want to play: (1-9)");
        try {
            do {
                while (turn) {
                    int user = input.nextInt();
                    if (user > 0 || user <= 9) {
                        userPlay(arr, user);
                        turn = false;
                    } else {
                        System.out.println("You can only choose from (1-9)");
                    }
                }
                gameStatus = checkWinner(arr);
                if (gameStatus == true) {
                    turn = true;
                }
                while (turn) {
                    int computer = 1 + (int) (Math.random() * ((9 - 1) + 1));
                    if (computer > 0 || computer <= 9) {
                        turn = computerPlay(arr, computer);
                    }
                }
                if (gameStatus) {
                    gameStatus = gameStatus(arr);
                }
                if (gameStatus) {
                    gameStatus = checkWinner(arr);
                }


                if (gameStatus == true) {
                    turn = true;
                }
                print2D(arr);


            } while (gameStatus);
        }
        catch (InputMismatchException e1){
            System.out.println("Enter only numbers from 1-9");
        }catch (Exception e2){
            System.out.println(e2.getMessage());
        }
        //print2D(arr);

    }
    static void userPlay(String [][] arr, int user) throws Exception{
        Scanner input = new Scanner(System.in);
        boolean turn = true;
        while(turn){
            switch (user) {
                case 1:
                    if (arr[0][0] == null) {
                        arr[0][0] = "X";
                        turn = false;
                    } else {
                        System.out.println("1 is not valid move");
                        System.out.println("Enter another number: ");
                        user = input.nextInt();
                    }
                    break;
                case 2:
                    if (arr[0][1] == null) {
                        arr[0][1] = "X";
                        turn = false;
                    } else {
                        System.out.println("2 is not valid move");
                        System.out.println("Enter another number: ");
                        user = input.nextInt();
                    }
                    break;
                case 3:
                    if (arr[0][2] == null) {
                        arr[0][2] = "X";
                        turn = false;
                    } else {
                        System.out.println("3 is not valid move");
                        System.out.println("Enter another number: ");
                        user = input.nextInt();
                    }
                    break;
                case 4:
                    if (arr[1][0] == null) {
                        arr[1][0] = "X";
                        turn = false;
                    } else {
                        System.out.println("4 is not valid move");
                        System.out.println("Enter another number: ");
                        user = input.nextInt();
                    }
                    break;
                case 5:
                    if (arr[1][1] == null) {
                        arr[1][1] = "X";
                        turn = false;
                    } else {
                        System.out.println("5 is not valid move");
                        System.out.println("Enter another number: ");
                        user = input.nextInt();
                    }
                    break;
                case 6:
                    if (arr[1][2] == null) {
                        arr[1][2] = "X";
                        turn = false;
                    } else {
                        System.out.println("6 is not valid move");
                        System.out.println("Enter another number: ");
                        user = input.nextInt();
                    }
                    break;
                case 7:
                    if (arr[2][0] == null) {
                        arr[2][0] = "X";
                        turn = false;
                    } else {
                        System.out.println("7 is not valid move");
                        System.out.println("Enter another number: ");
                        user = input.nextInt();
                    }
                    break;
                case 8:
                    if (arr[2][1] == null) {
                        arr[2][1] = "X";
                        turn = false;
                    } else {
                        System.out.println("8 is not valid move");
                        System.out.println("Enter another number: ");
                        user = input.nextInt();
                    }
                    break;
                case 9:
                    if (arr[2][2] == null) {
                        arr[2][2] = "X";
                        turn = false;
                    } else {
                        System.out.println("9 is not valid move");
                        System.out.println("Enter another number: ");
                        user = input.nextInt();
                    }
                    break;
                default:
                    System.out.println("You can only play from (1-9)");
                    user = input.nextInt();
            }
        }
    }

    static boolean computerPlay(String [][] arr, int user) throws Exception{
        switch (user){
            case 1:
                if(arr[0][0] == null){
                    arr[0][0] = "O";
                    return false;
                }else{return true;}
                //break;
            case 2:
                if(arr[0][1] == null){
                    arr[0][1] = "O";
                    return false;
                }else{return true;}
                //break;
            case 3:
                if(arr[0][2] == null){
                    arr[0][2] = "O";
                    return false;
                }else{return true;}
                //break;
            case 4:
                if(arr[1][0] == null){
                    arr[1][0] = "O";
                    return false;
                }else{return true;}
                //break;
            case 5:
                if(arr[1][1] == null){
                    arr[1][1] = "O";
                    return false;
                }else{return true;}
                //break;
            case 6:
                if(arr[1][2] == null){
                    arr[1][2] = "O";
                    return false;
                }else{return true;}
                //break;
            case 7:
                if(arr[2][0] == null){
                    arr[2][0] = "O";
                    return false;
                }else{return true;}
                //break;
            case 8:
                if(arr[2][1] == null){
                    arr[2][1] = "O";
                    return false;
                }else{return true;}
                //break;
            case 9:
                if(arr[2][2] == null){
                    arr[2][2] = "O";
                    return false;
                }else{return true;}
                //break;
        }
        return true;
    }
    static boolean gameStatus(String [][] arr) throws Exception{
        for (int i = 0; i < arr.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == null) {
                    return true;
                }
            }
        }
        System.out.println("Draw");
        return false;
    }

    static boolean checkWinner(String [][] arr) throws Exception{
        for(int i = 0; i<8; i++){
            String line = null;
            switch (i){
                case 0:
                    line = arr[0][0] + arr[0][1] + arr[0][2];
                    break;
                case 1:
                    line = arr[0][0] + arr[1][1] + arr[2][2];
                    break;
                case 2:
                    line = arr[0][0] + arr[1][0] + arr[2][0];
                    break;
                case 3:
                    line = arr[2][0] + arr[2][1] + arr[2][2];
                    break;
                case 4:
                    line = arr[2][0] + arr[1][1] + arr[0][2];
                    break;
                case 5:
                    line = arr[1][0] + arr[1][1] + arr[1][2];
                    break;
                case 6:
                    line = arr[2][1] + arr[1][1] + arr[0][1];
                    break;
                case 7:
                    line = arr[0][2] + arr[1][2] + arr[2][2];
                    break;
            }
            if(line.equalsIgnoreCase("XXX")){
                System.out.println("User wins");
                return false;
            } else if (line.equalsIgnoreCase("OOO")) {
                System.out.println("Computer wins");
                return false;
            }
        }
        return true;
    }
    public static void print2D(String mat[][]) throws Exception
    {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++) {
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "|");
            }
            System.out.print("\n-+-+-\n");
        }
    }
}