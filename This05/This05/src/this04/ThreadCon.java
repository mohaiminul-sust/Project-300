/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package this04;

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.LiveGraph.LiveGraph;
import org.LiveGraph.dataFile.write.DataStreamWriter;
import org.LiveGraph.settings.DataFileSettings;

/**
 *
 * @author Shibbir
 *
 * This class will generate Life. properties contains properties of life
 */
public class ThreadCon extends properties {

    String dir_name;
    LameLand c = new LameLand();
    Random rand1;
    int total_thread_count = 0, total_generation_count = 0, total_food_eaten = 0, total_poison_eaten = 0;
    LogGenerator log_main = new LogGenerator();
    LogGenerator log_parent = new LogGenerator();
    boolean check_program_run = true;
    DataStreamWriter out = null;
    GraphBuilder graph = new GraphBuilder();
    long startTime;
    //Thread t = new Thread(new threadGen());

    /**
     * threadGen class is Life. properties_of_life is a class for properties of
     * life in LameLand like move,eat
     */
    public class threadGen extends properties_of_life implements Runnable {

        LogGenerator log_thread = new LogGenerator();
        String thread_name;
        int generation_no;

        // public  int n=0,if_child=0,birth_period=20;

        public threadGen(int gen) {
            generation_no = gen;
            move_toad = 100;
            rand = new Random();
            x = rand.nextInt(100);
            y = rand.nextInt(100);
            k = x + y * 100;
            if (k == 10000) {
                k--;
            }
        }

        public threadGen(int b_k, int gen) {
            generation_no = gen;
            if (generation_no > total_generation_count) {
                total_generation_count = generation_no;
            }
            move_toad = 100;
            k = b_k;
            x = k % 100;
            y = k / 100;
            rand = new Random();

            if (k == 10000) {
                k--;
            }
        }

        @Override

        public void run() {

            thread_name = Thread.currentThread().getName();
            log_thread.LG(dir_name + "/" + thread_name);
            log_thread.write("move, food_type, probability");
            String[] st = thread_name.split("-");
            thread_no = Integer.parseInt(st[1]);

            try {
                lol();

            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadCon.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        public void lol() throws InterruptedException {

            int birth_gap = 0;
            c.label[k].setBorder(javax.swing.BorderFactory.createLineBorder(Color.blue, 100));
            String s = Thread.currentThread().getName();
            System.out.println("Birth of " + s);
            int total_food_count = 0, total_poison_count = 0, total_children_count = 0;
            for (int i = 0; i < move_toad; ++i) {
//               System.out.println("food_posi+"+food_position[0]);
                String food_type = eat(k,c, return_fodd_position(), return_obs_position());
                if (food_type.equals("food")) {
                    total_food_count++;
                    total_food_eaten++;
                } else if (food_type.equals("poison")) {
                    total_poison_count++;
                    total_poison_eaten++;
                }
                //System.out.println(i);
                //c.label[k].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
                int k_before_move = k;
                set_life_data(thread_no, k, move_toad, birth_gap, position_of_lives, birth_gap_of_life, total_move_toad);
                int chek = move(food_position, obstacle_position);

                birth_gap = return_birth_gap(thread_no, birth_gap_of_life);
                if (birth_gap > 20) {
                    int check_collition = Collition_between_two_thread2(thread_no, position_of_lives, birth_gap_of_life, total_move_toad);
                    if (check_collition != 0) // System.out.println(check_collition);
                    {
                        if (check_collition == 2) {

                            give_brth(k, ++generation_no);
                            log_thread.write("Child Spawned!!!");
                            total_children_count++;
                            Thread.sleep(300);
                            birth_gap = 0;
                            // System.out.println("Baccha hoiche!!!");
                            chek = move(food_position, obstacle_position);
                        }
                    }
                }
                birth_gap = return_birth_gap(thread_no, birth_gap_of_life);
                set_life_data(thread_no, k, move_toad, birth_gap, position_of_lives, birth_gap_of_life, total_move_toad);

                c.label[k_before_move].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
                int color_blue =50+move_toad;
                c.label[k].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, color_blue), 100));
                log_thread.write(Integer.toString(k) + ", " + food_type + ", " + chek);
                Thread.sleep(300);
                ++birth_gap;

                set_life_data(thread_no, k, move_toad, birth_gap, position_of_lives, birth_gap_of_life, total_move_toad);
            }

            log_parent.write(thread_name + ", " + move_toad + ", " + total_food_count + ", " + total_poison_count + ", " + total_children_count);
            log_thread.closefile();
            c.label[k].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
            position_of_lives[thread_no] = -10;
          // writer.write( Thread.currentThread().getName()+" "+total_move[thread_no]);
            // c.label[k].setIcon(null);  

        }

    }

    public void graphMaker() {

        out = graph.GraphBuilderInit(out, dir_name + "/graph", "Graph data for ALS");
        settings(dir_name + "/graph", 1000);
        startTime = System.currentTimeMillis();
        LiveGraph app = LiveGraph.application();
        app.exec(new String[]{"-dfs", "session.lgdfs"});

        graph.setColumn(out, new String[]{"Time", "Population", "Food", "Poison"});
    }

    private static void settings(String f_name, int freq) {
        DataFileSettings dfs = new DataFileSettings();
        dfs.setDataFile(f_name + ".lgdat");
        dfs.setUpdateFrequency(freq);
        dfs.save("session.lgdfs");
    }

    private void give_brth(int k, int gen) {
        Thread t_new = new Thread(new threadGen(k, gen));
        t_new.start();
        total_thread_count++;
    }

    public class status_gui_update implements Runnable {

        @Override

        public void run() {
            StatusGUI statusgui = new StatusGUI();
            statusgui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            statusgui.setVisible(true);
            graphMaker();
            int alive = statusgui.update(total_thread_count, position_of_lives, total_generation_count, total_food_eaten, total_poison_eaten);
            while (check_program_run) {
                try {
                    Thread.sleep(1000);
                    graph.writeData(out, new Double[]{(double) System.currentTimeMillis() - startTime, (double) alive, (double) total_food_eaten, (double) total_poison_eaten});
                    alive = statusgui.update(total_thread_count, position_of_lives, total_generation_count, total_food_eaten, total_poison_eaten);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadCon.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }

    public void threadEngine() {

        /**
         * initialising GUI
         */
        dir_name = "Log " + LocalDateTime.now().toString();
        dir_name = dir_name.replace(":", "-");
        System.out.println(dir_name);
        Accessories ac = new Accessories();
        if (ac.createDir(dir_name)) {
            System.out.println("Folder Created : " + dir_name);
        }
        log_parent.LG(dir_name + "/ThreadInfo");
        log_parent.write("thread name, total move, total food count , total poison count , total children count");
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setSize(1350, 730);
        c.setVisible(true);

        gen_food(c);    //generate food
        gen_obstacle(c);

        /**
         * Life starts from here
         */
        for (int i = 0; i < 40; ++i) {
            Thread t7 = new Thread(new threadGen(1));
            t7.start();

            total_thread_count = i + 1;
        }
        total_generation_count = 1;
        status_gui_update status = new status_gui_update();
        status.run();
//        SHUTDOWN HOOK
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            public void run() {
                // Do what you want when the application is stopping
                System.out.println("Closing parent Thread...");
                log_parent.closefile();
                log_main.LG(dir_name + "/logMain");
                log_main.write("total thread no, total generation count, total food eaten, total poison eaten");
                log_main.write(total_thread_count + "," + total_generation_count + "," + total_food_eaten + "," + total_poison_eaten);
                log_main.closefile();
                graph.closeGraph(out);
                check_program_run = false;
            }
        }));

    }

}
