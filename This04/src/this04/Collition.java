/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package this04;

/**
 *
 * @author Shibbir
 */
public class Collition {

    public void set_life_data(int thread_no, int k, int move_toad_of_thread, int birth_gap, int[] position_of_lives, int[] birth_gap_of_life, int[] total_move_toad) {
        position_of_lives[thread_no] = k;
        birth_gap_of_life[thread_no] = birth_gap;
        total_move_toad[thread_no] = move_toad_of_thread;

    }

    public int return_birth_gap(int thread_no, int[] birth_gap_of_life) {
        return birth_gap_of_life[thread_no];
    }

    public int Collition_between_two_thread(int thread_no, int[] position_of_lives, int[] birth_gap_of_life, int[] total_move_toad) {
        // System.out.println("Dhukse");
        for (int i = 0; i < position_of_lives.length - 1; i++) {
            for (int j = i + 1; j < position_of_lives.length; j++) {
                if (j != i) {
                    if (position_of_lives[i] != 0) {
                        if (position_of_lives[i] == position_of_lives[j]) {
                            if ((birth_gap_of_life[i] > 20) && (birth_gap_of_life[j] > 20)) {
                                if (total_move_toad[i] > 50 && total_move_toad[j] > 50) {
                       // check_collition[0]=i;
                                    //  check_collition[1]=j;

                                    birth_gap_of_life[i] = 0;
                                    birth_gap_of_life[j] = 0;
                                    System.out.println("Collition between   " + i + " dfK= " + j);
                                    System.out.println(thread_no);
                        //flag3=1;
                                    // writer.write("collu "+check_position[i]+" "+check_position[j]+" "+i+" "+j);
                                    // Thread baccha = new Thread(new threadGen(check_position[i],40));
                                    //baccha.start();
                                    if (i == thread_no) {
                                        return 1;
                                    }
                                    if (j == thread_no) {
                                        return 2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int Collition_between_two_thread2(int thread_no, int[] position_of_lives, int[] birth_gap_of_life, int[] total_move_toad) {
        // System.out.println("Dhukse");
        int j = thread_no;
        for (int i = 0; i < position_of_lives.length - 1; i++) {

            if (j != i) {
                if (position_of_lives[i] != 0) {
                    if (position_of_lives[i] == position_of_lives[j]) {
                        if ((birth_gap_of_life[i] > 20) && (birth_gap_of_life[j] > 20)) {
                            if (total_move_toad[i] > 50 && total_move_toad[j] > 50) {
                       // check_collition[0]=i;
                                //  check_collition[1]=j;

                                birth_gap_of_life[i] = 0;
                                birth_gap_of_life[j] = 0;
                                System.out.println("Collition between   " + i + " dfK= " + j);
                                System.out.println(thread_no);

                                if (i == thread_no) {
                                    return 1;
                                }
                                if (j == thread_no) {
                                    return 2;
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * check_empty_position is a function to check check_int is in array or not.
     * If yes return 1 else return 0
     *
     * @param array
     * @param check_int
     * @return
     */
    public int check_empty_position(int array[], int check_int) {

        for (int i = 0; i < array.length; ++i) {
            if (array[i] == check_int) {
                return 1;
            }
        }
        return 0;

    }

    public int collition_with_life_and_FoodObs(int k_of_thread) {

        return 0;
    }

}
