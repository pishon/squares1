/**
 * Created by animal_power on 21.05.2020.
 */
public class Square {

    static int height;
    static int length;
    static int max_size;

    static int[] squares_count;
    static int all_squares_count;


    private static void proc_cell(int[][] m, int cur_h, int cur_l) {

        int cur_size;
        int cur_ones;
        boolean find_next;

        if (m[cur_h][cur_l] == 1) {

            cur_size = 1;
            squares_count[cur_size] = squares_count[cur_size] + 1;
            find_next = true;

            while (cur_size < max_size && find_next == true) {

                cur_size = cur_size + 1;
                cur_ones = 0;

                for (int h = cur_h; h <= cur_h + cur_size - 1 && h < height; h++) {
                    for (int l = cur_l; l <= cur_l + cur_size - 1 && l < length; l++) {
                        if (m[h][l] == 1) {
                            cur_ones = cur_ones + 1;
                        } else {
                            break;
                        }
                    }
                }

                if (cur_ones == cur_size * cur_size) {
                    squares_count[cur_size] = squares_count[cur_size] + 1;
                } else {
                    find_next = false;
                }
            }
        }
    }




    private static void find_squares(int[][] m) {

        height = m.length;
        length = m[0].length;
        max_size = Math.min(height, length);
        squares_count = new int[max_size + 1];

        System.out.println("Высота = " + height);
        System.out.println("Длина = " + length);
        System.out.println("Максимальный размер квадрата = " + max_size);


        for (int h = 0; h < height; h++) {
            for (int l = 0; l < length; l++) {
                proc_cell(m, h, l);
            }
        }

        for (int i = 1; i < squares_count.length; i++) {
            if (squares_count[i] > 0) {
                System.out.println("Количество квадратов размера " + i + ": " + squares_count[i]);
                all_squares_count = all_squares_count + squares_count[i];
            }
        }

        System.out.println("Всего квадратов " + all_squares_count);
    }




    public static void main(String[] args) {
        /*
        int[][] m = {   {0, 1, 1, 1},
                        {1, 1, 1, 1},
                        {0, 1, 1, 1}
                    };*/

        int[][] m = {   {1, 0, 1},
                        {1, 1, 0},
                        {1, 1, 0}
                };


        find_squares(m);
    }



}
