package net.core.tutorial.elementary._05_Loops;

/**

 Examples of "while" and "for" loop, and also operators "break", "continue".

 */

public class _01_Loops {

    public static void main(String[] args) {

        int x = 9;
        int[][] arr = {{5, 4, 3}, {9, 7, 2}, {1, 6, 8}};

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(arr[i][j] == x) break;
                System.out.print(arr[i][j] + "  ");
            }
        }

        System.out.println();

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(arr[i][j] == x) continue;
                System.out.print(arr[i][j] + "  ");
            }
        }

        System.out.println();

        for(int i = 0; i < 10; i++){
            if(i >= 5 && i < 8){
                continue;
            }
            System.out.print(i + "  ");
        }

        System.out.println();

        while(x > 0){
            System.out.print(x + "  ");
            x--;
        }

        System.out.println();

        // endless loop
        while(true){
            int y = 9;
            System.out.println(y + "  ");
            y--;
            if(y < 1) break;
        }

    }
}