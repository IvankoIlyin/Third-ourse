public class Garden {
    private int width = 10;
    public int[][] field = new int[width][width];

    Garden() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                field[i][j] = 1;
            }
        }
        System.out.println("All grown up!");
    }

    public void PrintGarden() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(field[i][j] + "  ");
                if (j == width - 1) {
                    System.out.print("");
                }
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < width - 1; i++) {
            System.out.print("---");
        }
        System.out.println("-");
        System.out.println();
    }

    public void ChangePlantStatus(int xPos, int yPos, int status) {
        if (xPos < 0 || xPos >= width || yPos < 0 || yPos >= width) {
            throw new NumberFormatException("Integer is out of range.");
        }
        if (status != 0 && status != 1) {
            throw new NumberFormatException("Invalid status integer.");
        }
        field[xPos][yPos] = status;
    }
}
