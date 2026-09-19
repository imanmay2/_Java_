import java.util.*;

public class Greedy_Algorithm {
    public static int ActivitySelection(int start[], int end[]) {
        int ct = 1;
        int idx = 0; // prev choosen idx
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= end[idx]) {
                ct++;
                idx = i;
            }
        }
        return ct;
    }

    public static int fractional_knapsack(int val[], int wt[], int W) {
        double ratio[] = new double[val.length];
        for (int i = 0; i < ratio.length; i++) {
            ratio[i] = val[i] / (double) wt[i];
        }

        // sort in descending order.
        double arr[][] = new double[ratio.length][2];
        for (int i = 0; i < ratio.length; i++) {
            arr[i][0] = i;
            arr[i][1] = ratio[i];
        }
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));

        int maxProfit = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) arr[i][0];

            if (W >= wt[idx]) {
                maxProfit += val[idx];
                W = W - wt[idx];
            } else {
                maxProfit += ratio[idx] * W;
                W = 0;
            }
        }
        return maxProfit;
    }

    public static int min_abs_diff_pairs(int arr1[], int arr2[]) {
        int mini = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            mini += Math.abs(arr1[i] - arr2[i]);
        }
        return mini;
    }

    public static int indian_coin(int val, int coinsAvail[]) {
        ArrayList<Integer> list = new ArrayList<>();
        // val= 590
        int min = 0;
        Arrays.sort(coinsAvail);
        int idx = coinsAvail.length - 1;
        while (val != 0) {
            if (coinsAvail[idx] <= val) {
                min++;
                list.add(coinsAvail[idx]);
                val -= coinsAvail[idx];
                idx = coinsAvail.length - 1;
            } else {
                idx--;
            }
        }

        System.out.println("Coins used are : ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        return min;
    }

    static class Job {
        int id = 0, deadline = 0, profit = 0;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static int job_sequencing(int jobList[][]) {
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobList.length; i++) {
            jobs.add(new Job(i, jobList[i][0], jobList[i][1]));
        }
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); // sorting of the array in the descending
                                                                           // order.

        // main logic for sequencing
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        int maxProfit = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                maxProfit += curr.profit;
                time++;
                seq.add(curr.id);
            }
        }
        System.out.println("The Sequence is : ");
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
        return maxProfit;
    }

    public static int ChocolaProblem(Integer hor[], Integer ver[]) {
        int cost = 0;
        int hp = 1, vp = 1; // tracking the number of pieces.
        int h = 0, v = 0; // pointers for tracking the array
        Arrays.sort(hor, Collections.reverseOrder());
        Arrays.sort(ver, Collections.reverseOrder());

        while (h < hor.length && v < ver.length) {
            if (hor[h] < ver[v]) {
                // cut vertically
                vp++;
                cost += hp * ver[v];
                v++;

            } else {
                // cut horizontally
                hp++;
                cost += vp * hor[h];
                h++;
            }
        }
        // remaining cuts order.
        while (h < hor.length) {
            hp++;
            cost += vp * hor[h];
            h++;
        }

        while (v < ver.length) {
            vp++;
            cost += hp * ver[v];
            v++;
        }
        return cost;
    }

    public static void main(String args[]) {
        // int start[] = { 1, 3, 0, 5, 8, 5 };
        // int end[] = { 2, 4, 6, 7, 9, 9 };
        // // System.out.println(ActivitySelection(start, end));

        // int val[]={60,100,120};
        // int wt[]={10,20,30};
        // int W=50;
        // System.out.println(fractional_knapsack(val, wt, W));

        // int arr1[]={1,2,3};
        // int arr2[]={3,2,1};
        // System.out.println(min_abs_diff_pairs(arr1, arr2));

        // int coinsAvail[]={1,2,5,10,20,50,100,500,2000};
        // int val=121;
        // System.out.println(indian_coin(val, coinsAvail));

        // int jobList[][] = { { 1, 40 }, { 1, 30 }, { 4, 20 }, { 1, 10 } };
        // System.out.println(job_sequencing(jobList));


        Integer hor[]={2,1,3,1,4};
        Integer ver[]={4,1,2};
        System.out.println(ChocolaProblem(hor, ver));
    }
}