/*
If you are painting the ith post, you have two options:

make it different color as i-1th post
make it same color as i-1 th post (if you are allowed!)
simply add these for your answer:
num_ways(i) = num_ways_diff(i) + num_ways_same(i)

Now just think of how to calculate each of those functions.

The first one is easy. If you are painting the ith post, how many ways can you paint it to make it different from the i-1 th post? k-1

num_ways_diff(i) = num_ways(i-1) * (k-1)

The second one is hard, but not so hard when you think about it.

If you are painting the ith post, how many ways can you paint it to make it the same as the i-1th post? At first, we should think the answer is 1 -- it must be whatever color the last one was.

num_ways_same(i) = num_ways(i-1) * 1

But no! This will fail in the cases where painting the last post the same results in three adjacent posts of the same color! We need to consider ONLY the cases where the last two colors were different. But we can do that!

num_ways_diff(i-1) <- all the cases where the i-1th and i-2th are different.

THESE are the cases where can just plop the same color to the end, and no longer worry about causing three in a row to be the same.

num_ways_same(i) = num_ways_diff(i-1) * 1

We sum these for our answer, like I said before:

num_ways(i) = num_ways_diff(i) + num_ways_same(i)
= num_ways(i-1) * (k-1) + num_ways_diff(i-1)

We know how to compute num_ways_diff, so we can substitute:
num_ways(i) = num_ways(i-1) * (k-1) + num_ways(i-2) * (k-1)

We can even simplify a little more:

num_ways(i) = (num_ways(i-1) + num_ways(i-2)) * (k-1)*/

class Solution {
    public int numWays(int n, int k) {
        if (n==0 || k==0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k*k;
        }
        int[] paint = new int[n+1];
        paint[0] = 0;
        paint[1] = k;
        paint[2] = k*k;
        for (int i=3; i<=n; i++) {
            paint[i] = paint[i-1]*(k-1) + paint[i-2]*(k-1);
        }
        return paint[n];
    }
}